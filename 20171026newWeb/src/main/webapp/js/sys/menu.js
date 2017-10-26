$(function () {
    $("#jqGrid").jqGrid({
        url: host + "/sys/menu/queryPageList.do",
        datatype: "json",
        xhrFields : {
            withCredentials : true
        },
        crossDomain : true,
        colModel: [			
			{ label: '菜单ID', name: 'id', index: "id", width: 40, key: true },
			{ label: '菜单名称', name: 'name', width: 60 },
			{ label: '上级菜单', name: 'parentName', sortable: false, width: 60 },
			{ label: '菜单图标', name: 'icon', sortable: false, width: 50, formatter: function(value, options, row){
				return value == null ? '' : '<i class="'+value+' fa-lg"></i>';
			}},
			{ label: '菜单URL', name: 'url', width: 100 },
			{ label: '授权标识', name: 'perms', width: 100 },
			{ label: '类型', name: 'type', width: 50, formatter: function(value, options, row){
				if(value === 0){
					return '<span class="label label-primary">目录</span>';
				}
				if(value === 1){
					return '<span class="label label-success">菜单</span>';
				}
				if(value === 2){
					return '<span class="label label-warning">按钮</span>';
				}
			}},
			{ label: '排序号', name: 'orderNum', index: "order_num", width: 50}
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
            order: "orderNum"
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
			idKey: "id",
			pIdKey: "parentId",
			rootPId: -1
		},
		key: {
			url:"nourl",
            children: "childMenus"
		}
	}
};
var ztree;
var host="http://api.laison.com:8080";
var vm = new Vue({
	el:'#rrMenu',
	data:{
		showList: true,
		title: "",
		menu:{
			parentName:null,
			parentId:"0",
			type:0,
			orderNum:0
		}
	},
	methods: {
		getMenu: function(menuId){
			//加载菜单树
			$.get("http://api.laison.com:8080/sys/menu/findAllMenus.do", function(r){
				ztree = $.fn.zTree.init($("#menuTree"), setting, r.menu);
				var node = ztree.getNodeByParam("id", vm.menu.parentId);
				ztree.selectNode(node);
				vm.menu.parentName = node.name;
                vm.menu.parentId = node.id;
			})
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.menu = {parentName:null,parentId:0,type:1,orderNum:0};
			vm.getMenu();
		},
		update: function (event) {
			var menuId = getSelectedRow();
			if(menuId == null){
				return ;
			}

			$.get("../sys/menu/info.do?id="+menuId, function(r){
				vm.showList = false;
                vm.title = "修改";

                vm.menu = r.menu;
                
                vm.getMenu();
            });
		},
		del: function (event) {
			var menuIds = getSelectedRows();
            var delMenu ={};
            if(menuIds != null){
				delMenu.id=menuIds[0];
			}
            if(menuIds.length > 1){
                alert("只能选择一条记录");
                return ;
            }

			
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../sys/menu/delMenu.do",
                    contentType: "application/json",
				    data: JSON.stringify(delMenu),
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
			});
		},
		saveOrUpdate: function (event) {
			var url = vm.menu.id == null ? "../sys/menu/add.do" : "../sys/menu/update.do";
			$.ajax({
				type: "POST",
			    url: url,
                contentType: "application/json",
			    data: JSON.stringify(vm.menu),
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
		menuTree: function(){
			layer.open({
				type: 1,
				offset: '50px',
				skin: 'layui-layer-molv',
				title: "选择菜单",
				area: ['300px', '450px'],
				shade: 0,
				shadeClose: false,
				content: jQuery("#menuLayer"),
				btn: ['确定', '取消'],
				btn1: function (index) {
					var node = ztree.getSelectedNodes();
					//选择上级菜单
					vm.menu.parentId = node[0].id;
					vm.menu.parentName = node[0].name;
					
					layer.close(index);
	            }
			});
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});