package com.practice.domain;

import java.util.TreeSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("suggested")
public class SuggestedUserImpl implements ISuggestedUser{

	@Autowired
	private TreeSet<SuggestedNick> names;


	public void setSuggestedNickNames(TreeSet<SuggestedNick> names) {
		this.names = names;
	}

	public TreeSet<SuggestedNick> getSuggestedNickNames() {
		
		return names;
	}	
	
}
