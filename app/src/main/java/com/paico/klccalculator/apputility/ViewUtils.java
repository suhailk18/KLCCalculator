package com.paico.klccalculator.apputility;

import android.app.Activity;
import android.content.Context;
import android.view.WindowManager;


public class ViewUtils {


    public static void hideKeyboardOnStartActivity(Context context) {
        ((Activity) context).getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }


}
