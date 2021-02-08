<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>注册页面</title>
<link rel="stylesheet" href="css/register.css">
<script type="text/javascript" charset="utf-8" src="js/register.js"></script> 
</head>
<body>
     
    <div class="box">
    	<div><h2>注册</h2> </div>
    	
      <form name="register" method="post" action="RegisterServlet" onsubmit="return check(this)">
      
        <div >
           <label ><b>id :&nbsp;&nbsp;&nbsp;</b></label>
           <input placeholder="请输入用户的id"  type="text" name="id" />
        </div>
        <div>
           <label>用户名：</label>
           <input name="name" type="text" placeholder="请输入用户名"/>
        </div>
        <div >
           <label >密码：&nbsp;&nbsp;&nbsp;</label>
           <input type="password" name="password" placeholder="请输入密码"/>           
        </div>
        <div>
          <label >确认密码：</label>
          <input type="password" name="password1" placeholder="请再次输入密码"/>
        </div>
        <div>
          <label >性别：</label>
          		<input class="sexinput" type="radio" name="sex" value="man">男
				<input class="sexinput" type="radio" name="sex" value="woman">女
        </div>
        <div>
          <label >职业：</label>
          	<select name="job">
					<option value="">请选择你的职业</option>
					<option value="student">学生</option>
					<option value="teacher">教育</option>
					<option value="it">IT</option>
					<option value="finance">金融</option>
					<option value="other">其他</option>
			</select>
        </div>
        <div>
        	<label >兴趣：</label>
        	<input type="checkbox" name="zyjn" value="zyjn">职业技能
        	<input type="checkbox" name="ylbg" value="ylbg">娱乐八卦
        	<input type="checkbox" name="xwzx" value="xwzx">新闻资讯
        </div>
        <div>
          <label >个人简介：</label>
          <textarea rows="4" cols="20" placeholder="请输入你的简介信息" name="info"></textarea>
        </div>
        
        
        <div class="div1">
         
          <input class="input1" type="reset" name="reset" value="清空"/>
          
          <input class="input1"  type="submit" name="submit" value="注册"/>
         </div> 
      </form>
      
      
   </div>

</body>
</html>