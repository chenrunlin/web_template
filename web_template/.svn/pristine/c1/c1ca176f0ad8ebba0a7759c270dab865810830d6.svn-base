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
                        <li class="active"><a data-toggle="tab" href="#tab-1" aria-expanded="true">二维码生成</a></li>
                        <li class=""><a data-toggle="tab" href="#tab-2" aria-expanded="true">二维码识别</a></li>
                    </ul>
                    <div class="tab-content">
                        <div id="tab-1" class="tab-pane active">
                            <table class="col-sm-12">
							    <tr>
							        <td class="col-sm-8">
							            <table class="col-sm-12">
							                <tr>
							                    <td>内容：</td>
							                    <td>
							                        <textarea spellcheck="false" id="selText" class="form-control" rows="3">http://www.ofmonkey.com</textarea>
							                    </td>
							                </tr>
							                <tr><td>&nbsp;&nbsp;</td></tr>
							                <tr>
							                    <td>纠错：</td>
							                    <td>
							                        <select id="selLevel" class="form-control">
							                            <option value="L">L 7%</option>
							                            <option value="M">M 15%</option>
							                            <option value="Q">Q 25%</option>
							                            <option value="H">H 30%</option>
							                        </select>
							                    </td>
							                </tr>
							                <tr><td>&nbsp;&nbsp;</td></tr>
							                <tr>
							                    <td>尺寸：</td>
							                    <td>
							                        <input id="txtScale" type="text" class="form-control" value="150" placeholder="最大不能超过800像素" />
							                    </td>
							                </tr>
							                <tr><td>&nbsp;&nbsp;</td></tr>
							                <tr>
							                    <td>边距：</td>
							                    <td>
							                        <select id="selMargin" class="form-control">
					                                    <option selected="selected">0</option>
					                                    <option>1</option>
					                                    <option>2</option>
							                        </select>
							                    </td>
							                </tr>
							                <tr><td>&nbsp;&nbsp;</td></tr>
							                <tr>
							                    <td></td>
							                    <td>
							                        <input id="chkTrans" type="checkbox" />
							                        <label for="chkTrans" class="lblNormal">背景透明</label>
							                    </td>
							                </tr>
							            </table>
							        </td>
							        <td class="col-sm-1">
							            <p><button id="btnErcode" class="btn btn-primary">生成 &gt;</button></p>
							        </td>
							        <td class="col-sm-3">
							            <img id="imgPreview" class="img-thumbnail" src="${pageContext.request.contextPath}/static/img/qr/qr_code.png" style="max-width:150px;max-height:150px;" />
							            <p class="mt15">
							                [ 请右击图片另存为... ]
							            </p>
							        </td>
							    </tr>
							</table>
                        </div>
                        <div id="tab-2" class="tab-pane">
                            <div class="panel-body">
                            	努力开发中
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
    // 二维码
    $("#btnErcode").click(function () {
        var text = $("#selText").val();
        var level = $("#selLevel").val();
        var scale = $("#txtScale").val();
        var margin = $("#selMargin").val();
        var isTrans = $("#chkTrans").is(":checked");
        if (text == "") {
            error("请填写内容");
        }
        else {
            /* var url = "";
            url = encodeURI(url);
            callApi(url, { "text": text, "level": level, "scale": scale, "margin": margin, "isTrans": isTrans}, function (slt) {
            	$("#imgPreview").attr("src", slt);
            }); */
           $.ajax({
    			url : "${pageContext.request.contextPath}/tools/create_qrcode",
    			type:"POST",
				data: {
					text : text,
					level : level,
					scale : scale,
					margin : margin,
					isTrans : isTrans
				},
    			success:function(data){
    				$("#imgPreview").attr("src", "${pageContext.request.contextPath}/" + data);
    			}
    		});
        }
    });

    </script>
</body>
</html>
