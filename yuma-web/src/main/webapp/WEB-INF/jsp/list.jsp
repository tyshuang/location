<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/js/jquery-easyui-1.4.1/themes/default/easyui.css">
	<script type="text/javascript" src="/js/jquery-easyui-1.4.1/jquery.min.js"></script>
	<script type="text/javascript" src="/js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
</head>
<body>
	<h2>Basic DataGrid</h2>
	<p>The DataGrid is created from markup, no JavaScript code needed.</p>
	<div style="margin:20px 0;"></div>
	
	<table class="easyui-datagrid" title="Basic DataGrid" style="width:700px;height:250px"
			data-options="singleSelect:true,collapsible:true,url:'/get',method:'get'">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>`
				<th data-options="field:'id',width:60">ID</th>
	        	<th data-options="field:'type',width:60">类型</th>
	        	<th data-options="field:'name',width:70,align:'right'">物料名称</th>
	            <th data-options="field:'date',width:200">更新日期</th>
	            <th data-options="field:'sum',width:100">库存总数</th>
	            <th data-options="field:'location',width:100">摆放位置</th>
			</tr>
		</thead>
	</table>
		<input type="button" name="button" id="search" value="查询"/>
		<form id="test">
			<input type="text" name="name" id="name11"/>
		</form>
</body>
</script>
</html>