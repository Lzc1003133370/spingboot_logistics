	//config的设置是全局的
	layui.config({
		base: '../picker/'
		// 假设这是你存放拓展模块的根目录
	}).extend({ // 设定模块别名
		common: 'common' // 如果 common.js 是在根目录，也可以不用设定别名
	});
	var title = "";
	var url = "";
	var $;
	var layer;
	layui.use([ 'jquery', 'table', 'layer', 'form', 'laydate' ,'common'],
			function() {
			var common = layui.common,
			form = layui.form;
			// do something...
			// 三级地址联动
			common.showCity('province', 'city', 'district');
				// 加载layui模块，使用其推荐的【预先加载】方式，详见官网【模块规范】一节
				$ = layui.$;
				var table = layui.table;
				layer = layui.layer;
				var form = layui.form;
				var laydate = layui.laydate;
				// 记录选中的数据:做缓存使用,作为参数传递给后台
		        var ids = new Array();
		        // 当前表格中的全部数据:在表格的checkbox全选的时候没有得到数据, 因此用全局存放变量
		        var table_data=new Array();
				// 显示所有会员
				table.render({
					limit:'14',
					elem : '#member-tab',
					height : 'full-73',
					url : '/member/queryByPage',
					method : 'post',
					toolbar : '#toolbarDemo', // 开启头部工具栏，并为其绑定左侧模板
					defaultToolbar : [ 'filter', 'exports', 'print', { // 自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
						title : '提示',
						layEvent : 'LAYTABLE_TIPS',
						icon : 'layui-icon-tips'
					} ],
					title : '用户数据表',
					cols : [ [ {
						type : 'checkbox'
					}, {
						field : 'memberUsername',
						title : '用户名',
						edit : 'text',
					}, {
						field : 'memberName',
						title : '姓名'
					}, {
						field : 'memberPhone',
						title : '联系方式'
					}, {
						field : 'memberAddress',
						title : '地址'
					}, {
						fixed : 'right',
						title : '操作',
						toolbar : '#barDemo',
						width : 150
					} ] ],
					page : true,
					// 表格容器id，用于表格重载
					id : 'member-tab',
					done: function (res, curr, count) {
						// 数据表格加载完成时调用此函数
		                // 如果是异步请求数据方式，res即为你接口返回的信息。
		                // 如果是直接赋值的方式，res即为：{data: [], count: 99}
						// data为当前页数据、count为数据总长度
		                if (res.count == 0) {// 没有查询到数据隐藏分页栏
		                    $(".layui-none").hide();// 隐藏无数据
		                    $(".layui-table-page").hide();// 隐藏分页
		                }else{
		                	//设置全部数据到全局变量
		                    table_data=res.data;
		 
		                    //在缓存中找到id ,然后设置data表格中的选中状态
		                    //循环所有数据，找出对应关系，设置checkbox选中状态
		                    for(var i=0;i< res.data.length;i++){
		                        for (var j = 0; j < ids.length; j++) {
		                            //数据id和要勾选的id相同时checkbox选中
		                            if(res.data[i].memberId == ids[j]){
		                                //这里才是真正的有效勾选
		                                res.data[i]["LAY_CHECKED"]='true';
		                                //找到对应数据改变勾选样式，呈现出选中效果
		                                var index= res.data[i]['LAY_TABLE_INDEX'];
		                                $('.layui-table tr[data-index=' + index + '] input[type="checkbox"]').prop('checked', true);
		                                $('.layui-table tr[data-index=' + index + '] input[type="checkbox"]').next().addClass('layui-form-checked');
		                            }
		                        }
		                    }
		                    //设置全选checkbox的选中状态，只有改变LAY_CHECKED的值， table.checkStatus才能抓取到选中的状态
		                    var checkStatus = table.checkStatus('member-tab');
		                    if(checkStatus.isAll){
		                        $('.layui-table th[data-field="0"] input[type="checkbox"]').prop('checked', true);
		                        $('.layui-table th[data-field="0"] input[type="checkbox"]').next().addClass('layui-form-checked');
		                    }
		                }
					}
				});
				// 复选框选中监听,将选中的id 设置到缓存数组,或者删除缓存数组
		        table.on('checkbox(member-tab)', function (obj) {
		           if(obj.checked){
		              if(obj.type=='one'){// 单个复选框
		            	  if(!isExist(obj.data.memberId,ids)){
		            		  ids.push(obj.data.memberId); 
		            	  }
		              }else{// 全选复选框
		                   for(var i=0;i<table_data.length;i++){
		                	   if(!isExist(table_data[i].memberId,ids)){// 数组中不存在，则添加
		                		   ids.push(table_data[i].memberId);
		                	   }
		                   }
		              }
		           }else{
		               if(obj.type=='one'){
		                   for(var i=0;i<ids.length;i++){
		                      if(ids[i]==obj.data.memberId){
		                           ids.splice(i,1);
		                      }
		                  }
		               }else{
		                   for(var i=0;i<ids.length;i++){
		                       for(var j=0;j<table_data.length;j++){
		                           if(ids[i]==table_data[j].memberId){
		                        	   ids.splice(i,1);
		                        	   i--;// 删除的时候数组长度也在动态变化
		                        	   break;
		                          }
		                       }
		                   }
		               }
		           }
		        });

				// 添加会员表单提交
				form.on('submit(meber-form-submit)',function(data) {
					var resData = data.field,
					province = resData.province,
					city = resData.city,
					district = resData.district;
					console.log(province, city, district);
					// 通过地址code码获取地址名称
					var ress = common.getCity({
						province, 
						city,
						district
					});
					// 把获取到的三级联动地址追加起来
					resData.memberAddress = ress.provinceName+ress.cityName+ress.districtName;
					console.log(ress);
						// ajax方式添加会员
						$.ajax({
							url : "/member/" + url,
							type : "get",
							data : resData,
							dataType : 'json',
							success : function(data) {
								if (data.statue == 0) {
									layer.close(layer.index);
									layer.msg(data.msg);
									table.reload('member-tab');
								} else {
									layer.msg('添加失败');
								}
							},
							error : function() {
								console.log("ajax error");
							}
						});
						// 阻止表单跳转
						return false;
				});

				// 监听行工具栏事件：删除会员与更新会员
				table.on('tool(member-tab)', function(obj) {
					// 获取当前行数据和lay-event的值
					var data = obj.data;
					var event = obj.event;
					// 删除会员事件
					if (event === 'deleteMember') {
						layer.confirm('确定删除该会员吗？', function(index) {
							// ajax方式删除会员
							$.ajax({
								url : '/member/deleteMore',
								type : "post",
								data : 'ids=' + data.memberId,
								dataType : 'json',
								success : function(data) {
									if (data.statue == 0) {
										layer.msg(data.msg);
										table.reload('member-tab');
									} else {
										layer.msg('删除失败');
									}
								},
								error : function() {
									console.log("ajax error");
								}
							});
							layer.close(index);
						});
					}

					// 更新会员事件
					if (event === 'updateMember') {
						// 每次显示更新会员的表单前自动为表单填写该行的数据
						form.val('member-form', {
							"memberId" : data.memberId,
							"memberName" : data.memberName,
							"memberUsername" : data.memberUsername,
							"memberPhone" : data.memberPhone
						});
						title = "更新会员";
						url = "update";
						openDialog();
					}
				});
				
				$("#search_btn").click(function(){
					table.reload('member-tab', {
						  url: "/member/queryByPage",
						  where: {
							  memberUsername:$('#search_username').val(),
							  memberName:$('#search_name').val()
						  }
						  ,page: {
						    curr: 1
						  }
						});
				});
				
				// 头工具栏事件
				table.on('toolbar(member-tab)', function(obj) {
					var checkStatus = table.checkStatus(obj.config.id);
					switch (obj.event) {
					// 添加会员
					case 'memberAdd_btn':
						// 每次显示前重置表单
						$('#member-form')[0].reset();
						// 清空表单中id值
						$("input[name='memberId']").val('');
						title = "添加会员";
						url = "add";
						// 打开对话框
						openDialog();
						break;
					case 'deleteMore_btn':
						if(ids.length > 0) {
					         layer.confirm("确定删除选中的"+ids.length+"条数据吗？", {icon: 3, title: '提示信息'}, function (index) {
					        	 
					        	 $.ajax({
										url : "/member/deleteMore",
										type : "POST",
										data : "ids="+ids.join(),
										dataType : 'json',
										success : function(data) {
											if (data.statue == 0) {
												layer.close(index);
												layer.msg(data.msg);
												table.reload('member-tab');
											} else {
												layer.msg('删除失败');
											}
										}
					        	 });
					 
					         })
					     }else{
					         layer.msg("请选择需要删除的记录");
					     }
						break;
					case 'getCheckData':
						var data = checkStatus.data;
						layer.alert(JSON.stringify(data));
						break;
					case 'getCheckLength':
						var data = checkStatus.data;
						layer.msg('选中了：' + data.length + ' 个');
						break;
					case 'isAll':
						layer.msg(checkStatus.isAll ? '全选' : '未全选');
						break;

					// 自定义头工具栏右侧图标 - 提示
					case 'LAYTABLE_TIPS':
						layer.alert('这是工具栏右侧自定义的一个图标按钮');
						break;
					}
					;
				});
			});
	function openDialog() {
		// 显示更新会员表单的弹出层
		layer.open({
			type : 1,
			title : title,
			skin : 'layui-layer-molv',
			area : [ '500px' ],
			content : $('#member-layer')
		});
	}
	// 判断数组中是否包含指定的元素
	function isExist(value,array){
		var flag = false;
		for(var i=0;i<array.length;i++){
			if(array[i]==value){
				flag = true;
				break;
			}
		}
		return flag;
	}
	
