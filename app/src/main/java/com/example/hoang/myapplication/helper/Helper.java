package com.example.hoang.myapplication.helper;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by hoang on 18/11/2016.
 */

public class Helper {

    public static void showMsg(Context context, String msg){
         Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }


}
