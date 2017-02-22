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
                    	<li class="active"><a data-toggle="tab" href="#tab-1" aria-expanded="true">本地IP</a></li>
                        <li class=""><a data-toggle="tab" href="#tab-2" aria-expanded="true">json格式化</a></li>
                        <li class=""><a data-toggle="tab" href="#tab-3" aria-expanded="true">正则测试</a></li>
                        <li class=""><a data-toggle="tab" href="#tab-4" aria-expanded="true">进制换算</a></li>
                        <li class=""><a data-toggle="tab" href="#tab-5" aria-expanded="true">时间换算</a></li>
                        <li class=""><a data-toggle="tab" href="#tab-6" aria-expanded="true">Unix时间戳</a></li>
                        <li class=""><a data-toggle="tab" href="#tab-7" aria-expanded="true">MD5</a></li>
                    </ul>
                    <div class="error-container">
					    <div id="errorDiv" class="alert alert-danger alert-dismissible" role="alert" style="display:none;">
					        错误：解码错误
					    </div>
					</div>
                    <div class="tab-content">
                        <div id="tab-1" class="tab-pane active">
                            <div class="panel-body">
                            	<table class="table table-hover table-bordered">
								    <tbody>
								        <tr>
								            <td style="width:150px;">本机IP</td>
								            <td>113.139.188.235</td>
								        </tr>
								        <tr>
								            <td>用户代理</td>
								            <td>Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.87 Safari/537.36</td>
								        </tr>
								        <tr>
								            <td>浏览器类型</td>
								            <td>Chrome</td>
								        </tr>
								        <tr>
								            <td>浏览器版本</td>
								            <td>54.0</td>
								        </tr>
								        <tr>
								            <td>浏览器语言</td>
								            <td>zh-CN, zh;q=0.8</td>
								        </tr>
								        <tr>
								            <td>分辨率</td>
								            <td id="tdRatio"></td>
								        </tr>
								        <tr>
								            <td>操作系统</td>
								            <td>Windows 10</td>
								        </tr>
								    </tbody>
								</table>
                            </div>
                        </div>
                        
                        <div id="tab-2" class="tab-pane">
                            <div class="panel-body">
                            	<table>
								    <tr>
								        <td class="col-sm-5">
								            <textarea id="txtSourceJson" spellcheck="false" class="form-control " rows="18"> {&quot;name&quot;:&quot;王小二&quot;,&quot;age&quot;:15,&quot;address&quot;:{&quot;province&quot;:&quot;浙江&quot;,&quot;city&quot;:&quot;杭州&quot;,&quot;district&quot;:&quot;西湖区&quot;},&quot;hobby&quot;:[&quot;足球&quot;,&quot;棒球&quot;,&quot;乒乓球&quot;]}
											</textarea>
								        </td>
								        <td class="col-sm-1">
								            <p><button id="btnJson" class="btn btn-primary">格式化 &gt;</button></p>
								            <p><button id="btnCopyJson" class="btn btn-default">复制结果</button></p>
								        </td>
								        <td class="col-sm-5">
								            <textarea id="txtDestJson" spellcheck="false" class="form-control" rows="18"></textarea>
								        </td>
								    </tr>
								</table>
                            </div>
                        </div>
                        <div id="tab-3" class="tab-pane">
                            <div class="panel-body">
                            	<table class="col-sm-12">
								    <tr>
								        <td class="col-sm-5">
								            <table class="col-sm-12">
								                <tr>
								                    <td>
								                        <textarea id="txtRegexPattern" spellcheck="false" class="form-control" rows="2" placeholder="请填写正则">\w+?(\d+)\w+?([\u4e00-\u9fa5]+)</textarea>
								                    </td>
								                </tr>
								                <tr><td>&nbsp;&nbsp;</td></tr>
								                <tr>
								                    <td>
								                        <textarea id="txtRegexContent" spellcheck="false" class="form-control" rows="15" placeholder="请填写内容">hello123world世界</textarea>
								                    </td>
								                </tr>
								                <tr>
								                    <td>
								                        <input id="chkIgnoreCase" type="checkbox" checked="checked">
								                        <label for="chkIgnoreCase" class="lblNormal">忽略大小写</label>
								                    </td>
								                </tr>
								            </table>
								        </td>
								        <td class="col-sm-1">
								            <p><button id="btnRegexMatch" class="btn btn-primary">执行 &gt;</button></p>
								        </td>
								        <td class="col-sm-5" valign="top">
								            <table class="col-sm-12">
								                <tr>
								                    <td><textarea id="txtRegexTip" spellcheck="false" class="form-control" rows="2" disabled="disabled"></textarea></td>
								                </tr>
								                <tr><td>&nbsp;&nbsp;</td></tr>
								                <tr>
								                    <td>
								                        <textarea spellcheck="false" id="txtRegexResult" class="form-control" rows="15" placeholder="匹配结果"></textarea>
								                    </td>
								                </tr>
								                <tr>
								                    <td></td>
								                </tr>
								            </table>
								        </td>
								    </tr>
								</table>
                            </div>
                        </div>
                        <div id="tab-4" class="tab-pane">
                            <div class="panel-body">
                            	<div class="input-group m-b">
                            		<span class="input-group-btn"> <button type="button" class="btn btn-primary">十进制</button> </span>
                                    <input type="text" id="txt10" class="form-control" value="1024">
                                    <span class="input-group-btn"> <button type="button" data-val="10" class="btn btn-primary btnCal">计算</button> </span>
                                </div>
                                <div class="input-group m-b">
                            		<span class="input-group-btn"> <button type="button" class="btn btn-primary">二进制</button> </span>
                                    <input type="text" id="txt2" class="form-control">
                                    <span class="input-group-btn"> <button type="button" data-val="2" class="btn btn-primary btnCal">计算</button> </span>
                                </div>
                                <div class="input-group m-b">
                            		<span class="input-group-btn"> <button type="button" class="btn btn-primary">八进制</button> </span>
                                    <input type="text" id="txt8" class="form-control">
                                    <span class="input-group-btn"> <button type="button" data-val="8" class="btn btn-primary btnCal">计算</button> </span>
                                </div>
                                <div class="input-group m-b">
                            		<span class="input-group-btn"> <button type="button" class="btn btn-primary">十六进制</button> </span>
                                    <input type="text" id="txt16" class="form-control">
                                    <span class="input-group-btn"> <button type="button" data-val="16" class="btn btn-primary btnCal">计算</button> </span>
                                </div>
                            </div>
                        </div>
                        <div id="tab-5" class="tab-pane">
                            <div class="panel-body">
                            	<div class="input-group m-b">
                            		<span class="input-group-btn"> <button type="button" class="btn btn-primary">天</button> </span>
                                    <input type="text" id="txtDay" class="form-control">
                                    <span class="input-group-btn"> <button type="button" data-val="day" class="btn btn-primary btnCalTime">计算</button> </span>
                                </div>
                                <div class="input-group m-b">
                            		<span class="input-group-btn"> <button type="button" class="btn btn-primary">时</button> </span>
                                    <input type="text" id="txtHour" class="form-control">
                                    <span class="input-group-btn"> <button type="button" data-val="hour" class="btn btn-primary btnCalTime">计算</button> </span>
                                </div>
                                <div class="input-group m-b">
                            		<span class="input-group-btn"> <button type="button" class="btn btn-primary">分</button> </span>
                                    <input type="text" id="txtMinute" class="form-control">
                                    <span class="input-group-btn"> <button type="button" data-val="minute" class="btn btn-primary btnCalTime">计算</button> </span>
                                </div>
                                <div class="input-group m-b">
                            		<span class="input-group-btn"> <button type="button" class="btn btn-primary">秒</button> </span>
                                    <input type="text" id="txtSecond" class="form-control">
                                    <span class="input-group-btn"> <button type="button" data-val="second" class="btn btn-primary btnCalTime">计算</button> </span>
                                </div>
                                <div class="input-group m-b">
                            		<span class="input-group-btn"> <button type="button" class="btn btn-primary">毫秒</button> </span>
                                    <input type="text" id="txtMillisecond" class="form-control">
                                    <span class="input-group-btn"> <button type="button" data-val="millisecond" class="btn btn-primary btnCalTime">计算</button> </span>
                                </div>
                                <div class="input-group m-b">
                            		<span class="input-group-btn"> <button type="button" class="btn btn-primary clearAll">清除</button> </span>
                                </div>
                            </div>
                        </div>
                        <div id="tab-6" class="tab-pane">
                            <div class="panel-body">
                            	<div class="input-group m-b">
                            		<span class="input-group-btn"> <button type="button" class="btn btn-outline btn-default">原日期</button> </span>
                                    <input type="text" id="txtSourceUnix" class="form-control" value="2017-02-14 14:23:45" onclick="WdatePicker({ dateFmt: 'yyyy-MM-dd HH:mm:ss' })">
                                    <span class="input-group-btn"> <button type="button" id="btnTransUnix" data-val="10" class="btn btn-primary btnCal">转时间戳</button> </span>
                                </div>
                                <div class="input-group m-b">
                            		<span class="input-group-btn"> <button type="button" class="btn btn-outline btn-default">时间戳</button> </span>
                                    <input type="text" id="txtDestUnix" class="form-control">
                                    <span class="input-group-btn"> <button type="button" id="btnTransDate" data-val="2" class="btn btn-primary btnCal">转原日期</button> </span>
                                </div>
                            </div>
                        </div>
                        <div id="tab-7" class="tab-pane">
                            <div class="panel-body">
                            	<table>
								    <tr>
								        <td class="col-sm-5">
								            <textarea spellcheck="false" id="txtSourceMd5" class="form-control " rows="18">123456</textarea>
								        </td>
								        <td class="col-sm-1">
								        	<p><input id="rad16" type="radio" name="radHalf" /><label class="lblNormal" for="rad16">16位</label></p>
            								<p><input id="rad32" type="radio" name="radHalf" checked="checked" /><label class="lblNormal" for="rad32">32位</label></p>
								            <p><button id="btnMd5" class="btn btn-primary">MD5 &gt;</button></p>
								        </td>
								        <td class="col-sm-5">
								            <textarea spellcheck="false" id="txtDestMd5" class="form-control" rows="18"></textarea>
								        </td>
								    </tr>
								</table>
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
    <script type="text/javascript">
	    $(function () {
	    	//分辨率
	        $("#tdRatio").html(window.screen.width + " * " + window.screen.height);
	    	
	        $(".clearAll").bind("click",function(){
	        	$("#txtDay").val("");
	        	$("#txtHour").val("");
	        	$("#txtMinute").val("");
	        	$("#txtSecond").val("");
	        	$("#txtMillisecond").val("");
	        })
	    })
	</script>
</body>
</html>
