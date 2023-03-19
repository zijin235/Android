package com.example.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class ViewUtil {
    public static void hideAllInputMethod(Activity act){
        InputMethodManager imm=(InputMethodManager) act.getSystemService(Context.INPUT_METHOD_SERVICE);
        if(imm.isActive()){
            //如果软键盘已经开启
            imm.toggleSoftInput(0,InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public static void hideOneInputMethod(Activity act, View v){
        //从系统获取输入法管理
        InputMethodManager imm=(InputMethodManager) act.getSystemService(Context.INPUT_METHOD_SERVICE);
        //关闭软键盘
        imm.hideSoftInputFromWindow(v.getWindowToken(),0);
    }

}
