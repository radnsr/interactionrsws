package net.unityhealth.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.util.StringUtils;

import com.unityhealth.imgateway.interactions.db.dao.InteractionSearchDAO;
import com.unityhealth.imgateway.interactions.db.model.SearchResult;
import com.unityhealth.imgateway.web.service.model.SearchContent;

import net.unityhealth.interactionsdb.repository.InteractionsRepository;
import net.unityhealth.model.AdminUsers;
import net.unityhealth.model.ProductInfo;
import net.unityhealth.repository.ProductRepository;
import net.unityhealth.security.TokenInfo;
import net.unityhealth.security.TokenManager;

public class LoginServiceImpl implements LoginService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private final TokenManager tokenManager;

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private InteractionsRepository interactionsRepository;

	@Override
	public String findLoggedInUsername() {
		Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
		if (userDetails instanceof UserDetails) {
			return ((UserDetails) userDetails).getUsername();
		}

		return null;
	}

	@Override
	public void login(String username, String password) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				userDetails, password, userDetails.getAuthorities());

		authenticationManager.authenticate(usernamePasswordAuthenticationToken);

		if (usernamePasswordAuthenticationToken.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			logger.debug(String.format("Auto login %s successfully!", username));
		}
	}

	@Override
	public AdminUsers findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public LoginServiceImpl(AuthenticationManager authenticationManager, TokenManager tokenManager) {
		this.authenticationManager = authenticationManager;
		this.tokenManager = tokenManager;
	}

	@PostConstruct
	public void init() {
		System.out.println(" *** AuthenticationServiceImpl.init with: " + applicationContext);
	}

	@Override
	public TokenInfo authenticate(String login, String password) {
		System.out.println(" *** AuthenticationServiceImpl.authenticate");

		// Here principal=username, credentials=password
		Authentication authentication = new UsernamePasswordAuthenticationToken(login, password);
		try {
			authentication = authenticationManager.authenticate(authentication);
			// Here principal=UserDetails (UserContext in our case),
			// credentials=null (security reasons)
			SecurityContextHolder.getContext().setAuthentication(authentication);

			if (authentication.getPrincipal() != null) {
				UserDetails userContext = (UserDetails) authentication.getPrincipal();

				TokenInfo newToken = tokenManager.createNewToken(userContext);
				if (newToken == null) {
					return null;
				}
				return newToken;
			}
		} catch (AuthenticationException e) {
			System.out.println(" *** AuthenticationServiceImpl.authenticate - FAILED: " + e.toString());
		}
		return null;
	}

	@Override
	public boolean checkToken(String token) {
		System.out.println(" *** AuthenticationServiceImpl.checkToken");

		UserDetails userDetails = tokenManager.getUserDetails(token);
		if (userDetails == null) {
			return false;
		}
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		// for (Role role : user.getRoles()){
		// grantedAuthorities.add(new SimpleGrantedAuthority(""));
		// }
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_CLIENT"));

		Authentication securityToken = new PreAuthenticatedAuthenticationToken(userDetails, null, grantedAuthorities);
		SecurityContextHolder.getContext().setAuthentication(securityToken);

		return true;
	}

	@Override
	public void logout(String token) {
		UserDetails logoutUser = tokenManager.removeToken(token);
		System.out.println(" *** AuthenticationServiceImpl.logout: " + logoutUser);
		SecurityContextHolder.clearContext();
	}

	@Override
	public AdminUsers currentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return null;
		}
		return (AdminUsers) authentication.getPrincipal();
	}

	@Override
	public ProductInfo findIngsByProdId(String vProductId) {
		// TODO Auto-generated method stub

		return getSearchResultsFromProductId(vProductId);
	}

	@Override
	public List<Object> findIntsByIngName(List<String> commonNames) {
		// TODO Auto-generated method stub

		return interactionsRepository.findByIngName(commonNames);
	}

	@Override
	public ProductInfo getSearchResultsFromProductId(String vProductId) {
		// TODO Auto-generated method stub
		ProductInfo productInfo = new ProductInfo();
		List<Object> ingList = productRepository.findIngsByProdId(vProductId);
		List<String> ingStrList = new ArrayList<String>();
		for (Object ingredient : ingList) {
			Object[] objArr = (Object[]) ingredient;
			System.out.println((String) objArr[1]);
			if (!StringUtils.isEmpty(((String) objArr[1])))
				ingStrList.add(((String) objArr[1]).trim());
		}
		// getSearchResults(formSearchContent(interactionsRepository.findByIngName(ingStrList)));
		
		if(ingStrList.size()>0){
			productInfo.setProductId(vProductId);
			
			if(!ingList.isEmpty()){
				Object[] objArr = (Object[])ingList.get(0);
				productInfo.setProductName((String)objArr[0]);
			}
			productInfo.setInteractions(getSearchResults(formSearchContent(interactionsRepository.findByIngName(ingStrList))));
			
		}
			
			return productInfo;
		
	}

	private SearchContent formSearchContent(List<Object> resultList) {
		List<String> herbIdsLst = new ArrayList<String>();
		List<String> drugIdsLst = new ArrayList<String>();
		List<String> drugClsIdsLst = new ArrayList<String>();
		for (Object row : resultList) {
			Object[] objArr = (Object[]) row;
			System.out.println((String) objArr[1]);
			if (((String) objArr[2]).equalsIgnoreCase("herb"))
				herbIdsLst.add(String.valueOf(((Integer) objArr[0])));
			if (((String) objArr[2]).equalsIgnoreCase("drug"))
				drugIdsLst.add(String.valueOf(((Integer) objArr[0])));
			if (((String) objArr[2]).equalsIgnoreCase("drugclass"))
				drugClsIdsLst.add(String.valueOf(((Integer) objArr[0])));
		}

		SearchContent searchContent = new SearchContent();
		searchContent.setDrugClassIDs((String[]) drugClsIdsLst.toArray(new String[0]));
		searchContent.setDrugIDs((String[]) drugIdsLst.toArray(new String[0]));
		searchContent.setHerbIDs((String[]) herbIdsLst.toArray(new String[0]));
		return searchContent;
	}

	private List<SearchResult> getSearchResults(SearchContent sContent) {
		System.out.println(String.format("SearchContent INPUT [%s]", sContent));

		// ServletContext context = request.getSession().getServletContext();
		String db = "interactions";// context.getInitParameter("DB_CONNECTION_MAIN");
		InteractionSearchDAO sDAO = new InteractionSearchDAO(db);

		boolean userSearch = sContent.isUserSearch();
		String herbID = sContent.getHerbID();
		String drugID = sContent.getDrugID();
		String drugClassID = sContent.getDrugClassID();
		String[] herbIDs = sContent.getHerbIDs();
		String[] drugIDs = sContent.getDrugIDs();
		String[] drugClassIDs = sContent.getDrugClassIDs();
		String searchStr = sContent.getSearchStr();
		if (herbIDs.length > 0 || drugIDs.length > 0 || drugClassIDs.length > 0) {
			List<SearchResult> searchResults = sDAO.getSearchResults(userSearch, herbID, drugID, drugClassID,
					herbIDs, drugIDs, drugClassIDs, searchStr);
			System.out.println(searchResults.get(0));
			return searchResults;
		}
		
		return new ArrayList<SearchResult>();
		
		// return Response.status(201).entity(searchResults).build();
	}
	
	@Override
	public ProductInfo getSearchResultsFromPartNo(String vPartNo) {
		// TODO Auto-generated method stub
		ProductInfo productInfo = new ProductInfo();
		List<Object> ingList = productRepository.findIngsByPartNo(vPartNo);
		List<String> ingStrList = new ArrayList<String>();
		for (Object ingredient : ingList) {
			Object[] objArr = (Object[]) ingredient;
			System.out.println((String) objArr[1]);
			if (!StringUtils.isEmpty(((String) objArr[1])))
				ingStrList.add(((String) objArr[1]).trim());
		}
		if(ingStrList.size()>0){
			productInfo.setPartNo(vPartNo);
			
			if(!ingList.isEmpty()){
				Object[] objArr = (Object[])ingList.get(0);
				productInfo.setProductName((String)objArr[0]);
			}
			productInfo.setInteractions(getSearchResults(formSearchContent(interactionsRepository.findByIngName(ingStrList))));
			
		}
			
			return productInfo;
	}


}
