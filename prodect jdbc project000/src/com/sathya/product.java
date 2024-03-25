package com.sathya;

public class product {
	int pId;
    String pName;
    double pPrice;
    public product() {
    }
    
	public product(int pId, String pName, double pPrice) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pPrice = pPrice;
	}

	@Override
	public String toString() {
		return "product [pId=" + pId + ", pName=" + pName + ", pPrice=" + pPrice + "]";
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public double getpPrice() {
		return pPrice;
	}

	public void setpPrice(double pPrice) {
		this.pPrice = pPrice;
	}
    
	
    }
