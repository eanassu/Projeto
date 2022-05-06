<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Funcionários</title>
</head>
<body>
<c:import url="cabecalho.jsp"/>
<jsp:useBean id="dao" class="br.com.vemprafam.dao.DaoFuncionario"/>
<table border="1">
<tr>
<th>RE</th><th>nome</th><th>salário</th><th>nascimento</th><th>e-mail</th>
</tr>
<c:forEach var="funcionario" items="${dao.funcionarios}" varStatus="id">
<tr bgcolor="#${id.count%2==0?'aaee88':'ffffff' }">
<td>${funcionario.re}</td>
<td>${funcionario.nome}</td>
<td><fmt:formatNumber value="${funcionario.salario}" 
	type="currency"/></td>
<td><fmt:formatDate value="${funcionario.dataNascimento}" 
   pattern="dd/MM/yyyy"/></td>
<td>
<c:if test="${not empty funcionario.email}">
  	<a href="mailto:${funcionario.email}">${funcionario.email}</a>
</c:if>
<c:if test="${empty funcionario.email}">
	e-mail não informado
</c:if>
</td>
<td>
<a href="controle?re=${funcionario.re}&op=Excluir">excluir</a>
</td>
<td>
<a href="controle?re=${funcionario.re}&op=Alterar">alterar</a>
</td>


</tr>

</c:forEach>
</table>
<a href="/Projeto">voltar</a><br/>
<c:import url="rodape.jsp"/>
</body>
</html>