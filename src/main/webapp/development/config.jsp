<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<style type="text/css">  
        table {  
            border: 1px solid #D3D3D3;  
            padding:0;   
            margin:0 auto;  
            border-collapse: collapse;  
            width:90%;
            height:90%;
            margin-bottom:5px;
        }  
        th {  
            border: 1px solid #D3D3D3;  
            background: #fff;  
            font-size:12px;  
            padding: 3px 3px 3px 8px;  
            color: #4f6b72;  
        }
        td {  
            border: 1px solid #D3D3D3;  
            background: #fff;  
            font-size:12px;  
            padding: 3px 3px 3px 8px;  
            color: #4f6b72;  
        }  
</style>

<script type="text/javascript">
$(function(){
	$("#back").click(function(){
		$.ajax({
			  url: "treeview.do",
			  type: "POST",
			  dataType:"html",
			  async:false,
			  success: function(data){
				  $("#developCenterDiv").html(data);
			  },
			  error : function(data) {  
		      alert("error");
		    }  
		});
	});
	$("#addrule").click(function(){
		$.ajax({
			  url: "addrule.do",
			  type: "POST",
			  dataType:"json",
			  data:({"task_id":$("#task_id").val(),"original_value":$("#original_value").val(),"rule_type":$("#rule_type").val(),"new_value":$("#new_value").val()}),
			  async:false,
			  success: function(data){
				  html ="<table><tr><th>原值</th><th>规则类型</th><th>新值</th><th>操作</th></tr>";
				  for (var i=0;i<data.length;i++){
					  html += "<tr><td>"+data[i].original_value+"</td><td>"+data[i].rule_type+"</td><td>"+data[i].new_value+"</td><td><a href='#' class='del' id='"+data[i].rid+"'>删除</a></td></tr>";
				  }
				  html+="</table>";
				  $("#rulelist").html(html);
				  $("#original_value").val("");
				  $("#rule_type").val("");
				  $("#new_value").val("");
				  alert("增加成功！");
			  },
			  error : function(data) {  
		        alert("error");
		      }  
			})
	});
	$(".del").live('click',function(){
		var flag= false;
		$.ajax({
			  url: "deleterule.do",
			  type: "POST",
			  data:({"task_id":$("#task_id").val(),"rid":$(this).attr("id")}),
			  async:false,
			  success: function(){
				  flag = true;
			  },
			  error : function(data) {  
		        alert("error");
		      }  
		});
		if(flag){
			 $(this).closest("tr").remove();
			 alert("删除成功！");
		}
	});
})

$(document).ready(function(){
	$.ajax({
	  url: "queryrulelist.do",
	  type: "POST",
	  dataType:"json",
	  data:({"task_id":$("#task_id").val()}),
	  async:false,
	  success: function(data){
		  html ="<table><tr><th>原值</th><th>规则类型</th><th>新值</th><th>操作</th></tr>";
		  for (var i=0;i<data.length;i++){
			  html += "<tr><td>"+data[i].original_value+"</td><td>"+data[i].rule_type+"</td><td>"+data[i].new_value+"</td><td><a href='#' class='del' id='"+data[i].rid+"'>删除</a></td></tr>";
		  }
		  html+="</table>";
		  $("#rulelist").html(html);
	  },
	  error : function(data) {  
        alert("error");
      }  
	});
});
</script>
<div id="configDiv" style="width:100%; height:715px;border:0px solid #D3D3D3;background-color: #FFFFFF;">
<div style="margin-top:20px;margin-left:10px">
<span style="font-family:Verdana; font-size:13px;">任务名称:${ztree.name}</span>
<a href="#" id ="back" style="float:right;margin-right:50px">回退</a>
</div>
<input type="hidden" id="task_id" value="${ztree.taskId}">
<div style="margin-top:20px;margin-left:10px">
    原值:<input type="text" name="original_value" id="original_value"/>  
    类型:<select name="rule_type" id="rule_type">
		  <option value ="contant">contant</option>
		  <option value ="variable">variable</option>
		  <option value="regex">regex</option>
		</select>
    新值:<input type="text" name="new_value" id="new_value"/>
    <input type="button" id="addrule" value="新增"/>
</div>
<div style="margin-top:20px;margin-left:10px">
<span style="font-family:Verdana; font-size:13px;">变量列表：</span>
</div>
<div style="margin-top:5px" id="rulelist">
</div>
</div>

