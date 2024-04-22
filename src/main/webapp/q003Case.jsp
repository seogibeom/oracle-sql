<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "vo.*" %>
<%@ page import = "dao.*" %>
<%
	ArrayList<HashMap<String, Object>> list = EmpDAO.selectJobCaseList();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
</head>
<body>
	<h1>CASE식을 이용한 정렬</h1>
	<table border="1">
		<tr>
			<th>ENAME</th>
			<th>JOB</th>
			<th>COLOR</th>
		</tr>
		<%
			for(HashMap<String, Object> m : list) {
		%>
		<tr>
			<td><%=(String)(m.get("ENAME"))%></td>
			<td><%=(String)(m.get("JOB"))%></td>
			<td><%=(String)(m.get("COLOR"))%></td>
		</tr>
		<%		
			}
		%>
</table>
</body>
</html>