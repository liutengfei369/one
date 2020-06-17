<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>新增</title>
<script src="js/jquery-1.8.2.min.js"></script>
<script>
	function add(){
		var str = $("#form1").serialize();
		alert(str);
		
		$.ajax({
			url : "AddServlet",
			type : "post",
			data : str,
			success : function(obj){
				//alert(obj);
				if(obj == 1){
					//新增成功
					location = "QueryAllServlet";
				}else{
					//新增失败
				}
			}
		});
		
		
		
	}
</script>
</head>
<body>
	<form id="form1">
		医生姓名：<input type="text" name="name"/><br>
		医生性别：<input type="radio" name="sex" value="男"/>男&nbsp;<input type="radio" name="sex" value="女" />女<br>
		出生日期：<input type="text" name="birth"/><br>
		兴趣爱好：<input type="checkbox" name="hobby" value="跑步"/>跑步&nbsp;
				<input type="checkbox" name="hobby" value="音乐"/>音乐&nbsp;
				<input type="checkbox" name="hobby" value="其它"/>其它&nbsp;<br>
		
				
		<input type="button" value="新增" onclick="add()"/>
	</form>
</body>
</html>