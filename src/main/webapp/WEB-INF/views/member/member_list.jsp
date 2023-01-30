<%@ page import="java.util.List" %>
<%@ page import="com.spring.boot.vo.Vo_member" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Vo_member> list = (List<Vo_member>) request.getAttribute("list");
%>

<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Home!</title>
</head>
<body>

<!-- 헤더 위치 -->
	<%@ include file="/WEB-INF/views/common/header.jsp" %>

<main>
    <div class="container">
        <div class="row mb-2">
            <div class="col">아이디</div>
            <div class="col">이름</div>
            <div class="col">권한</div>
            <div class="col">등록일자</div>
            <div class="col">회원삭제</div>
        </div>

        <%  for(Vo_member vo_member : list){  %>
        <div class="row mb-2">
            <div class="col"><%= vo_member.getLoginId() %></div>
            <div class="col"><%= vo_member.getName() %></div>
            <div class="col"><%= vo_member.getRole() %></div>
            <div class="col"><%= vo_member.getRegDay() %></div>
            <div class="col"><a href="/member/delete?key_id=<%= vo_member.getMemberId() %>">삭제</a></div>
        </div>
        <% } %>

    </div>
</main>

<!-- 푸터 위치 -->
<%@ include file="/WEB-INF/views/common/footer.jsp" %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>