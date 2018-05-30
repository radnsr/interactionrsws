package net.unityhealth.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="tblinteractions_logger")
@XmlRootElement
public class TblInteractionsLogger
{
  Date datetime;
  String productid;
  String ingredientid;
  String userid;
  Integer result;
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  Integer iId;
  String commonname;
  String partno;
  
  public Date getDatetime()
  {
    return this.datetime;
  }
  
  public void setDatetime(Date datetime)
  {
    this.datetime = datetime;
  }
  
  public String getProductid()
  {
    return this.productid;
  }
  
  public void setProductid(String productid)
  {
    this.productid = productid;
  }
  
  public String getIngredientid()
  {
    return this.ingredientid;
  }
  
  public void setIngredientid(String ingredientid)
  {
    this.ingredientid = ingredientid;
  }
  
  public String getUserid()
  {
    return this.userid;
  }
  
  public void setUserid(String userid)
  {
    this.userid = userid;
  }
  
  public Integer getResult()
  {
    return this.result;
  }
  
  public void setResult(Integer result)
  {
    this.result = result;
  }
  
  public Integer getiId()
  {
    return this.iId;
  }
  
  public void setiId(Integer iId)
  {
    this.iId = iId;
  }
  
  public String getCommonname()
  {
    return this.commonname;
  }
  
  public void setCommonname(String commonname)
  {
    this.commonname = commonname;
  }
  
  public String getPartno()
  {
    return this.partno;
  }
  
  public void setPartno(String partno)
  {
    this.partno = partno;
  }
}
