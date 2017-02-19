package com.example.hoang.myapplication.helper;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.example.hoang.myapplication.R;

/**
 * Created by hoang on 18/11/2016.
 */

public class Helper {

    //showToast
    public static void showToast(Context context, String msg){
         Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    Context context;
    public static void ShowDialog(String msg, Context context) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
        builder1.setMessage(msg);
        builder1.setIcon(R.drawable.icon_shield);
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

}
