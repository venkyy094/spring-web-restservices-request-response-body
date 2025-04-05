package com.venkateshit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.venkateshit.entity.UserDetails;
import com.venkateshit.response.UserDetailsResponse;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, String>{
	
	UserDetails findByEmailIdAndPassword(String emailId, String password);

}
