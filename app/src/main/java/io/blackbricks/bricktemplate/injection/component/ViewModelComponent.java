package io.blackbricks.bricktemplate.injection.component;

import dagger.Component;
import dagger.Subcomponent;
import io.blackbricks.bricktemplate.injection.scope.PerViewModel;
import io.blackbricks.bricktemplate.ui.main.MainViewModel;
import io.blackbricks.bricktemplate.ui.sample.SampleViewModel;

/**
 * Created by yegorkryndach on 18/07/16.
 */
@PerViewModel
@Subcomponent
public interface ViewModelComponent {
    void inject(MainViewModel mainViewModel);
    void inject(SampleViewModel sampleViewModel);
}
