package com.example.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.example.dto.SubCompPrice;

public interface AlternateComponentManager {
	
	List<String> getCompnameByStd( int mdl_id);
	
	List<String> getCompnameByInt(int mdl_id);
	List<String> getCompnameByExt(int mdl_id);
	public List<SubCompPrice> getConfigurableConfig( int mdl_id ,String Comp_name);
	
	SubCompPrice getFinalConfig(int Alt_id );
	
	
	
	
	
}