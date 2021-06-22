package `in`.bitcode.broadcast1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, intent?.action, Toast.LENGTH_LONG).show()
        Log.e("tag", intent?.action.toString())

        if(intent?.action.equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
            if(intent?.getBooleanExtra("state", false) == true) {
                Log.e("tag", "Airlplane mode - ON")
            }
            else {
                Log.e("tag", "Airlplane mode - FF")
            }
        }
        if(intent?.action.equals("in.bitcode.media.DOWNLOAD_COMPLETE")) {
            var path = intent?.getStringExtra("path")
            Log.e("tag", path.toString())
            Toast.makeText(context, path, Toast.LENGTH_LONG).show()
        }
    }
}