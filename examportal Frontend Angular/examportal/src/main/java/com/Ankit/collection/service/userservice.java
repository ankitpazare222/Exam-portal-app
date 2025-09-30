package com.Ankit.collection.service;

import java.util.List;
import java.util.Set;

//import com.Ankit.collection.model.extraDeatils;
import com.Ankit.collection.model.user;
import com.Ankit.collection.model.usersrole;

public interface userservice {
 public user createusr(user users,Set<usersrole> userroles) throws Exception ;
 
 public user  getuser(String username);
 
 public user  updateUserByID(user userID);
 
 public void deleteuser(Long userID);
 
 public Iterable<user> getallUser();
 
 public user getextraDeatilsID(Long userID);
 
}
