$(document).ready(function(){
	var t = $("#tree");
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