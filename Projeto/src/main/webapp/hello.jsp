<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exemplo de JSP</title>
</head>
<body>
<h1>Cabeçalho</h1>
<%
String mensagem = "Teste JSP";
out.println(mensagem);
%>
<br/>
<%=mensagem%>
<%System.out.println("Onde vai isto?"); %>
</body>
</html>