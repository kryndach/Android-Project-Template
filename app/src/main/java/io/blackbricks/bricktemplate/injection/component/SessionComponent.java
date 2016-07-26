package io.blackbricks.bricktemplate.injection.component;

import dagger.Subcomponent;
import io.blackbricks.bricktemplate.injection.scope.PerSession;

/**
 * Created by yegorkryndach on 18/07/16.
 */
@PerSession
@Subcomponent
public interface SessionComponent {
    SessionViewModelComponent newSessionViewModelComponent();
}
