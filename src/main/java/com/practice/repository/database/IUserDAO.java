package com.practice.repository.database;

import java.sql.SQLException;

import com.practice.domain.ISuggestedUser;
import com.practice.domain.User;

public interface IUserDAO {

	public boolean existsUserAsRestrictedName(User user) throws Exception,SQLException;
	public boolean validateUser(User user) throws Exception,SQLException;
	public boolean includeRestrictedName(String nameRestricted) throws Exception,SQLException;
	public ISuggestedUser getSuggestedNames(User user)throws Exception,SQLException;
}
