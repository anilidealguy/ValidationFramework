package com.anil.implementations;

import java.util.regex.Pattern;

public class AlphaNumericImpl implements Validator{

	@Override
	public boolean validate(Object... objects) {
		String val = objects[0].toString();
		Pattern p = Pattern.compile("[^a-zA-Z0-9]");
		return ! p.matcher(val).find();
	}

}
