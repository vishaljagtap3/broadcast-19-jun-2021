package `in`.bitcode.broadcast1

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var btnRegister : Button
    lateinit var btnUnRegister : Button
    lateinit var br : BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        btnRegister.setOnClickListener {
            br = MyBroadcastReceiver()

            var intentFilter = IntentFilter(Intent.ACTION_WALLPAPER_CHANGED)
            intentFilter.addAction("in.bitcode.event.COMPLETE")
            intentFilter.addAction("in.bitcode.media.DOWNLOAD_COMPLETE")
            intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
            intentFilter.addAction(Intent.ACTION_BATTERY_LOW)
            intentFilter.addAction(Intent.ACTION_POWER_CONNECTED)

            registerReceiver(br, intentFilter)
        }

        btnUnRegister.setOnClickListener {
            unregisterReceiver(br)
        }
    }

    private fun init() {
        btnRegister = findViewById(R.id.btnRegister)
        btnUnRegister = findViewById(R.id.btnUnRegister)
    }
}