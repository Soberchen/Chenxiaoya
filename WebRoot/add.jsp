<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	request.setAttribute("path", path);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'insert.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

div {
	margin: 0 auto;
	width: 420px;
}

#tip {
	text-align: center;
	height: 50px;
	line-height: 50px;
}

table {
	width: 420px;
	border-collapse: collapse;
}

.title {
	font-size: 30px;
	height: 50px;
	line-height: 50px;
	text-align: center;
}

.center {
	text-align: center;
}
</style>
<script type="text/javascript" src="${path}/scripts/jquery-1.12.4.js"></script>

<script type="text/javascript">
/* function judgeCode() {
	$.ajax({
		url : "http://localhost:8080/FinancingProductSys/ajaxServlet",
		type : "POST",
		data : {
			"suibian" : $('#id').val()
		},
		dataType : "text",
		success : function(info) { //局部刷新
			if (info == "true") { //重复代码
				$('#ajax_info').html("代码不可用");
			} else if (info == "false") {
				$('#ajax_info').html("代码可用");
			}
		}
	});

} */


	function tijiao(falg) {
		var ifname = $('#name').val();
		var ifcount = $('#count').val();
		var ifprice = $('#price').val();
		alert(ifname + "" + ifcount + "" + ifprice);
		if (ifname==""||ifname.length == 0) {
			alert("书名不能为空！")
			return false;
		}else if (!(Math.round(ifcount) == ifcount)) {
			alert("页数必须是整数！");
			return false;
		}else if (ifprice != null) {
			alert("价格必须是数字类型！");
			return false;
		}
		return true;
		
	}
	//确认提交按钮
	
	//重置按钮
	function again() {
		$("[input=text]").html("");
	}
	function runback() {
		location.href = "http://localhost:8080/BookWeb/SelectServlet"
	}
</script>
</head>

<body>
	<div>
		<form action="${path}/InsertServlet" method="post">

			<table border="0" cellpadding="0" cellspacing="0">
				<tr class="title">
					<td colspan="3">增加新书&nbsp;&nbsp;<input type="button"
						onclick="runback()" value="返回" /></td>
				</tr>
				<tr>
					<td>书名：</td>
					<td><input type="text" name="bookName" id="name"
						onblur="judgeCode()" /></td>
					<td><span id="ajax_info"></span></td>
				</tr>
				<tr>
					<td>作者：</td>
					<td><input type="text" name="bookAuthor" /></td>
					<td></td>
				</tr>
				<tr>
					<td>出版社：</td>
					<td><input type="text" name="bookPublish" /></td>
					<td></td>
				</tr>
				<tr>
					<td>页面数量：</td>
					<td><input type="text" name="bookPage" id="count" /></td>
					<td></td>
				</tr>
				<tr>
					<td>价格：</td>
					<td><input type="text" name="bookPrice" id="price" /></td>
					<td></td>
				</tr>
				<tr>
					<td>出版时间：</td>
					<td><input type="text" name="createDate" /></td>
					<td></td>
				</tr>
				<tr class="center">
					<td colspan="3"><input type="submit" value="提交"
						onclick="tijiao()" />&nbsp; <input type="reset" value="重置"
						onclick="again()" /></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="tip"></div>
</body>
</html>
