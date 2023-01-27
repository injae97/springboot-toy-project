<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <div class="container">
    <header class="d-flex flex-wrap align-items-center justify-content-center py-3 mb-4 border-bottom">
      <ul class="nav nav-pills">
        <li class="nav-item"><a href="/home" class="nav-link" aria-current="page">Home</a></li>
        <li class="nav-item"><a href="/home/record" class="nav-link">기록</a></li>
        <li class="nav-item"><a href="/home/member_list" class="nav-link">회원</a></li>
        <li class="nav-item"><a href="#" class="nav-link">About</a></li>
      </ul>
      
      <div class="col-md-3 text-end">
          <button type="button" class="btn btn-outline-primary me-2" onclick="location.href='/login/login'" >Login</button>
          <button type="button" class="btn btn-primary" onclick="location.href='/login/join'">Sign-up</button>
      </div>
    </header>
  </div>