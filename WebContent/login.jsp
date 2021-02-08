<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登录</title>
    <link rel="stylesheet" href="css/login.css">
<script type="text/javascript" charset="utf-8" src="js/login.js"></script>  
</head>
<body>

<div class="box">
  <div>
    <h2 >登录页面</h2>
  </div>
  	<div>
	${failmessage}
	</div>
       <form name="login" method="post" action="LoginServlet" onsubmit="return check(this)" >
       
          
        <div>
           <label>id:</label> 
           <input name="id" type="text" placeholder="请输入用户id">
        </div>
        <div><label>用户名：</label>
          <input name="name" type="text" placeholder="请输入用户名"/>
        </div>
        <div>  
           <label>密码:</label>
           <input  name="password" type="password" placeholder="请输入用户密码"/>        
         </div>

       <div >
       <input type="hidden" name="listtype" value="listmessage">
       <input class="button" name="submit" type="submit" value="登录"  />
       <input class="button" name="reset" type="reset" value="重置" />
       <input class="button" name="register" type="reset" value="注册" onclick="javascript:document.location.href='register.jsp';"/>
       </div>
    </form>
    
</div>
</body>
</html>