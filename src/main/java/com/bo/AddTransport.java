package com.bo;

public class AddTransport {
	
	public AddTransport() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String consignor_name;
	private String consignor_mobile;
	private String consignee_name;
	private String consignee_mobile;
	private String consignee_address;
	private String driver_assigned;
	private int id;
	public String getConsignor_name() {
		return consignor_name;
	}
	public void setConsignor_name(String consignor_name) {
		this.consignor_name = consignor_name;
	}
	public String getConsignor_mobile() {
		return consignor_mobile;
	}
	public void setConsignor_mobile(String consignor_mobile) {
		this.consignor_mobile = consignor_mobile;
	}
	public String getConsignee_name() {
		return consignee_name;
	}
	public void setConsignee_name(String consignee_name) {
		this.consignee_name = consignee_name;
	}
	public String getConsignee_mobile() {
		return consignee_mobile;
	}
	public void setConsignee_mobile(String consignee_mobile) {
		this.consignee_mobile = consignee_mobile;
	}
	public String getConsignee_address() {
		return consignee_address;
	}
	public void setConsignee_address(String consignee_address) {
		this.consignee_address = consignee_address;
	}
	public String getDriver_assigned() {
		return driver_assigned;
	}
	public void setDriver_assigned(String driver_assigned) {
		this.driver_assigned = driver_assigned;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public AddTransport(String consignor_name, String consignor_mobile, String consignee_name, String consignee_mobile,
			String consignee_address, String driver_assigned, int id) {
		super();
		this.consignor_name = consignor_name;
		this.consignor_mobile = consignor_mobile;
		this.consignee_name = consignee_name;
		this.consignee_mobile = consignee_mobile;
		this.consignee_address = consignee_address;
		this.driver_assigned = driver_assigned;
		this.id = id;
	}
	
	

}
