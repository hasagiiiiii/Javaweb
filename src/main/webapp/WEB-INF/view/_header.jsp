<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <style>
.menu{
display:flex;
justify-content:space-around;
}
.menu li {
list-style: none
}
a{
text-decoration: none
}
</style>
<header>
	<ul class="menu">
		<li><a href="${pageContext.request.contextPath }/home">Home</a></li>
		<li><a href="${pageContext.request.contextPath }/About">About</a></li>
		<li><a href="${pageContext.request.contextPath }/product">Products</a></li>
		<li><a href="${pageContext.request.contextPath }/login">Login</a></li>
	</ul>
</header>