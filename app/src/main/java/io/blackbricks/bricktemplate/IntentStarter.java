package io.blackbricks.bricktemplate;

import android.content.Context;
import android.content.Intent;

import javax.inject.Inject;

import io.blackbricks.bricktemplate.injection.scope.PerApplication;
import io.blackbricks.bricktemplate.ui.main.MainActivity;

/**
 * Created by yegorkryndach on 04/08/16.
 */
@PerApplication
public class IntentStarter {

    @Inject
    public IntentStarter() {
    }

    public void openMain(Context context) {
        Intent i = new Intent(context, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}
