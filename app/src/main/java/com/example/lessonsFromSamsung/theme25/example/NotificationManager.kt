package com.example.lessonsFromSamsung.theme25.example

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.example.lessonsFromSamsung.theme25.ServiceActivity

internal class NotificationManager(private val context: Context) {

    private val notificationBuilder: NotificationCompat.Builder = NotificationCompat.Builder(context, CHANNEL_ID)

    private val notificationManager: NotificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun updateNotification(text: String = ""): Notification {
        return buildNotification(text).apply {
            notificationManager.notify(NOTIFICATION_ID, this)
        }
    }

    private fun buildNotification(text: String): Notification {
        notificationBuilder.setContentTitle(text)
            .setSmallIcon(android.R.drawable.sym_def_app_icon)
            .setGroupAlertBehavior(NotificationCompat.GROUP_ALERT_SUMMARY)
            .setGroup(CHANNEL_ID)
            .setGroupSummary(false)
            .setWhen(0)
            .setContentIntent(createNotificationIntent()) // Это шоб запустить активити по нажатию на нотификацию

        return notificationBuilder.build().apply {
            flags = flags or Notification.FLAG_ONGOING_EVENT
        }
    }

    private fun createNotificationIntent(): PendingIntent {
        val notificationIntent = Intent(context, ServiceActivity::class.java).apply {
            action = Intent.ACTION_MAIN
            addCategory(Intent.CATEGORY_LAUNCHER)
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED
        }

        return PendingIntent.getActivity(context, 0, notificationIntent, 0)
    }

    companion object {

        const val NOTIFICATION_ID = 78428
        const val CHANNEL_ID = "CHANNEL_ID"

    }

}