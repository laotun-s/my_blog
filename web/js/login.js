layui.use('form', function(){
    let form = layui.form;
    //监听提交
    form.on('submit(login)', function(data){
        $.ajax({
            url:"/login",
            type:"POST",
            xhrFields: {
                withCredentials: true,
            },
            dataType:"json",
            data:data.field,
            success:function (result) {
                if (result != null){
                    window.location.href = "/index.html";
                }else {
                    layer.msg("账号或者密码错误",{icon: 2,});
                }
            },
            error:function () {
                console.log("error");
            }
        });
    });
});
