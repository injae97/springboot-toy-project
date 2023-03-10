<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!doctype html>    
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  </head>
  <body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    
    <%@ include file="/WEB-INF/views/common/header.jsp" %>
    
    <!-- Headers -->  
    <div class="px-4 py-5 my-5 text-center">
	    <img class="d-block mx-auto mb-4" src="/img/cat.jpg">
	    <h1 class="display-5 fw-bold">Centered hero</h1>
	    <div class="col-lg-6 mx-auto">
	      <p class="lead mb-4">Spring boot + JSP + Mybatis(Oracle) + Spring Tool Suite(IDE)</p>
	      Java version: 1.8<br> 
	      dev tools: Spring Tool Suite (IDE)<br>
	      DBMS: Oracle<br>
	      View: jsp<br>
	      Mapper: Mybatis<br><br><br>
	      <div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
	        <button type="button" class="btn btn-primary btn-lg px-4 gap-3">Primary button</button>
	        <button type="button" class="btn btn-outline-secondary btn-lg px-4">Secondary</button>
	      </div>
        </div>
    </div>
    <!-- Headers -->   
    
    <%@ include file="/WEB-INF/views/common/footer.jsp" %>
  </body>
</html>