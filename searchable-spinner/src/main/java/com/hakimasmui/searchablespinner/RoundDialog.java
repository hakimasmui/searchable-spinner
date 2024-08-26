package com.hakimasmui.searchablespinner;

import android.content.Context;
import android.content.res.Configuration;

public class RoundDialog {
    public int getWidth(Context context) {
        int width = 0;
        int orientation = context.getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            width = (int) (context.getResources().getDisplayMetrics().widthPixels * 0.6f);
        } else {
            width = (int) (context.getResources().getDisplayMetrics().widthPixels * 0.85f);
        }
        return width;
    }
}
