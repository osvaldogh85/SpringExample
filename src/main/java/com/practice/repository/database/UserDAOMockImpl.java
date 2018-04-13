/**
 * 
 */
package com.practice.repository.database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import com.practice.domain.ISuggestedUser;
import com.practice.domain.SuggestedNick;
import com.practice.domain.SuggestedUserImpl;
import com.practice.domain.User;
import com.practice.utils.RandomWords;

/**
 * @author Osvaldo
 *
 */
public class UserDAOMockImpl implements IUserDAO {

	private List<String> badWords = new ArrayList<String>();
	private Map<String,User> users = new HashMap<String,User>();
	
	{
		badWords.addAll(Arrays.asList("cannabis, abuse, crack, damn, drunk, grass,baddass,marihuana,death,violence".split(",")));
		users.put("anzabu09",new User("Angie Zamora Araya","anzabu09"));
		users.put("arturo901",new User("Arturo Mena Saborio","arturo901"));
		users.put("robbeardless98",new User("Roberto Gonzalez Hernandez","robbeardless98"));
		users.put("barran_921",new User("Luis Solis Barrantes","barran_921"));
		users.put("jess85",new User("Jessica Reyes Guerrero","jess85"));
		
		
	}
	/* (non-Javadoc)
	 * @see com.practice.repository.database.IUserDAO#existsUserAsRestrictedName(com.practice.domain.User)
	 */
	public boolean existsUserAsRestrictedName(User user) throws Exception, SQLException {
		
		return badWords.contains(user.getNickName());
	}

	/* (non-Javadoc)
	 * @see com.practice.repository.database.IUserDAO#validateUser(com.practice.domain.User)
	 */
	public boolean validateUser(User user) throws Exception, SQLException {
		// TODO Auto-generated method stub
		return users.containsKey(user.getNickName());
	}

	/* (non-Javadoc)
	 * @see com.practice.repository.database.IUserDAO#includeRestrictedName(java.lang.String)
	 */
	public boolean includeRestrictedName(String nameRestricted) throws Exception, SQLException {
		this.badWords.add(nameRestricted);
		return false;
	}

	/* (non-Javadoc)
	 * @see com.practice.repository.database.IUserDAO#getSuggestedNames(com.practice.domain.User)
	 */
	public ISuggestedUser getSuggestedNames(User user) throws Exception, SQLException {
		
		String name=null;
		int i=0;
		 TreeSet<SuggestedNick> names= new  TreeSet<SuggestedNick>();
		 //Step 1 Check using random numbers
       for(;i < 7 ; i++) {
    	   name = user.getNickName().concat(String.valueOf(i));
    	   if(!users.containsKey(name) && !badWords.contains(name)) {
       	     names.add(new SuggestedNick(name));  
       	   }      	
       }
       
       //Step 2 Using Util Random Mixer
       
       for(;i < 7 ; i++) {
    	   name = user.getNickName().concat(RandomWords.randomIdentifier());
    	   if(!users.containsKey(name) && !badWords.contains(name)) {
         	     names.add(new SuggestedNick(name));  
         	}    	
       }
       
  //Step 3 Using Util Random Mixer
       
       for(;i < 7 ; i++) {
    	   name = user.getNickName().concat(RandomWords.randomIdentifier());
    	   if(!users.containsKey(name) && !badWords.contains(name)) {
         	     names.add(new SuggestedNick(name));  
         	}    	
       }
       
       
       ISuggestedUser obj = new SuggestedUserImpl();
       obj.setSuggestedNickNames(names);
		return obj;
	}

}
