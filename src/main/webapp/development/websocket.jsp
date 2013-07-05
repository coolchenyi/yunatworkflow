<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
<script type="text/javascript">
	var ws = null;
	function startWebSocket() {
	}

	function sendMsg() {
		var timestamp=(new Date()).valueOf();
		if ('WebSocket' in window)
			ws = new WebSocket(
					"ws://10.200.190.191:8080/yunatworkflow/mywebsocket"+timestamp+".socket");
		else if ('MozWebSocket' in window)
			ws = new MozWebSocket(
					"ws://10.200.190.191:8080/yunatworkflow/mywebsocket"+timestamp+".socket");
		else
			alert("not support");
		ws.onmessage = function(evt) {
			alert(evt.data); 
		};

		ws.onclose = function(evt) {
			alert("close");
		};

		ws.onopen = function(evt) {
			alert("open");
		};
		setTimeout(function(){ws.send(document.getElementById('writeMsg').value)},1000);
	}
</script>
</head>
<body onload="startWebSocket();">
	<input type="text" id="writeMsg"></input>
	<input type="button" value="send" onclick="sendMsg()"></input>
</body>
</html>
