package prt.springbootthymeleafcrudwebapp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import asam.model.ApplicantModel;
import asam.repository.ApplicantRepository;

@Service
public abstract class ApplicantServiceImp implements ApplicantService {

    @Autowired
    private ApplicantRepository applicantrepository;

    public List<ApplicantModel> getAllModels() {

        return applicantrepository.findAll();
    }

    @Override
    public void saveModel(ApplicantModel model) {
        this.applicantrepository.save(model);
    }

    @Override
    public ApplicantModel getApplicantById(long id) {
        Optional<ApplicantModel> optional = applicantrepository.findById(id);
        ApplicantModel applicantmodel = null;
        if (optional.isPresent()) {
            applicantmodel = optional.get();
        } else {
            throw new RuntimeException("Applicant not found for id: " + id);
        }
        return applicantmodel;
    }

    @Override
    public void deleteApplicantById(long id) {
        this.applicantrepository.deleteById(id);
    }

}
