<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>新增</title>
<script src="js/jquery-1.8.2.min.js"></script>
<script>
	//得到要修改的id（非常重要）
	var id = "<%=request.getParameter("id") %>";
	alert(id);
	
	//实现修改功能的第一步（回显）
	$(function(){
		
		$.getJSON("QueryOneServlet", "id="+id, function(obj){
													alert(obj);//接收到一个json对象
													//从json对象中，把name、sex、birth、hobby的值取出来
													var a1 = obj.name;
													var a2 = obj.sex;
													var a3 = obj.birth;
													var a4 = obj.hobby;//"跑步,其它"
													//实现回显（把查询出来的信息放到对应的元素标签中）
													$("#name").val(a1);
													$(":radio").each(function(){
																if(a2 == this.value){
																	this.checked = true;
																}
															}
													);
													$("#birth").val(a3);
													//实现复选框的回显
													$(":checkbox").each(function(){
														if(a4.indexOf(this.value) >= 0){
															this.checked = true;
														}
													});
												}
	   );
		
		
		/* $.ajax({
			url : "QueryOneServlet",
			type : "post",
			data : "id="+id,
			dataType : "json",
			success : function(obj){
				alert(obj);//接收到一个json对象
				//从json对象中，把name、sex、birth、hobby的值取出来
				var a1 = obj.name;
				var a2 = obj.sex;
				var a3 = obj.birth;
				var a4 = obj.hobby;
				//实现回显（把查询出来的信息放到对应的元素标签中）
				$("#name").val(a1);
				$(":radio").each(
						function(){
							if(a2 == this.value){
								this.checked = true;
							}
						}
				);
				$("#birth").val(a3);
			}
		}); */
		
	});
	//实现修改功能的第二步
	function update(){
		var str = $("#form1").serialize();
		alert(str);
		
		$.ajax({
			url : "UpdateServlet",
			type : "post",
			data : str+"&id="+id,
			success : function(obj){
				//alert(obj);
				if(obj == 1){
					//成功
					location = "QueryAllServlet";
				}else{
					//失败
				}
			}
		});
	}

</script>
</head>
<body>
	<form id="form1">
		医生姓名：<input type="text" name="name" id="name"/><br>
		医生性别：<input type="radio" name="sex" value="男"/>男&nbsp;<input type="radio" name="sex" value="女" />女<br>
		出生日期：<input type="text" name="birth" id="birth"/><br>
		兴趣爱好：<input type="checkbox" name="hobby" value="跑步"/>跑步&nbsp;
				<input type="checkbox" name="hobby" value="音乐"/>音乐&nbsp;
				<input type="checkbox" name="hobby" value="其它"/>其它&nbsp;<br>
				
		<input type="button" value="更新" onclick="update()"/>	
				
				
	</form>
</body>
</html>