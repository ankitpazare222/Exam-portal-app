package com.Ankit.collection.service.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ankit.collection.dao.deailsRepo;
//import com.Ankit.collection.model.UserDetails;
import com.Ankit.collection.model.UserInfo;
//import com.Ankit.collection.model.extraDeatils;
import com.Ankit.collection.service.detailsService;
@Service
public class detailsImpl implements detailsService {
	@Autowired
	deailsRepo detailsrepoo;

	@Override
	public UserInfo addextraDeatils(UserInfo extraDeatils) {
		// TODO Auto-generated method stub
		
		return detailsrepoo.save(extraDeatils);
	}

	@Override
	public UserInfo UpdateextraDeatils(UserInfo extraDeatils) {
		// TODO Auto-generated method stub
		return detailsrepoo.save(extraDeatils);
	}

	@Override
	public Set<UserInfo> getallextraDeatils() {
	    return new HashSet<>((Collection<? extends UserInfo>) detailsrepoo.findAll());
	}

	
}
