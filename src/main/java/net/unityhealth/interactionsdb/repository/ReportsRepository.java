package net.unityhealth.interactionsdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.unityhealth.model.Reports;

public interface ReportsRepository extends JpaRepository<Reports, Long> {
      //@Query(value = " SELECT  * from reports as r where r.InteractionID = ?1 "
	  @Query(value = " SELECT  r from Reports r where r.interactionID = ?1 ")
		//,nativeQuery = true)
	List<Reports> findByInteractionID(String generalInteractionID);
	
}
