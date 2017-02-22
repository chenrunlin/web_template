<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html lang="en">
<!-- Mirrored from www.zi-han.net/theme/hplus/login_v2.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:49 GMT -->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
	<title>管理后台模板</title>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/style.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/login.min.css" rel="stylesheet">
    <script>
    	if(window.top!==window.self){window.top.location=window.location};
    </script>
</head>
<body class="signin">
    <div class="signinpanel">
        <div class="row">
            <div class="col-sm-7">
                <div class="signin-info">
                    <div class="logopanel m-b">
                        <h1>[ H+ ]</h1>
                    </div>
                    <div class="m-b"></div>
                    <h4>欢迎使用 <strong>H+ 后台主题UI框架</strong></h4>
                    <ul class="m-b">
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势一</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势二</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势三</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势四</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势五</li>
                    </ul>
                    <strong>还没有账号？ <a href="#">立即注册&raquo;</a></strong>
                </div>
            </div>
            <div class="col-sm-5">
                <form id="login-form" method="post" action="${pageContext.request.contextPath}/login/login">
                    <h4 class="no-margins">登录：</h4>
                    <p class="m-t-md" id="error"></p>
                    <input type="text" id="username" name="username" class="form-control uname" placeholder="用户名" />
                    <input type="password" id="password" name="password" class="form-control pword m-b" placeholder="密码" />
                    <a href="#">忘记密码了？</a>
                    <input id="submit_btn" class="btn btn-success btn-block" type="submit" value="登录"/>
                </form>
            </div>
        </div>
        <div class="signup-footer">
            <div class="pull-left">
                &copy; 2015 All Rights Reserved. H+
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/static/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="${pageContext.request.contextPath}/static/js/content.min.js?v=1.0.0"></script>
    <script src="${pageContext.request.contextPath}/static/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/plugins/validate/messages_zh.min.js"></script>
    <script>
    	$(function(){
			$("#login-form").submit(function(e) {
				e.preventDefault();
 				var submit = true;
				if(submit){
					jQuery.ajax({
						url : $("#login-form").attr("action"),
						data : $("#login-form").serialize(),
						type : "POST",
						success:function(data){
							if(data.code == "1"){
								window.location.href="${pageContext.request.contextPath}/sysInit/init";
							}else{
								console.info(data.msg);
								if("1001" == data.code || "1002" == data.code){
									$("#username").val("");
									$("#password").val("");
								}
								$(".m-t-md").html(data.msg);
								$(".m-t-md").css("color","red");
							}
						}
					});
				}
				return false; 
			});
		});
	</script>
</body>
</html>
