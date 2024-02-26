package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.dto.SubCompPrice;
import com.example.repositories.AlternateComponentRepository;
@Service
public class AlternateComponentManagerImpl implements AlternateComponentManager {
	
	@Autowired
	AlternateComponentRepository alt_repo;

	

	@Override
	public List<String> getCompnameByStd(int mdl_id) {
		// TODO Auto-generated method stub
		return alt_repo.getCompnameByStd(mdl_id);
	}

	@Override
	public List<String> getCompnameByInt(int mdl_id) {
		// TODO Auto-generated method stub
		return alt_repo.getCompnameByInt(mdl_id);
	}

	@Override
	public List<String> getCompnameByExt(int mdl_id) {
		// TODO Auto-generated method stub
		return alt_repo.getCompnameByExt(mdl_id);
	}

	
	  @Override 
	  public List<SubCompPrice> getConfigurableConfig(int mdl_id,String Comp_name) { 
		  return alt_repo.getConfigurableConfig(mdl_id, Comp_name); }
	  
	
	  @Override public SubCompPrice getFinalConfig(int alt_id) {
		  return alt_repo.getFinalConfig(alt_id); }
	 
	



}