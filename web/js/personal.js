layui.use('layer', function () {
    let layer = layui.layer;

    if ($.cookie("user_key")){
        let user = $.cookie("user_key").split("-")[0];
        let html = "";
        html = '<a href="/index.html"><img src="icon/1.jpg" class="layui-nav-img">' + user + '</a><dl class="layui-nav-child"><dd><a href="">个人资料</a></dd><dd><a href="/layui-admin/#/page/edit.html">撰写文章</a></dd><dd><a href="javascript:;" class="logout">退出登录</a></dd></dl>';
        $("#user").append(html);
    }else {
        let html = "";
        html = '<a href="/layui-admin/page/login.html"><img src="icon/1.jpg" class="layui-nav-img">log in</a><dl class="layui-nav-child"><dd><a href="/layui-admin/page/login.html">登录</a></dd></dl>';
        $("#user").append(html);
    }
    $('.logout').on("click", function () {
        $.ajax({
            url:"/logout",
            type:"POST",
            xhrFields: {
                withCredentials: true,
            },
            dataType:"json",
            data: "",
            success:function (result) {
                layer.msg('退出登录成功', function () {
                    window.location = 'index.html';
                });
            }
        });
    });
});