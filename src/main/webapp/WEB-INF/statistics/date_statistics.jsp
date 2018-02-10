<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<div class="easyui-layout" fit="true" style="background: red;" >
        <!-- 搜索条件 -->
        <div id="head_panel" data-options="region:'north',border:true"
	style="height: 100px; padding: 5px;">
            <!------------------ 在这里填写你的搜索条件（FORM） -------------------->
            
            <h2>明细统计</h2>
            
            <div>
            <form id="date_statistic_form">
            选择统计开始日期（含当天）
            <input id="start_dat" name="start_dat" class="easyui-datebox"/>，选择结束日期
            <input id="end_dat" name="end_dat" class="easyui-datebox"/>,点击按钮
            <a href="javascript:void(0)" onclick="date_statistic()"class="easyui-linkbutton" data-options="iconCls:'icon-search'">统计</a>
            </form>
            </div>
					
            

        </div>

        <!-- 查询结果 -->
<div data-options="region:'center',border:false"
	style="padding: 0px;">
           
<table id="date_statistic_table">
</table>

        </div>          
    </div>
    <script>
    function center_load_ready(){
    	var Today=new Date();
    	var today_str=Today.getFullYear()+"-"+(Today.getMonth()+1)+"-"+Today.getDate();
    	　
    	$('#start_dat').datebox('setValue',today_str);
    	$('#end_dat').datebox('setValue',today_str);


        
    	$('#date_statistic_table')
		.datagrid(
				{
					//border:false,  
					fitColumns : true,
					singleSelect : true,
					title : '明细统计结果',
					rownumbers : true,
					showFooter: true,
					columns : [ [
							{
								field : 'create_date_print',
								title : '申请时间'
							},
							{
								field : 'dept_type_name',
								title : '部门类型'
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
								field : 'public_account_count',
								title : '对公账户'
							},
							{
								field : 'public_detail_count',
								title : '对公账户明细'
							},
							{
								field : 'private_account_count',
								title : '对私账户'
							},
							{
								field : 'private_detail_count',
								title : '对私明细'
							} ] ],
					onLoadSuccess : function(data) {
					
						

						$('#date_statistic_table').datagrid(
								'fixRowHeight')

					}
				});

        
        }
    
    					$.parser.onComplete = function(){
						
						center_load_ready();
					};	
					
					</script>
					
					
					
					
<script type='text/javascript'>


function date_statistic(){
	

	
	var start_dat = $('#start_dat').datebox('getValue');
	
	var gridOpts = $('#date_statistic_table').datagrid('options');   
	gridOpts.url="../statistic/get_date_statistic.action";
	gridOpts.showFooter=true;
	
	gridOpts.queryParams=$('#date_statistic_form').serializeObject();
	//console.log(gridOpts.queryParams);
	$("#date_statistic_table").datagrid("load");
	
	
}



</script>

