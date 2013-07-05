<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>调度项目</title>
<link rel="stylesheet" href="css/layout.css" type="text/css" />
<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css" />
<script type="text/javascript" src="jquery/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="jquery/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="jquery/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="jquery/jquery.ztree.exedit-3.5.js"></script>
<script type="text/javascript" src="js/development/develop.js"></script>
<script src="jquery/jquery.ui.draggable.js" type="text/javascript"></script>
		
<script src="jquery/jquery.alerts.js" type="text/javascript"></script>
<link href="css/jquery.alerts.css" rel="stylesheet" type="text/css" media="screen" />

</head>

<body>
<body>
<div id="container">
  <div class="menu">
	<div id="developCenter" name="developCenter" class="menu-item menu-item-active">开发中心</div>
	<div id="workflowCenter" name="workflowCenter" class="menu-item">流程中心</div>
	<div id="controlCenter" name="controlCenter" class="menu-item">调度中心</div>
  </div>
  <div id="developCenterDiv" style="display:block">
    <div id="sidebar"><ul id="tree" class="ztree" style="width:260px; overflow:auto;"></ul></div>
    <div id="divButton">
	<div class='buttons' style="margin-top: 10px;">
	<input id="run" type="button" value="运行" style="background:transparent;border-width:1px">
	<input id="save" type="button" value="保存" style="background:transparent;border-width:1px">
	<input id="upload" type="button" value="上传附件"  style="background:transparent;border-width:1px;float:right;">
	<input id="config" type="button" value="变量规则" style="background:transparent;border-width:1px;float:right;">
	</div>
    </div>
    <div class="margin"></div>
    <div id="divText">
	<span id="scriptsid" value="XXXSQL">XXXSQL</span>
    	<textarea id="scripts" cols="87" rows="17" id="content" style="border: 1 solid #888888;LINE-HEIGHT:18px;padding: 3px;"></textarea>
    </div>
    <div class="margin"></div>
    <div id="divLog">
	<span id="logsid" value="日志">日志</span>
	<textarea id="logs" cols="87" rows="16" id="content" style="border: 1 solid #888888;LINE-HEIGHT:18px;padding: 3px;"></textarea>
    </div>
  </div>
  <div id="workflowCenterDiv" style="display:none">
    <div class="divbc">This is the workflow center.</div>
  </div>
  <div id="controlCenterDiv" style="display:none">
    <div class="divbc">This is the control center.</div>
  </div>
</div>
</body>
</html>
