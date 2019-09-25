package com.miracle.Motion.FourCornersOfHealth.Repos;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miracle.Motion.FourCornersOfHealth.Entity.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, String>{
	
	@Query("select u from USERS u where u.username = ?1")
	public Users findByUsername(String username);

}
