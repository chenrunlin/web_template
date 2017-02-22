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
	        <div class="col-sm-12">
	            <div class="ibox float-e-margins">
	            	<div class="ibox-title">
                        <h5><a href="${pageContext.request.contextPath}/sysRole/to_add">添加新角色</a></h5>
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
									<th width="12%" style="text-align: center">角色名称</th>
									<th width="10%" style="text-align: center">角色标识</th>
									<th width="8%" style="text-align: center">角色描述</th>
									<th width="12%" style="text-align: center">添加时间</th>
									<th width="12%" style="text-align: center">操作</th>
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
    <script type="text/javascript">
    $(function() {
		$(".dataTables-example").dataTable();
		initDataList();
    });
    
    function initDataList(){
    	//绑定查询数据的按钮事件
		$.ajax({
			url : "${pageContext.request.contextPath}/sysRole/getSysRoleList",
			type : "post",
			dataType : "json",
			success : function(data) {
				$(".dataTables-example").dataTable().fnClearTable();   //将数据清除  
				if(data.length == 0){
				} else {
					var arr = [];
					for(i in data){
					 	var tempArr = new Array();
					    tempArr[0] = Number(i) + 1;
					    tempArr[1] = data[i].r_role_name;
					    tempArr[2] = data[i].r_role_type;
					    tempArr[3] = data[i].r_role_desc;
					    tempArr[4] = data[i].r_role_time;
					    
					    var updateUrl = "${pageContext.request.contextPath}/sysRole/to_update/" + data[i].id;
					    var updateStr = "<a href='" + updateUrl + "'>修改</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"; 
					    var deleteStr = "<a href='javascript:void(0)' onclick='deleteRole(\"" + data[i].id + "\")'>删除</a>";
					    var roleFunUrl = "${pageContext.request.contextPath}/sysRole/to_role_fun/" + data[i].id;
					    var roleFunStr = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='" + roleFunUrl + "'>分配权限</a>"; 
					    
					    tempArr[5] = updateStr + deleteStr + roleFunStr;
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
    
	function deleteRole(id){
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
				url:"${pageContext.request.contextPath}/sysRole/deleteSysRole",
				type:"POST",
				data: {
					id : id
				},
				success:function(data){
					if (data == "success") {
						swal("删除成功！", "您已经永久删除了这条信息。", "success");
						initDataList(); 
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
