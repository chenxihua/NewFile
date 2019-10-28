package com.neuedu.crm.bean;

import java.io.Serializable;

import javax.annotation.Resource;

/**
 * 用于封装查询的满意度数量等。。。
 * @author Administrator
 *
 */


public class AmountTwo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer satisfaction;
	private Integer counts;
	public Integer getSatisfaction() {
		return satisfaction;
	}
	public void setSatisfaction(Integer satisfaction) {
		this.satisfaction = satisfaction;
	}
	public Integer getCounts() {
		return counts;
	}
	public void setCounts(Integer counts) {
		this.counts = counts;
	}
	@Override
	public String toString() {
		return "Satisfact [satisfaction=" + satisfaction + ", counts=" + counts + "]";
	}
	public AmountTwo(Integer satisfaction, Integer counts) {
		super();
		this.satisfaction = satisfaction;
		this.counts = counts;
	}
	public AmountTwo() {
		super();
	}
	
	
	

}
