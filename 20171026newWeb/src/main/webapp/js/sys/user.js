$(function () {
    $("#jqGrid").jqGrid({
        url: '../sys/user/listByPage.do',
        datatype: "json",
        colModel: [			
			{ label: '用户ID', name: 'id', index: "id", key: true ,hidedlg:true,hidden:true },
			{ label: '用户名', name: 'loginName', width: 75 },
            { label: '用户类型', name: 'userType', width: 20, formatter: function(value, options, row){
                if(value == 0){
                    return '<span class="label label-primary">其他</span>';
                }
                if(value == 1){
                    return '<span class="label label-success">管理</span>';
                }
                if(value == 2){
                    return '<span class="label label-warning">业务</span>';
                }
            }},

			{ label: '邮箱', name: 'email', width: 90 },
			{ label: '手机号', name: 'mobile', width: 50 },
			{ label: '信用额度', name: 'creditLimit', width: 30 },
            { label: '所属站点', name: 'stationName', width: 90 },
            { label: '角色', name: 'roleName', width: 90 },
			{ label: '状态', name: 'state', width: 20, formatter: function(value, options, row){
                if(value == 0){
                    return '<span class="label label-primary" @click="changeState(id,1)">禁用</span>';
                }
                if(value == 1){
                    return '<span class="label label-success" @click="changeState(id,0)">启用</span>';
                }
                if(value == 2){
                    return '<span class="label label-warning" @click="changeState(2)">系统</span>';
                }
			}},
			{ label: '创建时间', name: 'createDate', width: 80}
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

var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			username: null
		},
		isUpdate:false,
        disabled:"false",
		showList: true,
		title:null,
		roleList:{},
		user:{
			state:"1",
			role:{
				id:0
			}
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
        addAdmin: function(){
			vm.showList = false;
			vm.title = "新增管理员";
			vm.roleList = {};
            vm.disabled=false,
			vm.user = {
				state:"1",
				role:{
					id:0
				},
				userType:1
			};
			
			//获取角色信息
			this.getRoleList("1");
		},
        addOperator: function(){
            vm.showList = false;
            vm.title = "新增操作员";
            vm.roleList = {};
            vm.disabled=false,
            vm.user = {
    				state:"1",
    				role:{
    					id:0
    				},
    				userType:2
    			};
            //获取角色信息
            this.getRoleList("2");
        },
		update: function () {
			var userId = getSelectedRow();
			if(userId == null){
				return ;
			}
			
			vm.showList = false;
            vm.title = "修改";
			vm.isUpdate=true;
            vm.disabled="disabled",
			vm.getUser(userId);
			//获取角色信息
			this.getRoleList(vm.user.userType);
		},
		del: function () {
			var userId = getSelectedRow();
			if(userId == null){
				return ;
			}
            delUser={"id":userId};
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../sys/user/del.do",
                    contentType: "application/x-www-form-urlencoded",
				    data: delUser,
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
		saveOrUpdate: function (event) {
			var url = vm.user.id == null ? (vm.user.userType==2?"../sys/user/addOperator.do":"../sys/user/addAdmin.do") : "../sys/user/update.do";
			$.ajax({
				type: "POST",
			    url: url,
                contentType: "application/json",
			    data: JSON.stringify(vm.user),
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
		getUser: function(userId){

            $.ajax({
                async: false,
                type : "GET",
                url : "../sys/user/info.do?id="+userId,
                dataType : 'json',
                success : function(r) {
                    vm.user = r.user;
                }
            });

		},

		getRoleList: function(userType){
            $.ajax({
                async: false,
                type : "GET",
                url : "../sys/role/list.do?roleType="+userType,
                dataType : 'json',
                success : function(r) {
                    vm.roleList = r.list;
                }
            });


		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                postData:{'username': vm.q.username},
                page:page
            }).trigger("reloadGrid");
		}
	}
});