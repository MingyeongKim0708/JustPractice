<%@page import="bean.BbsVO"%>
<%@page import="bean.BbsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
    jsp에서 해야하는 작업 3가지
    1) 클라이언트로부터 전달되는 데이터 받기 ==> java
    2) 받은 데이터를 DAO에게 주자. ==> java
    3) 결과를 html로 만들어서 클라이언트로 전송 ==> html
     -->

<%
	// 자바코드를 쭉 쓰면됨. 스크립트릿(let, flt ==> 작은 프로그램, 작은 코드 블럭)
	//form안에 입력한 데이터 받아서 저장해두자.
	//HttpSurvletRequest request = new HttpSurvletRequest();
	//미리 톰킷에서 자주 사용하는 부품은 new를 이용해서 객체를 만들어놨음
	//미리 만들어서 제공하는 객체(부품) ==> 내장된 객체
	//클라이언트로부터 데이터를 받아오는 객체 ==> request
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String writer = request.getParameter("writer");
	
	//2. DAO에 데이터를 주소 db처리 요청
	BbsDAO dao = new BbsDAO();
	
	BbsVO bag = new BbsVO();
	
	bag.setTitle(title);
	bag.setContent(content);
	bag.setWriter(writer);
	
	dao.insert(bag);
	
	//3. 결과를 html로 만들어서 클라이언트에 전송
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BBS INSERT JSP</title>
<style>
* {
	font-family: "마루 부리";
	font-size: 20px;
}
a {
	color: blue;
	text-decoration: none;
	cursor: pointer;
}

a:hover {
	color: red;
	text-decoration: none;
}
</style>
</head>
<body bgcolor="lavender">
<h5>게시물 작성 완료</h5>
<hr color = "blue">
게시물 제목은 <%= title %><br>
게시물 내용은 <%= content %><br>
게시물 작성자는 <%= writer %> 입니다. <br><br>
<a href="index.html">첫 페이지로</a><br>
<a href="bbs.html">게시판정보 페이지로</a>
</body>
</html>