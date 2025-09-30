package com.Ankit.collection.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.Ankit.collection.model.UserDetails;
import com.Ankit.collection.model.UserInfo;
//import com.Ankit.collection.model.extraDeatils;
@Repository
public interface deailsRepo extends JpaRepository<UserInfo, Long> {
	

}
