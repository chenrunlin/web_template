<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
	<title>管理后台模板</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${pageContext.request.contextPath}/static/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/zTreeStyle/metro.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
</head>
<body>

	<input type="text" id="id" name="id" hidden="hidden" value="${sys_role.id}" />
    <ul id="tree" class="ztree" style="width:560px; overflow:auto;"></ul>
    <button class="btn btn-primary" type="button"><i class="fa fa-check"></i>&nbsp;提交</button>
    <button class="btn btn-success" type="button"><i class="fa fa-upload"></i>&nbsp;返回</button>
    
	<script src="${pageContext.request.contextPath}/static/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="${pageContext.request.contextPath}/static/js/content.min.js?v=1.0.0"></script>
    <script src="${pageContext.request.contextPath}/static/js/ztree/jquery-1.4.4.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/ztree/jquery.ztree.all-3.5.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/plugins/sweetalert/sweetalert.min.js"></script>
    <script type="text/javascript">
    var setting = {
            check: {
                enable: true
            },
            view: {
                showLine: true,
                selectedMulti: false
            },
            data: {
                simpleData: {
                    enable:true
                }
            }
        };
/*         var zNodes =[
            {id:1, pId:0, name:"[core] 基本功能 演示", open:true},
            {id:101, pId:1, name:"最简单的树 --  标准 JSON 数据", file:"core/standardData", checked:true},
            {id:102, pId:1, name:"最简单的树 --  简单 JSON 数据", file:"core/simpleData", checked:true},
            {id:2, pId:0, name:"[excheck] 复/单选框功能 演示", open:true},
            {id:201, pId:2, name:"Checkbox 勾选操作", file:"excheck/checkbox"},
            {id:206, pId:2, name:"Checkbox nocheck 演示", file:"excheck/checkbox_nocheck"},
        ];  */
        
        var zNodes = new Array();
    	var list = '${treeList}';
    	var obj = eval('(' + list + ')');
    	for(var i = 0; i< obj.length; i++ ){
    		var tree = obj[i];
    		zNodes.push({ id : tree.id, pId : tree.pId, name : tree.name, open : tree.open, checked : tree.checked});
    	} 

        $(document).ready(function(){
            $.fn.zTree.init($("#tree"), setting, zNodes);
            //保存角色功能
            addRoleFun();
        });
        
        function addRoleFun(){
        	$(".btn-primary").click(function (event) {
        		var tree = $.fn.zTree.getZTreeObj("tree");
        		var checkedNodes = tree.getCheckedNodes(true);
        		var roleId = $("#id").val(); 
        		var funIds = "";
        		for(var i = 0; i < checkedNodes.length; i++){
        			if(checkedNodes[i].level == 1){
        				funIds += checkedNodes[i].id + ";";
        			}
        		};
        		funIds = funIds.substring(0, funIds.length-1); 
        		$.ajax({
    				url:"${pageContext.request.contextPath}/sysRole/updateRoleFun",
    				type:"POST",
    				data: {
    					id : roleId,
    					funIds : funIds
    				},
    				success:function(data){
    					swal({
							  title: "保存成功！",
							  type: "success",
							  showCancelButton: false,
							  confirmButtonColor: "#7EC0EE",
							  confirmButtonText: "关闭",
							  closeOnConfirm: false
						},
						function(){
							window.location.href = "${pageContext.request.contextPath}/sysRole/to_list";
						});
    				}
    			});
        	});
			$(".btn-success").click(function (event) {
				window.location.href = "${pageContext.request.contextPath}/sysRole/to_list";
        	});
        }
    </script>
</body>
</html>