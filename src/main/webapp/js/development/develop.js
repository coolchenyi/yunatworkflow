$(function(){
	$("div[id$='Center']").click(function(){
		$("div[id$='Center']").each(function(index,domEle) {
		    $(domEle).removeClass("menu-item-active");	
		});
		$(this).addClass("menu-item-active");
		$("div[id$='CenterDiv']").each(function(index,domEle) {
		    $(domEle).css("display","none");	
		});
		$("#"+$(this).attr("name")+"Div").css("display","block");
		
	});
	$("span[id^='_span']").click(function(){
		$("#scripts").val($(this).attr("name"));	
	});
	$("input[type='button']").click(function(){
        	alert($(this).val());
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
		onRemove: onRemove,
		onRename: onRename,
		onClick: onClick
	}
};

function onClick(event, treeId, treeNode, clickFlag) {
	$("#scripts").val(treeNode.name);
	$("#scriptsid").text(treeNode.name);
}
var log, className = "dark";
function beforeDrag(treeId, treeNodes) {
	return false;
}
function beforeEditName(treeId, treeNode) {
	className = (className === "dark" ? "":"dark");
	showLog("[ "+getTime()+" beforeEditName ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
	var zTree = $.fn.zTree.getZTreeObj("tree");
	zTree.selectNode(treeNode);
	return confirm("进入节点 -- " + treeNode.name + " 的编辑状态吗？");
}
function beforeRemove(treeId, treeNode) {
	className = (className === "dark" ? "":"dark");
	showLog("[ "+getTime()+" beforeRemove ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
	var zTree = $.fn.zTree.getZTreeObj("tree");
	zTree.selectNode(treeNode);
	return confirm("确认删除 节点 -- " + treeNode.name + " 吗？");
}
function onRemove(e, treeId, treeNode) {
	showLog("[ "+getTime()+" onRemove ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
}
function beforeRename(treeId, treeNode, newName, isCancel) {
	className = (className === "dark" ? "":"dark");
	showLog((isCancel ? "<span style='color:red'>":"") + "[ "+getTime()+" beforeRename ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name + (isCancel ? "</span>":""));
	if (newName.length == 0) {
		alert("节点名称不能为空.");
		var zTree = $.fn.zTree.getZTreeObj("tree");
		setTimeout(function(){zTree.editName(treeNode)}, 10);
		return false;
	}
	return true;
}
function onRename(e, treeId, treeNode, isCancel) {
	showLog((isCancel ? "<span style='color:red'>":"") + "[ "+getTime()+" onRename ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name + (isCancel ? "</span>":""));
}
function showRemoveBtn(treeId, treeNode) {
	return !treeNode.isFirstNode;
}
function showRenameBtn(treeId, treeNode) {
	//return !treeNode.isLastNode;
	return true;
}
function showLog(str) {
	if (!log) log = $("#log");
	log.append("<li class='"+className+"'>"+str+"</li>");
	if(log.children("li").length > 8) {
		log.get(0).removeChild(log.children("li")[0]);
	}
}
function getTime() {
	var now= new Date(),
	h=now.getHours(),
	m=now.getMinutes(),
	s=now.getSeconds(),
	ms=now.getMilliseconds();
	return (h+":"+m+":"+s+ " " +ms);
}

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
			var zTree = $.fn.zTree.getZTreeObj("tree");
			zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:r, isParent:isfolder});
			return false;
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
	{ "id":"1", "pId":"0", "name":"父节点 1", "open":"true"},
	{ "id":"11", "pId":"1", "name":"叶子节点 1-1"},
	{ "id":"12", "pId":"1", "name":"叶子节点 1-2"},
	{ "id":"13", "pId":"1", "name":"叶子节点 1-3"}
];

$(document).ready(function(){
	var t = $("#tree");
	$.ajax({
	  url: "queryZtree.do",
	  type: "POST",
	  dataType:"Text",
	  success: function(data){
		  alert(data);
	  },
	  error : function(data) {  
        alert("error");
      }  
	});
	t = $.fn.zTree.init(t, setting, zNodes);
	var zTree = $.fn.zTree.getZTreeObj("tree");
	zTree.selectNode(zTree.getNodeByParam("id", 101));

});