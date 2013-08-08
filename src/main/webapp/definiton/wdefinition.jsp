<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css" />
<script type="text/javascript" src="jquery/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="jquery/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="jquery/jquery.ztree.exedit-3.5.js"></script>

<script type="text/javascript" src="js/definition/definition.js"></script>
<script src="jquery/jquery.ui.draggable.js" type="text/javascript"></script>

<script src="jquery/jquery.alerts.js" type="text/javascript"></script>
<link href="css/jquery.alerts.css" rel="stylesheet" type="text/css" media="screen" />

<style type="text/css">
SELECT, INPUT[type="text"] {
    width: 160px;
    box-sizing: border-box;
}
SECTION {
    padding: 8px;
    background-color: #f0f0f0;
    overflow: auto;
}
SECTION > DIV {
    float: left;
    padding: 4px;
}
SECTION > DIV + DIV {
    width: 40px;
    text-align: center;
}
#wcontainer {margin:0 auto; width:1000px;border:0px solid #D3D3D3;background-color: #FFFFFF;}
#develop #workflow #control{ margin-bottom:5px;}
#sidebar { float:left; width:260px; height:715px;border:1px solid #D3D3D3;background-color: #FFFFFF; margin-top:5px; }
#contentbar { float:right; width:725px; height:715px; }
#divButton { float:right; width:725px; height:40px;border:1px solid #D3D3D3;background-color: #FFFFFF; margin-top:5px;}
#divText { float:left; width:720px; height:300px; }
#divLog { float:right; width:725px; height:320px; }
.margin {float:right; width:725px; margin-bottom:5px;}
</style>

<div id="wcontainer" style="margin-top:5px">
  <div id="workflowCenterDiv" style="display:block">
    <div id="sidebar"><ul id="wtree" class="ztree"></ul></div>
    <div id="divButton">
		<input id="save" type="button" value="保存" style="width:100px;border-width:1px;float:left;margin-top:10px;">
    </div>
    <div class="margin"></div>
	<div id="contentbar">
        <div id="properties" >
            <div>
              <input type="button" id="pbtnNodeType" value="Node Type:" style="width:100px;"/>
              <select id="nodeType">
                <option value="none" selected="selected">select type of node</option>
                <option value="start">Start</option>
                <option value="end">End</option>
                <option value="autorun">Autorun</option>
                <option value="jms">JMS</option>
                <option value="sms">SMS</option>
                <option value="email">EMAIL</option>
              </select>
            </div>
            <div>
              <div id="ntConfigjms" style="display:none;">
                <div class="margin"></div>
                <input type="button" id="btnJmsApp" value="Application:" style="width:100px;"/>
                <select id="jmsApp">
                  <option value="mq">MQ</option>
                </select>
              </div>
              <div id="ntConfigsms" style="display:none;">
                <div class="margin"></div>
                <input type="button" id="btnSmsNumber" value="Number:" style="width:100px;"/>
                <input type="text" name="smsNumber" />
              </div>
              <div id="ntConfigemail" style="display:none;">
                <div class="margin"></div>
                <input type="button" id="btnEmail" value="Email:" style="width:100px;"/>
                <input type="text" name="emailNumber" />
              </div>
            </div>
            <div class="margin"></div>
            <div>
              <input type="button" id="pbtnHookType" value="Hook Type:" style="width:100px;"/>
              <select id="hookType">
                <option value="none" selected="selected">select type of hook</option>
                <option value="hive">Hive</option>
              </select>
            </div>
            <div class="margin"></div>
            <div>
              <div>
                <input type="button" id="pbtnObj" value="Hook Obj:" style="width:100px;"/>
                <select id="ss_hookObj">
                  <option value="none" selected="selected">select hook object</option>
                  <option value="1.hive">1.hive</option>
                  <option value="2.hive">2.hive</option>
                </select>
              </div>
              <div class="margin"></div>
              <div id="divText">
    	        <textarea id="scripts" style="height:290px"></textarea>
              </div>
            </div>
            <div class="margin"></div>
            <div>
              <input type="button" id="pbtnTo" value="To:" style="width:100px;"/>
              <div class="margin"></div>
              <section class="container">
                <div>
                  <select id="leftValues" size="5" multiple>
                    <option value="1">Node 1</option>
                    <option value="2">Node 2</option>
                    <option value="3">Node 3</option>
                    <option value="4">Node 4</option>
                    <option value="5">Node 5</option>
                  </select>
                </div>
                <div>
                  <input type="button" id="btnRight" value="&gt;&gt;" />
                  <input type="button" id="btnLeft" value="&lt;&lt;" />
                </div>
                <div>
                  <select id="rightValues" size="5" multiple>
                  </select>
                </div>
              </section>
            </div>
        </div>
    </div>
  </div>
</div>
