
package asam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import asam.model.ApplicantModel;

@Repository
public interface ApplicantRepository extends JpaRepository<ApplicantModel, Long>{
    
}
