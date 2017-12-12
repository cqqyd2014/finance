<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<jsp:include page="../common/include_easyui.jsp" flush="true" />
<jsp:include page="../common/include_print.jsp" flush="true" />


<title>框架头部文件</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="charset" content="utf-8">





<script type="text/javascript">

var pic_num;
	function print_bill_callback(){
		print_bill('<s:property value="#request.bill_uuid"/>');
		}

	function save_print_bill(){

		//如果没有条目，不能打印
		var detail_num=$('#seatch_item_count').numberbox('getValue');
		if (detail_num==0){

			$.messager.alert("操作提示", "没有查询条目，不能打印！", "error");
			return ;
		}
		temp_save_bill(print_bill_callback);

		}

	function save_callback(){
		//nothing todo
		}
	function exit_callback(){
		//alert('exit');

		windo.location.href="../bills/my_bills_init.action";
		}

	function temp_save_bill_and_exit(){
		temp_save_bill(exit_callback);
		}

	function temp_save_bill_check_field(){
		//检测字段是否合规
		//申请人信息
		
		check_string_allowed_blank_not_length('contract_name','联系人姓名',64);
		check_string_allowed_blank_not_length('contract_tell','联系人电话',64);
		check_string_allowed_blank_not_length('contract_mail','联系人邮件',64);
		check_string_allowed_blank_not_length('pro_name','项目名称',512);
		check_string_allowed_blank_not_length('search_reason','联系人邮件',1024);
		check_num_allowed_bigger_tip('seatch_item_count',1);
		
		return true;
		}


	function set_change_business_code(){
		var business_code=$("#business_code").combobox("getValue");
		change_business_code(business_code)

		}
	function change_business_code(business_code) {
		
		
		$.getJSON("get_search_par_code.action", {
			business_code :business_code
		}, function(result) {
			
			var field = result.msg;

			if (field.success) {
				//有效
				var pars = field.o;
				 $("#search_par_code").combobox("loadData", pars);
				 var data = $('#search_par_code').combobox('getData');
				 $('#search_par_code').combobox('select',data[0].code);

				
				

			} else {
				$.messager.alert("操作提示", "获取查询参数出错！"+field.body, "error");

			}

		});
	}

	function add_detail() {
		var search_par_value = trim($('#search_par_value').val());
		$('#search_par_value').val(search_par_value);
		if (search_par_value == '') {
			$.messager.alert("操作提示", "查询条件不能为空！", "error");
			return;
		}

		$.getJSON("add_bill_detail.action", {
			"business_code" : $("#business_code").combobox("getValue"),
			"bank_code" : $("#bank_code").combobox("getValue"),
			"search_par_code" : $("#search_par_code").combobox("getValue"),
			"search_par_value" : $('#search_par_value').val(),
			"bill_uuid" : $('#bill_uuid').val()
		}, function(result) {

			var field = result.msg;

			if (field.success) {
				//有效
				var bds = field.o;

				show_bds(bds);

			} else {

				$.messager.alert("操作提示", "增加查询条目错误：" + field.body, "error");
			}

		});

	}
	function temp_save_bill(callback){
		ajax_start();
		//是否满足临时保存条件
		if (!temp_save_bill_check_field()){
			return;
			}

$.getJSON("temp_save_bill.action", {
			
			"bill_uuid" : $('#bill_uuid').val(),
			pro_name:$('#pro_name').textbox('getValue'),
			contract_name:$('#contract_name').textbox('getValue'),
			contract_tell:$('#contract_tell').textbox('getValue'),
			search_reason:$('#search_reason').textbox('getValue'),
			contract_mail:$('#contract_mail').textbox('getValue'),
			"pic_num":pic_num,
			detail_num:$('#seatch_item_count').numberbox('getValue')
				
		}, function(result) {
			ajax_stop();

			var field = result.msg;

			if (field.success) {
				//有效
				//alert('保存成功')
				callback();

			} else {

				$.messager.alert("操作提示", "暂存申请单错误：" + field.body, "error");
			}

		});

		}

	function get_bill(bill_uuid){
		
		$.getJSON("get_bill.action", {
			
			"bill_uuid" : bill_uuid
		}, function(result) {

			var field = result.msg;

			if (field.success) {
				//有效
				var bill = field.o;
				var bds=field.o2;
				show_bill(bill);
				show_bds(bds);
				setInterval("temp_save_bill(save_callback)", <s:property value="#request.temp_save_time"/> * 1000*60);

			} else {

				$.messager.alert("操作提示", "增加查询条目错误：" + field.body, "error");
			}

		});
		
		}
	
	function show_bill(data){

		$('#dept_name').text(data.dept_name);
		$('#contract_name').textbox("setValue",data.contract_name);
		$('#contract_tell').textbox("setValue",data.contract_tell);
		$('#pro_name').textbox("setValue",data.pro_name);
		$('#search_reason').textbox("setValue",data.pro_name);
		}

	function show_bds(data) {
		var n = data.length;
		$('#seatch_item_count').numberbox('setValue', n);
		$("#bds_table").datagrid('loadData', {
			total : n,
			rows : data
		});
	}



	function del_bd(uuid) {

		$.getJSON("del_bill_detail.action", {

			"detail_uuid" : uuid
		}, function(result) {

			var field = result.msg;

			if (field.success) {
				//有效
				var bds = field.o;

				show_bds(bds);

			} else {

				$.messager.alert("操作提示", "删除查询条目错误：" + field.body, "error");
			}

		});
	}
	</script>
<script>
	$(document)
			.ready(
					function() {
						//$("#login_dialog").panel("move",{top:$(document).scrollTop() + ($(window).height()-250) * 0.5});  
						pic_num=0;
						 $('#bank_code').combobox({    
			                 required:true,    
			                 multiple:false, //多选
			                 editable:false  //是否可编辑
			                 });  
			                 $('#business_code').combobox({    
				                 required:true,    
				                 multiple:false, //多选
				                 editable:false,  //是否可编辑
				                 onChange:function(newValue,oldValue){
					                
				                	 set_change_business_code();  
				                 }  
				                 }); 

			                 $('#search_par_code').combobox({    
				                 required:true,    
				                 multiple:false, //多选
				                 editable:false,  //是否可编辑
				                 valueField:'code',
				                 textField:'value'
				                 }); 
			                 
						$('#bds_table')
								.datagrid(
										{
											//border:false,  
											fitColumns : true,
											singleSelect : true,
											title : '查询条目列表',
											rownumbers : true,
											columns : [ [
													{
														field : 'bank_name',
														title : '银行'
													},
													{
														field : 'business_code_name',
														title : '业务类型'
													},
													{
														field : 'search_par_code_name',
														title : '查询要素'
													},
													{
														field : 'search_par_value',
														title : '查询条件'
													},

													{
														field : 'opt',
														title : '操作',
														width : '100px',
														align : 'center',
														formatter : function(
																value, rec) {
															var btn = '<a class="del_bd" onclick="del_bd(\''
																	+ rec.detail_uuid
																	+ '\')" href="javascript:void(0)">删除条目</a>';
															return btn;
														}
													} ] ],
											onLoadSuccess : function(data) {
												$('.del_bd').linkbutton({
													text : '删除条目',
													plain : true,
													iconCls : 'icon-cancel'
												});

												$('#bds_table').datagrid(
														'fixRowHeight')

											}
										});
						change_business_code('0001');
						get_bill('<s:property value="#request.bill_uuid"/>');
						/**
						 * jquery 定时刷新
						 * edit 
						 */

						
						

					});
</script>
<script type="text/javascript" src="../js/ajaxfileupload.js"></script>
<script type="text/javascript">
	function ajaxFileUpload() {
		if($('#paper').filebox("getValue")==""){
			return;
		}

		var paper=new Array()
		paper[0]= $("input[name='paper']").attr("id");
		ajax_start();

		$.ajaxFileUpload({
			url : 'pic_upload.action',//用于文件上传的服务器端请求地址
			data : {
				bill_uuid : $('#bill_uuid').val(),

			},
			secureuri : false,//一般设置为false
			fileElementId : paper,// 文件id数组
			dataType : 'json',//返回值类型 一般设置为json
			success : function(data, status) //服务器成功响应处理函数
			{

				ajax_stop();
				//重置文件选择框
				

				var field = data.msg;
				if (field.success) {
					var pic_uuids = field.o;
					var pic_uuid = pic_uuids[0];
					var pic_names = field.o2;
					var pic_name = pic_names[0];
					$.messager.alert("操作提示", "上传图片成功：" + pic_name, "info");
					
					show_pics();
				}
				else{
					$.messager.alert("操作提示", "上传图片失败：" + field.body, "error");
					}
				
			},
			error : function(data, status, e)//服务器响应失败处理函数
			{
				ajax_stop();
				alert("上传处理出错");
			}
		});

		$('#paper').filebox("reset");
		$('#paper').filebox("setValue","");
		$('#paper').filebox("disableValidation");

		return false;

	}

	function show_pics(){
		ajax_start();

		$.getJSON("get_bill_pics.action", {

			"bill_uuid" : $('#bill_uuid').val()
		}, function(result) {
			ajax_stop();

			var field = result.msg;

			if (field.success) {
				//有效
				var pics = field.o;

				var pics_html='<table width="100%"><tr>';
				//一行最多6个照片
				var flag=1;
				var i;
				pic_num=pics.length;
				for (i=0;i<pics.length;i++){
					var pic=pics[i];

					if (flag==7){
						pics_html=pics_html+'</tr><tr>';
						flag=0;
						
						}
					
					pics_html=pics_html+'<td width="16.667%"><div><a id="pic'+pic.uuid+'" href="get_pic.action?uuid='+pic.uuid+'"><img alt="" src="get_pic.action?uuid='+pic.uuid+'" width="100px"></a></div>'+
					'<div align="center"><a class="del" id="img'+pic.uuid+'" onclick="javascript:del_pic(\''+pic.uuid+'\')">删除图片</a></div></td>';
					flag++;
					

					}
				//除以6的余数
				var addon=6-i%6;
				
				if (addon<6){
					for (var a=0;a<addon;a++){
						pics_html=pics_html+'<td width="16.667%"></td>';
					}
				}
				

				

				pics_html=pics_html+'</tr></table>';
				$('#pics_table').empty();

				$('#pics_table').html(pics_html);
				for (var i=0;i<pics.length;i++){
					
					$('.del').linkbutton({text:'删除图片',plain:true,iconCls:'icon-cancel'});
				}
				

			} else {

				$.messager.alert("操作提示", "删除查询条目错误：" + field.body, "error");
				
			}

		});

		

		}


	function del_pic(uuid){
		ajax_start();

		$.getJSON("del_pic.action", {

			"pic_uuid" : uuid
		}, function(result) {
			ajax_stop();

			var field = result.msg;

			if (field.success) {
				//有效
				$.messager.alert("操作提示", "删除图片成功", "info");
				show_pics();

			} else {

				$.messager.alert("操作提示", "删除查询条目错误：" + field.body, "error");
				show_pics();
			}

		});

		}
</script>
</head>

<body style="padding: 30px; margin: 0px">
	<div class="easyui-panel"
		style="width: 800px; padding: 10px; margin: 10px, 50px10px, 50px;">

		<h1 align='center'>查询账户审批单</h1>

		<table border="1" width="90%" class="box" align='center'>
			<tr>
				<td colspan='2'><span style='float: left'>系统每<span>${temp_save_time }</span>分钟暂存一次数据
				</span><span style='float: right'> <a href="javascript:void(0)"
						class="easyui-linkbutton" icon="icon-print"
						onclick="javascript:save_print_bill()">打印申请</a>

						<a href="javascript:void(0)" class="easyui-linkbutton"
						onclick="javascript:temp_save_bill_and_exit()" icon="icon-save">暂存退出</a> <a
						href="javascript:void(0)" class="easyui-linkbutton"
						onclick="javascript:login()" icon="icon-ok">提交申请</a>
				</span></td>
			</tr>
			<tr>
				<td>申请单位：</td>
				<td><span id='dept_name'></span></td>
			</tr>
			<tr>
				<td>
					<div id='contract_name_title'>联系人</div>
				</td>
				<td><input class="easyui-textbox" type='text'
					id='contract_name' required="true"
					data-options="iconCls:'icon-man'" style="width: 100%;">
					<div id="contract_name_msg"></div></td>
			</tr>
			<tr>
				<td>
					<div id='contract_tell_title'>联系电话</div>
				</td>
				<td><input type='text' id='contract_tell'
					class="easyui-textbox" required="true" style="width: 100%;">
					<div id="contract_tell_msg"></div></td>

			</tr>
			<tr>
				<td>
					<div id='contract_mail_title'>邮箱</div>
				</td>
				<td><input type='text' id='contract_mail'
					class="easyui-textbox" required="true" style="width: 100%;">
					<input type="hidden"
					value='<s:property value="#request.bill_uuid"/>' id='bill_uuid'>
					<div id="contract_mail_msg"></div></td>

			</tr>

			<tr>
				<td width='30%'><div id='pro_name_title'>审计（调查）项目名称</div></td>
				<td width='70%'><input required="true"
					style="width: 100%; height: 50px" id="pro_name"
					class="easyui-textbox" data-options="multiline:true"></input>
					<div id="pro_name_msg"></div></td>
			</tr>
			<tr>
				<td width='30%'><div id='search_reason_title'>查询理由</div></td>
				<td width='70%'><input required="true"
					style="width: 100%; height: 50px" id="search_reason"
					class="easyui-textbox" data-options="multiline:true"></input>
					<div id="search_reason_msg"></div></td>
			</tr>
			<tr>
				<td colspan='2'>
					<div>
						<div>录入查询条目</div>
						<div>
							1、银行：
							<s:select id="bank_code" name="bank_code" list="bank_code"
								listKey="code" listValue="value" cssClass="easyui-combobox"
								cssStyle="width:150px" />

							2、业务类型
							<s:select id="business_code" name="business_code"
								list="business_code" listKey="code" listValue="value"
								onchange="change_business_code();" cssClass="easyui-combobox"
								cssStyle="width:150px" />
							3、查询要素<input id="search_par_code" class="easyui-combobox"
								style="width: 150px"> </input>
						</div>
						<div>
							<span> 4、查询条件<input required="true" id='search_par_value'
								class="easyui-textbox" style="width: 400px"></span><span
								align='right'> <a href="javascript:void(0)"
								class="easyui-linkbutton" onclick="javascript:add_detail()"
								iconCls="icon-add">增加查询项目</a></span>
						</div>
						<div>
							<span>已经录入</span><span id='seatch_item_count_title'>查询条目</span> <span><input
								class="easyui-numberbox" value="0" style="width: 50px"
								disabled='disabled' data-options="min:0,precision:0"
								id='seatch_item_count'></span> <span>条。</span><span
								id='seatch_item_count_msg'></span>
						</div>
					</div>
					<table width='100%' id='bds_table' style="height: 200px">
					</table>
				</td>
			</tr>
			<tr>
				<td>审计组主神意见</td>
				<td>&nbsp;签名&nbsp;日期</td>
			</tr>
			<tr>
				<td>业务部门负责人意见</td>
				<td>&nbsp;签名&nbsp;日期</td>
			</tr>
			<tr>
				<td>法规处审核意见</td>
				<td>&nbsp;签名&nbsp;日期</td>
			</tr>
			<tr>
				<td>分管领导意见</td>
				<td>&nbsp;签名&nbsp;日期</td>
			</tr>
			<tr>
				<td>局长意见</td>
				<td>&nbsp;签名&nbsp;日期</td>
			</tr>



			<tr>
				<td colspan='2'><input class="easyui-filebox"
					style="width: 100%" id="paper" name="paper"
					data-options="onChange:function(){ajaxFileUpload()},label:'上传纸质签批扫描件:',buttonText:'浏览选择文件',prompt:'仅支持jpg、tiff、png格式的图片'
					,required:true,accept:'image/png,image/jpeg,image/tiff'" />



				</td>
			</tr>
			<tr>
				<td colspan='2'>
					<div id='pics_table'></div>
				</td>
			</tr>



		</table>

	</div>
</body>
</html>