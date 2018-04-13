package com.practice.domain;

import java.util.TreeSet;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("user")
public class User {
	
	@NotEmpty
	@Size(min = 15, max = 50)
	private String fullName ;
	
	@NotEmpty
	@Size(min = 6, max = 15)
	private String nickName;
	

	@Autowired
	private ISuggestedUser suggestedNames;
	
	public User(String fullName, String nickName) {		
		this.fullName = fullName;
		this.nickName = nickName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	
	public void setSuggestedNames(ISuggestedUser suggestedNames) {
		this.suggestedNames = suggestedNames;
	}

	public TreeSet<SuggestedNick> getSuggestedNames() {
		return suggestedNames.getSuggestedNickNames();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		return true;
	}
	
	
}
