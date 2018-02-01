<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<div class="easyui-layout" fit="true" style="background: red;" >
        <!-- 搜索条件 -->
        <div id="head_panel" data-options="region:'north',border:true"
	style="height: 100px; padding: 5px;">
            <!------------------ 在这里填写你的搜索条件（FORM） -------------------->
            
            <h2>追踪账户查询数据流向</h2>
            
            <div>
            <form id="search_data_route_form">
            输入账户名称开始查询（模糊查询）
            <input id="account_name" name="account_name" class="easyui-textbox"/>点击按钮
            <a href="javascript:void(0)" onclick="search_data_route()"class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
            </form>
            </div>
					
            

        </div>

        <!-- 查询结果 -->
<div data-options="region:'center',border:false"
	style="padding: 0px;">
           
<table id="search_data_route_table">
</table>

        </div>          
    </div>
    <script>
    function center_load_ready(){
    	

        
    	$('#search_data_route_table')
		.datagrid(
				{
					//border:false,  
					fitColumns : true,
					singleSelect : true,
					title : '查询结果',
					rownumbers : true,
					columns : [ [
							{
								field : 'create_bill_m_dat_print',
								title : '申请时间'
							},
							{
								field : 'create_user_name',
								title : '申请时间'
							},
							
							{
								field : 'dept_name',
								title : '申请部门'
							},
							{
								field : 'pro_name',
								title : '项目名称'
							},
							{
								field : 'account_name',
								title : '账户名称'
							}
							

							 ] ],
					onLoadSuccess : function(data) {
					
						

						$('#search_data_route_table').datagrid(
								'fixRowHeight')

					}
				});

        
        }
    
    					$.parser.onComplete = function(){
						
						center_load_ready();
					};	
					
					</script>
					
					
					
					
<script type='text/javascript'>


function search_data_route(){
	

	
	
	
	var gridOpts = $('#search_data_route_table').datagrid('options');   
	gridOpts.url="../route/search_data_route.action";
	
	gridOpts.queryParams=$('#search_data_route_form').serializeObject();
	//console.log(gridOpts.queryParams);
	$("#search_data_route_table").datagrid("load");
	
	
}



</script>

