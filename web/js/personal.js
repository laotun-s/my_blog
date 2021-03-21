$(function() {
    if ($.cookie("user_key")){
        let user = $.cookie("user_key").split("-")[0];
        let html = "";
        html = '<a href="/index.html"><img src="icon/1.jpg" class="layui-nav-img">' + user + '</a><dl class="layui-nav-child"><dd><a href="">个人资料</a></dd><dd><a href="/layui-admin/#/page/edit.html">撰写文章</a></dd><dd><a href="/logout">退出登录</a></dd></dl>';
        $("#user").append(html);
    }else {
        let html = "";
        html = '<a href="/layui-admin/page/login.html"><img src="icon/1.jpg" class="layui-nav-img">log in</a><dl class="layui-nav-child"><dd><a href="/layui-admin/page/login.html">登录</a></dd></dl>';
        $("#user").append(html);
    }
});