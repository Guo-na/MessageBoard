function check(form) {    //表单提交事件
if (form.id.value == "") {
    alert("用户id不能为空");
    return false;
       }
if (form.name.value == "") {
    alert("用户名不能为空");
    return false;
       }
if (form.password.value == "") {
    alert("密码不能为空");
    return false;
       }
return true;
}