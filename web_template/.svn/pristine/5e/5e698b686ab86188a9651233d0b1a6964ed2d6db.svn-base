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
                    	<li class="active"><a data-toggle="tab" href="#tab-1" aria-expanded="true">js/html格式化</a></li>
                        <li class=""><a data-toggle="tab" href="#tab-2" aria-expanded="true">css格式化</a></li>
                        <li class=""><a data-toggle="tab" href="#tab-3" aria-expanded="true">json格式化</a></li>
                        <li class=""><a data-toggle="tab" href="#tab-4" aria-expanded="true">xml格式化</a></li>
                        <li class=""><a data-toggle="tab" href="#tab-5" aria-expanded="true">sql格式化</a></li>
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
								    <textarea spellcheck="false" id="html_text" class="form-control" rows="18">function filterFilter(){return function(array,expression,comparator){if(!isArrayLike(array)){if(array==null){return array}else{throw minErr('filter')('notarray','Expected array but received: {0}',array);}}var expressionType=getTypeForFilter(expression);var predicateFn;var matchAgainstAnyProp;switch(expressionType){case'function':predicateFn=expression;break;case'boolean':case'null':case'number':case'string':matchAgainstAnyProp=true;case'object':predicateFn=createPredicateFn(expression,comparator,matchAgainstAnyProp);break;default:return array}return Array.prototype.filter.call(array,predicateFn)}}</textarea>
									<p class="mt15">
									    <button id="beautify" class="btn btn-primary">格式化</button>
									    <button id="htmljsmin" class="btn btn-primary">压缩</button>  
								    </p>
								</table>
                            </div>
                        </div>
                        
                        <div id="tab-2" class="tab-pane">
                            <div class="panel-body">
                            	<table>
								   <textarea spellcheck="false" id="css_text" class="form-control" rows="18">.pagination {display: inline-block;padding-left: 0;margin: 20px 0;border-radius: 4px;}.pagination li {display: inline;}</textarea>
									<p class="mt15">
									    <button class="btn btn-primary" onclick="$('#css_text').format({method: 'css'})">多行</button>
									    <button class="btn btn-primary" onclick="$('#css_text').format({method: 'cssone'})">单行</button>
									    <button class="btn btn-primary" onclick="$('#css_text').format({method: 'cssmin'})">压缩</button>      
									</p>
								</table>
                            </div>
                        </div>
                        <div id="tab-3" class="tab-pane">
                            <div class="panel-body">
                            	<table class="col-sm-12">
								    <textarea spellcheck="false" id="json_text" class="form-control" rows="18"> {"name":"王小二","age":15,"address":{"province":"浙江","city":"杭州","district":"西湖区"},"hobby":["足球","棒球","乒乓球"]}</textarea>
									<p class="mt15">
									    <button class="btn btn-primary" onclick="$('#json_text').format({method: 'json'})">格式化</button>
									    <button class="btn btn-primary" onclick="$('#json_text').format({ method: 'jsonmin'})">压缩</button>
									</p>
								</table>
                            </div>
                        </div>
                        <div id="tab-4" class="tab-pane">
                            <div class="panel-body">
                            	<textarea spellcheck="false" id="xml_text" class="form-control" rows="18">&lt;note&gt;
&lt;to copy=&quot;true&quot;&gt;George&lt;/to&gt;
&lt;from&gt;John&lt;/from&gt;
&lt;heading&gt;Reminder&lt;/heading&gt;
&lt;body&gt;Don't forget the meeting!&lt;/body&gt;
&lt;/note&gt;</textarea>
								<p class="mt15">
								    <button class="btn btn-primary" onclick="$('#xml_text').format({ method: 'xml' })">格式化</button>
								    <button class="btn btn-primary" onclick="$('#xml_text').format({ method: 'xmlmin' })">压缩</button>
								</p>
                            </div>
                        </div>
                        <div id="tab-5" class="tab-pane">
                            <div class="panel-body">
                            	<textarea spellcheck="false" id="sql_text" class="form-control" rows="18">select id,name from user where type=1 order by id desc</textarea>
								<p class="mt15">
								    <button class="btn btn-primary" onclick="$('#sql_text').format({ method: 'sql' })">格式化</button>
								    <button class="btn btn-primary" onclick="$('#sql_text').format({ method: 'sqlmin' })">压缩</button>
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
    <!--代码格式化-->
    <script src="${pageContext.request.contextPath}/static/js/jquery-extend.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/tools_base.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/tools_jsformat.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/tools_htmlformat.js"></script>
</body>
</html>
