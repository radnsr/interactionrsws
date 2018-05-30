/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unityhealth.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameer
 */
@Entity
@Table(name = "tblproductingredients")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblproductingredients.findAll", query = "SELECT t FROM Tblproductingredients t"),
    @NamedQuery(name = "Tblproductingredients.findByIID", query = "SELECT t FROM Tblproductingredients t WHERE t.iID = :iID"),
    @NamedQuery(name = "Tblproductingredients.findByVCode", query = "SELECT t FROM Tblproductingredients t WHERE t.vCode = :vCode"),
    @NamedQuery(name = "Tblproductingredients.findByVName", query = "SELECT t FROM Tblproductingredients t WHERE t.vName = :vName"),
    @NamedQuery(name = "Tblproductingredients.findByVNameLst", query = "SELECT t FROM Tblproductingredients t WHERE t.vName in :vNameLst"),
    @NamedQuery(name = "Tblproductingredients.findByVCommonName", query = "SELECT t FROM Tblproductingredients t WHERE t.vCommonName = :vCommonName"),
    @NamedQuery(name = "Tblproductingredients.findByVDesc", query = "SELECT t FROM Tblproductingredients t WHERE t.vDesc = :vDesc"),
    @NamedQuery(name = "Tblproductingredients.findByBCustom", query = "SELECT t FROM Tblproductingredients t WHERE t.bCustom = :bCustom"),
    @NamedQuery(name = "Tblproductingredients.findByVCustomBy", query = "SELECT t FROM Tblproductingredients t WHERE t.vCustomBy = :vCustomBy")})
public class Tblproductingredients implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iID")
    private Integer iID;
    @Column(name = "vCode")
    private String vCode;
    @Column(name = "vName")
    private String vName;
    @Column(name = "vCommonName")
    private String vCommonName;
    @Column(name = "vDesc")
    private String vDesc;
    @Column(name = "bCustom")
    private Boolean bCustom;
    @Column(name = "vCustomBy")
    private String vCustomBy;
    @Column(name = "vIngredientID")
    private String vIngredientID;
    public Tblproductingredients() {
    }

    public Tblproductingredients(Integer iID) {
        this.iID = iID;
    }

    public Integer getIID() {
        return iID;
    }

    public void setIID(Integer iID) {
        this.iID = iID;
    }

    public String getVCode() {
        return vCode;
    }

    public void setVCode(String vCode) {
        this.vCode = vCode;
    }

    public String getVName() {
        return vName;
    }

    public void setVName(String vName) {
        this.vName = vName;
    }

    public String getVCommonName() {
        return vCommonName;
    }

    public void setVCommonName(String vCommonName) {
        this.vCommonName = vCommonName;
    }

    public String getVDesc() {
        return vDesc;
    }

    public void setVDesc(String vDesc) {
        this.vDesc = vDesc;
    }

    public Boolean getBCustom() {
        return bCustom;
    }

    public void setBCustom(Boolean bCustom) {
        this.bCustom = bCustom;
    }

    public String getVCustomBy() {
        return vCustomBy;
    }

    public void setVCustomBy(String vCustomBy) {
        this.vCustomBy = vCustomBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iID != null ? iID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblproductingredients)) {
            return false;
        }
        Tblproductingredients other = (Tblproductingredients) object;
        if ((this.iID == null && other.iID != null) || (this.iID != null && !this.iID.equals(other.iID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unityhealth.model.Tblproductingredients[ iID=" + iID + " ]";
    }

    /**
     * @return the vIngredientID
     */
    public String getvIngredientID() {
        return vIngredientID;
    }

    /**
     * @param vIngredientID the vIngredientID to set
     */
    public void setvIngredientID(String vIngredientID) {
        this.vIngredientID = vIngredientID;
    }
    
}
