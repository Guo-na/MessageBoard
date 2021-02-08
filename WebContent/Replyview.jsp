<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf8"%>
<%@ page import="bean.Javabean" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>回复详情</title>
   <link rel="stylesheet" href="css/replyview.css">
</head>
<body>
   <div>
        <div><h2>留言详情界面</h2></div>
        <%
        String content=request.getParameter("content");
	    /* content= new String(content.getBytes("ISO-8859-1"),"utf-8"); */
	   	/* 用post方法不需要改编码，用get方法改了编码也没用，目前没有找到解决方法。 */
	    String author=request.getParameter("author");
	    /* author= new String(author.getBytes("ISO-8859-1"),"utf-8"); */
	    %>
	     <table style="margin:2% auto; ">
	     	<tr>
            <td><form  action="MessageServlet" method="post">
               <label> <input  type="submit" name="shouye" value="返回主界面 "/>  </label>
            </form></td>
            <td><form  action="reply.jsp" method="post">
            	<input type="hidden" name="author" value="<%=author%>">
            	<input type="hidden" name="content" value="<%=content  %>">
               <label> <input  type="submit" name="shouye" value="添加回复"/>  </label>
            </form></td>
            </tr>
         </table>
            
        <table style="border: 2px solid  black; cellspacing:1px; border-radius:15px;">
            <div class="div1">
	        <label><%=author %>:</label>
	        <label><%=content %></label>
	    </div>
        </table>    
	    
	   
	    
	    <div class="div2">
	    
	    
	       
       <%
            List<Javabean> list=(List<Javabean>)request.getAttribute("list");
            if(list==null||list.size()<1){   %>
       <div class="div3">   <%   	out.print("暂无回复→_→"); %></div>
          <%   }
            else{
                for(Javabean note :list)	{
       %>
            <div class="div4">
               <p> <%= note.getName() %>:<%= note.getReply() %>    </p>                       	             	             	
            </div> 	
              <%
                   }            	
            }
            %>  
          </div>
</div>
   
   
   
   
   
  
</body>
</html> 