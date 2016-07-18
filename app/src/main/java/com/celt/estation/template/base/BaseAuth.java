package com.celt.estation.template.base;


import com.celt.estation.template.bean.User;

public class BaseAuth {
	
	static public boolean isLogin () {
		User customer = User.getInstance();
		if (customer.isLogin() == true) {
			return true;
		}
		return false;
	}
	
	static public void setLogin (Boolean status) {
		User customer = User.getInstance();
		customer.setLogin(status);
	}
	
	static public void setCustomer (User mc) {
		User customer = User.getInstance();
		customer.setId(mc.getId());
		
		customer.setUsername(mc.getUsername());
		
	}
	
	static public User getCustomer () {
		return User.getInstance();
	}
}