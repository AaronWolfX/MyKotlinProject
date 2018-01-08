package com.example.aaronsmith.mykotlinproject.utils

import android.content.Context
import android.net.ConnectivityManager
import java.net.NetworkInterface
import java.net.SocketException

//  ┏┓　　　┏┓
//┏┛┻━━━┛┻┓
//┃　　　　　　　┃
//┃　　　━　　　┃
//┃　┳┛　┗┳　┃
//┃　　　　　　　┃
//┃　　　┻　　　┃
//┃　　　　　　　┃
//┗━┓　　　┏━┛
//    ┃　　　┃   神兽保佑
//    ┃　　　┃   代码无BUG！
//    ┃　　　┗━━━┓
//    ┃　　　　　　　┣┓
//    ┃　　　　　　　┏┛
//    ┗┓┓┏━┳┓┏┛
//      ┃┫┫　┃┫┫
// 
/**
 * Created by aaronsmith on 29/12/2017.
 */
class NetworkUtil {

    companion object {
        var NET_CNNT_BAIDU_OK = 1 // NetworkAvailable
        var NET_CNNT_BAIDU_TIMEOUT = 2 // no NetworkAvailable
        var NET_NOT_PREPARE = 3 // Net no ready
        var NET_ERROR = 4 //net error
        private val TIMEOUT = 3000 // TIMEOUT


        /**
         * check NetworkAvailable
         *
         * @param context
         * @return
         */
        @JvmStatic
        fun isNetworkAvailable(context: Context): Boolean {
            val manager = context.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val info = manager.activeNetworkInfo
            return !(null == info || !info.isAvailable)
        }

        @JvmStatic
        fun getLocalIpAddress(): String {
            var ret = ""
            try {
                val en = NetworkInterface.getNetworkInterfaces()
                while (en.hasMoreElements()) {
                    val enumIpAddress = en.nextElement().inetAddresses
                    while (enumIpAddress.hasMoreElements()) {
                        val netAddress = enumIpAddress.nextElement()
                        if (!netAddress.isLoopbackAddress) {
                            ret = netAddress.hostAddress.toString()
                        }
                    }
                }
            } catch (ex: SocketException) {
                ex.printStackTrace()
            }
            return ret
        }
    }
}