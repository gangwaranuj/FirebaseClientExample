package com.thinksys.demo.bean;

public class FirebaseBean implements java.io.Serializable {


	private String browserName;
	private String token;
	public String getBrowserName() {
		return browserName;
	}
	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "BrowserBean [browserName=" + browserName + ", token=" + token + "]";
	}
	
}
