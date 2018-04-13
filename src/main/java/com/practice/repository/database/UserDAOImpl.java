package com.practice.repository.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import com.practice.domain.ISuggestedUser;
import com.practice.domain.SuggestedNick;
import com.practice.domain.SuggestedUserImpl;
import com.practice.domain.User;
import com.practice.repository.constantsdb.ConstantsQuery;
import com.practice.repository.dataservice.IDataService;
import com.practice.utils.RandomWords;

public class UserDAOImpl implements IUserDAO {

	@Autowired
	private IDataService service;

	public UserDAOImpl() {

	}

	public boolean validateUser(User user) throws Exception, SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean isValidUser = false;
		try {
			service.openConnection();
			ps = service.getPreparedStatement(ConstantsQuery.VALIDATE_USER);
			ps.setString(1, user.getNickName());
			rs = service.getResultSet(ps);
			isValidUser = rs.next();
		} catch (SQLException e) {

		} catch (Exception e) {

		} finally {
			service.closeStatements(ps);
			service.closeCursor(rs);
			service.closeConnection();
		}
		return isValidUser;
	}
	
	public boolean existsUserAsRestrictedName(User user) throws Exception,SQLException{
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean isRestricted = false;
		try {
			service.openConnection();
			ps = service.getPreparedStatement(ConstantsQuery.VALIDATE_RESTRICTED_NAME);
			ps.setString(1, user.getNickName());
			rs = service.getResultSet(ps);
			if(rs.next()) {
				isRestricted = rs.getInt(1)>0;
				
			}
		} catch (SQLException e) {

		} catch (Exception e) {

		} finally {
			service.closeStatements(ps);
			service.closeCursor(rs);
			service.closeConnection();
		}
		return isRestricted;
		
	}

	public ISuggestedUser getSuggestedNames(User user) throws Exception, SQLException {
		String name=null;
		int i=0;
		 TreeSet<SuggestedNick> names= new  TreeSet<SuggestedNick>();
		 //Step 1 Check using random numbers
       for(;i < 7 ; i++) {
    	   name = user.getNickName().concat(String.valueOf(i));
    	   user.setNickName(name);
    	   if(!this.validateUser(user) && !this.existsUserAsRestrictedName(user)) {
       	     names.add(new SuggestedNick(name));  
       	   }      	
       }
       
       //Step 2 Using Util Random Mixer
       
       for(;i < 7 ; i++) {
    	   name = user.getNickName().concat(RandomWords.randomIdentifier());
    	   user.setNickName(name);
    	   if(!this.validateUser(user) && !this.existsUserAsRestrictedName(user)) {
       	     names.add(new SuggestedNick(name));  
       	   }    	
       }
       
  //Step 3 Using Util Random Mixer
       
       for(;i < 7 ; i++) {
    	   name = user.getNickName().concat(RandomWords.randomIdentifier());
    	   user.setNickName(name);
    	   if(!this.validateUser(user) && !this.existsUserAsRestrictedName(user)) {
       	     names.add(new SuggestedNick(name));  
       	   }    	
       }
              
       ISuggestedUser obj = new SuggestedUserImpl();
       obj.setSuggestedNickNames(names);
		return obj;
	}

	public boolean includeRestrictedName(String nameRestricted) throws Exception, SQLException{
		PreparedStatement ps = null;		
		boolean success = false;
		try {
			service.openConnection();
			ps = service.getPreparedStatement(ConstantsQuery.INCLUDE_RESTRICTED_NAME);
			ps.setString(1, nameRestricted);
			success = service.execute(ps);			
		} catch (SQLException e) {

		} catch (Exception e) {

		} finally {
			service.closeStatements(ps);			
			service.closeConnection();
		}
		return success;
	}

	public IDataService getService() {
		return service;
	}

	public void setService(IDataService service) {
		this.service = service;
	}

	

}
