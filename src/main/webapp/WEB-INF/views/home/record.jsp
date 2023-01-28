<%@page import="com.spring.boot.vo.Vo_record"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<%-- request 부분을 받아야 되기 때문에 Controller-type을 똑같이 받으면 됨 (returntype : MAP)
<%
	List<Map<String, String>> list = (List<Map<String, String>>) request.getAttribute("list");
%> 
--%>

<%
	List<Vo_record> list = (List<Vo_record>) request.getAttribute("list");
%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Record Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  </head>
  <body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
  
    <%@ include file="/WEB-INF/views/common/header.jsp" %>
  
    <!-- grid -->  
    <div class="container">
    
		<%--  return type : Map  		
		<% for(Map<String, String> map: list) { %>
        <div class="row mb-3">
            <div class="col"><%= map.get("KEY_ID") %></div>
            <div class="col"><%= map.get("STUDY_DAY") %></div>
            <div class="col"><%= map.get("CONTENTS") %></div>
            <div class="col"><%= map.get("REG_DAY") %></div>
        </div>
        <% } %> 
        --%>
		
		<!-- returnType : VO 객체  -->
		<% for(Vo_record vo_record : list) { %>
        <div class="row mb-3">
            <div class="col"><%= vo_record.getKEY_ID() %></div>
            <div class="col"><%= vo_record.getSTUDY_DAY() %></div>
            <div class="col"><%= vo_record.getCONTENTS() %></div>
            <div class="col"><%= vo_record.getREG_DAY() %></div>
        </div>
        <% } %>

        <div class="row mb-3">
            <div class="col">No(VO-Lombok use)</div>
            <div class="col">공부일자</div>
            <div class="col">공부내용</div>
            <div class="col">등록일자</div>
        </div>
    </div>
    <!-- grid --> 
    
    <%@ include file="/WEB-INF/views/common/footer.jsp" %>
  </body>
</html>