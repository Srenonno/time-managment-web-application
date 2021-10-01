package com.HRpath.MPM.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.HRpath.MPM.bean.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
	Optional<User> findByEmail(String email);
	
	@Query("SELECT u FROM User u JOIN u.roles r WHERE r.id = 2")
	List <User> ListManager();
	
	
	@Query("SELECT u FROM User u JOIN u.roles r WHERE r.id = 3")
	List<User> ListPrestataire();
	
	@Query("SELECT u FROM User u JOIN u.roles r WHERE r.id = 1")
	List<User> ListAdmin();
	
	@Query("Select u From User u Join u.affectation f WHERE f.manager.id= :id and f.dateFin is null"  )
	List<User> ListAffecter(@Param("id") Integer Id);
	
	@Query("Select distinct u from User u Join u.roles r WHERE r.id= 3 and u.id not in(select f.prestataire.id from Affectation f where f.dateFin is null)")
	List<User> ListNonAffecterManager();
}
