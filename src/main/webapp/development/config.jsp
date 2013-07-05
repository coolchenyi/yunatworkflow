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
})
</script>
<div id="configDiv" style="width:100%; height:715px;border:0px solid #D3D3D3;background-color: #FFFFFF;">
<div style="margin-top:20px;margin-left:10px">
<span style="font-family:Verdana; font-size:13px;">任务名称:${ztree.name}</span>
<a href="#" id ="back" style="float:right;margin-right:50px">回退</a>
</div>
<input type="hidden" id="task_id" value="${ztree.taskId}">
<div style="margin-top:20px;margin-left:10px">
	<form method="post" action="/form" enctype="multipart/form-data">  
	    <input type="file" name="file"/>  
	    <input type="submit"/>  
	</form>  
</div>
<div style="margin-top:20px;margin-left:10px">
<span style="font-family:Verdana; font-size:13px;">变量列表：</span>
</div>
<div style="margin-top:5px">
	<table>  
	<tr>  
	  <th>a</th>  
	  <th>b</th>  
	  <th>c</th>  
	  <th>d</th>  
	</tr>  
	<tr>  
	  <td>a</td>  
	  <td>a</td>  
	  <td>a</td>  
	  <td>a</td>  
	</tr>  
	<tr>  
	  <td>b</td>  
	  <td>b</td>  
	  <td>b</td>  
	  <td>b</td>  
	</tr>  
	<tr>  
	  <td>c</td>  
	  <td>c</td>  
	  <td>c</td>  
	  <td>c</td>  
	</tr>  
	<tr>  
	  <td>d</td>  
	  <td>d</td>  
	  <td>d</td>  
	  <td>d</td>  
	</tr>  
</table> 
</div>
</div>

