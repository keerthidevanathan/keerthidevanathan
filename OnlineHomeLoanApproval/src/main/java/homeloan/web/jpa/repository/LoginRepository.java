package homeloan.web.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import homeloan.web.jpa.entity.Login;

public interface LoginRepository extends JpaRepository<Login,String>{
	//@Modifying
	@Query("select l.role from Login l where l.userId = :userId and l.password = :password")
	//public Optional<Login> verification(@Param("userId") String userId,@Param("password")String password,@Param("role") String role);
	public String verification(@Param("userId") String userId,@Param("password")String password);

}
