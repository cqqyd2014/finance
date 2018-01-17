<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>



<script type="text/javascript">
function page_init() {
	//获取数据
	show_bill_simple_table();

		
	
	

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
						search_bill_simple_ready("../trans/get_trans_download_bills.action");
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
            <table id="simple_bill_table" >
		
	</table>

        </div>          
    </div>
<jsp:include page="common/search_bill_simple.jsp" flush="true" />
