package com.yuma.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuma.pojo.EasyUIDataGridResult;
import com.yuma.pojo.JsonUtils;
import com.yuma.pojo.Result;
import com.yuma.pojo.Yuma;
import com.yuma.service.ItemService;
import com.yuma.service.TestService;

@Controller
public class TestController {
	
	@Autowired
	private TestService testService;
	
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/test")
	@ResponseBody
	public String queryNow() {
		return testService.query();
	}
	
	@RequestMapping("/query")
	@ResponseBody
	public String query() {
		return itemService.search();
	}
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	@ResponseBody
	public EasyUIDataGridResult getAll(Integer page,Integer rows) {
		return itemService.getAll(page, rows);
	}
	
	@RequestMapping("/list")
	//@ResponseBody
	public String getAl() {
		return "list.jsp";
	}
	
//	@RequestMapping("/search")
//	//@ResponseBody
//	public String getA() {
//		return "search.jsp";
//	}
	
	@RequestMapping("/add")
	//@ResponseBody
	public String getAdd() {
		return "edit.jsp";
	}
	
	
	//页面输入nama进行查询
	@RequestMapping(value="/search/list",method=RequestMethod.POST)
	@ResponseBody
	public EasyUIDataGridResult getAll(Integer page,Integer rows,HttpServletRequest request) {
		String nameId = request.getParameter("nameid");
		String locationId = request.getParameter("locationid");
		EasyUIDataGridResult list = new EasyUIDataGridResult();
		if(locationId !=null || locationId != "") {
			list = itemService.getByLocation(locationId,page,rows);
		}
		if(nameId.length()>0) {
			list = itemService.getByName(nameId,page,rows);
		}
		if(nameId.length()==0 && locationId.length()==0) {
			list = itemService.getAll(page, rows);
		}
		return list;
	}
	
	//添加
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public Result add(HttpServletRequest request) {
		String type = request.getParameter("type");
		String name = request.getParameter("name");
		Integer sum = Integer.parseInt(request.getParameter("sum"));
		String location = request.getParameter("location");
		return itemService.add(name, type, location, sum);
	}
	
	//更新
	@RequestMapping(value="/update", method=RequestMethod.POST)
	@ResponseBody
	public Result update(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Integer sum = Integer.parseInt(request.getParameter("sum"));
		String location = request.getParameter("location");
		return itemService.update(id,location, sum);
	}
	
	//删除
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	@ResponseBody
	public Result delete(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		return itemService.delete(id);
	}
	

}
