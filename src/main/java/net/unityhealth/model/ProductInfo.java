package net.unityhealth.model;

import java.util.List;

import com.unityhealth.imgateway.interactions.db.model.SearchResult;

public class ProductInfo {
	private List<SearchResult> interactions;
	private String productId;
	private String productName;
	private String partNo;
	
	public List<SearchResult> getInteractions() {
		return interactions;
	}
	public void setInteractions(List<SearchResult> interactions) {
		this.interactions = interactions;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPartNo() {
		return partNo;
	}
	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}

}
