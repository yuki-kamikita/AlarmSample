package com.example.alarmsample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

// 指定時間に呼び出されるクラス
class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "5秒経過しました", Toast.LENGTH_LONG).show()
    }
}