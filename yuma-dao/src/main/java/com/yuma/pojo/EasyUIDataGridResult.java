package com.yuma.pojo;

import java.io.Serializable;
import java.util.List;
/**
 * datagrid展示数据的POJO 包括商品的pojo
 * 
 * @author Administrator
 *
 */

public class EasyUIDataGridResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer total;//记录条数
	private List rows;//可以不写泛型
	
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	
}
