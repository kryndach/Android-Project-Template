package io.blackbricks.bricktemplate.injection.component;

import dagger.Subcomponent;
import io.blackbricks.bricktemplate.injection.scope.PerSession;
import io.blackbricks.bricktemplate.service.session.SessionModule;

/**
 * Created by yegorkryndach on 18/07/16.
 */
@PerSession
@Subcomponent(modules = SessionModule.class)
public interface SessionComponent {
    SessionViewModelComponent newSessionViewModelComponent();
}
