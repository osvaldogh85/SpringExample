package com.practice.domain;

import org.springframework.stereotype.Component;

@Component("nickname")
public class SuggestedNick {
	
	public SuggestedNick(String suggestedNick) {
		this.suggestedNick = suggestedNick;
	}

	private String suggestedNick;
	public String getSuggestedNick() {
		return suggestedNick;
	}

	public void setSuggestedNick(String suggestedNick) {
		this.suggestedNick = suggestedNick;
	}
	

}
