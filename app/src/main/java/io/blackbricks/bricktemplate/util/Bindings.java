package io.blackbricks.bricktemplate.util;

import android.databinding.BindingAdapter;
import android.widget.TextView;

/**
 * Created by yegorkryndach on 24/08/16.
 */
public class Bindings {
    @BindingAdapter({"bind:font"})
    public static void setFont(TextView textView, String fontName) {
        textView.setTypeface(FontCache.getInstance().get(fontName));
    }
}
