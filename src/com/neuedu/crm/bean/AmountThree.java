package com.neuedu.crm.bean;

import java.io.Serializable;

import javax.annotation.Resource;

/**
 * 用于封装查询的等级数量等。。。
 * @author Administrator
 *
 */


public class AmountThree implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer clientClass;
	private Integer counts;
	public Integer getClientClass() {
		return clientClass;
	}
	public void setClientClass(Integer clientClass) {
		this.clientClass = clientClass;
	}
	public Integer getCounts() {
		return counts;
	}
	public void setCounts(Integer counts) {
		this.counts = counts;
	}
	@Override
	public String toString() {
		return "AmountThree [clientClass=" + clientClass + ", counts=" + counts + "]";
	}
	public AmountThree(Integer clientClass, Integer counts) {
		super();
		this.clientClass = clientClass;
		this.counts = counts;
	}
	public AmountThree() {
		super();
	}
	
	
	

}
