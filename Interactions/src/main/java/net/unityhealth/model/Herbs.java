package net.unityhealth.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "herbs")
public class Herbs {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ID;
	private String CommonName;
	private String ScientificName;
	private String OtherNames;
	private Date LastChangeDate;
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getCommonName() {
		return CommonName;
	}
	public void setCommonName(String commonName) {
		CommonName = commonName;
	}
	public String getScientificName() {
		return ScientificName;
	}
	public void setScientificName(String scientificName) {
		ScientificName = scientificName;
	}
	public String getOtherNames() {
		return OtherNames;
	}
	public void setOtherNames(String otherNames) {
		OtherNames = otherNames;
	}
	public Date getLastChangeDate() {
		return LastChangeDate;
	}
	public void setLastChangeDate(Date lastChangeDate) {
		LastChangeDate = lastChangeDate;
	}
}
