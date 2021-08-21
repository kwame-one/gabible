package com.kgapps.gabible.utils;

import android.content.Context;
import android.widget.Toast;

public class AppUtils {

    public static final String NEW_TESTAMENT = "new";
    public static final String OLD_TESTAMENT = "old";
    public static final String MY_PREF ="ga bible pref" ;

    public static void toast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void out(String message) {
        System.out.println(message);
    }
}
