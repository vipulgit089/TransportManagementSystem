package com.bo;

public class AddDriver {
	private String name;
	private String mobile;
	private String address;
	private String vechile;
	private String lic;
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLic() {
		return lic;
	}
	public void setLic(String lic) {
		this.lic = lic;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public AddDriver() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getVechile() {
		return vechile;
	}
	public void setVechile(String vechile) {
		this.vechile = vechile;
	}
	public AddDriver(int id,String name, String mobile, String address, String vechile, String lic) {
		super();
		this.id=id;
		this.name = name;
		this.mobile = mobile;
		this.address = address;
		this.vechile = vechile;
	
		this.lic = lic;
	}
	

}
