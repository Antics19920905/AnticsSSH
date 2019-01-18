package com.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.bean.Country;
import com.opensymphony.xwork2.ModelDriven;
import com.service.CountryService;

public class CountryAction implements ModelDriven<Country> {
	private CountryService service;
	private List<Country> counList;
	private Country country;
	public String list(){
		counList=service.queryAll();
		return "list";
	}
	public String del(){
		service.delete(country);
		
		return list();
	}
	public String preAdd(){
		return "add";
	}
	public String add(){
		
		service.add(country);
		return list();
	}
	public String preUpdate() throws IOException{
		String n=new String(country.getName().getBytes("ISO-8859-1"),"utf-8");
		String L=new String(country.getLanguage().getBytes("ISO-8859-1"),"utf-8");
		country.setName(n);
		country.setLanguage(L);
		return "update";
	}
	public String update(){
		
		service.update(country);
		return list();
	}
	public String queryByNameOrLanguage(){
		counList=service.select(country);
		return "list";
	}
	public CountryService getService() {
		return service;
	}
	public void setService(CountryService service) {
		this.service = service;
	}
	public List<Country> getCounList() {
		return counList;
	}
	public void setCounList(List<Country> counList) {
		this.counList = counList;
	}
	@Override
	public Country getModel() {
		// TODO Auto-generated method stub
		if(country==null){
			country=new Country();
		}
		return country;
	}
	
}
