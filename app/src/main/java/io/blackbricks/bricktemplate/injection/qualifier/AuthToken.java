package io.blackbricks.bricktemplate.injection.qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by yegorkryndach on 18/07/16.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthToken {
}