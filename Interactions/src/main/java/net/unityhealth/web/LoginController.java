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
import com.unityhealth.imgateway.interactions.db.model.Report;
import com.unityhealth.imgateway.interactions.db.model.SearchResult;
import com.unityhealth.imgateway.web.service.model.SearchContent;

import net.unityhealth.model.AdminUsers;
import net.unityhealth.model.ProductInfo;
import net.unityhealth.service.LoginService;
import net.unityhealth.validator.UserValidator;
@RestController
@EnableWebMvc
public class LoginController {
	@Autowired
	private LoginService loginService;

	@Autowired
	private UserValidator userValidator;
	String db = "interactions";
	@RequestMapping(value = "/dummy", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") AdminUsers userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

       // userService.save(userForm);

        loginService.login(userForm.getUsername(), userForm.getPassword());

        return "redirect:/welcome";
    }
	@RequestMapping(value = {"/searchall"},  headers = {"Accept=application/json"},produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
	public List<SearchResult> welcome(Model model) {
		SearchContent searchContent = new SearchContent();
		List<SearchResult> searchResults = getSearchResults(searchContent);
        return searchResults;
    }
	@RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public  String logout(Model model) {
		SearchContent searchContent = new SearchContent();
		getSearchResults(searchContent);
        return "welcome";
    }
	public List<SearchResult> getSearchResults(SearchContent sContent) {				
		System.out.println(String.format("SearchContent INPUT [%s]", sContent));
		
		//ServletContext context = request.getSession().getServletContext();
		//String db = "interactions";//context.getInitParameter("DB_CONNECTION_MAIN");
		InteractionSearchDAO sDAO = new InteractionSearchDAO(db);
		
		boolean userSearch = sContent.isUserSearch();
		String herbID = sContent.getHerbID();
		String drugID = sContent.getDrugID();
		String drugClassID = sContent.getDrugClassID();
		String[] herbIDs = sContent.getHerbIDs();
		String[] drugIDs = sContent.getDrugIDs();
		String[] drugClassIDs = sContent.getDrugClassIDs(); 
		String searchStr = sContent.getSearchStr();
				
		ArrayList<SearchResult> searchResults = sDAO.getSearchResults(userSearch, herbID, drugID, drugClassID, herbIDs, drugIDs, drugClassIDs, searchStr);				
		System.out.println(searchResults.get(0));
		return searchResults;
		//return Response.status(201).entity(searchResults).build();		
	}
	@RequestMapping(value = {"/v1/interaction/{generalInteractionId}"},  headers = {"Accept=application/json"},produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
    public List<Report> getReportList(@PathVariable String generalInteractionId) {
	List<Report> listReport = new ArrayList<Report>();
	try{
		ReportDAO reportDAO = new ReportDAO(db);
		return reportDAO.getReportByGeneralInteractionID(generalInteractionId);
	}catch(Exception e){
		Report report = new Report(generalInteractionId, e.getMessage());
		
		listReport.add(report);
	}
		//reportDAO.getReportByGeneralInteractionID(generalInteractionId);
	
	return listReport;
    }
	
	@RequestMapping(value = {"/v1/interaction-report/{reportId}"},  headers = {"Accept=application/json"},produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
    public Report getSingleReportList(@PathVariable String reportId) {
		ReportDAO reportDAO = new ReportDAO(db);
		Report report ;//
		try{
        return reportDAO.getReportById(reportId);
		}catch(Exception e){
			report = new Report(reportId, e.getMessage());
		}
		return report;
    }
	@RequestMapping(value = {"/v1/product/productId/{vProductId}"},  headers = {"Accept=application/json"},produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
	public ProductInfo welcome(@PathVariable String vProductId) {
		//loginService.findIngsByProdId(vProductId);
		ProductInfo productInfo;
		try{
        return loginService.getSearchResultsFromProductId(vProductId);
		}catch(Exception e){
			productInfo = new ProductInfo();
			productInfo.setProductId(vProductId);
			productInfo.setProductName(e.getMessage());
		}
		return productInfo;
    }
	@RequestMapping(value = {"/v1/product/partNo/{vPartNo}"},  headers = {"Accept=application/json"},produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
	public ProductInfo findByIngName(@PathVariable String vPartNo) {
		//loginService.findIngsByProdId(vProductId);
		ProductInfo productInfo;
		try{
        return loginService.getSearchResultsFromPartNo(vPartNo);
	}catch(Exception e){
		productInfo = new ProductInfo();
		productInfo.setProductId(vPartNo);
		productInfo.setProductName(e.getMessage());
	}
	return productInfo;
    }
}
