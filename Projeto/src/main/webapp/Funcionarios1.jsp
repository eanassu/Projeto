<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:import url="cabecalho.jsp"/>
<jsp:useBean id="dao" class="br.com.vemprafam.dao.DaoFuncionario"/>
<table border="1">
<tr>
<th>RE</th><th>nome</th><th>salário</th><th>nascimento</th>
</tr>
<c:forEach var="funcionario" items="${dao.funcionarios}">
<tr>
<td>${funcionario.re}</td>
<td>${funcionario.nome}</td>
<td><fmt:formatNumber value="${funcionario.salario}" 
	type="currency"/></td>
<td><fmt:formatDate value="${funcionario.dataNascimento}" 
   pattern="dd/MM/yyyy"/></td>
</tr>
</c:forEach>
</table>
<a href="/Projeto">voltar</a><br/>
<c:import url="rodape.jsp"/>
</body>
</html>