<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>列表页面</title>
    <LINK href="css/css.css" type="text/css" rel="stylesheet">
    <script src="js/jquery-1.8.2.min.js"></script>
    <script>
    	
    	//实现批量删除
    	//delete from t_doctor where id in (1,3)
    	function dels(){
    		var str = "";
			$(":checkbox:checked").each(function(){
				str += this.value+",";
			});
			str = str.substring(0, str.length-1);//去掉最后一个逗号
			//alert(str);//这里测试一下，非常重要
			if(str == ""){
				alert("对不起，您没有选择");
				return;
			}
    		
    		if(window.confirm("您确定要删除吗？")){
    			$.ajax({
    				url:"DeleteServlet",
    				type:"post",
    				data:"str="+str,
    				success:function(obj){
    					alert(obj);
    					if(obj > 0){
    						//成功
    						location = "QueryAllServlet";
    					}else{
    						//
    					}
    				}
    				
    			});
    		}
    	}
    	//单条删除
    	//delete from t_doctor where id in (1)
    	function del(id){
    		if(window.confirm("您确定要删除吗？")){
    			
    			$.ajax({
    				url:"DeleteServlet",
    				type:"post",
    				data:"str="+id,
    				success:function(obj){
    					alert(obj);
    					if(obj > 0){
    						//成功
    						location = "QueryAllServlet";
    					}else{
    						//
    					}
    				}
    				
    			});
    		}
    	}
    	//全选
    	function a1(){
    		$(":checkbox").attr("checked", true);
    	}
    	//全不选
    	function a2(){
    		$(":checkbox").attr("checked", false);
    	}
    	//反选
    	function a3(){
    		$(":checkbox").each(function(){
    			this.checked = !this.checked;
    		});
    	}
    
    </script>
   
  </head>
  <body>
  
  	<a href="add.jsp"><input type="button" value="新增"/></a>
  	<input type="button" value="批量删除" onclick="dels()"/>
  	<input type="button" value="全选" onclick="a1()">
    <input type="button" value="全不选" onclick="a2()">
    <input type="button" value="反选" onclick="a3()">
  
    <table border=1>
	<tr>
	<td>请选择</td>
	<td>医生id</td>
	<td>医生姓名</td>
	<td>性别</td>
	<td>出生日期</td>
	<td>爱好</td>
	<td>操作一</td>
	<td>操作二</td>
	</tr>
	<c:forEach items="${list }" var="a">
		<tr>
		<td><input type="checkbox" name="ck" value="${a.id }"/></td>
		<td>${a.id }</td>
		<td>${a.name }</td>
		<td>${a.sex }</td>
		<td>${a.birth }</td>
		<td>${a.hobby }</td>
		<td><a href="update.jsp?id=${a.id }"><input type="button" value="修改"/></a></td>
		
		<td><input type="button" value="删除" onclick="del(${a.id })"/></td>
		</tr>
	</c:forEach>
  	</table>
  
  </body>
</html>
