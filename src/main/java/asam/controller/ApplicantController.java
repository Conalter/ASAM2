
package asam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import asam.model.ApplicantModel;
import prt.springbootthymeleafcrudwebapp.service.ApplicantService;


@Controller
public class ApplicantController {
    
    @Autowired
    public ApplicantService applicantService;
    //Create method handler which will display a list of applicants for home page index.html to display
    @GetMapping("/index")
    public String viewHomePage (Model model){
        model.addAttribute("listApplicants", applicantService.getAllApplicants());
        return "index";
    }
    
    @GetMapping("/showNewApplicantForm")
    public String showNewApplicantForm(Model model){
        //Create a model to bind new applicant data
       ApplicantModel applicant = new ApplicantModel();
       model.addAttribute("applicant", applicant);
       return "new_applicant";
    }
  
    @PostMapping("/saveApplicant")
    public String saveApplicant(@ModelAttribute("applicant")ApplicantModel applicant){
    //save applicant to database
    applicantService.saveModel(applicant);
    return "redirect:/index";
    }
    
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") long id, Model model){
    //Get the applicant from the service
    ApplicantModel applicant = applicantService.getApplicantById(id);
    
    //set applicant as a model attribute to pre-populate form
    model.addAttribute("applicant", applicant);
    return "update_applicant";
    }
    
    //delete applicant by id
    @GetMapping("/deleteApplicant/{id}")
    public String deleteApplicant(@PathVariable( value = "id") long id){
    
    //Call delete method from the service
    this.applicantService.deleteApplicantById(id);
        return "redirect:/index";
    }
}
