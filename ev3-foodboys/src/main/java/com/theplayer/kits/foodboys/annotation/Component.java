package com.theplayer.kits.foodboys.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
//author: Long
@Retention(RUNTIME)
public @interface Component {
	String value() default "";
}
