package net.therap.controller;

import net.therap.domain.User;
import net.therap.domain.Vcard;
import net.therap.exception.ApplicationException;
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
 * Time: 8:17 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@SessionAttributes("vcardCommand")
@RequestMapping(value = "/vcard")
public class VcardController {

    @Autowired
    VcardService vcardService;

    public VcardService getVcardService() {
        return vcardService;
    }

    public void setVcardService(VcardService vcardService) {
        this.vcardService = vcardService;
    }

    @RequestMapping(value = "/create.htm", method = RequestMethod.GET)
    public String createVcardGetAction(Map<String, Object> model, HttpServletRequest request) {
     model.put("title", "Create VCARD");
        model.put("vcardCommand", new Vcard());
        return "vcardCreate";
    }

    @RequestMapping(value = "/create.htm", method = RequestMethod.POST)
    public String createVcardPostAction(@Valid @ModelAttribute("vcardCommand") Vcard vcard, BindingResult bindingResult,HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return "vcardCreate";
        }
        else {
           vcard.setUser((User)request.getSession().getAttribute("user"));
           vcardService.saveVcard(vcard);

           return "redirect:/app/vcard/viewlist.htm";
        }
    }

    @RequestMapping(value = "/view.htm", method = RequestMethod.GET)
    public String viewVcardAction(Map<String, Object> model, HttpServletRequest request) {

      if (request.getParameter("vcardId") == null || !request.getParameter("vcardId").matches("[0-9]+")) {
            throw new ApplicationException(" You are trying to access Illegal resource...");
        }

        long vcardId =  Long.valueOf(request.getParameter("vcardId"));

        Vcard vcard = vcardService.getVcardById(vcardId);
        model.put("title", "View VCARD");
        model.put("vcard", vcard);
        return "vcardView";
    }


    @RequestMapping(value = "/delete.htm", method = RequestMethod.GET)
    public String deleteVcardAction(Map<String, Object> model, HttpServletRequest request) {

      if (request.getParameter("vcardId") == null || !request.getParameter("vcardId").matches("[0-9]+")) {
            throw new ApplicationException(" You are trying to access Illegal resource...");
        }

        long vcardId =  Long.valueOf(request.getParameter("vcardId"));

        vcardService.deleteVcardByUser((User)request.getSession().getAttribute("user"),vcardId);

        return "redirect:/app/vcard/viewlist.htm";
    }


     @RequestMapping(value = "/update.htm", method = RequestMethod.GET)
    public String updateVcardGetAction(Map<String, Object> model, HttpServletRequest request) {

         if (request.getParameter("vcardId") == null || !request.getParameter("vcardId").matches("[0-9]+")) {
            throw new ApplicationException(" You are trying to access Illegal resource...");
        }

        long vcardId =  Long.valueOf(request.getParameter("vcardId"));
        Vcard vcard = vcardService.getVcardById(vcardId);
         model.put("title", "Update vcard");
        model.put("vcardCommand", vcard);
        return "updateVcard";

    }

    @RequestMapping(value = "/update.htm", method = RequestMethod.POST)
    public String updateVcardPostAction(@Valid @ModelAttribute("vcardCommand") Vcard vcard, BindingResult bindingResult,HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return "updateVcard";
        }
        else {
          vcardService.updateVcardByUser(vcard);
           return "redirect:/app/vcard/viewlist.htm";
        }
    }


     @RequestMapping(value = "/viewlist.htm", method = RequestMethod.GET)
    public String viewVcardListAction(Map<String, Object> model, HttpServletRequest request) {

         model.put("title", "View VCARD List");
        List<Vcard> vcardList = vcardService.getVcardListByUser((User)request.getSession().getAttribute("user"));
        model.put("vcardList", vcardList);
        return "viewVcardList";

    }


}
