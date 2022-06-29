package net.unityhealth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.unityhealth.model.Tblproduct;

public interface ProductRepository extends JpaRepository<Tblproduct, Long> {
	@Query(value = "select distinct prod.vName ProdName, case when ISNULL(ing.vCommonName) or ing.vCommonName ='' then ing.vName else ing.vCommonName end as ingName from tblproduct prod"
			+ " join tblproductingredientassoc ingAssoc on prod.iID = ingAssoc.iProductID "
			+ "join tblproductingredients ing on ingAssoc.iIngredientID = ing.iID where prod.vproductid =?1",
			nativeQuery = true)
	List<Object> findIngsByProdId(String vProductId);
	
	@Query(value = "select distinct prod.vName ProdName, case when ISNULL(ing.vCommonName) or ing.vCommonName ='' then ing.vName else ing.vCommonName end as ingName from tblproduct prod"
			+ " join tblproductingredientassoc ingAssoc on prod.iID = ingAssoc.iProductID "
			+ "join tblproductingredients ing on ingAssoc.iIngredientID = ing.iID where prod.vPartNo =?1",
			nativeQuery = true)
	List<Object> findIngsByPartNo(String vPartNo);
	
	@Query(value = "select distinct prod.vName ProdName, case when ISNULL(ing.vCommonName) or ing.vCommonName ='' then ing.vName else ing.vCommonName end as ingName from tblproduct prod"
			+ " join tblproductingredientassoc ingAssoc on prod.iID = ingAssoc.iProductID "
			+ "join tblproductingredients ing on ingAssoc.iIngredientID = ing.iID where prod.iLicenceId =?1",
			nativeQuery = true)
	List<Object> findIngsByLicenseId(String vLicenseId);
	
	@Query(value = "select distinct prod.vName ProdName, case when ISNULL(ing.vCommonName) or ing.vCommonName ='' then ing.vName else ing.vCommonName end as ingName from tblproduct prod"
			+ " join tblproductingredientassoc ingAssoc on prod.iID = ingAssoc.iProductID "
			+ "join tblproductingredients ing on ingAssoc.iIngredientID = ing.iID where prod.iAUSTL  =?1",
			nativeQuery = true)
	List<Object> findIngsByAustlId(String austlId);

}
