//检测没有登录就跳转到登录界面
$(function () {
    if (!$.cookie("user_key")){

        window.location = 'http://' + location.host + '/layui-admin/page/login.html';
        //console.log("2222222222222");
    }
});