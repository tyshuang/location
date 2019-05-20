<!DOCTYPE html>
<html >
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="/js/jquery-easyui-1.4.1/themes/default/easyui.css">
	<script type="text/javascript" src="/js/jquery-easyui-1.4.1/jquery.min.js"></script>
	<script type="text/javascript" src="/js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
</head>
<body>
	<h2>小马</h2>
	<p>定子转子定位服务</p>
	<div style="margin:20px 0;"></div>
    <table id="tt" class="easyui-datagrid" style="width:600px;height:250px"
   		url="/search/list" toolbar="#tb"
   		title="Load Data" iconCls="icon-save"
   		rownumbers="true" pagination="true" singleSelect="true">
   	<thead>
   		<tr>
   			<th field="id" width="40">ID</th>
   			<th field="type" width="80">类型</th>
   			<th field="name" width="160">物料名称</th>
   			<th field="date" width="160" align="right" sortable="true" data-options="formatter:function(value){return formatDatebox(value);}">更新日期</th>
   			<th field="sum" width="80" align="right">库存总数</th>
   			<th field="location" width="80">摆放位置</th>
   		</tr>
   	</thead>
   </table>
       <div id="tb" style="padding:3px">
    	<span>品名查询:</span>
    	<input id="nameid" style="line-height:26px;border:1px solid #ccc">
    	<span>位置查询:</span>
    	<input id="locationid" style="line-height:26px;border:1px solid #ccc">
    	<a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">查询</a>
    </div>
    <div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">入库</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">更新库存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">删除库存</a>
</div>
<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
        closed="true" buttons="#dlg-buttons">
    <div class="ftitle">User Information</div>
    <form id="fm" method="post">
        <div class="fitem">
            <label>产品类型:</label>
            <input name="type" class="easyui-validatebox" required="true">
        </div>
        <div class="fitem">
            <label>物料名称:</label>
            <input name="name" class="easyui-validatebox" required="true">
        </div>
        <div class="fitem">
            <label>更新时间:</label>
            <input name="date">
        </div>
        <div class="fitem">
            <label>库存总数:</label>
            <input name="sum" class="easyui-validatebox" required="true">
        </div>
        <div class="fitem">
            <label>摆放位置:</label>
            <input name="location" class="easyui-validatebox" required="true">
        </div>
    </form>
</div>
<div id="dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
</div>
</body>

<script type="text/javascript">

	Date.prototype.format = function (format) {
	    var o = {
	        "M+": this.getMonth() + 1, // month
	        "d+": this.getDate(), // day
	        "H+": this.getHours(), // hour
	        "m+": this.getMinutes(), // minute
	        "s+": this.getSeconds(), // second
	        "q+": Math.floor((this.getMonth() + 3) / 3),   // quarter
	        "S": this.getMilliseconds()
	        // millisecond
	    }
	    if (/(y+)/.test(format))
	        format = format.replace(RegExp.$1, (this.getFullYear() + "")
	            .substr(4 - RegExp.$1.length));
	    for (var k in o)
	        if (new RegExp("(" + k + ")").test(format))
	            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
	    return format;
	}

	function formatDatebox(value) {  
	    if (value == null || value == '') {  
	        return '';  
	    }  
	    var dt;  
	    if (value instanceof Date) {  
	        dt = value;  
	    } else {  
	        dt = new Date(value);  
	    }  
	  
	    return dt.format("yyyy-MM-dd HH:mm:ss"); //扩展的Date的format方法(上述插件实现)  
	} 
	
/* 	$('#tt').datagrid({
	    ……
	    columns: [[
	            { field: 'date', title: '创建日期', width: 120,align: 'center',formatter: formatDatebox},
	            ……
	        ]]    
	}); */

	function doSearch(){
		$('#tt').datagrid('load',{
			nameid: $('#nameid').val(),
			locationid: $('#locationid').val(),
		});
	}
	function newUser(){
	    $('#dlg').dialog('open').dialog('setTitle','New User');
	    $('#fm').form('clear');
	    url = '/add';
	}

	function editUser(){
		var row = $('#tt').datagrid('getSelected');
		 if (row){
		    $('#dlg').dialog('open').dialog('setTitle','Edit User');
		    $('#fm').form('load',row);
		    url = 'update.action?id='+row.id;
		}
	}
	
	function saveUser(){
	    $('#fm').form('submit',{
	        url: url,
	        onSubmit: function(){
	            return $(this).form('validate');
	        },
	        success: function(result){
	            var result = eval('('+result+')');
	            if (result.errorMsg){
	                $.messager.show({
	                    title: 'Error',
	                    msg: result.errorMsg
	                });
	            } else {
	                $('#dlg').dialog('close');        // close the dialog
	               /*  $('#dg').datagrid('reload'); */
	               alert("操作成功！！！");
	            }
	        }
	    });
	}
	
	function destroyUser(){
	    var row = $('#tt').datagrid('getSelected');
	    if (row){
	        $.messager.confirm('Confirm','Are you sure you want to destroy this user?',function(r){
	            if (r){
	                $.post('/delete',{id:row.id},function(result){
	                	//var result = eval('('+result+')');
	                    if (result.success){
	                        //$('#tt').datagrid('reload');    // reload the user data
							$.messager.alert("系统提示","已成功删除这条记录!");
	                    } else {
	                        $.messager.show({    // show error message
	                            title: 'success',
	                            msg: '删除成功'
	                        });
	                    }
	                },'json');
	            }
	        });
	    }
	}
	
	
</script>
</html>