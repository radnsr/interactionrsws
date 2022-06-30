package net.unityhealth.model;

import java.util.List;

import com.unityhealth.imgateway.interactions.db.model.SearchResult;

public class HerbInfo {

    private List<SearchResult> interactions;
    private String herbID;

    public String getHerbID() {
        return herbID;
    }

    public void setHerbID(String herbID) {
        this.herbID = herbID;
    }

    public List<SearchResult> getInteractions() {
        return interactions;
    }

    public void setInteractions(List<SearchResult> interactions) {
        this.interactions = interactions;
    }

}
