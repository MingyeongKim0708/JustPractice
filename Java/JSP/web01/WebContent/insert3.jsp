<%@page import="bean.ProductVO"%>
<%@page import="bean.ProductDAO"%>
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
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String content = request.getParameter("content");
	String price = request.getParameter("price");
	String company = request.getParameter("company");
	String img = request.getParameter("img");

	//2. DAO에 데이터를 주소 db처리 요청
	ProductDAO dao = new ProductDAO();

	ProductVO bag = new ProductVO();

	bag.setId(id);
	bag.setName(name);
	bag.setContent(content);
	bag.setPrice(Integer.parseInt(price)); //int->String
	bag.setCompany(company);
	bag.setImg(img);

	dao.insert(bag);

	//3. 결과를 html로 만들어서 클라이언트에 전송
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PRODUCT INSERT JSP</title>
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
	<h5>상품 등록 완료</h5>
	<hr color="blue">
	상품 아이디는 <%=id%> <br>
	상품 이름은 <%=name%><br>
	상품 내용은 <%=content%><br>
	상품 가격은 <%=price%><br>
	상품 회사는 <%=company%><br>
	상품 이미지는 <%=img%> 입니다.<br><br>
	<a href="index.html">첫 페이지로</a><br>
	<a href="product.html">상품정보 페이지로</a>
</body>
</html>