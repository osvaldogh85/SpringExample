package com.practice.repository.constantsdb;

public class ConstantsQuery {
  
	public static final String VALIDATE_USER ="select u.userID from tb_users u where u.userID = ? ";
	
	public static final String VALIDATE_RESTRICTED_NAME ="select count(*) form tb_restricted_names r where r.restricted_word '%?%' ";
	
	public static final String INCLUDE_RESTRICTED_NAME ="insert into tb_restricted_names(restricted_word) values(?)";
}
