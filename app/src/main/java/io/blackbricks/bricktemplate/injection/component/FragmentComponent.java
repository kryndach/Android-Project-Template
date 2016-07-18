package io.blackbricks.bricktemplate.injection.component;

import dagger.Component;
import io.blackbricks.bricktemplate.injection.module.FragmentModule;
import io.blackbricks.bricktemplate.injection.scope.PerFragment;

/**
 * Created by yegorkryndach on 18/07/16.
 */
@PerFragment
@Component(dependencies = AppComponent.class, modules = {FragmentModule.class})
public interface FragmentComponent {

}
