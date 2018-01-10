<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>



<script type="text/javascript">
function page_init() {
	//获取数据
	show_bill_simple_table("../trans/get_trans_download_bills.action");

		
	
	

}

function download_xml_request(){

	var checkedItems = $('#simple_bill_table').datagrid('getChecked');
	if (checkedItems.length==0){
		$.messager.alert("操作提示", "选中的记录数为0", "error");
		return ;
		}
	var bills = [];
	$.each(checkedItems, function(index, item){
		bills.push(item.bill_uuid);
	});
	window.open('download_xml_request.action?bills='+bills);
}

function un_check_all(){

	$('#simple_bill_table').datagrid('clearSelections');
}
function check_all(){
	//设置为全部选中
	var rows=$('#simple_bill_table').datagrid('getRows');
	//console.log(rows);
	
	for (var i=0;i<rows.length;i++){
		$('#simple_bill_table').datagrid('checkRow', i);
		
		}
	}
	

</script>
<script>

					function center_load_ready() {
						search_bill_simple_ready();
						page_init();
					}



					$.parser.onComplete = function(){
						
						center_load_ready();
					};	
</script>





<div class="easyui-layout" fit="true" style="background: red;" >
        <!-- 搜索条件 -->
        <div id="head_panel" data-options="region:'north',border:true"
	style="height: 140px; padding: 5px;">
            <!------------------ 在这里填写你的搜索条件（FORM） -------------------->
            
            <h2>下载查询请求</h2>
            <p>将已经提交的查询需求下载为xml文件，传输至银行执行查询。</p>
            <div><a ref="javascript:void(0)"
								class="easyui-linkbutton" onclick="javascript:check_all()"
								iconCls="icon-add" >全部选中</a><a ref="javascript:void(0)"
								class="easyui-linkbutton" onclick="javascript:un_check_all()"
								iconCls="icon-remove">全部清空</a><a ref="javascript:void(0)"
								class="easyui-linkbutton" onclick="javascript:download_xml_request()"
								iconCls="icon-ok">下载申请单数据（XML）</a></div>
            

        </div>

        <!-- 查询结果 -->
<div data-options="region:'center',border:false"
	style="padding: 0px;">
            <!------------------ 在这里填写你的datagrid -------------------->
            <table id="simple_bill_table"   pagination="true" class="easyui-datagrid"
		fit="true" sortName="itemid" singleSelect="false"
			iconCls="icon-redo">
		<thead>
			<tr>
				<th field="ck" checkbox="true"></th>
				<th field=dept_name width="100">处室</th>
				
				<th field="contract_name" width="100" >联系人</th>
				<th field="contract_tell" width="100" >联系电话</th>
				<th field="create_dat_chinese_print" width="100">创建时间</th>
				<th field="pro_name" width="200">项目名称</th>
				<th field="search_reason" width="400" >查询原因</th>
			</tr>
		</thead>
	</table>

        </div>          
    </div>
<jsp:include page="common/search_bill_simple.jsp" flush="true" />
