package io.blackbricks.bricktemplate.util;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by yegorkryndach on 02/09/16.
 */
public class DimensUtils {
    /**
     * Converts a dp value to a px value
     *
     * @param context The context
     * @param dp the dp value
     * @return value in pixels
     */
    public static int dpToPx(Context context, float dp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) ((dp * displayMetrics.density) + 0.5);
    }

    /**
     * Converts pixel in dp
     *
     * @param context The context
     * @param px the pixel value
     * @return  value in dp
     */
    public static int pxToDp(Context context, int px) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) ((px / displayMetrics.density) + 0.5);
    }

    /**
     * Convertes pixels to sp
     */
    public static float pxToSp(Context context, Float px) {
        float scaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
        return px / scaledDensity;
    }
}
