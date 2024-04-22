<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "dao.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "vo.*" %>
<%
 	ArrayList<Integer> list = EmpDAO.selectDeptNoList();
	ArrayList<HashMap<String, Integer>> groupByList = EmpDAO.selectDeptNoCntList();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
</head>
<body>
<h1> DISTINCT 키워드 연산</h1>
	<select name="deptNo">
		<option value=""> ===선택=== </option>
		<%
			for(Integer i : list ){
		%>
		<option value="<%=i%>"><%=i%></option>
		<%
			}
		%>
	</select>
	<h1> DISTINCT 대신 GROUP BY를 사용해야만 하는 경우</h1>
	<select name="dept">
		<option value="">===선택===</option>
		<%
			for(HashMap<String, Integer> m: groupByList) {
		%>
		<option value='<%=m.get("deptNo")%>'>
				<%=m.get("deptNo")%>(<%=m.get("cnt")%>명)
		</option>
		<%	
			}
		%>
	</select>
</body>
</html>