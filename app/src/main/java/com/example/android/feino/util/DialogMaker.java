package com.example.android.feino.util;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Environment;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AlertDialog;

import java.io.File;

/**
 * Created by Doha on 03/09/18.
 */
public class DialogMaker {
    public static AlertDialog makeDialog(Context context, String message,
                                         String positiveStr, DialogInterface.OnClickListener positiveListener,
                                         String negativeStr, DialogInterface.OnClickListener negativeListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        return builder.setMessage(message)
                .setPositiveButton(positiveStr, positiveListener)
                .setNegativeButton(negativeStr, negativeListener)
                .setCancelable(false)
                .create();
    }

    public static AlertDialog makeDialog(Context context, String message,
                                         String positiveStr, DialogInterface.OnClickListener positiveListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        return builder.setMessage(message)
                .setPositiveButton(positiveStr, positiveListener)
                .setCancelable(false)
                .create();
    }

    public static Dialog makeDialog(Context context, @LayoutRes int layoutResource){
        Dialog dialog = new Dialog(context);
        dialog.setContentView(layoutResource);
        return dialog;
    }

    public static void fixMediaDir() {
        File sdcard = Environment.getExternalStorageDirectory();
        if (sdcard != null) {
            File mediaDir = new File(sdcard, "DCIM/Camera");
            if (!mediaDir.exists()) {
                mediaDir.mkdirs();
            }
        }
    }

}
