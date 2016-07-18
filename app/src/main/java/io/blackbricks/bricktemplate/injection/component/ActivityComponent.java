package io.blackbricks.bricktemplate.injection.component;

import dagger.Component;
import io.blackbricks.bricktemplate.injection.module.ActivityModule;
import io.blackbricks.bricktemplate.injection.scope.PerActivity;

/**
 * Created by yegorkryndach on 18/07/16.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class})
public interface ActivityComponent {
}
