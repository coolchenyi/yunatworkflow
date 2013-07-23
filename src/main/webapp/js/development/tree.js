$(function(){
	$("#save").click(function(){
		if($("#idhidden").val() == ""){
			return false;
		}
		$.ajax({
			  url: "saveZtreeNodeContent.do",
			  type: "POST",
			  data:({"id":$("#idhidden").val(),"content":$("#scripts").val()}),
			  async:false,
			  success: function(){
				  $("#contenthidden").val($("#scripts").val());
				  jAlert("保存成功！");
				  return true;
			  },
			  error : function() {  
				  jAlert("error");
				  return false;
		      }  
			});
	});
	$("#run").click(function(){
		if($.trim($("#scripts").val())==""){
			jAlert("无运行的脚本！","友情提示");
			return false;
		}
		if($("#typehidden").val()==""){
			jAlert("运行脚本类型不明确！","友情提示");
			return false;
		}
		var ws = null;
		var timestamp=(new Date()).valueOf();
		if ('WebSocket' in window)
			ws = new WebSocket(
					"ws://10.200.187.24:8081/yunatworkflow/mywebsocket"+timestamp+".socket");
		else if ('MozWebSocket' in window)
			ws = new MozWebSocket(
					"ws://10.200.187.24:8081/yunatworkflow/mywebsocket"+timestamp+".socket");
		else
			alert("not support");
		ws.onmessage = function(evt) {
			$("#logs").append(evt.data);
			var textArea = document.getElementById('logs');
			setTimeout(function(){
				textArea.scrollTop = textArea.scrollHeight;
			}, 10);
		};

		ws.onclose = function(evt) {
//			alert("close");
		};

		ws.onopen = function(evt) {
//			alert("open");
		};
		var scripts = $("#scripts").val();
		$.ajax({
			  url: "queryrulelist.do",
			  type: "POST",
			  dataType:"json",
			  data:({"task_id":$("#taskidhidden").val()}),
			  async:false,
			  success: function(data){
				  for (var i=0;i<data.length;i++){
					  var reg =new RegExp(data[i].original_value,"g"); 
					  scripts = scripts.replace(reg,data[i].new_value)
				  }
				  setTimeout(function(){ws.send($("#typehidden").val()+"%:%"+scripts+"%:%"+$("#taskidhidden").val())},1000);
			  },
			  error : function(data) {  
		        alert("error");
		      }  
		});
	});
	$("#upload").click(function(){
		if($("#taskidhidden").val()== ""){
			jAlert("未选择任务！","友情提示");
			return false;
		}
		$.ajax({
			  url: "uploadview.do",
			  type: "POST",
			  dataType:"html",
			  data:({"id":$("#taskidhidden").val()}),
			  async:false,
			  success: function(data){
				  $("#developCenterDiv").html(data);
				  return true;
			  },
			  error : function() {  
				  jAlert("error");
				  return false;
		      }  
		});
	});
	$("#config").click(function(){
		if($("#taskidhidden").val()== ""){
			jAlert("未选择任务！","友情提示");
			return false;
		}
		$.ajax({
			  url: "configview.do",
			  type: "POST",
			  dataType:"html",
			  data:({"id":$("#taskidhidden").val()}),
			  async:false,
			  success: function(data){
				  $("#developCenterDiv").html(data);
				  return true;
			  },
			  error : function() {  
				  jAlert("error");
				  return false;
		      }  
		});
	});
})


var setting = {
	view: {
		addHoverDom: addHoverDom,
		removeHoverDom: removeHoverDom,
		selectedMulti: false
	},
	edit: {
		enable: true,
		editNameSelectAll: true,
		showRemoveBtn: showRemoveBtn,
		showRenameBtn: showRenameBtn
	},
	data: {
		simpleData: {
			enable:true,
			idKey: "id",
			pIdKey: "pId",
			rootPId: ""
		}
	},
	callback: {
		beforeDrag: beforeDrag,
		beforeEditName: beforeEditName,
		beforeRemove: beforeRemove,
		beforeRename: beforeRename,
		onClick: onClick
	}
};

//点击节点事件
function onClick(event, treeId, treeNode, clickFlag) {
	//验证活动节点是否需要保存。调用回调函数查看节点信息
	verify(treeNode,viewNode);
}
//查看节点内容信息
function viewNode(treeNode){
	if(treeNode.isParent){
		$("#contenthidden").val("");
		$("#idhidden").val("");
		$("#typehidden").val("");
		$("#taskidhidden").val(treeNode.taskId);
		$("#scripts").val("");
//		$("#scriptsid").text(treeNode.name);
		return false;
	}else{
		$.ajax({
			  url: "queryZtreeNodeContent.do",
			  type: "POST",
			  data:({"id":treeNode.id}),
			  dataType:"json",
			  async:false,
			  success: function(data){
				  $("#contenthidden").val(data.content);
				  $("#idhidden").val(data.id);
				  $("#typehidden").val(treeNode.name.split(".")[1]);
				  $("#taskidhidden").val(treeNode.taskId);
				  $("#scripts").val(data.content);
//				  $("#scriptsid").text(treeNode.name);
				  return true;
			  },
			  error : function() {  
				  jAlert("error");
				  return false;
		      }  
			});
	}
}
//验证节点是否需要保存，根据情况执行回调函数
function verify(treeNode,callBack){
	if($("#scripts").val() != $("#contenthidden").val()){
		jConfirm('脚本未保存，是否保存?', '友情提示', function(r) {
		    if(r){
		    	$.ajax({
					  url: "saveZtreeNodeContent.do",
					  type: "POST",
					  data:({"id":$("#idhidden").val(),"content":$("#scripts").val()}),
					  async:false,
					  success: function(){
						  jAlert("保存成功！");
						  callBack(treeNode);
					  },
					  error : function() {  
						  jAlert("error");
						  return false;
				      }  
					});
		    }else{
		    	callBack(treeNode);
			}
		});
	}else{
		callBack(treeNode);
	}
}

var log, className = "dark";
function beforeDrag(treeId, treeNodes) {
	return false;
}
function beforeEditName(treeId, treeNode) {
	className = (className === "dark" ? "":"dark");
	var zTree = $.fn.zTree.getZTreeObj("tree");
	zTree.selectNode(treeNode);
	return confirm("进入节点 -- " + treeNode.name + " 的编辑状态吗？");
}
function beforeRemove(treeId, treeNode) {
	className = (className === "dark" ? "":"dark");
	if(confirm("确认删除节点--" + treeNode.name + " 吗？")){
		$.ajax({
			  url: "deleteZtreeNode.do",
			  type: "POST",
			  data:({"id":treeNode.id}),
			  async:false,
			  success: function(){
				  return true;
			  },
			  error : function() {  
				  jAlert("error");
		        return false;
		      }  
			});
	}
}
//function onRemove(e, treeId, treeNode) {
//	showLog("[ "+getTime()+" onRemove ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
//}
function beforeRename(treeId, treeNode, newName, isCancel) {
	className = (className === "dark" ? "":"dark");
	if (newName.length == 0) {
		alert("节点名称不能为空.");
		var zTree = $.fn.zTree.getZTreeObj("tree");
		setTimeout(function(){zTree.editName(treeNode)}, 10);
		return false;
	}
	$.ajax({
		  url: "renameZtreeNode.do",
		  type: "POST",
		  data:({"id":treeNode.id,"name":newName}),
		  async:false,
		  success: function(){
			  return true;
		  },
		  error : function() {  
	        jAlert("error");
	        return false;
	      }  
		});
	return true;
}
//function onRename(e, treeId, treeNode, isCancel) {
//	showLog((isCancel ? "<span style='color:red'>":"") + "[ "+getTime()+" onRename ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name + (isCancel ? "</span>":""));
//}
function showRemoveBtn(treeId, treeNode) {
	return treeNode.id!="1";
}
function showRenameBtn(treeId, treeNode) {
	//return !treeNode.isLastNode;
	return true;
}
//function showLog(str) {
//	if (!log) log = $("#log");
//	log.append("<li class='"+className+"'>"+str+"</li>");
//	if(log.children("li").length > 8) {
//		log.get(0).removeChild(log.children("li")[0]);
//	}
//}
//function getTime() {
//	var now= new Date(),
//	h=now.getHours(),
//	m=now.getMinutes(),
//	s=now.getSeconds(),
//	ms=now.getMilliseconds();
//	return (h+":"+m+":"+s+ " " +ms);
//}

var newCount = 1;
function addHoverDom(treeId, treeNode) {
	var sObj = $("#" + treeNode.tId + "_span");
	if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0 || !treeNode.isParent) return;
	var addStr = "<span class='button add' id='addBtn_" + treeNode.tId + "' title='add node' onfocus='this.blur();'></span>";
	sObj.after(addStr);
	var btn = $("#addBtn_"+treeNode.tId);
	if (btn) btn.bind("click", function(){
		jPrompt('支持文件夹及.hive文件:', '', '新建节点', function(r) {
			rarray = r.split(".");
			isfolder = false;
			if (r == ""){
				return;
			}
			if (rarray.length == 1){
				isfolder = true;
			}
			if(rarray.length == 2 && rarray[1]== "hive"){
				isfolder = false;
			}
			if(rarray.length > 2){
				jAlert("目前只支持.hive文件","友情提示");
				return;
			}
			$.ajax({
				  url: "addZtreeNode.do",
				  type: "POST",
				  data:({"pId":treeNode.id,"name":r,"taskId":treeNode.taskId,"isParent":isfolder}),
				  dataType:"json",
				  async:false,
				  success: function(data){
					  var zTree = $.fn.zTree.getZTreeObj("tree");
					  zTree.addNodes(treeNode, data);
					  return false;
				  },
				  error : function(data) {  
			        alert("error");
			      }  
				});
		});
	});
};
function removeHoverDom(treeId, treeNode) {
	$("#addBtn_"+treeNode.tId).unbind().remove();
};
function selectAll() {
	var zTree = $.fn.zTree.getZTreeObj("tree");
	zTree.setting.edit.editNameSelectAll =  $("#selectAll").attr("checked");
}

var zNodes =[
	{ "id":"1", "pId":"0", "name":"父节点 1", "open":"true","group_id":""},
	{ "id":"11", "pId":"1", "name":"叶子节点 1-1"},
	{ "id":"12", "pId":"1", "name":"叶子节点 1-2"},
	{ "id":"13", "pId":"1", "name":"叶子节点 1-3"}
];

$(document).ready(function(){
	var t = $("#tree");
	$.ajax({
	  url: "queryZtree.do",
	  type: "POST",
	  dataType:"json",
	  async:false,
	  success: function(data){
		  zNodes = data;
		  t = $.fn.zTree.init(t, setting, zNodes);
		  var zTree = $.fn.zTree.getZTreeObj("tree");
		  zTree.expandNode(zTree.getNodeByParam("id", "1"));
	  },
	  error : function(data) {  
        alert("error");
      }  
	});
});