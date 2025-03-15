import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.4.3"
	id("io.spring.dependency-management") version "1.1.7"
	id("org.jlleitschuh.gradle.ktlint") version "12.2.0"
}

group = "vinni"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	// Telegram API
	implementation("org.telegram:telegrambots:6.9.7.1")

	// MongoDB
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")

	// Tests
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

	testImplementation("io.kotest.extensions:kotest-extensions-spring:1.3.0")
	testImplementation("io.kotest:kotest-runner-junit5-jvm:5.9.1")
	testImplementation("de.flapdoodle.embed:de.flapdoodle.embed.mongo:4.18.1")
	testImplementation("com.ninja-squad:springmockk:4.0.2")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	// Linter Ktlint
	runtimeOnly("com.pinterest.ktlint:ktlint-core:0.49.1")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "21"
	}
}

apply(plugin = "org.jlleitschuh.gradle.ktlint")
