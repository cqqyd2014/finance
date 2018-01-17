<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<div class="easyui-layout" fit="true" style="background: red;" >
        <!-- 搜索条件 -->
        <div id="head_panel" data-options="region:'north',border:true"
	style="height: 100px; padding: 5px;">
            <!------------------ 在这里填写你的搜索条件（FORM） -------------------->
            
            <h2>分类统计</h2>
            
            <div>
            <form id="type_form">
            选择统计开始日期（含当天）
            <input id="start_dat" name="start_dat" class="easyui-datebox"/>，选择结束日期
            <input id="end_dat" name="end_dat" class="easyui-datebox"/>,点击按钮
            <a href="javascript:void(0)" onclick="type_statistic()"class="easyui-linkbutton" data-options="iconCls:'icon-search'">统计</a>
            </form>
            </div>
					
            

        </div>

        <!-- 查询结果 -->
<div data-options="region:'center',border:false"
	style="padding: 0px;">
           
<table id="type_table">
</table>

        </div>          
    </div>
    <script>
    function center_load_ready(){
    	var Today=new Date();
    	var today_str=Today.getFullYear()+"-"+(Today.getMonth()+1)+"-"+Today.getDate();
    	$('#start_dat').datebox('setValue',today_str);
    	$('#end_dat').datebox('setValue',today_str);


        
    	$('#type_table')
		.datagrid(
				{
					//border:false,  
					fitColumns : true,
					singleSelect : true,
					title : '分类统计结果',
					rownumbers : true,
					columns : [ [


						
							{
								field : 'type_name',
								title : '类型'
							},
							{
								field : 'dept_count',
								title : '数量'
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
							}

							] ],
					onLoadSuccess : function(data) {
						
						

						$('#type_table').datagrid(
								'fixRowHeight')

					}
				});

        
        }
    
    					$.parser.onComplete = function(){
						
						center_load_ready();
					};	
					
					</script>
					
					
					
					
<script type='text/javascript'>


function type_statistic(){
	

	
	var start_dat = $('#start_dat').datebox('getValue');
	
	var gridOpts = $('#type_table').datagrid('options');   
	gridOpts.url="../statistic/get_type_statistic.action";
	
	gridOpts.queryParams=$('#type_form').serializeObject();
	//console.log(gridOpts.queryParams);
	$("#type_table").datagrid("load");
	
	
}



</script>

