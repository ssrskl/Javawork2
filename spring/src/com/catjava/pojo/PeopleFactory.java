package com.catjava.pojo;

public class PeopleFactory {
	public People newInstance(){
		return new People(19,"maoyan2",true);
	}
	public static People newInstance2() {
		return new People(20,"maoyan3",false);
	}
}
