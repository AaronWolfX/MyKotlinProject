package com.example.aaronsmith.mykotlinproject

import android.app.Activity
import android.app.Application
import android.content.Context
import android.hardware.display.DisplayManager
import android.os.Bundle
import android.util.Log
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import kotlin.properties.Delegates

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
 * Created by q on 2017/12/24.
 */
class MyApplicaiton : Application() {
    private var refWatcher:RefWatcher? = null
    companion object {
        private val TAG = "MyApplication"

        var context:Context by Delegates.notNull()
            private set
        fun getRefWatcher(context: Context):RefWatcher?{
            val myApplication = context.applicationContext as MyApplicaiton
            return myApplication.refWatcher
        }
    }


    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        refWatcher = setupLeakCanary()
        initConfig()
        DisplayManager.init(this)
        registerActivityLifecycleCallbacks(mActivityLifecycleCallbacks)
    }

    private fun setupLeakCanary():RefWatcher{
        return if (LeakCanary.isInAnalyzerProcess(this)){
            RefWatcher.DISABLED
        }else LeakCanary.install(this)
    }

    /**
     * 初始化配置
     */
    private fun initConfig(){

        val formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)
                .methodCount(0)
                .methodOffset(7)
                .tag("aaron_smith")
                .build()
        Logger.addLogAdapter(object :AndroidLogAdapter(formatStrategy){
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })
    }

    private val mActivityLifecycleCallbacks = object :Application.ActivityLifecycleCallbacks{
        override fun onActivityPaused(p0: Activity?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onActivityResumed(p0: Activity?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onActivityStarted(activity: Activity?) {
            Log.d(TAG,"onStart:"+activity!!.componentName.className)
        }

        override fun onActivityDestroyed(p0: Activity?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onActivitySaveInstanceState(p0: Activity?, p1: Bundle?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onActivityStopped(p0: Activity?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
            Log.d(TAG,"onCreated:"+activity!!.componentName.className)
        }

    }
}