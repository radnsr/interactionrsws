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
 * @author Clinton
 */
@Entity
@Table(name = "tblproductingredientassoc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblproductingredientassoc.findAll", query = "SELECT t FROM Tblproductingredientassoc t"),
    @NamedQuery(name = "Tblproductingredientassoc.findByIID", query = "SELECT t FROM Tblproductingredientassoc t WHERE t.iID = :iID"),
    @NamedQuery(name = "Tblproductingredientassoc.findByIProductID", query = "SELECT t FROM Tblproductingredientassoc t WHERE t.iProductID = :iProductID"),
    @NamedQuery(name = "Tblproductingredientassoc.findByIIngredientID", query = "SELECT t FROM Tblproductingredientassoc t WHERE t.iIngredientID = :iIngredientID"),
    @NamedQuery(name = "Tblproductingredientassoc.findByIIngredientIDIproductID", query = "SELECT t FROM Tblproductingredientassoc t WHERE t.iIngredientID = :iIngredientID AND t.iProductID = :iProductID"),
    @NamedQuery(name = "Tblproductingredientassoc.findByVQty", query = "SELECT t FROM Tblproductingredientassoc t WHERE t.vQty = :vQty"),
    @NamedQuery(name = "Tblproductingredientassoc.findByVQtyUnit", query = "SELECT t FROM Tblproductingredientassoc t WHERE t.vQtyUnit = :vQtyUnit"),
    @NamedQuery(name = "Tblproductingredientassoc.findDistinctVQtyUnit", query = "SELECT DISTINCT t.vQtyUnit FROM Tblproductingredientassoc t order by t.vQtyUnit"),
    @NamedQuery(name = "Tblproductingredientassoc.findByIParentID", query = "SELECT t FROM Tblproductingredientassoc t WHERE t.iParentID = :iParentID")})
public class Tblproductingredientassoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iID")
    private Integer iID;
    @Column(name = "iProductID")
    private Integer iProductID;
    @Column(name = "iIngredientID")
    private Integer iIngredientID;
    @Column(name = "vQty")
    private String vQty;
    @Column(name = "vQtyUnit")
    private String vQtyUnit;
    @Column(name = "iParentID")
    private Integer iParentID;

    public Tblproductingredientassoc() {
    }

    public Tblproductingredientassoc(Integer iID) {
        this.iID = iID;
    }

    public Integer getIID() {
        return iID;
    }

    public void setIID(Integer iID) {
        this.iID = iID;
    }

    public Integer getIProductID() {
        return iProductID;
    }

    public void setIProductID(Integer iProductID) {
        this.iProductID = iProductID;
    }

    public Integer getIIngredientID() {
        return iIngredientID;
    }

    public void setIIngredientID(Integer iIngredientID) {
        this.iIngredientID = iIngredientID;
    }

    public String getVQty() {
        return vQty;
    }

    public void setVQty(String vQty) {
        this.vQty = vQty;
    }

    public String getVQtyUnit() {
        return vQtyUnit;
    }

    public void setVQtyUnit(String vQtyUnit) {
        this.vQtyUnit = vQtyUnit;
    }

    public Integer getIParentID() {
        return iParentID;
    }

    public void setIParentID(Integer iParentID) {
        this.iParentID = iParentID;
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
        if (!(object instanceof Tblproductingredientassoc)) {
            return false;
        }
        Tblproductingredientassoc other = (Tblproductingredientassoc) object;
        if ((this.iID == null && other.iID != null) || (this.iID != null && !this.iID.equals(other.iID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unityhealth.model.Tblproductingredientassoc[ iID=" + iID + " ]";
    }
    
}
