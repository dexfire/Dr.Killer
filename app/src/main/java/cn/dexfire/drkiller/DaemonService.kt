package cn.dexfire.drkiller

import android.app.Service
import android.content.Intent
import android.os.IBinder
import java.io.Console
import java.io.PrintWriter

class DaemonService : Service() {
    var con: Console? = null
    var ptr: PrintWriter? = null

    override fun onBind(intent: Intent): IBinder {
        con = System.console()
        ptr = con?.writer()
        TODO(reason = "Return the communication channel to the service.")
    }

    override fun onUnbind(intent: Intent?): Boolean {
        ptr?.printf("killall dogcom")
        return super.onUnbind(intent)
    }

    fun startDaemon(): Int {
        ptr?.printf("drcom -m %s -c %s %s", "", "", "")
        ptr?.flush()
        return 0
    }
}
