package net.unityhealth.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.unityhealth.imgateway.interactions.db.dao.InteractionSearchDAO;
import com.unityhealth.imgateway.interactions.db.dao.ReportDAO;
import com.unityhealth.imgateway.interactions.db.dao.SummaryDAO;
import com.unityhealth.imgateway.interactions.db.model.Report;
import com.unityhealth.imgateway.interactions.db.model.SearchResult;
import com.unityhealth.imgateway.interactions.db.model.Summary;
import com.unityhealth.imgateway.web.service.model.SearchContent;
import java.util.HashMap;

import net.unityhealth.model.AdminUsers;
import net.unityhealth.model.DrugInfo;
import net.unityhealth.model.GeneralInteractionInfo;
import net.unityhealth.model.HerbInfo;
import net.unityhealth.model.ProductInfo;
import net.unityhealth.model.Reports;
import net.unityhealth.service.LoginService;
import net.unityhealth.validator.UserValidator;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//import org.json.JSONObject;

@RestController
@EnableWebMvc
public class LoginController {
	@Autowired
	private LoginService loginService;

	@Autowired
	private UserValidator userValidator;
	String db = "interactions";

	@RequestMapping(value = "/dummy", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") AdminUsers userForm, BindingResult bindingResult,
			Model model) {
		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "registration";
		}

		// userService.save(userForm);

		loginService.login(userForm.getUsername(), userForm.getPassword());

		return "redirect:/welcome";
	}

	@RequestMapping(value = { "/searchall" }, headers = { "Accept=application/json" }, produces = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public List<SearchResult> welcome(Model model) {
		SearchContent searchContent = new SearchContent();
		List<SearchResult> searchResults = getSearchResults(searchContent);
		return searchResults;
	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public String logout(Model model) {
		SearchContent searchContent = new SearchContent();
		getSearchResults(searchContent);
		return "welcome";
	}

	public List<SearchResult> getSearchResults(SearchContent sContent) {
		System.out.println(String.format("SearchContent INPUT [%s]", sContent));

		// ServletContext context = request.getSession().getServletContext();
		// String db = "interactions";//context.getInitParameter("DB_CONNECTION_MAIN");
		InteractionSearchDAO sDAO = new InteractionSearchDAO(db);

		boolean userSearch = sContent.isUserSearch();
		String herbID = sContent.getHerbID();
		String drugID = sContent.getDrugID();
		String drugClassID = sContent.getDrugClassID();
		String[] herbIDs = sContent.getHerbIDs();
		String[] drugIDs = sContent.getDrugIDs();
		String[] drugClassIDs = sContent.getDrugClassIDs();
		String searchStr = sContent.getSearchStr();

		ArrayList<SearchResult> searchResults = sDAO.getSearchResults(userSearch, herbID, drugID, drugClassID, herbIDs,
				drugIDs, drugClassIDs, searchStr);
		System.out.println(searchResults.get(0));
		return searchResults;
		// return Response.status(201).entity(searchResults).build();
	}

	@RequestMapping(value = { "/v1/interaction/{generalInteractionId}" }, headers = {
			"Accept=application/json" }, produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public List<Report> getReportList(@PathVariable String generalInteractionId) {
		List<Report> listReport = new ArrayList<Report>();
		try {
			ReportDAO reportDAO = new ReportDAO(db);
			return reportDAO.getReportByGeneralInteractionID(generalInteractionId);
		} catch (Exception e) {
			Report report = new Report(generalInteractionId, e.getMessage());

			listReport.add(report);
		}
		// reportDAO.getReportByGeneralInteractionID(generalInteractionId);

		return listReport;
	}

	@RequestMapping(value = { "/v1/interaction-report/{reportId}" }, headers = {
			"Accept=application/json" }, produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public Report getSingleReportList(@PathVariable String reportId) {
		ReportDAO reportDAO = new ReportDAO(db);
		Report report;//
		try {
			return reportDAO.getReportById(reportId);
		} catch (Exception e) {
			report = new Report(reportId, e.getMessage());
		}
		return report;
	}

	@RequestMapping(value = { "/v1/product/productId/{vProductId}" }, headers = {
			"Accept=application/json" }, produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public ProductInfo welcome(@PathVariable String vProductId) {
		// loginService.findIngsByProdId(vProductId);
		ProductInfo productInfo;
		try {
			return loginService.getSearchResultsFromProductId(vProductId);
		} catch (Exception e) {
			productInfo = new ProductInfo();
			productInfo.setProductId(vProductId);
			productInfo.setProductName(e.getMessage());
		}
		return productInfo;
	}

	@RequestMapping(value = { "/v1/product/partNo/{vPartNo}" }, headers = { "Accept=application/json" }, produces = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public ProductInfo findByPartNo(@PathVariable String vPartNo) {
		// loginService.findIngsByProdId(vProductId);
		ProductInfo productInfo;
		try {
			return loginService.getSearchResultsFromPartNo(vPartNo);
		} catch (Exception e) {
			productInfo = new ProductInfo();
			productInfo.setProductId(vPartNo);
			productInfo.setProductName(e.getMessage());
		}
		return productInfo;
	}

	@RequestMapping(value = { "/v1/ingredients/ingredientNames/{ingredientNames}/{userID}" }, produces = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public ProductInfo findByIngName(@PathVariable(value = "ingredientNames") List<String> ingredientNames,
			@PathVariable(value = "userID") String userID) {
		ProductInfo productInfo;
		try {
			System.out.println("userID --> " + userID);
			return loginService.getSerachResultsByIngredients(ingredientNames, userID);
		} catch (Exception e) {
			productInfo = new ProductInfo();

			productInfo.setProductName(e.getMessage());
		}
		return productInfo;
	}

	@RequestMapping(value = { "/v1/product/licenseId/{vLicenseId}" }, headers = {
			"Accept=application/json" }, produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public ProductInfo findByLicenseId(@PathVariable String vLicenseId) {
// loginService.findIngsByProdId(vProductId);
		ProductInfo productInfo;
		try {
			return loginService.getSearchResultsFromLicenseId(vLicenseId);
		} catch (Exception e) {
			productInfo = new ProductInfo();
			productInfo.setProductId(vLicenseId);
			productInfo.setProductName(e.getMessage());
		}
		return productInfo;
	}
        
        
        
        @RequestMapping(value = {"/v2/test/{userID}"}, produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
        public HashMap<String, Object> findByTest( @PathVariable(value="userID") String userID){
           // JSONObject jsonObj = new JSONObject().put("JSON", "This was a TEST API hurray ");
          //  JSONObject jsonObj2 = new JSONObject().put("JSON", "Sorry error occurred TEST API ");
            
            HashMap<String, Object> map = new HashMap<>();
            map.put("JSON", "This was a TEST API hurray ");
            map.put("JSON2", "Sorry error occurred TEST API ");     
            
		try{
                    System.out.println("userID from Test --> " +  userID);
                    
                    List<String>drugIDs = new ArrayList<>();
                    
                    drugIDs.add("3");
                    
                   // map.put("drugIDResultset",loginService.getSearchResultsByDrugID(drugIDs));
                    
                    //System.out.println("DrugID results from Test --> " +  loginService.getSearchResultsByDrugID(drugIDs));
                    
        return map;
	}catch(Exception e){
		e.printStackTrace();
	}
	return map ;
        }
        
        
        
        @RequestMapping(value = {"/v2/interactions/drugs/drugID/{drugID}"}, produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
        public DrugInfo findInteractionByDrugID( @PathVariable(value="drugID") String drugID){

            DrugInfo drugInfo;
		try{
                    //System.out.println("drugID from Test --> " +  drugID);
                    //System.out.println("DrugID results from Test --> " +  loginService.getSerachResultsByDrugID(drugIDs));                  
                    return loginService.getSearchResultsByDrugID(drugID);
                    
                }catch(Exception e){
                    
                drugInfo = new DrugInfo();
		drugInfo.setDrugID(e.getMessage());
                }
                
            return drugInfo ;
        }
        
        
	@RequestMapping(value = {"/v2/interaction/{generalInteractionId}"},  headers = {"Accept=application/json"},produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
    public GeneralInteractionInfo getGeneralInteractionReportList(@PathVariable String generalInteractionId) {
	//Summary listReport = new ArrayList<Report>();
        Object[] returnValueError = new Object[2];
        GeneralInteractionInfo generalInteractInfo = new GeneralInteractionInfo();
	try{
		ReportDAO reportDAO = new ReportDAO(db);
                SummaryDAO summaryDAO = new SummaryDAO(db);
                
                
                List<Reports> reportsList = null;
                Summary summaryItem = null;
                
                //Object[] returnValue = new Object[2];
                
                //GeneralInteractionInfo generalInteractInfo = new GeneralInteractionInfo();
                
                summaryItem = summaryDAO.getSummaryById(generalInteractionId);
                reportsList = loginService.findReportsByGeneralInteractionID(generalInteractionId);
                
                if(summaryItem != null){
                    
                    generalInteractInfo.setCommentaryOnEvidence(summaryItem.getCommentaryOnEvidence());
                    generalInteractInfo.setDrugName(summaryItem.getDrugName());
                    generalInteractInfo.setHerbName(summaryItem.getHerbName());
                    generalInteractInfo.setLevel(summaryItem.getLevel());
                    generalInteractInfo.setPatientAdvice(summaryItem.getPatientAdvice());
                    generalInteractInfo.setRecommendation(summaryItem.getRecommendation());
                    generalInteractInfo.setTciName(summaryItem.getTciName());
                }
                if(reportsList != null){
                    generalInteractInfo.setReportsList(reportsList);
                }
                
                
                
                //returnValue[0] = summaryDAO.getSummaryById(generalInteractionId);
                //returnValue[1] = loginService.findReportsByGeneralInteractionID(generalInteractionId);
                //returnValue[1] = reportDAO.getReportByGeneralInteractionID(generalInteractionId);
                
                return generalInteractInfo;
                
                
		//return reportDAO.getReportByGeneralInteractionID(generalInteractionId);
	}catch(Exception e){
		//Reports report = new Report(generalInteractionId, e.getMessage(), "", "","", "", "","", "", "", "", );
                
                Reports report = new Reports();
                Summary summary = new Summary(generalInteractionId.toString(), e.getMessage(), e.getStackTrace().toString(), "", "", "", "");
		//GeneralInteractionInfo generalInteractInfo = new GeneralInteractionInfo();
                
                generalInteractInfo.setHerbName(generalInteractionId.toString());
                generalInteractInfo.setDrugName(e.getMessage());
                        
                //returnValueError[0] = summary;
                //returnValueError[1] = report;
		//listReport.add(report);
	}
		//reportDAO.getReportByGeneralInteractionID(generalInteractionId);
	
	return generalInteractInfo;
    }
    
    
            @RequestMapping(value = {"/v2/interactions/herbs/herbID/{herbID}"}, produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
        public HerbInfo findInteractionByHerbID( @PathVariable(value="herbID") String herbID){

            HerbInfo herbInfo;
		try{
                    //System.out.println("drugID from Test --> " +  drugID);
                    //System.out.println("DrugID results from Test --> " +  loginService.getSerachResultsByDrugID(drugIDs));                  
                    return loginService.getSearchResultsByHerbID(herbID);
                    
                }catch(Exception e){
                    
                herbInfo = new HerbInfo();
		herbInfo.setHerbID(e.getMessage());
                }
                
            return herbInfo ;
        }

}
