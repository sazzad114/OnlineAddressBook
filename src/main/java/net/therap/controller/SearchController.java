package net.therap.controller;

import net.therap.domain.SearchCommand;
import net.therap.domain.User;
import net.therap.domain.Vcard;
import net.therap.service.VcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: sazzadur
 * Date: 6/27/12
 * Time: 2:58 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@SessionAttributes("searchCommand")
public class SearchController {

    @Autowired
    VcardService vcardService;

    public VcardService getVcardService() {
        return vcardService;
    }

    public void setVcardService(VcardService vcardService) {
        this.vcardService = vcardService;
    }

    @RequestMapping(value = "/search.htm", method = RequestMethod.POST)
     public String searchVcardPostAction(@ModelAttribute("searchCommand") SearchCommand searchCommand, BindingResult bindingResult,HttpServletRequest request,Map<String, Object> model) {

        if (bindingResult.hasErrors()) {
            return "searchVcard";
        }
        else {
           User user = (User)request.getSession().getAttribute("user");
          List<Vcard> vcardList = vcardService.searchVcardByName(searchCommand.getSearchString(),user);
         model.put("title", "Search VCARD");
         model.put("searchCommand", searchCommand);
         model.put("vcardList",vcardList);
           return "searchVcard";
        }
    }

    @RequestMapping(value = "/search.htm", method = RequestMethod.GET)
    public String searchVcardGetAction(Map<String, Object> model, HttpServletRequest request) {
     model.put("title", "Search VCARD");
        model.put("searchCommand", new SearchCommand());
        return "searchVcard";
    }
}
