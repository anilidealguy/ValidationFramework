package com.anil.implementations;

@FunctionalInterface
public interface Validator {
	boolean validate(Object ...objects);
}
