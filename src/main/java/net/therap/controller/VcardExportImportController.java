package net.therap.controller;

import net.therap.domain.ImportFileCommand;
import net.therap.domain.Vcard;
import net.therap.exception.ApplicationException;
import net.therap.service.VcardService;
import net.therap.utills.VcardUtills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: sazzadur
 * Date: 6/27/12
 * Time: 11:26 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class VcardExportImportController {

    @Autowired
    private VcardService vcardService;


    public VcardService getVcardService() {
        return vcardService;
    }

    public void setVcardService(VcardService vcardService) {
        this.vcardService = vcardService;
    }



  @RequestMapping(value = "/export.htm", method = RequestMethod.GET)
    public void exportAction(HttpServletRequest request, HttpServletResponse response) {

       if (request.getParameter("vcardId") == null || !request.getParameter("vcardId").matches("[0-9]+")) {
            throw new ApplicationException(" You are trying to access Illegal resource...");
        }
      long vcardId = Long.valueOf(request.getParameter("vcardId"));

      Vcard vcard = vcardService.getVcardById(vcardId);
      byte[] vcardBytes = VcardUtills.vcardToByteArray(vcard);

      try{
            response.setContentType("text/plain; charset=utf-8");
            response.setHeader("Content-Disposition", "attachment; filename=vCard.vcf");
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(vcardBytes);
            outputStream.flush();
            outputStream.close();

        } catch (Exception e) {
            throw new ApplicationException(" You are trying to access Illegal resource...");
        }

    }

     @RequestMapping(value = "/import.htm", method = RequestMethod.GET)
    public String importGetAction(Map<String, Object> model, HttpServletRequest request) {
        model.put("importFile", new ImportFileCommand());
        model.put("title", "Import File:");
        return "importFile";

    }

    @RequestMapping(value = "/import.htm", method = RequestMethod.POST)
    public String importPostAction(Map<String, Object> model, HttpServletRequest request) {
        model.put("importFile", new ImportFileCommand());
        model.put("title", "Import File:");
        return "common/createflat";

    }
}
