package vinni.vinni_task_bot.vinni.models.reminder

import java.time.Instant

data class CreateReminderRequest(
    val chatId: Long,
    val description: String,
    val minutes: Long = 0,
    val hours: Long = 0
) {

    fun toReminderDocument(
        timeToReminder: Instant
    ): Reminder = Reminder(
        chatId = chatId,
        description = description,
        minutes = minutes,
        hours = hours,
        timeToReminder = timeToReminder
    )
}
