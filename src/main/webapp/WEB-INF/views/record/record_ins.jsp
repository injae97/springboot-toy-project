<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Record Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  </head>
  <body class="text-center">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
  
    <%@ include file="/WEB-INF/views/common/header.jsp" %> 
    
    <!-- 게시글 등록화면 페이지 -->
    <!-- 등록하기 버튼 클릭시 action의 /record_reg/insert_exe로 이동함  -->
    <!-- ★★★ record_reg.java Controller에서 @RequestMapping("record_reg") + @PostMapping("/insert_exe") 를 더해서 action에 기입 ★★★ -->
    <form name="form_record_mod" action="/record_reg/insert_exe" method="post">
        <div>keyId: <input type="text" name="keyId" value="자동입력" readonly></div><br>
        <div>StudyDay: <input type="text" name="StudyDay" value=""></div><br>
        <div>Contents: <input type="text" name="contents" size="70" value=""></div><p>
              
        <br><input type="submit" value="등록하기"> 
    </form>
        
    <%@ include file="/WEB-INF/views/common/footer.jsp" %>
  </body>
</html>