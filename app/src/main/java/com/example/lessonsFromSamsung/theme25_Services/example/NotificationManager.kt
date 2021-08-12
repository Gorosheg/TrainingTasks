package com.example.lessonsFromSamsung.theme25_Services.example

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.example.lessonsFromSamsung.theme25_Services.ServiceActivity

internal class NotificationManager(private val context: Context) {

    // Класс, который создает натификацию
    private val notificationBuilder: NotificationCompat.Builder = NotificationCompat.Builder(context, CHANNEL_ID)

    // Отображает натификацию
    private val notificationManager: NotificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    // Создание и отображение Notification
    fun updateNotification(text: String = ""): Notification {
        return buildNotification(text).also { notification ->
            // Отображение Notification
            notificationManager.notify(NOTIFICATION_ID, notification)
        }
    }

    // Билдим нотификацию.
    private fun buildNotification(text: String): Notification {
        // Паттерн Builder. Через точку передаются параметры, когда вызываем build() - создается класс
        return notificationBuilder.setContentTitle(text)
            .setSmallIcon(android.R.drawable.sym_def_app_icon)
            .setGroupAlertBehavior(NotificationCompat.GROUP_ALERT_SUMMARY)
            .setGroup(CHANNEL_ID)
            .setGroupSummary(false)
            .setWhen(0)
            .setContentIntent(createNotificationIntent()) // Это шоб запустить активити по нажатию на нотификацию
            .build() // Этот метод создает натификацию
            .apply { flags = flags or Notification.FLAG_ONGOING_EVENT } //  apply меняет контекст. Возвращает первоначальное значение
    }

    // Создаем интент по которому можно запустить ServiceActivity
    private fun createNotificationIntent(): PendingIntent {
        val notificationIntent = Intent(context, ServiceActivity::class.java).apply {
            // Эти штуки нужны для корректного запуска активити
            action = Intent.ACTION_MAIN
            addCategory(Intent.CATEGORY_LAUNCHER)
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED
        }

        // PendingIntent в отличие от интента вызывается не сразу. Создаем интент и "оборачиваем его в pending"
        return PendingIntent.getActivity(context, 0, notificationIntent, 0)
    }

    companion object {

        const val NOTIFICATION_ID = 78428
        const val CHANNEL_ID = "CHANNEL_ID"

    }

}