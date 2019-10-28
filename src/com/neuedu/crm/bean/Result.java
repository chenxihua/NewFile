package com.neuedu.crm.bean;

public class Result {
	
	private boolean result;

	public Result() {
		super();
	}

	public Result(boolean result) {
		super();
		this.result = result;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Result [result=" + result + ", isResult()=" + isResult() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
