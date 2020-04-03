package com.catjava.pojo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class People {
	private int years;
	private String name;
	private boolean sex;
	private Set<String> setsSet;
	private List<String> listsList;
	private String[] strings;
	private Map<String, String> mapsMap;
	private Properties properties;
	private GirlFriend girlFriend;
	
	
	@Override
	public String toString() {
		return "People [years=" + years + ", name=" + name + ", sex=" + sex
				+ ", setsSet=" + setsSet + ", listsList=" + listsList
				+ ", strings=" + Arrays.toString(strings) + ", mapsMap="
				+ mapsMap + ", properties=" + properties + ", girlFriend="
				+ girlFriend + "]";
	}
	public GirlFriend getGirlFriend() {
		return girlFriend;
	}
	public void setGirlFriend(GirlFriend girlFriend) {
		this.girlFriend = girlFriend;
	}
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	public Set<String> getSetsSet() {
		return setsSet;
	}
	public void setSetsSet(Set<String> setsSet) {
		this.setsSet = setsSet;
	}
	public List<String> getListsList() {
		return listsList;
	}
	public void setListsList(List<String> listsList) {
		this.listsList = listsList;
	}
	public String[] getStrings() {
		return strings;
	}
	public void setStrings(String[] strings) {
		this.strings = strings;
	}
	public Map<String, String> getMapsMap() {
		return mapsMap;
	}
	public void setMapsMap(Map<String, String> mapsMap) {
		this.mapsMap = mapsMap;
	}
	public int getYears() {
		return years;
	}
	public void setYears(int years) {
		System.out.println("调用了set方法");
		this.years = years;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public People() {
		System.out.println("无参构造方法");
	}
	public People(int years, String name, boolean sex) {
		super();
		this.years = years;
		this.name = name;
		this.sex = sex;
	}
	
}
