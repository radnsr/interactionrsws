package net.unityhealth.model;

import java.util.List;

import com.unityhealth.imgateway.interactions.db.model.SearchResult;

public class GeneralInteractionInfo {
    
    
    
    private String herbName;
    private String drugName;
    private String recommendation;
    private String patientAdvice;
    private String commentaryOnEvidence;
    private String level;
    private String tciName;
    private List<Reports> reportsList;

    public List<Reports> getReportsList() {
        return reportsList;
    }

    public void setReportsList(List<Reports> reportsList) {
        this.reportsList = reportsList;
    }

    public String getHerbName() {
        return herbName;
    }

    public void setHerbName(String herbName) {
        this.herbName = herbName;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getPatientAdvice() {
        return patientAdvice;
    }

    public void setPatientAdvice(String patientAdvice) {
        this.patientAdvice = patientAdvice;
    }

    public String getCommentaryOnEvidence() {
        return commentaryOnEvidence;
    }

    public void setCommentaryOnEvidence(String commentaryOnEvidence) {
        this.commentaryOnEvidence = commentaryOnEvidence;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTciName() {
        return tciName;
    }

    public void setTciName(String tciName) {
        this.tciName = tciName;
    }

	

}
