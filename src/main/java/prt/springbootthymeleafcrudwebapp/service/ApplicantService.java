
package prt.springbootthymeleafcrudwebapp.service;

import java.util.List;
import asam.model.ApplicantModel;

public interface ApplicantService {
    List<ApplicantModel> getAllApplicants();
   
    void saveModel(ApplicantModel applicantmodel);
    
    ApplicantModel getApplicantById(long id);
    
    void deleteApplicantById(long id);

}
