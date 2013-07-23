<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css" />
<script type="text/javascript" src="jquery/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="jquery/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="jquery/jquery.ztree.exedit-3.5.js"></script>
<script type="text/javascript" src="js/development/tree.js"></script>
<script src="jquery/jquery.ui.draggable.js" type="text/javascript"></script>
		

<div id="sidebar"><ul id="tree" class="ztree" style="width:260px; overflow:auto;"></ul></div>
    <div id="divButton">
	<div class='buttons' style="margin-top: 10px;">
	<input id="run" type="button" value="运行" style="background:transparent;border-width:1px">
	<input id="save" type="button" value="保存" style="background:transparent;border-width:1px">
	<input type="hidden" id = "idhidden" value="">
	<input type="hidden" id = "contenthidden" value="">
	<input type="hidden" id = "typehidden" value="">
	<input type="hidden" id = "taskidhidden" value="">
	<input id="upload" type="button" value="上传附件"  style="background:transparent;border-width:1px;float:right;">
	<input id="config" type="button" value="变量规则" style="background:transparent;border-width:1px;float:right;">
	</div>
    </div>
    <div class="margin"></div>
    <div id="divText">
		<!-- <span id="scriptsid"></span> -->
    	<textarea id="scripts" id="content" style="height:310px"></textarea>
    </div>
    <div class="margin"></div>
    <div id="divLog">
    <div>
	<span id="logsid" value="日志">日志</span>
	</div>
	<div>
	<textarea id="logs" id="content" style="height:310px"></textarea>
	</div>
 </div>
