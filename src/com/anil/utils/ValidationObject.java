package com.anil.utils;

import java.lang.reflect.Field;

import com.anil.implementations.Validator;

public class ValidationObject {
	private Validator validator;
	private Field field;
	private Object annotationValue;
	private String fieldValue;
	private boolean isValidationSuccess;
	private String message; 
	
	public Validator getValidator() {
		return validator;
	}
	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	public Field getField() {
		return field;
	}
	public void setField(Field field) {
		this.field = field;
	}
	public Object getAnnotationValue() {
		return annotationValue;
	}
	public void setAnnotationValue(Object annotationValue) {
		this.annotationValue = annotationValue;
	}
	public String getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	public boolean isValidationSuccess() {
		return isValidationSuccess;
	}
	public void setValidationSuccess(boolean isValidationSuccess) {
		this.isValidationSuccess = isValidationSuccess;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "ValidationObject [validator=" + validator.getClass().getName() + ", field=" + field.getName() + ", annotationValue=" + annotationValue
				+ ", fieldValue=" + fieldValue + ", isValidationSuccess=" + isValidationSuccess + ", message=" + message
				+ "]";
	}
	
	
}
