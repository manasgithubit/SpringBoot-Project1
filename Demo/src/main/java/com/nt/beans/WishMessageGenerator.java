package com.nt.beans;

import java.util.Date;

public class WishMessageGenerator {

	private Date date;
	
	public void SetDate(Date date)
	{
		this.date = date;
	}
	public String generateMessage(String user)
	{
		int hour = date.getHours();
		
		if(hour<12)
			return"GM" + user;
		if(hour<16)
			return"GM" + user;
		if(hour<20)
			return"GM" + user;
		
		return user;
	}
}
