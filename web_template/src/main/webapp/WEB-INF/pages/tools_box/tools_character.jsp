<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/style.min862f.css?v=4.1.0" rel="stylesheet">
</head>
<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeIn">
        <div class="row">
            <div class="col-sm-12">
                <div class="tabs-container">
                    <ul class="nav nav-tabs">
                        <li class="active"><a data-toggle="tab" href="#tab-1" aria-expanded="true">UUID</a></li>
                        <li class=""><a data-toggle="tab" href="#tab-2" aria-expanded="true">字符长度</a></li>
                    </ul>
                    <div class="tab-content ">
                        <div id="tab-1" class="tab-pane active">
                            <div class="panel-body">
                            	<table>
								    <tr>
								        <td class="col-sm-8">
								            <textarea spellcheck="false" id="txtSourceUuid" class="form-control " rows="18"></textarea>
								        </td>
								        <td class="col-sm-2">
								        	<p><button id="btnGetUuid" class="btn btn-primary">生成UUID</button></p>
								        </td>
								    </tr>
								</table>
                            </div>
                        </div>
                        <div id="tab-2" class="tab-pane">
                            <div class="panel-body">
                            	<textarea spellcheck="false" id="txtSourceLen" class="form-control " rows="12">hello world!世界</textarea>
								<p class="mt15">
								    <div class="alert alert-warning alert-dismissible compress-tip" role="alert">压缩比：100%</div>
								    <div class="alert alert-warning alert-dismissible length-tip" role="alert" style="display: none;"></div>
								    <span id="btnGetLen" class="btn btn-primary">计算</span>
								</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/static/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="${pageContext.request.contextPath}/static/js/content.min.js?v=1.0.0"></script>
    <script src="${pageContext.request.contextPath}/static/js/tools_normal.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/tools_simple.js"></script>
</body>
</html>
