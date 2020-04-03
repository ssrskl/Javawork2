package com.catjava.pojo;

public class GirlFriend {
	private int years;
	private String hobby;
	
	
	@Override
	public String toString() {
		return "GirlFriend [years=" + years + ", hobby=" + hobby + "]";
	}
	public int getYears() {
		return years;
	}
	public void setYears(int years) {
		this.years = years;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
}
