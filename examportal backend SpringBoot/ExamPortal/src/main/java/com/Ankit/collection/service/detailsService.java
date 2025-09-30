package com.Ankit.collection.service;

import java.util.Set;

//import com.Ankit.collection.model.UserDetails;
import com.Ankit.collection.model.UserInfo;
//import com.Ankit.collection.model.extraDeatils;
import com.Ankit.collection.model.exam.Category;
import com.Ankit.collection.model.exam.Quiz;

public interface detailsService {

public UserInfo addextraDeatils(UserInfo extraDeatils);
	
	public UserInfo UpdateextraDeatils(UserInfo extraDeatils);
	
	public Set<UserInfo> getallextraDeatils();
}
