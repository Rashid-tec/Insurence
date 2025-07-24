package com.insrence.res;

import java.math.BigDecimal;

public class PolicyResponse {

	private Long id;
	public PolicyResponse() {
		super();
		
	}
	public PolicyResponse(Long id, String holdername, String type, String startdate, String enddate,
			BigDecimal premimumAmoutn) {
		super();
		this.id = id;
		this.holdername = holdername;
		this.type = type;
		this.startdate = startdate;
		this.enddate = enddate;
		this.premimumAmoutn = premimumAmoutn;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHoldername() {
		return holdername;
	}
	public void setHoldername(String holdername) {
		this.holdername = holdername;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public BigDecimal getPremimumAmoutn() {
		return premimumAmoutn;
	}
	public void setPremimumAmoutn(BigDecimal premimumAmoutn) {
		this.premimumAmoutn = premimumAmoutn;
	}
	private String holdername;
	private String type;
	private String startdate;
	private String enddate;
	private BigDecimal premimumAmoutn;
}
