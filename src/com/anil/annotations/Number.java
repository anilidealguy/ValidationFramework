package com.anil.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.anil.implementations.NumberImpl;
import com.anil.implementations.Validator;

@Retention(RetentionPolicy.RUNTIME)
public @interface Number {
	boolean value() default true;
	Class<? extends Validator> implementationClass() default NumberImpl.class;
}
