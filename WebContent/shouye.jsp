<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="bean.Javabean" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>留言板首页</title>
     <link rel="stylesheet" href="css/shouye2.css"> 
</head>
<body>
    <div>
        <p>
		欢迎您：<%=session.getAttribute("name") %></p>
		
        <div>
             <h2>留言板主页</h2>
        </div>
           	<table style="margin:2% auto;">
           	<tr>
             <td><form action="insert.jsp" method="post">
                 <input type="submit" name="submit"  class="input" value="添加留言"/>
             </form></td>
             </tr>
           	</table> 
      	
      	<div class="content">
		<table style="border: 2px solid  black; cellspacing:1px; border-radius:15px;">
         		<tr style="background-color:#ffccff;">
         			<th width="250px">留言标题</th>
         			<th width="100px">留言作者</th>
         			<th width="100px">留言日期</th>
         			<th width="100px">查看详情</th>
         			<th width="100px">删除</th>
         		</tr>
         <c:forEach var="note" items="${list}">
         	
         		<tr style=" border-bottom:1px solid #dedede;">
         			<td>${note.title}</td>
         			<td>${note.author}</td>
         			<td>${note.date }</td>
         			<td>
         				<form action="ReplyviewServlet">
         					<input type="hidden" name="author" value="${note.author}">
         					<input type="hidden" name="content" value="${note.content}">
         					<input type="submit" value="查看回复">
         				</form>
         			</td>
         			<td>
         				<form action="DeleteServlet">
         					<input type="hidden" name="id1" value="<%=session.getAttribute("id") %>">
         					<input type="hidden" name="id" value="${note.id}">
         					<input type="hidden" name="content" value="${note.content}">
         					<input type="submit" value="删除">
         				</form>
         			<%-- <a href="DeleteServlet?id1=${sessionscope.id}&id=${note.id}>&content=${note.content}">删除</a> --%>
         			</td>
         		</tr>
     
         </c:forEach>
         </table>
      	</div>
     
    </div>
</body>
</html> 