package net.unityhealth.model;

public class SearchResult2 {
	String herbID;
	String herbName;	
	String drugID;
	String drugName;
	String catID;
	String catName;
	String recommendation;
	String generalInteractionID;
	
	/**
	 * @param herbName
	 * @param drugName
	 * @param catName
	 * @param recommendation
	 * @param generalInteractionID
	 */
	public SearchResult2(String herbName, String drugName, String catName,
			String recommendation, String generalInteractionID) {
		super();
		this.herbName = herbName;		
		this.drugName = drugName;		
		this.catName = catName;		
		this.recommendation = recommendation;
		this.generalInteractionID = generalInteractionID;
	}
	
	
	/**
	 * @param herbName
	 * @param drugName
	 * @param catName
	 * @param recommendation
	 * @param generalInteractionID
	 */
	public SearchResult2(String herbID, String herbName, String drugID, String drugName, String catID, String catName,
						String recommendation, String generalInteractionID) {
		super();
		this.herbID = herbID;
		this.herbName = herbName;
		this.drugID = drugID;
		this.drugName = drugName;
		this.catID = catID;
		this.catName = catName;
		this.recommendation = recommendation;
		this.generalInteractionID = generalInteractionID;
	}

	/**
	 * @return the herbName
	 */
	public String getHerbName() {
		return herbName;
	}

	/**
	 * @param herbName the herbName to set
	 */
	public void setHerbName(String herbName) {
		this.herbName = herbName;
	}

	/**
	 * @return the drugName
	 */
	public String getDrugName() {
		return drugName;
	}

	/**
	 * @param drugName the drugName to set
	 */
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	/**
	 * @return the catName
	 */
	public String getCatName() {
		return catName;
	}

	/**
	 * @param catName the catName to set
	 */
	public void setCatName(String catName) {
		this.catName = catName;
	}

	/**
	 * @return the recommendation
	 */
	public String getRecommendation() {
		return recommendation;
	}

	/**
	 * @param recommendation the recommendation to set
	 */
	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}

	/**
	 * @return the generalInteractionID
	 */
	public String getGeneralInteractionID() {
		return generalInteractionID;
	}

	/**
	 * @param generalInteractionID the generalInteractionID to set
	 */
	public void setGeneralInteractionID(String generalInteractionID) {
		this.generalInteractionID = generalInteractionID;
	}
	
	/**
	 * @return the herbID
	 */
	public String getHerbID() {
		return herbID;
	}


	/**
	 * @param herbID the herbID to set
	 */
	public void setHerbID(String herbID) {
		this.herbID = herbID;
	}


	/**
	 * @return the drugID
	 */
	public String getDrugID() {
		return drugID;
	}


	/**
	 * @param drugID the drugID to set
	 */
	public void setDrugID(String drugID) {
		this.drugID = drugID;
	}


	/**
	 * @return the catID
	 */
	public String getCatID() {
		return catID;
	}


	/**
	 * @param catID the catID to set
	 */
	public void setCatID(String catID) {
		this.catID = catID;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SearchResult2 [herbID=" + herbID + ", herbName=" + herbName
				+ ", drugID=" + drugID + ", drugName=" + drugName + ", catID="
				+ catID + ", catName=" + catName + ", recommendation="
				+ recommendation + ", generalInteractionID="
				+ generalInteractionID + "]";
	}
		
}