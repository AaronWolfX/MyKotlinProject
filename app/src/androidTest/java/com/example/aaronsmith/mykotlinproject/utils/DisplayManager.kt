package com.example.aaronsmith.mykotlinproject.utils

import android.content.Context
import android.util.DisplayMetrics

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
 * Created by q on 2017/12/25.
 */
object DisplayManager {
     init {

     }
    private var displayMetrice:DisplayMetrics?=null

    private var screenWidth:Int?=null

    private var screenHeight:Int?=null

    private var screenDpi:Int?=null

    fun init(context: Context){
        displayMetrice = context.resources.displayMetrics
        screenWidth = displayMetrice?.widthPixels
        screenHeight = displayMetrice?.heightPixels
        screenDpi = displayMetrice?.densityDpi
    }

    //UI图的大小
    private val STANDARD_WIDTH = 1080
    private val STANDARD_HEIGHT = 1920

    fun getScreenWidth():Int?{
        return screenWidth
    }

    fun getScreenHeight():Int?{
        return screenHeight
    }

    fun getPaintSize(size:Int):Int?{
        
    }



}