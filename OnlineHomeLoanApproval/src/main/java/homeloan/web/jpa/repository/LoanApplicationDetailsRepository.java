package homeloan.web.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import homeloan.web.jpa.entity.LoanApplicationDetails;

public interface LoanApplicationDetailsRepository extends JpaRepository<LoanApplicationDetails,Integer>{
	
	@Modifying
	@Query("update LoanApplicationDetails lad set lad.status=:status,lad.remarks=:remarks where lad.applicationId=:appId")
	public int modifyLoanApplicationStatus(@Param("status") String status,@Param("remarks")String remarks,@Param("appId")int applicationId);
	

}
