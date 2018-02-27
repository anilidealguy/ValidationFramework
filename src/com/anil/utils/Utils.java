package com.anil.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.anil.implementations.Validator;

public class Utils {
	public static Object getFieldValueFromGetter(Field field, Object object){
		Class<?> classObject = object.getClass();
		Method[] methods = classObject.getMethods();
		String fieldName = "get" + field.getName().toLowerCase();
		for (Method method : methods) {
			if (method.getName().equalsIgnoreCase(fieldName)) {
				try {
					return method.invoke(object);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static List<ValidationObject> getValidationsList(Object target) throws Exception{
		List<ValidationObject> validations = new ArrayList<>();
		Class<?> cls = target.getClass();
		for (Field field : cls.getDeclaredFields()) {
			for (Annotation annotation : field.getAnnotations()) {
				
				Class<? extends Validator> validatorImplClass = (Class<? extends Validator>) annotation.annotationType().getMethod("implementationClass").invoke(annotation);
				Validator validator = validatorImplClass.newInstance();
				String annotationValue = annotation.annotationType().getMethod("value").invoke(annotation).toString();
				String fieldValue = (String) getFieldValueFromGetter(field, target);
				
				ValidationObject validationObject = new ValidationObject();
				validationObject.setValidator(validator);
				validationObject.setField(field);
				validationObject.setAnnotationValue(annotationValue);
				validationObject.setFieldValue(fieldValue);
				
				validations.add(validationObject);
			}
		}
		return validations;
	}

	public static void runValidations(List<ValidationObject> validations) {
		for (ValidationObject validationObject : validations) {
			Validator validator = validationObject.getValidator();
			boolean isValidationSuccess = validator.validate(validationObject.getFieldValue());
			validationObject.setValidationSuccess(isValidationSuccess);
			validationObject.setMessage("Validation completed");
		}
	} 
}

