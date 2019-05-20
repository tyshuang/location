package com.yuma.service;

import com.yuma.pojo.EasyUIDataGridResult;
import com.yuma.pojo.Result;

;

public interface ItemService {

	public String search();
	public EasyUIDataGridResult getAll(Integer page,Integer rows);
	public EasyUIDataGridResult getByName(String name,Integer page,Integer rows);
	public EasyUIDataGridResult getByLocation(String location,Integer page,Integer rows);
	public Result add(String name,String type,String location,Integer sum);
	public Result delete(Integer id);
	public Result update(Integer id,String location,Integer sum);
	
}
