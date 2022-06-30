package net.unityhealth.model;

import java.util.List;

import com.unityhealth.imgateway.interactions.db.model.SearchResult;

public class DrugInfo {
	private List<SearchResult> interactions;
	private String drugID;
	
	public List<SearchResult> getInteractions() {
		return interactions;
	}
	public void setInteractions(List<SearchResult> interactions) {
		this.interactions = interactions;
	}
	public String getDrugID() {
		return drugID;
	}
	public void setDrugID(String drugID) {
		this.drugID = drugID;
	}

}
