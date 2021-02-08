<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>添加留言</title>
<link rel="stylesheet" href="css/insert.css">
</head>
<body>
     <div>
           <div>
               <h2>添加留言界面</h2>
           </div>
           <div class="div1">
                 <form action="MessageServlet" method="post">
                      <input class="input0" name="shouye" type="submit" value="返回主页面"/>
                 </form>
             </div>
           <div class="div2">
                 <form action="InsertServlet" method="post">
                 <div>
                       <table>
                           
                           <tr>
                              <td><label>留言id:</label></td>
                              <td><%=session.getAttribute("id") %><input name="id" type="hidden" maxlength="11" value="<%=session.getAttribute("id") %>"/></td>
                           </tr>
                          
                         <tr>
                           <td><label >留言标题:</label></td>
                           <td><input class="input1" name="title" type="text"/></td>                          
                         </tr>
                         <tr>
                           <td><label>留言作者:</label></td>
                           <td><%=session.getAttribute("name") %><input name="author" type="hidden" value="<%=session.getAttribute("name") %>"/></td>
                         </tr>
                         <tr>
                           <td><label>留言内容:</label></td>
                           <td><textarea   name="content" type="text" /></textarea></td>
                         </tr>
                         <tr>
                           <td><label>留言时间:</label></td>
                           <td><input class="input1" name="date" type="text" maxlength="11"/></td>
                         </tr>
                     </table>
                  </div>
                   <div class="div3">
                          <input class="input3" name="submit" type="submit" value="提交"/>
                          <input class="input3" name="reset" type="reset" value="清空"/>                  
                   </div>                 
                 </form>
             </div>
             
     
     
     
     
     
     
     
     
     </div>
</body>
</html> 