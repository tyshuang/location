package com.yuma.serviceImpl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuma.mapper.YumaMapper;
import com.yuma.pojo.EasyUIDataGridResult;
import com.yuma.pojo.Result;
import com.yuma.pojo.Yuma;
import com.yuma.pojo.YumaExample;
import com.yuma.pojo.YumaExample.Criteria;
import com.yuma.pojo.YumaTime;
import com.yuma.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private YumaMapper mapper;
	
	@Override
	public  String search() {
		// TODO Auto-generated method stub
		String name = "42-1.8";
		YumaExample example = new YumaExample();
		
		Criteria createCriteria = example.createCriteria();
		createCriteria.andNameLike("%"+name+"%");
		
		
		List<Yuma> examples = mapper.selectByExample(example);
		ArrayList arrayList = new ArrayList<>();
		
		for (Yuma exa: examples) {	
			arrayList.add(exa.getName());
			arrayList.add(exa.getSum());
		}
		String nn = arrayList.toString();
		return nn;

	}


	@Override
	public EasyUIDataGridResult getAll(Integer page, Integer rows) {
		// TODO Auto-generated method stub
		//1设置分页信息
		if(page == null)page = 1;
		if(rows == null)rows = 30;
		PageHelper.startPage(page, rows);
		YumaExample example = new YumaExample();
		Criteria criteria = example.createCriteria();
		//criteria.andCategoryIdEqualTo(id);
		List<Yuma> list = mapper.selectByExample(example);	
    	//5获取分页信息 
		PageInfo info = new PageInfo<>(list);
		//6分装到EasyUIDataGridResult
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal((int)info.getTotal());
		result.setRows(info.getList());
		//7返回
		return result;
	}


	@Override
	public EasyUIDataGridResult getByName(String name, Integer page, Integer rows) {
		// TODO Auto-generated method stub
		//1设置分页信息
		if(page == null)page = 1;
		if(rows == null)rows = 30;
		PageHelper.startPage(page, rows);
		YumaExample example = new YumaExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameLike("%"+name+"%");
		List<Yuma> list = mapper.selectByExample(example);	
		PageInfo info = new PageInfo<>(list);
		//6分装到EasyUIDataGridResult
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal((int)info.getTotal());
		result.setRows(info.getList());
		//7返回
		return result;
	}


	@Override
	public EasyUIDataGridResult getByLocation(String location, Integer page, Integer rows) {
		// TODO Auto-generated method stub
		//1设置分页信息
		if(page == null)page = 1;
		if(rows == null)rows = 30;
		PageHelper.startPage(page, rows);
		YumaExample example = new YumaExample();
		Criteria criteria = example.createCriteria();
		criteria.andLocationLike("%"+location+"%");
		List<Yuma> list = mapper.selectByExample(example);	
    	//5获取分页信息 
		PageInfo info = new PageInfo<>(list);
		//6分装到EasyUIDataGridResult
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal((int)info.getTotal());	
		result.setRows(info.getList());
		//7返回
		return result;
	}


	@Override
	public Result add(String name, String type, String location, Integer sum) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
		//数据库格式的时间
		Date da = new Date();
		String dat = sdf.format(da);
		Timestamp date = Timestamp.valueOf(dat);
		//Date date = null;
//		try {
//			date = sdf.parse(sdf.format(dt));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Yuma ym = new Yuma();
		ym.setDate(date);
		ym.setLocation(location);
		ym.setName(name);
		ym.setSum(sum);
		ym.setType(type);
		mapper.insert(ym);;
		return Result.ok();		
		
	}


	@Override
	public Result delete(Integer id) {
		mapper.deleteByPrimaryKey(id);
		return Result.ok();
		// TODO Auto-generated method stub
		
	}


	@Override
	public Result update(Integer id, String location, Integer sum) {
		Yuma yuma = new Yuma();
		yuma.setId(id);
		yuma.setSum(sum);
		yuma.setLocation(location);
		mapper.updateByPrimaryKeySelective(yuma);
		return Result.ok("success");
		// TODO Auto-generated method stub
		
	}

}
