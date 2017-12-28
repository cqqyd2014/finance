<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<div class="easyui-layout" fit="true" style="background: red;" >
        <!-- 搜索条件 -->
        <div id="head_panel" data-options="region:'north',border:true"
	style="height: 140px; padding: 5px;">
            <!------------------ 在这里填写你的搜索条件（FORM） -------------------->
            
            <h2>上传查询结果</h2>
            <p>将银行返回的查询结果上传至服务器。</p>
            <div>1、选择数据文件，校验数据<input class="easyui-filebox" style="width: 400px" id="paper"
						name="paper"
						data-options="onChange:function(){ajaxFileUpload()},label:'上传纸质签批扫描件:',buttonText:'浏览选择文件',prompt:'仅支持xml格式的图片'
					,required:true,accept:'text/xml'" /></div>
					<div>2、确认校验通过的数据发送至数据库
					<a class="easyui-linkbutton" id="post_to_Db" href="javascript:void(0)"  onclick="javascript:post_to_db()">
					
					确定保存至数据库
					</a></div>
            

        </div>

        <!-- 查询结果 -->
<div data-options="region:'center',border:false"
	style="padding: 0px;">
           
<input class="easyui-textbox" data-options="multiline:true" id="up_result" style="width: 100%;height:100%">

        </div>          
    </div>
    <script>
    function center_load_ready(){
        }
    
    					$.parser.onComplete = function(){
						
						center_load_ready();
					};	
					
					</script>
					
					
					
					
<script type='text/javascript'>






function ajaxFileUpload() {
	if ($('#paper').filebox("getValue") == "") {
		return;
	}

	var paper = new Array()
	paper[0] = $("input[name='paper']").attr("id");
	ajax_start();

	$.ajaxFileUpload({
		url : '../trans/data_upload.action',//用于文件上传的服务器端请求地址
		data : {
			

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
				//$.messager.alert("操作提示", "上传图片成功：" + pic_name, "info");

				picture_manage_init(image_bill_uuid,null);
			} else {
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
	$('#paper').filebox("setValue", "");
	$('#paper').filebox("disableValidation");

	return false;

}



	var image_bill_uuid;

	function img_resize() {

		var img_w = $('#main_image').width();//图片宽度   
		var img_h = $('#main_image').height();//图片高度   
		if (img_w > 380) {//如果图片宽度超出指定最大宽度   
			var height = (w * img_h)/ img_w; //高度等比缩放
			$('#main_image').css({
				"width" : 380,
				"height" : height
			});//设置缩放后的宽度和高度   
		}
	}
	function show_main_picture(pic_uuid){
		//alert(pic_uuid);
		$("#main_image").attr('src',
				"../bills/get_pic.action?uuid=" + pic_uuid);
		img_resize();
		}

	function set_main_picture(picture_object) {
		show_main_picture(picture_object.uuid);
		
	}

	function picture_manage_init(bill_uuid, object) {
		//得到图片列表
		image_bill_uuid = bill_uuid;

		ajax_start();
		$
				.getJSON(
						"../bills/get_bill_pics.action",
						{

							"bill_uuid" : bill_uuid
						},
						function(result) {
							ajax_stop();

							var field = result.msg;

							if (field.success) {
								//有效
								var pictures = field.o;
								var len = pictures.length;
								$('#pic_num').text(len);
								if (len == 0) {
									//没有传图片
									$("#main_image").attr('src',
											"../img/380-500.png");

								} else {
									var html = '';
									for (var i = 0; i < len; i++) {
										pic = pictures[i];
										html = html
												+ '<span style=\"float:left;\"><div><a id=\"show_main_picture_'
												+ pic.uuid
												+ '\" href=\"javascript:void(0)\" '
												+ 'onclick=\"javascript:show_main_picture(\''
												+ pic.uuid
												+ '\') \"><img alt="" src="../bills/get_pic.action?uuid='
												+ pic.uuid
												+ '" height="80px"/></a></div><div><a class=\"del_picture\" id=\"del_picture_'
												+ pic.uuid
												+ '\" href=\"javascript:void(0)\" '
												+ 'onclick=\"javascript:del_picture(\''
												+ pic.uuid + '\') \"></a></div></span>';

									}

									//alert(html);
									$('#mini_pictures').html(html);
									$('.del_picture').linkbutton({
										text : '删除图片',
										plain : true,
										iconCls : 'icon-cancel'
									});
									//设置图片为第一张
									
									var first = pictures[0];
									set_main_picture(first);

								}

							} else {

								$.messager.alert("操作提示", "获取图片附件错误错误："
										+ field.body, "error");
								show_pics();
							}

						});

		$('#picture_manage_div').dialog('open');
	}



</script>


<script type='text/javascript'>
/*
 *初始化ready 
 
 */
 var picture_manage_handler;

	

	


 
function picture_manage_ready(){
	picture_manage_handler=page_init;
	
	

	dialog_init('picture_manage_div');

	
}



</script>