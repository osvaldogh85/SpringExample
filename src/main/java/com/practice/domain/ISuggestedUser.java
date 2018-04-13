package com.practice.domain;


import java.util.TreeSet;

public interface ISuggestedUser {
	public TreeSet<SuggestedNick> getSuggestedNickNames();
	public void setSuggestedNickNames(TreeSet<SuggestedNick> names);

}
