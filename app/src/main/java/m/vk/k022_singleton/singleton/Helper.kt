package m.vk.k022_singleton.singleton

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.DisplayMetrics
import android.view.WindowManager
import android.content.Context.WINDOW_SERVICE
import androidx.core.content.ContextCompat.getSystemService



class Helper private constructor() {

    object Holder{
        val INSTANCE = Helper()
    }
    companion object{
        val INSTANCE: Helper by lazy { Holder.INSTANCE }
    }

    /*Internet*/
    fun isConnectInternet(): Boolean {
        //var result = 0 // Returns connection type. 0: none; 1: mobile data; 2: wifi
        var isConnect = false
        val cm = Contexttor.INSTANCE.getContext()?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            cm?.run {
                cm.getNetworkCapabilities(cm.activeNetwork)?.run {
                    if (hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                        //result = 2
                        isConnect = true
                    } else if (hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                        //result = 1
                        isConnect = true
                    }
                }
            }
        } else {
            cm?.run {
                cm.activeNetworkInfo?.run {
                    if (type == ConnectivityManager.TYPE_WIFI) {
                        //result = 2
                        isConnect = true
                    } else if (type == ConnectivityManager.TYPE_MOBILE) {
                        //result = 1
                        isConnect = true
                    }
                }
            }
        }
        //return result
        return isConnect
    }

    /*Screen Size*/
    fun getScreenSizeWidth(): Int{
        return checkScreenSize(false)
    }
    fun getScreenSizeHeight(): Int{
        return checkScreenSize(true)
    }
    private fun checkScreenSize(isHeight: Boolean): Int{
        val dm = DisplayMetrics()
        val windowManager = Contexttor.INSTANCE.getContext()?.getSystemService(WINDOW_SERVICE) as WindowManager
        windowManager.defaultDisplay.getMetrics(dm)
        val height = dm.heightPixels
        val width = dm.widthPixels
        return if (isHeight){
            height
        }else{
            width
        }
    }

}