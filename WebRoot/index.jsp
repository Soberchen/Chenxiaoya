<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	request.setAttribute("path", path);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>图书信息管理系统</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

table, p {
	margin: 0 auto;
	width: 800px;
}

form, td {
	text-align: center;
}

form {
	margin-top: 15px;
}

/* table tr:nth-child(even) {
	background-color: springgreen;
}
 */
/* table tr:first-child {
	background-color: skyblue;
} */

/* table tr:nth-child(3) {
	background-color: yellow;
} */

p {
	text-align: center;
	font-weight: bold;
	font-size: 20px;
}
#pager{
text-align:center;

}
#tip{
text-align:center;

}
</style>

	<script type="text/javascript" src="${path}/scripts/jquery-1.12.4.js"></script>
	<script type="text/javascript">
		/* $(function() {
			$('table:last-of-type tr:gt(0):odd').css('background-color', 'skyblue'); //隔行换色
			
		}); */
		$('#tip').css("color","red");
	</script>
</head>
<body>
	<table>
		<tr>
			<td>
				<form action="${path}SelectServlet" method="post">
					<input type="hidden" name="currPageNo" value="${pager.currPageNo}" />
					<input type="hidden" name="pageSize" value="${pager.pageSize}" /> 
					<select name="bookPublish" >
						<option value="">请选择</option>
						<c:forEach var="prod" items="${pager.newlist}" varStatus="i">
							<option value="${prod.bookPublish}">${prod.bookPublish}</option>
						</c:forEach>
					</select>&nbsp;<input type="text" name="bookName" />&nbsp;
					<input type="submit" value="查询" />
				</form>
			</td>
			<td><a href="${basePath }add.jsp">新增理财信息</a></td>
		</tr>
	</table>
	<table border="1" cellpadding="0" cellspacing="0">
		<tr class="title">
			<td>序号</td>
			<td>书名</td>
			<td>作者</td>
			<td>出版社</td>
			<td>页数</td>
			<td>价格</td>
		</tr>
		<c:forEach var="prod" items="${pager.newlist}" varStatus="i">
		<!--为偶数时的隔行变色  -->
			<tr <c:if test="${i.index%2==1}">style="background-color:rgb(219,241,212);"</c:if>>
				<td>${prod.bookId}</td>
				<td>${prod.bookName}</td>
				<td>${prod.bookAuthor}</td>
				<td>${prod.bookPublish}</td>
				<td>${prod.bookPage}</td>
				<td>${prod.bookPrice}</td>
			</tr>
		</c:forEach>
	</table>
	<div id="pager">
		<select onchange="slectPage()">
			<c:forEach var="num" begin="1" end="4">
				<option>${pager.baseSize*num}</option>	
			</c:forEach>
		</select>&nbsp;&nbsp;
		<c:if test="${pager.ifFirst}">
	首页&nbsp;
	上一页&nbsp;&nbsp;|&nbsp;
	</c:if>
		<c:if test="${not pager.ifFirst}">
			<a href="http://localhost:8080/BookWeb/SelectServlet?currPageNo=1&pageSize=4">首页</a>&nbsp;
	<a href="http://localhost:8080/BookWeb/SelectServlet?currPageNo=${pager.currPageNo-1}&pageSize=4">上一页</a>&nbsp;&nbsp;|&nbsp;
	</c:if>
		第&nbsp;<input type="text" value="${pager.currPageNo }" onblur="inputPage()"/>&nbsp;页,共&nbsp;${pager.totalPageCount}页&nbsp;总记录数：${pager.totalCount}条
		<c:if test="${not pager.ifLast }">
			<a href="http://localhost:8080/BookWeb/SelectServlet?currPageNo=${pager.currPageNo+1}&pageSize=4">下一页</a>&nbsp;
	<a href="http://localhost:8080/BookWeb/SelectServlet?currPageNo=${pager.totalPageCount}&pageSize=4">末页</a>
		</c:if>
		<c:if test="${pager.ifLast}">
	上一页&nbsp;&nbsp;|&nbsp;
	末页&nbsp;
	</c:if>
	</div>
	<div id="tip">${mess}</div>
	<c:remove var="mess" scope="session" />
</body>
</html>