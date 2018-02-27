package com.anil.main;

import java.util.List;

import com.anil.utils.Utils;
import com.anil.utils.ValidationObject;

public class MainClass {

	public static void main(String[] args) throws Exception {
		TestPojo pojo = new TestPojo();
		pojo.setInvAccount("123#Anil567");
		pojo.setQuantity("120");
		
		List<ValidationObject> validations =  Utils.getValidationsList(pojo);
		Utils.runValidations(validations);
		
		
		for (ValidationObject validationObject : validations) {
			System.out.println(validationObject);
		}
		
	}

}