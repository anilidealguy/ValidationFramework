package com.anil.main;

import com.anil.annotations.AlphaNumeric;
import com.anil.annotations.Number;

public class TestPojo {
	@AlphaNumeric(value = false)
	private String invAccount;
	
	@Number
	private String quantity;
	
	public String getInvAccount() {
		return invAccount;
	}
	public void setInvAccount(String invAccount) {
		this.invAccount = invAccount;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
}
