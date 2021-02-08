<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>添加回复</title>
 <link rel="stylesheet" href="css/reply.css">

</head>
<body>
   <div>
      <div><h2>添加回复界面</h2></div>
      <div class="div2">
            <form  action="MessageServlet" method="post">
               <label><input class="input3" type="submit" name="shouye" value="返回主界面 "/>  </label>
            </form>
      </div >
      <%String content=request.getParameter("content");
	    content= new String(content.getBytes("ISO-8859-1"),"utf-8");
	    String author=request.getParameter("author");
	    author= new String(author.getBytes("ISO-8859-1"),"utf-8");  
	  %>
	 
     <div class="div0">
        <div>
	    <p><b><%=author %>:<%=content %></b></p>
        
        </div>
        <div>
        <form action="ReplyServlet" method="post"> 
           <div>
              
              <input  name="author" type="hidden" value="<%=author %>"/>  <%--将值隐藏起来 --%>
              <input  name="content" type="hidden" value="<%=content %>"/>         
           </div>
           <%--  
              <label>留言内容:</label>
              <input  name="content" type="text" value="<%=content %>"/>
           
           --%>
           <div>
              <table>
                 
                 <tr >
                    <td>回复姓名:</td>
                    <td><%=session.getAttribute("name") %><input type="hidden" name="name" value="<%=session.getAttribute("name") %>" /></td>                                    
                 </tr>
                
                 <tr>
                 
                    <td>回复内容:</td>
                    <td><textarea  name="reply" ></textarea></td>                 
                 </tr>         
              </table>                
          </div>
          <div class="div1">
                <input class="input1" name="submit" type="submit" value="提交"/>
                <input class=" input2" name="reset" type="reset" value="重置"/>
          </div>                        
      </form>
      </div>
    </div>
  </div> 
</body>
</html>