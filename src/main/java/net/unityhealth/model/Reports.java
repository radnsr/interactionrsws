/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unityhealth.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tabish
 */
@Entity
@Table(name = "reports")
public class Reports{ 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "LastChangeDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastChangeDate;
    @Size(max = 255)
    @Column(name = "LastChangeUser")
    private String lastChangeUser;
    @Column(name = "InteractionID")
    private String interactionID;
    @Column(name = "RefID")
    private Integer refID;
    @Size(max = 255)
    @Column(name = "Title")
    private String title;
    @Size(max = 255)
    @Column(name = "DrugDose")
    private String drugDose;
    @Size(max = 255)
    @Column(name = "HerbalDose")
    private String herbalDose;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "StudyAim")
    private String studyAim;
    @Column(name = "SampleSize")
    private Integer sampleSize;
    @Size(max = 255)
    @Column(name = "SubjectType")
    private String subjectType;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "StudyDesign")
    private String studyDesign;
    @Lob
    @Size(max = 65535)
    @Column(name = "AssayMethods")
    private String assayMethods;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "PharmacokineticMethods")
    private String pharmacokineticMethods;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "StatisticalMethods")
    private String statisticalMethods;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Results")
    private String results;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Discussion")
    private String discussion;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Implication")
    private String implication;
    @Size(max = 255)
    @Column(name = "StudyType")
    private String studyType;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "StudyDesignDetails")
    private String studyDesignDetails;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "AssayMethodsDetails")
    private String assayMethodsDetails;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "PharmacokineticMethodsDetails")
    private String pharmacokineticMethodsDetails;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "StatisticalMethodsDetails")
    private String statisticalMethodsDetails;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "ResultsDetails")
    private String resultsDetails;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "DiscussionDetails")
    private String discussionDetails;
    @Size(max = 255)
    @Column(name = "HerbAssayed")
    private String herbAssayed;
    @Column(name = "EvidenceRanking")
    private Integer evidenceRanking;
    @Column(name = "EvidenceRankingNHMRC")
    private Integer evidenceRankingNHMRC;
    @Column(name = "DocumentationRanking")
    private Integer documentationRanking;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "CommentsOnEvidence")
    private String commentsOnEvidence;
    @Column(name = "EvidenceType")
    private Integer evidenceType;
    @Column(name = "QA")
    private Integer qa;

    public Reports() {
    }

    public Reports(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getLastChangeUser() {
        return lastChangeUser;
    }

    public void setLastChangeUser(String lastChangeUser) {
        this.lastChangeUser = lastChangeUser;
    }

    public String getInteractionID() {
        return interactionID;
    }

    public void setInteractionID(String interactionID) {
        this.interactionID = interactionID;
    }

    public Integer getRefID() {
        return refID;
    }

    public void setRefID(Integer refID) {
        this.refID = refID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDrugDose() {
        return drugDose;
    }

    public void setDrugDose(String drugDose) {
        this.drugDose = drugDose;
    }

    public String getHerbalDose() {
        return herbalDose;
    }

    public void setHerbalDose(String herbalDose) {
        this.herbalDose = herbalDose;
    }

    public String getStudyAim() {
        return studyAim;
    }

    public void setStudyAim(String studyAim) {
        this.studyAim = studyAim;
    }

    public Integer getSampleSize() {
        return sampleSize;
    }

    public void setSampleSize(Integer sampleSize) {
        this.sampleSize = sampleSize;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public String getStudyDesign() {
        return studyDesign;
    }

    public void setStudyDesign(String studyDesign) {
        this.studyDesign = studyDesign;
    }

    public String getAssayMethods() {
        return assayMethods;
    }

    public void setAssayMethods(String assayMethods) {
        this.assayMethods = assayMethods;
    }

    public String getPharmacokineticMethods() {
        return pharmacokineticMethods;
    }

    public void setPharmacokineticMethods(String pharmacokineticMethods) {
        this.pharmacokineticMethods = pharmacokineticMethods;
    }

    public String getStatisticalMethods() {
        return statisticalMethods;
    }

    public void setStatisticalMethods(String statisticalMethods) {
        this.statisticalMethods = statisticalMethods;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public String getDiscussion() {
        return discussion;
    }

    public void setDiscussion(String discussion) {
        this.discussion = discussion;
    }

    public String getImplication() {
        return implication;
    }

    public void setImplication(String implication) {
        this.implication = implication;
    }

    public String getStudyType() {
        return studyType;
    }

    public void setStudyType(String studyType) {
        this.studyType = studyType;
    }

    public String getStudyDesignDetails() {
        return studyDesignDetails;
    }

    public void setStudyDesignDetails(String studyDesignDetails) {
        this.studyDesignDetails = studyDesignDetails;
    }

    public String getAssayMethodsDetails() {
        return assayMethodsDetails;
    }

    public void setAssayMethodsDetails(String assayMethodsDetails) {
        this.assayMethodsDetails = assayMethodsDetails;
    }

    public String getPharmacokineticMethodsDetails() {
        return pharmacokineticMethodsDetails;
    }

    public void setPharmacokineticMethodsDetails(String pharmacokineticMethodsDetails) {
        this.pharmacokineticMethodsDetails = pharmacokineticMethodsDetails;
    }

    public String getStatisticalMethodsDetails() {
        return statisticalMethodsDetails;
    }

    public void setStatisticalMethodsDetails(String statisticalMethodsDetails) {
        this.statisticalMethodsDetails = statisticalMethodsDetails;
    }

    public String getResultsDetails() {
        return resultsDetails;
    }

    public void setResultsDetails(String resultsDetails) {
        this.resultsDetails = resultsDetails;
    }

    public String getDiscussionDetails() {
        return discussionDetails;
    }

    public void setDiscussionDetails(String discussionDetails) {
        this.discussionDetails = discussionDetails;
    }

    public String getHerbAssayed() {
        return herbAssayed;
    }

    public void setHerbAssayed(String herbAssayed) {
        this.herbAssayed = herbAssayed;
    }

    public Integer getEvidenceRanking() {
        return evidenceRanking;
    }

    public void setEvidenceRanking(Integer evidenceRanking) {
        this.evidenceRanking = evidenceRanking;
    }

    public Integer getEvidenceRankingNHMRC() {
        return evidenceRankingNHMRC;
    }

    public void setEvidenceRankingNHMRC(Integer evidenceRankingNHMRC) {
        this.evidenceRankingNHMRC = evidenceRankingNHMRC;
    }

    public Integer getDocumentationRanking() {
        return documentationRanking;
    }

    public void setDocumentationRanking(Integer documentationRanking) {
        this.documentationRanking = documentationRanking;
    }

    public String getCommentsOnEvidence() {
        return commentsOnEvidence;
    }

    public void setCommentsOnEvidence(String commentsOnEvidence) {
        this.commentsOnEvidence = commentsOnEvidence;
    }

    public Integer getEvidenceType() {
        return evidenceType;
    }

    public void setEvidenceType(Integer evidenceType) {
        this.evidenceType = evidenceType;
    }

    public Integer getQa() {
        return qa;
    }

    public void setQa(Integer qa) {
        this.qa = qa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reports)) {
            return false;
        }
        Reports other = (Reports) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.unityhealth.model.Reports[ id=" + id + " ]";
    }
    
}
