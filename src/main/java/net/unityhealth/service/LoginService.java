package net.unityhealth.service;

import java.util.List;


import net.unityhealth.model.AdminUsers;
import net.unityhealth.model.DrugInfo;
import net.unityhealth.model.HerbInfo;
import net.unityhealth.model.ProductInfo;
import net.unityhealth.model.Reports;
import net.unityhealth.security.TokenInfo;

public interface LoginService {

	AdminUsers findByUsername(String username);

	String findLoggedInUsername();

	void login(String username, String password);

	/**
	 * Authenticates the user and returns valid token. If anything fails,
	 * {@code null} is returned instead. Prepares
	 * {@link org.springframework.security.core.context.SecurityContext} if
	 * authentication succeeded.
	 */
	TokenInfo authenticate(String login, String password);

	/**
	 * Checks the authentication token and if it is valid prepares
	 * {@link org.springframework.security.core.context.SecurityContext} and returns
	 * true.
	 */
	boolean checkToken(String token);

	/** Logouts the user - token is invalidated/forgotten. */
	void logout(String token);

	/**
	 * Returns current user or {@code null} if there is no authentication or user is
	 * anonymous.
	 */
	AdminUsers currentUser();

	ProductInfo findIngsByProdId(String vProductId);

	List<Object> findIntsByIngName(List<String> vIngNames);

	ProductInfo getSearchResultsFromProductId(String vProductId);

	ProductInfo getSearchResultsFromPartNo(String vPartNo);

	ProductInfo getSerachResultsByIngredients(List<String> vIngNames);

	ProductInfo getSerachResultsByIngredients(List<String> vIngNames, String userID);

	ProductInfo getSearchResultsFromLicenseId(String vLicenseId);//AusTL Number
        
        DrugInfo getSearchResultsByDrugID(String drugId);
        
        List<Reports> findReportsByGeneralInteractionID(String generalInteractionID);
        
        HerbInfo getSearchResultsByHerbID(String HerbID);
}
