package m.vk.k022_singleton

import android.app.Application
import m.vk.k022_singleton.singleton.Contexttor

class MainApplication: Application(){
    override fun onCreate() {
        super.onCreate()
        Contexttor.INSTANCE.init(applicationContext)
    }

    override fun onTerminate() {
        super.onTerminate()
        Contexttor.INSTANCE.clear()
    }
}