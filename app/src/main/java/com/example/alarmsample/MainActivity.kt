package com.example.alarmsample

import android.app.*
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ボタン押下
        button.setOnClickListener {
            // 実行する時間（ミリ秒）
            val alarmTime = System.currentTimeMillis() + 5000

            // 実行したいクラスから Intent を作成
            val alarmIntent = Intent(this, AlarmReceiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT)

            // AlarmManager で pendingIntent を指定時間後に実行するように設定
            val manager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            manager.setExact(AlarmManager.RTC_WAKEUP, alarmTime, pendingIntent)
        }
    }
}

// 出典：https://joyplot.com/documents/2018/04/26/alarmmanager-pendingintent/