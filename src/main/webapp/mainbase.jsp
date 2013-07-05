<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>hadoop任务调度</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/jquery.ui/development-bundle/jquery.ui.all.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="jquery/jquery-1.4.4.min.js"></script>
<script src="jquery.ui/development-bundle/jquery.ui.core.js" type="text/javascript"></script>
<script src="jquery.ui/development-bundle/jquery.ui.widget.js" type="text/javascript"></script>
<script src="jquery.ui/development-bundle/jquery.ui.tabs.js" type="text/javascript"></script>
<script type="text/javascript" charset="utf-8">
$(document).ready( function (){
	$("#TabDetails").tabs({tabId: "#tabtag",conId:"#tabcon"});
});
</script>
</head>
<body>
<div id="TabDetails">
        <div id="tabtag">
        <ul class="tabSelect">
          <li><a href="deveopmentview.do" title="Todo Overview1">开发中心</a></li>
          <li><a href="workflowview.do" title="Todo Overview2">流程中心</a></li>
          <li><a href="executionview.do" title="Todo Overview3">执行中心</a></li>
        </ul>
        </div>
        <div id="tabcon">
        	<div id="Todo_Overview1"></div>
      		<div id="Todo_Overview2"></div>
      		<div id="Todo_Overview3"></div>
      	</div>
      </div>
</body>
</html>