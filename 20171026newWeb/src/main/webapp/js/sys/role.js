$(function () {
    $("#jqGrid").jqGrid({
        url: '../sys/role/listBypage.do',
        datatype: "json",
        colModel: [			
			{ label: '角色ID', name: 'id', index: "role_id", width: 45, key: true ,hidedlg:true,hidden:true},
			{ label: '角色名称', name: 'name', index: "role_name", width: 75 },
			{ label: '备注', name: 'remarks', width: 100 },
			{ label: '创建时间', name: 'createDate', width: 80},
            { label: '角色类型', name: 'roleType', width: 50, formatter: function(value, options, row){
            	 	if(value == 0){
	                    return '<span class="label label-primary">其他</span>';
	                }
	                if(value == 1){
	                    return '<span class="label label-success">管理</span>';
	                }
	                if(value == 2){
	                    return '<span class="label label-warning">业务</span>';
	                }
            }}
			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "pageInfo.list",
            page: "pageInfo.pageNum",
            total: "pageInfo.pages",
            records: "pageInfo.total"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var setting = {
	data: {
		simpleData: {
			enable: true,
			idKey: "menuId",
			pIdKey: "parentId",
			rootPId: -1
		},
		key: {
			url:"nourl",
            children:"childMenus"
		}
	},
	check:{
		enable:true,
		nocheckInherit:true
	}
};
var ztree;
	
var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			roleName: null
		},
		showList: true,
		title:null,
		role:{}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.role = {};
            vm.role.roleType=2;
			vm.getMenuTree(null);
		},
		update: function () {
			var roleId = getSelectedRow();
			if(roleId == null){
				return ;
			}
			vm.getRole(roleId);
            var roleTypeOption = $("#roleTypeOption");
           
            roleTypeOption.attr("disabled","disabled");
			vm.showList = false;
            vm.title = "修改";
            vm.getMenuTree(roleId);
		},
		del: function (event) {
			var roleIds = getSelectedRows();
            var delRole ={};
			if(roleIds == null){
				return ;
			}else{
                if(roleIds.length > 1){
                    alert("只能选择一条记录");
                    return ;
                }
                delRole={"roleId":roleIds[0]};
			}
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../sys/role/delete.do?",
                    contentType: "application/x-www-form-urlencoded",
				    data: delRole,
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								vm.reload();
							});
						}else{
							alert(r.errors);
						}
					}
				});
			});
		},
		getRole: function(roleId){

            $.ajax({
                async: false,
                type : "GET",
                url : "../sys/role/info.do?id="+roleId,
                dataType : 'json',
                success : function(r) {
                    vm.role = r.role;
                }
            });

		},
		saveOrUpdate: function (event) {
			//获取选择的菜单
			var nodes = ztree.getCheckedNodes(true);
			var menuIdList = new Array();
			for(var i=0; i<nodes.length; i++) {
				menuIdList.push(nodes[i].id);
			}
			vm.role.menuIdList = menuIdList;
			
			var url = vm.role.id == null ? "../sys/role/save.do" : "../sys/role/update.do";
			$.ajax({
				type: "POST",
			    url: url,
                contentType: "application/json",
			    data: JSON.stringify(vm.role),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.errors);
					}
				}
			});
		},
		getMenuTree: function(roleId) {
			//加载菜单树
            $.ajax({
                async: false,
                type : "GET",
                url : vm.role.roleType =='2' ?"../getMyBusinessMenu.do":"../getMyAllMenu.do",
                dataType : 'json',
                success : function(r) {
                    ztree = $.fn.zTree.init($("#menuTree"), setting, r.menu);
                    //展开所有节点
                    ztree.expandAll(true);
                    //勾选角色所拥有的菜单
                    var menuIds = vm.role.menuIdList;
                    for(var i=0; i<menuIds.length; i++) {
                        var node = ztree.getNodeByParam("id", menuIds[i]);
                        ztree.checkNode(node, true, false);
                    }
                }
            });

	    },
	    reload: function (event) {
	    	vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                postData:{'roleName': vm.q.roleName},
                page:page
            }).trigger("reloadGrid");
		}
	}
});