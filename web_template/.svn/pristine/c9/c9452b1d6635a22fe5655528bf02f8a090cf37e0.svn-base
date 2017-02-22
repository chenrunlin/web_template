<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>管理后台模板</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/static/img/favicon.ico"> 
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/style.min862f.css?v=4.1.0" rel="stylesheet">
</head>
<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5><a href="${pageContext.request.contextPath}/sysRole/to_list"><返回</a></h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <form class="form-horizontal m-t" id="signupForm" action="${pageContext.request.contextPath}/sysRole/saveSysRole" method="post">
             				<input type="text" name="id" hidden="hidden" value="${sys_role.id}" />
                            <div class="form-group">
                                <label class="col-sm-3 control-label">角色名称：</label>
                                <div class="col-sm-8">
                                    <input id="r_role_name" name="r_role_name" class="form-control" type="text" aria-required="true" aria-invalid="false" class="valid" value="${sys_role.r_role_name}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">角色描述：</label>
                                <div class="col-sm-8">
                                    <input id="r_role_desc" name="r_role_desc" class="form-control" type="text" aria-required="true" aria-invalid="false" class="valid" value="${sys_role.r_role_desc}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">角色类型：</label>
                                <div class="col-sm-8">
                                    <input id="r_role_type" name="r_role_type" class="form-control" type="text" aria-required="true" aria-invalid="true" class="error" value="${sys_role.r_role_type}">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-8 col-sm-offset-3">
                                    <button class="btn btn-primary" type="submit">提交</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/static/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="${pageContext.request.contextPath}/static/js/content.min.js?v=1.0.0"></script>
    <script src="${pageContext.request.contextPath}/static/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/plugins/validate/messages_zh.min.js"></script>
    <script type="text/javascript">
    	$(function(){
    		var pFun = '${sys_function.f_fun_pid}';
    		
    		$.validator.setDefaults({
    			highlight : function(e) {
    				$(e).closest(".form-group").removeClass("has-success").addClass(
    						"has-error")
    			},
    			success : function(e) {
    				e.closest(".form-group").removeClass("has-error").addClass(
    						"has-success")
    			},
    			errorElement : "span",
    			errorPlacement : function(e, r) {
    				e.appendTo(r.is(":radio") || r.is(":checkbox") ? r.parent().parent()
    						.parent() : r.parent())
    			},
    			errorClass : "help-block m-b-none",
    			validClass : "help-block m-b-none"
    		}), $().ready(function() {
    			var e = "<i class='fa fa-times-circle'></i> ";
    			$("#signupForm").validate({
    				rules : {
    					r_role_name : "required"
    				},
    				messages : {
    					r_role_name : e + "角色名称不能为空"
    				}
    			})
    		});
    	})
    </script>
</body>
</html>