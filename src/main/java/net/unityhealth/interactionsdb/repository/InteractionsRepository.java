package net.unityhealth.interactionsdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.unityhealth.model.Herbs;

public interface InteractionsRepository extends JpaRepository<Herbs, Long> {
	
	@Query(value = "SELECT DISTINCT h.id, h.commonname as name, 'herb' as type from herbs h, interactionsgeneral ig where h.id > 0 "
			+	"and commonName in ?1 and ig.HerbID = h.ID and ig.DocStatus='Approved' "
			+ " UNION " +
			" SELECT DISTINCT d.id, d.commonname as name, 'drug' as type from drugs d, interactionsgeneral ig where d.id > 0  and commonName  in ?1 and ig.DrugID = d.ID and ig.DocStatus='Approved'"
			+ " UNION " + " SELECT DISTINCT t.id, t.name, 'drugclass' as type from tci t, interactionsgeneral ig where t.id > 0 and name  in ?1 and ig.DrugID = t.ID and ig.DocStatus='Approved' "
		,nativeQuery = true)
	List<Object> findByIngName(List<String> commonName);
}
