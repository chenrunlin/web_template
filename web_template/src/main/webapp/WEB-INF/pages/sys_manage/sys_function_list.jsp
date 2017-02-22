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
    <link href="${pageContext.request.contextPath}/static/css/plugins/treeview/bootstrap-treeview.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/style.min862f.css?v=4.1.0" rel="stylesheet">
   	<style type="text/css">
		a:link,a:visited {
		 	text-decoration:none;  /*超链接无下划线*/
		}
		
		/* dataTables列内容居中 */
		.dataTables-example>tbody>tr>td{
		        text-align:center;
		}
	</style>
</head>
<body class="gray-bg">
    <div class="row wrapper wrapper-content animated fadeInRight">
    	<div class="row">
	        <div class="col-sm-3">
	            <div class="ibox float-e-margins">
	                <div class="ibox-title">
	                    <h5>默认</h5>
	                    <div class="ibox-tools">
	                        <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
	                    </div>
	                    <h4></h4>
	                </div>
	                <div class="ibox-content">
	                    <div id="treeview" class="test"></div>
	                </div>
	            </div>
	        </div>
	        <div class="col-sm-9">
	            <div class="ibox float-e-margins">
	            	<div class="ibox-title">
                        <h5><a href="${pageContext.request.contextPath}/sysFunction/to_add">添加新功能</a></h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                        </div>
                    </div>
	                <div class="ibox-content">
	                    <table class="table table-striped table-bordered table-hover dataTables-example">
	                        <thead>
	                            <tr>
	                                <th width="2%" style="text-align: center">NO.</th>
									<th width="12%" style="text-align: center">功能名称</th>
									<th width="10%" style="text-align: center">功能URL</th>
									<th width="8%" style="text-align: center">功能等级</th>
									<th width="12%" style="text-align: center">添加时间</th>
									<th width="8%" style="text-align: center">操作</th>
	                            </tr>
	                        </thead>
	                    </table>
	                </div>
	            </div>
        	</div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/static/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="${pageContext.request.contextPath}/static/js/content.min.js?v=1.0.0"></script>
    <script src="${pageContext.request.contextPath}/static/js/plugins/treeview/bootstrap-treeview.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/plugins/dataTables/dataTables.bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/plugins/sweetalert/sweetalert.min.js"></script>
    <%-- <script src="${pageContext.request.contextPath}/static/js/demo/treeview-demo.min.js"></script> --%>
    <script type="text/javascript">
    $(function() {
/*      var e = [ {
    		text : "父节点 1",
    		nodes : [ {
    			text : "子节点 1",
    			nodes : [ {
    				text : "孙子节点 1"
    			}, {
    				text : "孙子节点 2"
    			} ]
    		} ]
    	}];  */
    	
/*      var e = [{
    		"text":"琴岛通在线充值系统", 
    		"nodes":[{
    			"text":"系统管理", 
    			"nodes":[{
    				"text":"功能管理", 
    				"nodes":null
    			}, {
    				"text":"用户管理", 
    				"nodes":null
    			}, {
    				"text":"角色管理", 
    				"nodes":null
    			}]
    		}]
    	}];  */
    	
/*      	var root = '${treeView}';
    	var e = "[" + root + "]"
   
    	$("#treeview").treeview({
    		data : e,
    		onNodeSelected : function(e, o) {
    			initDataList(o.tags);
    		}
    	}); */
    	initTreeView();
    	//初始化样式
		$(".dataTables-example").dataTable();
    	
    });
    
    function initTreeView(){
    	$.ajax({
			url : "${pageContext.request.contextPath}/sysFunction/getSysFunctionTree",
			type : "post",
			success : function(data) {
				var e = "[" + data + "]"
				$("#treeview").treeview({
					data : e,
		    		onNodeSelected : function(e, o) {
		    			initDataList(o.tags);
		    		}
		    	})
			}
		});
    }
    
    function initDataList(id){
    	//绑定查询数据的按钮事件
		$.ajax({
			url : "${pageContext.request.contextPath}/sysFunction/getSysFunctionListById",
			type : "post",
			data : {
				id : id
			},
			dataType : "json",
			success : function(data) {
				$(".dataTables-example").dataTable().fnClearTable();   //将数据清除  
				if(data.length == 0){
				} else {
					var arr = [];
					for(i in data){
					 	var tempArr = new Array();
					    tempArr[0] = Number(i) + 1;
					    tempArr[1] = data[i].f_fun_name;
					    tempArr[2] = data[i].f_fun_url;
					    tempArr[3] = data[i].f_fun_level;
					    tempArr[4] = data[i].f_fun_time;
					    
					    var updateUrl = "${pageContext.request.contextPath}/sysFunction/to_update/" + data[i].id;
					    var updateStr = "<a href='" + updateUrl + "'>修改</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"; 
					    var deleteStr = "<a href='javascript:void(0)' onclick='deleteFunction(\"" + data[i].id + "," + id + "\")'>删除</a>";
					  
					    tempArr[5] = updateStr + deleteStr;
					    arr.push(tempArr);
					}
					$(".dataTables-example").dataTable().fnAddData(arr, true); 
				}
			},
			error : function() {
				alert("error");
			}
		});
    }
    
	function deleteFunction(ids){
		var id =  ids.split(",");
		swal({
			title : "您确定要删除这条信息吗",
			text : "删除后将无法恢复，请谨慎操作！",
			type : "warning",
			showCancelButton : true,
			confirmButtonColor : "#DD6B55",
			confirmButtonText : "删除",
			closeOnConfirm : false
		}, function() {
			$.ajax({
				url:"${pageContext.request.contextPath}/sysFunction/deleteSysFunction",
				type:"get",
				data: {
					id : id[0]
				},
				success:function(data){
					if (data == "success") {
						swal("删除成功！", "您已经永久删除了这条信息。", "success");
						initTreeView();
						initDataList(id[1]); 
					} else {
						swal("删除失败！", "请重新进行删除操作。", "error");
					}
				}
			});
		});
	}
	
    </script>
</body>
</html>
