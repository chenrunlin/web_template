<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/plugins/summernote/summernote.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/plugins/summernote/summernote-bs3.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/style.min862f.css?v=4.1.0" rel="stylesheet">
</head>
<body class="gray-bg">
    <div class="wrapper wrapper-content">
        <div class="row">
            <div class="col-sm-12 fadeInRight">
                <div class="mail-box">
                    <div class="mail-body">
                        <form class="form-horizontal" method="get">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">发送到：</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" value="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">主题：</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" value="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">分类：</label>
                                <ul class="tag-list" style="padding: 0">
	                                <li><a href="javascript:void(0);"> <i class="fa fa-circle text-navy"></i> 工作</a></li>
	                                <li><a href="javascript:void(0);"> <i class="fa fa-circle text-danger"></i> 文档</a></li>
	                                <li><a href="javascript:void(0);"> <i class="fa fa-circle text-primary"></i> 社交</a></li>
	                                <li><a href="javascript:void(0);"> <i class="fa fa-circle text-info"></i> 广告</a></li>
	                                <li><a href="javascript:void(0);"> <i class="fa fa-circle text-warning"></i> 客户端</a></li>
	                            </ul>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">标签：</label>
                                <ul class="tag-list" style="padding: 0">
	                                <li><a href="javascript:void(0);"><i class="fa fa-tag"></i> 朋友</a></li>
	                                <li><a href="javascript:void(0);"><i class="fa fa-tag"></i> 工作</a></li>
	                                <li><a href="javascript:void(0);"><i class="fa fa-tag"></i> 家庭</a></li>
	                                <li><a href="javascript:void(0);"><i class="fa fa-tag"></i> 孩子</a></li>
	                                <li><a href="javascript:void(0);"><i class="fa fa-tag"></i> 假期</a></li>
	                                <li><a href="javascript:void(0);"><i class="fa fa-tag"></i> 音乐</a></li>
	                                <li><a href="javascript:void(0);"><i class="fa fa-tag"></i> 照片</a></li>
	                                <li><a href="javascript:void(0);"><i class="fa fa-tag"></i> 电影</a></li>
	                            </ul>
                            </div>
                        </form>
                    </div>
                    <div class="mail-text h-200">
                        <div class="summernote"></div>
                    </div>
                    <div class="mail-body text-right tooltip-demo">
                        <a href="javascript:void(0);" onclick="send()" class="btn btn-sm btn-primary" data-toggle="tooltip" data-placement="top" title="Send"><i class="fa fa-reply"></i> 发送</a>
                        <a href="javascript:void(0);" class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="Discard email"><i class="fa fa-times"></i> 放弃</a>
                        <a href="javascript:void(0);" class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="Move to draft folder"><i class="fa fa-pencil"></i> 存为草稿</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/static/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="${pageContext.request.contextPath}/static/js/content.min.js?v=1.0.0"></script>
    <script src="${pageContext.request.contextPath}/static/js/plugins/summernote/summernote.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/plugins/summernote/summernote-zh-CN.js"></script>
    <script>
		$(document).ready(function() {
			$(".summernote").summernote({
				lang : "zh-CN"
			})
		});
		var edit = function() {
			$("#eg").addClass("no-padding");
			$(".click2edit").summernote({
				lang : "zh-CN",
				focus : true
			})
		};
		var save = function() {
			$("#eg").removeClass("no-padding");
			var aHTML = $(".click2edit").code();
			$(".click2edit").destroy()
		};
		function send(){
			alert($(".summernote").summernote('code'));
		}
	</script>
</body>
</html>
