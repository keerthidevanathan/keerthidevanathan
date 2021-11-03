package homeloan.web.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import homeloan.web.jpa.entity.Bank;

public interface BankRepository extends JpaRepository<Bank,String> {

}
