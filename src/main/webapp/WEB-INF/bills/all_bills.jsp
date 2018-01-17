<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>


<script language='javascript' type='text/javascript'>
	function page_init() {


		
		//获取数据
		
		
		show_search_bill_list_table();
		
		

	}




	
</script>
<script language='javascript' type='text/javascript'>
	function bill_list_table_Dclick(rowData) {

	}
	function room(bill_uuid){
		window.open("../bills/bill_room.action?bill_uuid="+bill_uuid);
		}
	function output(bill_uuid){
		window.open("../bills/bill_output.action?bill_uuid="+bill_uuid);
		}
	function del_bill(bill_uuid,object){
		$.messager.confirm('操作提示','确定删除这个申请单吗?',function(r){
		    if (r){
		    	$.getJSON("../bills/del_bill_m.action", {
					
					"bill_uuid" : bill_uuid
				}, function(result) {

					var field = result.msg;

					if (field.success) {
						//有效
						$.messager.alert("操作提示", "删除查询申请成功", "info");
						page_init();

					} else {

						$.messager.alert("操作提示", "删除查询申请错误：" + field.body, "error");
					}

				});
		    }
		});

		}



	</script>
<script language='javascript' type='text/javascript'>




				
$.parser.onComplete = function(){
	
	center_load_ready();
	
};	

function center_load_ready(){
	

	

	
	
	
	
	picture_manage_ready(page_init);
	view_reslut_ready();
	search_bill_ready("../bills/get_all_bills.action");
				
				var search_bill_list_table_view = $
				.extend(
						{},
						$.fn.datagrid.defaults.view,
						{
							renderRow : function(target, fields, frozen, rowIndex,
									rowData) {

								//alert(typeof (rowData));
								try {
									var row_len = row_len = rowData.bill_details.length;
								} catch (err) {
									return "<td></td>";
								}
								var cc = [];

								cc
										.push('<td  style="padding:10px;border:0;width:1000px;"><div style=\'box-shadow:5px 2px 6px #000;margin:20px 30px 0px 0px; width:100%\'><table width=\'100%\' border=\'1\' class=\'box\'><tr><td colspan=\'8\' bgcolor=\'#cccccc\'><span style=\'color:white;background-color:');
								switch (rowData.bill_status) {
								case '起草申请':
									cc.push('#CC99CC');
									break;
								case '打印待签':
									cc.push('#CC3399');
									break;
								case '等待传单':
									cc.push('#996666');
									break;
								case '等待返回':
									cc.push('#666666');
									break;
								case '返回待审':
									cc.push('#CCCCCC');
									break;
								case '查看结果':
									cc.push('#CCCC33');
									break;

								default:
									cc.push('CCCCCC');
								}
								//alert(rowData.order_type_name);
								cc.push(';\'>' + rowData.bill_status
										+ '</span> 编号：' + rowData.bill_uuid
										//+ '<img width=\'40\' height=\'20\'src=\'../img/ebusiness/'+rowData.order_ebusiness_code+'.jpg\'/>'
										//+ rowData.original_id + ','
										+'[部门：'
										+ rowData.dept_name
										+ '][申请人：'
										+ rowData.create_user_name
										+ '][申请单创建时间'
										+ rowData.create_dat_chinese_print
										+ ']</td></tr>');
								//alert(rowData.c_status);
								
								var opts=$('#search_bill_list_table').datagrid('getPager').pagination('options');
								//console.log(opts);
								var pageSize=opts.pageSize;
								var pageNumber=opts.pageNumber;
								var row_no = parseInt(rowIndex + 1, 10)
										+ parseInt(((pageNumber==0?1:pageNumber) -1)
												* pageSize, 10);

								var row_len = row_len = rowData.bill_details.length;
								row_len++;

								//alert(row_len);
								var tip=rowData.audit_user_name==""?"":"<font color=\'red\'>已打印数据拷出审批单</font>";

								cc
										.push('<tr><td width=\'10%\' rowspan=\''
												+ row_len
												+ '\'>序号：'
												+  row_no
												

												+ '</td><td width=\'10%\' rowspan=\''
												+ row_len
												+ '\'>'
												+ rowData.pro_name
												+ '</td><td width=\'20%\' rowspan=\''
												+ row_len
												+ '\'>'
												+ rowData.search_reason
												+ '</td><td width=\'7%\' bgcolor=\'#cccccc\'>'
												+ '银行名称'
												+ '</td><td width=\'7%\' bgcolor=\'#cccccc\'>'
												+ '业务类型'
												+ '</td><td width=\'8%\' bgcolor=\'#cccccc\'>'
												+ '参数类型'
												+ '</td><td width=\'17%\' bgcolor=\'#cccccc\'>'
												+ '查询参数'

												+ '</td><td width=\'21%\' rowspan=\''
												+ row_len + '\'>审核状态：'+tip+'<br>图片附件：'
												+ rowData.pics_num + '<br>');

								var pics = rowData.pictures;

								$.each(
												pics,
												function(j, pic) {
													cc
															.push('<a id="pic'
																	+ pic.uuid
																	+ '" href="../bills/get_pic.action?uuid='
																	+ pic.uuid
																	+ '"><img alt="" src="../bills/get_pic.action?uuid='
																	+ pic.uuid
																	+ '" height="50px"></a>');

												});

								cc.push('</td></tr>')

								if (rowData.bill_details != null) {
									var bill_details = rowData.bill_details;

									$.each(bill_details, function(i, field) {

										cc.push('<tr><td width=\'7%\'>'
												+ field.bank_name
												+ '</td><td width=\'7%\' >'
												+ field.business_code_name
												+ '</td><td width=\'8%\' >'
												+ field.search_par_code_name
												+ '</td><td width=\'17%\' >'
												+ field.search_par_value
												+ '</td></tr>');

									});
								}
								
								
								var temp_b='<tr><td colspan=\'8\'>'
									+ '<div>操作：<a	class="print_bill" href="javascript:void(0)" id=\"print_bill_'
									+ rowData.bill_uuid
									+ '\" class="easyui-linkbutton"	onclick="javascript:print_bill(\''
									+ rowData.bill_uuid
									+ '\',this)">打印申请</a><a	class="upload_pictures" href="javascript:void(0)" id=\"upload_pictures_'
									+ rowData.bill_uuid
									+ '\" class="easyui-linkbutton"	onclick="javascript:picture_manage_init(\''
									+ rowData.bill_uuid
									+ '\',this)">管理图片附件</a><a	class="room" href="javascript:void(0)" id=\"room_'
									+ rowData.bill_uuid
									+ '\" class="easyui-linkbutton"	onclick="javascript:room(\''
									+ rowData.bill_uuid
									+ '\',this)">打印数据分析室使用申请单</a><a	class="output" href="javascript:void(0)" id=\"output_'
									+ rowData.bill_uuid
									+ '\" class="easyui-linkbutton"	onclick="javascript:output(\''
									+ rowData.bill_uuid
									+ '\',this)">打印数据导出申请单</a>'
									
									+'<a	class="view_reslut" href="javascript:void(0)" id=\"view_reslut_'
									+ rowData.bill_uuid
									+ '\" class="easyui-linkbutton"	onclick="javascript:view_result_init(\''
									+ rowData.bill_uuid
									+ '\',this)">查看结果</a><a	class="del_bill" href="javascript:void(0)" id=\"del_bill_'
									+ rowData.bill_uuid
									+ '\" class="easyui-linkbutton"	onclick="javascript:del_bill(\''
									+ rowData.bill_uuid
									+ '\',this)">删除</a></div>'

									+ '</td></tr></table></div></td>';
									//alert(temp_b);
								cc.push(temp_b);

								//alert(cc.join(''));
								return cc.join('');
							}

						});

				$('#search_bill_list_table').datagrid(
						{
							view : search_bill_list_table_view,

							onDblClickRow : function(rowIndex, rowData) {
								bill_list_table_Dclick(rowData);
							},
						
							pagination : true,
							//rownumbers: true, 
							onLoadSuccess : function(data) {
								

								

								//console.log(data);
								
								$('.upload_pictures').linkbutton({
									text : '管理图片附件',
									plain : false,
									iconCls : 'icon-add'
								});

								$('.view_reslut').linkbutton({
									text : '查看结果',
									plain : false,
									iconCls : 'icon-more'
								});
								$('.room').linkbutton({
									text : '打印数据分析室使用申请单',
									plain : false,
									iconCls : 'icon-print'
								});
								$('.print_bill').linkbutton({
									text : '打印申请',
									plain : false,
									iconCls : 'icon-print'
								});
								$('.output').linkbutton({
									text : '打印数据导出申请单',
									plain : false,
									iconCls : 'icon-print'
								});
								$('.del_bill').linkbutton({
									text : '删除申请单',
									plain : false,
									iconCls : 'icon-cancel'
								});
								
								var rowsData = $("#search_bill_list_table").datagrid("getRows");
								//console.log(rowsData.length);
								for (var i = 0; i < rowsData.length; i++) {
									var row = data.rows;
									var bill = row[i];
									
									//console.log(i);
									//console.log(bill);
									switch (bill.bill_status) {
									case '起草申请':
										$('#upload_pictures_' + bill.bill_uuid)
												.linkbutton('disable');
										
										
										$('#output_' + bill.bill_uuid)
												.linkbutton('disable');
										$('#print_bill_' + bill.bill_uuid)
												.linkbutton('disable');
										$('#view_reslut_' + bill.bill_uuid)
												.linkbutton('disable');
										$('#room_' + bill.bill_uuid)
												.linkbutton('disable');
										$('#del_bill_' + bill.bill_uuid)
										.linkbutton('enable');
										
										break;
									case '打印待签':
										$('#upload_pictures_' + bill.bill_uuid)
										.linkbutton('disable');
										$('#output_' + bill.bill_uuid)
										.linkbutton('disable');
								$('#print_bill_' + bill.bill_uuid)
										.linkbutton('disable');
								$('#view_reslut_' + bill.bill_uuid)
										.linkbutton('disable');
								$('#room_' + bill.bill_uuid)
										.linkbutton('disable');
								$('#del_bill_' + bill.bill_uuid)
								.linkbutton('disable');
										break;
									case '等待传单':
										$('#upload_pictures_' + bill.bill_uuid)
										.linkbutton('enable');
										$('#output_' + bill.bill_uuid)
										.linkbutton('disable');
								$('#print_bill_' + bill.bill_uuid)
										.linkbutton('disable');
								$('#view_reslut_' + bill.bill_uuid)
										.linkbutton('disable');
								$('#room_' + bill.bill_uuid)
										.linkbutton('disable');
								$('#del_bill_' + bill.bill_uuid)
								.linkbutton('disable');
										break;
									case '等待返回':
										$('#upload_pictures_' + bill.bill_uuid)
										.linkbutton('enable');
										$('#output_' + bill.bill_uuid)
										.linkbutton('disable');
								$('#print_bill_' + bill.bill_uuid)
										.linkbutton('disable');
								$('#view_reslut_' + bill.bill_uuid)
										.linkbutton('disable');
								$('#room_' + bill.bill_uuid)
										.linkbutton('disable');
								$('#del_bill_' + bill.bill_uuid)
								.linkbutton('disable');
										break;
									case '返回待审':
										$('#upload_pictures_' + bill.bill_uuid)
										.linkbutton('enable');
										$('#output_' + bill.bill_uuid)
										.linkbutton('enable');
								$('#print_bill_' + bill.bill_uuid)
										.linkbutton('enable');
								$('#view_reslut_' + bill.bill_uuid)
										.linkbutton('enable');
								$('#room_' + bill.bill_uuid)
										.linkbutton('enable');
								$('#del_bill_' + bill.bill_uuid)
								.linkbutton('disable');
										break;
									case '查看结果':
										$('#upload_pictures_' + bill.bill_uuid)
										.linkbutton('enable');
										$('#output_' + bill.bill_uuid)
										.linkbutton('enable');
								$('#print_bill_' + bill.bill_uuid)
										.linkbutton('enable');
								$('#view_reslut_' + bill.bill_uuid)
										.linkbutton('enable');
								$('#room_' + bill.bill_uuid)
										.linkbutton('enable');
								$('#del_bill_' + bill.bill_uuid)
								.linkbutton('disable');
										break;
									default:

									}
								}
								

							}
						});
				page_init();

}
</script>







	<jsp:include page="common/picture_manage.jsp" flush="true" />
	<jsp:include page="common/search_bill.jsp" flush="true" />
	<jsp:include page="common/view_reslut.jsp" flush="true" />
<jsp:include page="../common/include_print.jsp" flush="true" />


