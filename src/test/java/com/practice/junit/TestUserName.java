package com.practice.junit;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.practice.domain.User;
import com.practice.repository.database.UserDAOMockImpl;

import junit.framework.TestCase;
@RunWith(MockitoJUnitRunner.class)
public class TestUserName extends TestCase{
	
	private UserDAOMockImpl userDAOMock = mock(UserDAOMockImpl.class);
	private List<User> mockedList = mock(List.class);

	@Test
	public void existsUser() {
		User user = new User("","");
		user.setNickName("anzabu09");
		User user2 = new User("","");
		user.setNickName("Rocket2");
		mockedList.add(user2);
		try {
			when(userDAOMock.validateUser(user)).thenReturn(true);
			

			assertTrue("Mockito encuentra que "+user.getNickName() + " existe",userDAOMock.validateUser(user));
			
			when(userDAOMock.validateUser(user2)).thenReturn(false);
			
			assertFalse("Debe retornar falso segun mockito "+ user2.getNickName() + " no existe",userDAOMock.validateUser(user2));
			
			User user3 = mock(User.class);
			when(user3.getNickName()).thenReturn("Osvaldo");
			
			when(userDAOMock.validateUser(user3)).thenReturn(true);
			assertTrue("Segun mockito se registro en falso el usuario " + user3.getNickName() + " que si debe existir ",userDAOMock.validateUser(user3));
 
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void existsRestrictedName() {
		User user = mock(User.class);
		
		try {
		    when(user.getNickName()).thenReturn("cannabis");
			when(userDAOMock.existsUserAsRestrictedName(user)).thenReturn(true);
			assertTrue("El usuario "+ user.getNickName() + "  existe en bad words",userDAOMock.existsUserAsRestrictedName(user));
			 when(user.getNickName()).thenReturn("arturo990");
			when(userDAOMock.existsUserAsRestrictedName(user)).thenReturn(true);
			assertFalse("El usuario "+ user.getNickName() + "  existe en bad words",userDAOMock.existsUserAsRestrictedName(user));
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
