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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameer
 */
@Entity
@Table(name = "tblproduct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblproduct.findAll", query = "SELECT t FROM Tblproduct t"),
    @NamedQuery(name = "Tblproduct.findByIID", query = "SELECT t FROM Tblproduct t WHERE t.iID = :iID"),
    @NamedQuery(name = "Tblproduct.findMaxIID", query = "SELECT MAX(t.iID) FROM Tblproduct t"),
    @NamedQuery(name = "Tblproduct.findByIBrandID", query = "SELECT t FROM Tblproduct t WHERE t.iBrandID = :iBrandID"),
    @NamedQuery(name = "Tblproduct.findByICategoryID", query = "SELECT t FROM Tblproduct t WHERE t.iCategoryID = :iCategoryID"),
    @NamedQuery(name = "Tblproduct.findByVName", query = "SELECT t FROM Tblproduct t WHERE t.vName = :vName"),
    @NamedQuery(name = "Tblproduct.findByVCode", query = "SELECT t FROM Tblproduct t WHERE t.vCode = :vCode"),
    @NamedQuery(name = "Tblproduct.findByVRegNumType", query = "SELECT t FROM Tblproduct t WHERE t.vRegNumType = :vRegNumType"),
    @NamedQuery(name = "Tblproduct.findByVRegNum", query = "SELECT t FROM Tblproduct t WHERE t.vRegNum = :vRegNum"),
    @NamedQuery(name = "Tblproduct.findByIAUSTR", query = "SELECT t FROM Tblproduct t WHERE t.iAUSTR = :iAUSTR"),
    @NamedQuery(name = "Tblproduct.findByIAUSTL", query = "SELECT t FROM Tblproduct t WHERE t.iAUSTL = :iAUSTL"),
    @NamedQuery(name = "Tblproduct.findByVSize", query = "SELECT t FROM Tblproduct t WHERE t.vSize = :vSize"),
    @NamedQuery(name = "Tblproduct.findByVQtyUnit", query = "SELECT t FROM Tblproduct t WHERE t.vQtyUnit = :vQtyUnit"),
    @NamedQuery(name = "Tblproduct.findByIStorageTempID", query = "SELECT t FROM Tblproduct t WHERE t.iStorageTempID = :iStorageTempID"),
    @NamedQuery(name = "Tblproduct.findByIStorageInfoID", query = "SELECT t FROM Tblproduct t WHERE t.iStorageInfoID = :iStorageInfoID"),
    @NamedQuery(name = "Tblproduct.findByVRRP", query = "SELECT t FROM Tblproduct t WHERE t.vRRP = :vRRP"),
    @NamedQuery(name = "Tblproduct.findByVImage", query = "SELECT t FROM Tblproduct t WHERE t.vImage = :vImage"),
    @NamedQuery(name = "Tblproduct.findByVImageID", query = "SELECT t FROM Tblproduct t WHERE t.vImageID = :vImageID"),
    @NamedQuery(name = "Tblproduct.findByVDosage", query = "SELECT t FROM Tblproduct t WHERE t.vDosage = :vDosage"),
    @NamedQuery(name = "Tblproduct.findByBActive", query = "SELECT t FROM Tblproduct t WHERE t.bActive = :bActive"),
    @NamedQuery(name = "Tblproduct.findByVURL", query = "SELECT t FROM Tblproduct t WHERE t.vURL = :vURL"),
    @NamedQuery(name = "Tblproduct.findByVIngPer", query = "SELECT t FROM Tblproduct t WHERE t.vIngPer = :vIngPer"),
    @NamedQuery(name = "Tblproduct.findByVNutriCalories", query = "SELECT t FROM Tblproduct t WHERE t.vNutriCalories = :vNutriCalories"),
    @NamedQuery(name = "Tblproduct.findByVNutriProtein", query = "SELECT t FROM Tblproduct t WHERE t.vNutriProtein = :vNutriProtein"),
    @NamedQuery(name = "Tblproduct.findByVNutriCarbs", query = "SELECT t FROM Tblproduct t WHERE t.vNutriCarbs = :vNutriCarbs"),
    @NamedQuery(name = "Tblproduct.findByVNutriFat", query = "SELECT t FROM Tblproduct t WHERE t.vNutriFat = :vNutriFat"),
    @NamedQuery(name = "Tblproduct.findByVNutriSodium", query = "SELECT t FROM Tblproduct t WHERE t.vNutriSodium = :vNutriSodium"),
    @NamedQuery(name = "Tblproduct.findByVNutriPotassium", query = "SELECT t FROM Tblproduct t WHERE t.vNutriPotassium = :vNutriPotassium"),
    @NamedQuery(name = "Tblproduct.findByVNutriFibre", query = "SELECT t FROM Tblproduct t WHERE t.vNutriFibre = :vNutriFibre"),
    @NamedQuery(name = "Tblproduct.findByVNutriVitRDI", query = "SELECT t FROM Tblproduct t WHERE t.vNutriVitRDI = :vNutriVitRDI"),
    @NamedQuery(name = "Tblproduct.findByVNutriLactose", query = "SELECT t FROM Tblproduct t WHERE t.vNutriLactose = :vNutriLactose"),
    @NamedQuery(name = "Tblproduct.findByVPartNo", query = "SELECT t FROM Tblproduct t WHERE t.vPartNo = :vPartNo"),
    @NamedQuery(name = "Tblproduct.findByVProductId", query = "SELECT t FROM Tblproduct t WHERE t.vProductId = :vProductId")})
public class Tblproduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iID")
    private Integer iID;
    @Basic(optional = false)
    @Column(name = "iBrandID")
    private int iBrandID;
    @Column(name = "iCategoryID")
    private Integer iCategoryID;
    @Column(name = "vName")
    private String vName;
    @Column(name = "vCode")
    private String vCode;
    @Lob
    @Column(name = "vDescription")
    private String vDescription;
    @Column(name = "vRegNumType")
    private String vRegNumType;
    @Column(name = "vRegNum")
    private String vRegNum;
    @Column(name = "iAUSTR")
    private String iAUSTR;
    @Column(name = "iAUSTL")
    private String iAUSTL;
    @Column(name = "vSize")
    private String vSize;
    @Column(name = "vQtyUnit")
    private String vQtyUnit;
    @Column(name = "iStorageTempID")
    private Integer iStorageTempID;
    @Column(name = "iStorageInfoID")
    private Integer iStorageInfoID;
    @Column(name = "vRRP")
    private String vRRP;
    @Column(name = "vImage")
    private String vImage;
    @Column(name = "vImageID")
    private Integer vImageID;
    @Lob
    @Column(name = "vDesc")
    private String vDesc;
    @Column(name = "vDosage")
    private String vDosage;
    @Basic(optional = false)
    @Column(name = "bActive")
    private int bActive;
    @Column(name = "vURL")
    private String vURL;
    @Column(name = "vIngPer")
    private String vIngPer;
    @Column(name = "vNutriCalories")
    private String vNutriCalories;
    @Column(name = "vNutriProtein")
    private String vNutriProtein;
    @Column(name = "vNutriCarbs")
    private String vNutriCarbs;
    @Column(name = "vNutriFat")
    private String vNutriFat;
    @Column(name = "vNutriSodium")
    private String vNutriSodium;
    @Column(name = "vNutriPotassium")
    private String vNutriPotassium;
    @Column(name = "vNutriFibre")
    private String vNutriFibre;
    @Column(name = "vNutriVitRDI")
    private String vNutriVitRDI;
    @Column(name = "vNutriLactose")
    private String vNutriLactose;
    @Lob
    @Column(name = "vSearchText")
    private String vSearchText;
    
     @Column(name = "vProductId")
    private String vProductId;
     
      @Column(name = "vPartNo")
    private String vPartNo;

    public Tblproduct() {
    }

    public Tblproduct(Integer iID) {
        this.iID = iID;
    }

    public Tblproduct(Integer iID, int iBrandID, int bActive) {
        this.iID = iID;
        this.iBrandID = iBrandID;
        this.bActive = bActive;
    }

    public Integer getIID() {
        return iID;
    }

    public void setIID(Integer iID) {
        this.iID = iID;
    }

    public int getIBrandID() {
        return iBrandID;
    }

    public void setIBrandID(int iBrandID) {
        this.iBrandID = iBrandID;
    }

    public Integer getICategoryID() {
        return iCategoryID;
    }

    public void setICategoryID(Integer iCategoryID) {
        this.iCategoryID = iCategoryID;
    }

    public String getVName() {
        return vName;
    }

    public void setVName(String vName) {
        this.vName = vName;
    }

    public String getVCode() {
        return vCode;
    }

    public void setVCode(String vCode) {
        this.vCode = vCode;
    }

    public String getVDescription() {
        return vDescription;
    }

    public void setVDescription(String vDescription) {
        this.vDescription = vDescription;
    }

    public String getVRegNumType() {
        return vRegNumType;
    }

    public void setVRegNumType(String vRegNumType) {
        this.vRegNumType = vRegNumType;
    }

    public String getVRegNum() {
        return vRegNum;
    }

    public void setVRegNum(String vRegNum) {
        this.vRegNum = vRegNum;
    }

    public String getIAUSTR() {
        return iAUSTR;
    }

    public void setIAUSTR(String iAUSTR) {
        this.iAUSTR = iAUSTR;
    }

    public String getIAUSTL() {
        return iAUSTL;
    }

    public void setIAUSTL(String iAUSTL) {
        this.iAUSTL = iAUSTL;
    }

    public String getVSize() {
        return vSize;
    }

    public void setVSize(String vSize) {
        this.vSize = vSize;
    }

    public String getVQtyUnit() {
        return vQtyUnit;
    }

    public void setVQtyUnit(String vQtyUnit) {
        this.vQtyUnit = vQtyUnit;
    }

    public Integer getIStorageTempID() {
        return iStorageTempID;
    }

    public void setIStorageTempID(Integer iStorageTempID) {
        this.iStorageTempID = iStorageTempID;
    }

    public Integer getIStorageInfoID() {
        return iStorageInfoID;
    }

    public void setIStorageInfoID(Integer iStorageInfoID) {
        this.iStorageInfoID = iStorageInfoID;
    }

    public String getVRRP() {
        return vRRP;
    }

    public void setVRRP(String vRRP) {
        this.vRRP = vRRP;
    }

    public String getVImage() {
        return vImage;
    }

    public void setVImage(String vImage) {
        this.vImage = vImage;
    }

    public Integer getVImageID() {
        return vImageID;
    }

    public void setVImageID(Integer vImageID) {
        this.vImageID = vImageID;
    }

    public String getVDesc() {
        return vDesc;
    }

    public void setVDesc(String vDesc) {
        this.vDesc = vDesc;
    }

    public String getVDosage() {
        return vDosage;
    }

    public void setVDosage(String vDosage) {
        this.vDosage = vDosage;
    }

    public int getBActive() {
        return bActive;
    }

    public void setBActive(int bActive) {
        this.bActive = bActive;
    }

    public String getVURL() {
        return vURL;
    }

    public void setVURL(String vURL) {
        this.vURL = vURL;
    }

    public String getVIngPer() {
        return vIngPer;
    }

    public void setVIngPer(String vIngPer) {
        this.vIngPer = vIngPer;
    }

    public String getVNutriCalories() {
        return vNutriCalories;
    }

    public void setVNutriCalories(String vNutriCalories) {
        this.vNutriCalories = vNutriCalories;
    }

    public String getVNutriProtein() {
        return vNutriProtein;
    }

    public void setVNutriProtein(String vNutriProtein) {
        this.vNutriProtein = vNutriProtein;
    }

    public String getVNutriCarbs() {
        return vNutriCarbs;
    }

    public void setVNutriCarbs(String vNutriCarbs) {
        this.vNutriCarbs = vNutriCarbs;
    }

    public String getVNutriFat() {
        return vNutriFat;
    }

    public void setVNutriFat(String vNutriFat) {
        this.vNutriFat = vNutriFat;
    }

    public String getVNutriSodium() {
        return vNutriSodium;
    }

    public void setVNutriSodium(String vNutriSodium) {
        this.vNutriSodium = vNutriSodium;
    }

    public String getVNutriPotassium() {
        return vNutriPotassium;
    }

    public void setVNutriPotassium(String vNutriPotassium) {
        this.vNutriPotassium = vNutriPotassium;
    }

    public String getVNutriFibre() {
        return vNutriFibre;
    }

    public void setVNutriFibre(String vNutriFibre) {
        this.vNutriFibre = vNutriFibre;
    }

    public String getVNutriVitRDI() {
        return vNutriVitRDI;
    }

    public void setVNutriVitRDI(String vNutriVitRDI) {
        this.vNutriVitRDI = vNutriVitRDI;
    }

    public String getVNutriLactose() {
        return vNutriLactose;
    }

    public void setVNutriLactose(String vNutriLactose) {
        this.vNutriLactose = vNutriLactose;
    }

    public String getVSearchText() {
        return vSearchText;
    }

    public void setVSearchText(String vSearchText) {
        this.vSearchText = vSearchText;
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
        if (!(object instanceof Tblproduct)) {
            return false;
        }
        Tblproduct other = (Tblproduct) object;
        if ((this.iID == null && other.iID != null) || (this.iID != null && !this.iID.equals(other.iID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unityhealth.model.Tblproduct[ iID=" + iID + " ]";
    }

    /**
     * @return the vProductId
     */
    public String getvProductId() {
        return vProductId;
    }

    /**
     * @param vProductId the vProductId to set
     */
    public void setvProductId(String vProductId) {
        this.vProductId = vProductId;
    }

    public String getvPartNo() {
        return vPartNo;
    }

    public void setvPartNo(String vPartNo) {
        this.vPartNo = vPartNo;
    }
    
}
