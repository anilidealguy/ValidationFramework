package com.anil.implementations;

import java.math.BigInteger;

public class NumberImpl implements Validator {

	@Override
	public boolean validate(Object... objects) {
		try {
			new BigInteger(objects[0].toString());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
