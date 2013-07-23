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
	$("#uploadbutton").click(function(){
		if($("#file").val() == ""){
			alert("请先选择附件！");
			return false;
		}
		$("#uploadfile").submit();
		$("#file").val("");
		$("#description").val("");
		setTimeout(function(){
			$.ajax({
			  url: "queryattachment.do",
			  type: "POST",
			  dataType:"json",
			  data:({"task_id":$("#task_id").val()}),
			  async:false,
			  success: function(data){
				  html ="<table><tr><th>文件名称</th><th>文件描述</th><th>操作</th></tr>";
				  for (var i=0;i<data.length;i++){
					  html += "<tr><td>"+data[i].file_name+"</td><td>"+data[i].description+"</td><td><a href='#' class='del' name='"+data[i].file_name+"' id='"+data[i].fid+"'>删除</a></td></tr>";
				  }
				  html+="</table>";
				  $("#attachmentlist").html(html);
				  alert("上传成功！");
			  },
			  error : function(data) {  
		        alert("error");
		      }  
			});},1000);
	});
	$(".del").live('click',function(){
		var flag= false;
		$.ajax({
			  url: "deleteattachment.do",
			  type: "POST",
			  data:({"task_id":$("#task_id").val(),"fid":$(this).attr("id"),"file_name":$(this).attr("name")}),
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
	  url: "queryattachment.do",
	  type: "POST",
	  dataType:"json",
	  data:({"task_id":$("#task_id").val()}),
	  async:false,
	  success: function(data){
		  html ="<table><tr><th>文件名称</th><th>文件描述</th><th>操作</th></tr>";
		  for (var i=0;i<data.length;i++){
			  html += "<tr><td>"+data[i].file_name+"</td><td>"+data[i].description+"</td><td><a href='#' class='del' name='"+data[i].file_name+"' id='"+data[i].fid+"'>删除</a></td></tr>";
		  }
		  html+="</table>";
		  $("#attachmentlist").html(html);
	  },
	  error : function(data) {  
        alert("error");
      }  
	});
});
</script>
<div id="uplandDiv" style="width:100%; height:715px;border:0px solid #D3D3D3;background-color: #FFFFFF;">
<div style="margin-top:20px;margin-left:10px">
<span style="font-family:Verdana; font-size:13px;">任务名称:${ztree.name}</span>
<a href="#" id ="back" style="float:right;margin-right:50px">回退</a>
</div>
<div style="margin-top:20px;margin-left:10px">
	<form id="uploadfile" method="post" action="uploadfile.do" enctype="multipart/form-data" target="hidden_frame"> 
	    选择文件：<input type="file" name="file" id="file"/>
	    文件说明：<input type="text" name="description" id="description"/> 
	    <input type="hidden" id="task_id" name="task_id" value="${ztree.taskId}">
	    <input type="hidden" id="name" name="task_name" value="${ztree.name}">
	    <input type="button" id="uploadbutton" value="上传"/>
	    <iframe name='hidden_frame' id="hidden_frame" style="display:none"></iframe>
	</form>  
</div>
<div style="margin-top:20px;margin-left:10px">
<span style="font-family:Verdana; font-size:13px;">附件列表：</span>
</div>
<div style="margin-top:5px" id ="attachmentlist">
</div>
</div>

