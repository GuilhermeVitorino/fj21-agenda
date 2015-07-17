<%@ page 	import ="	java.util.*,br.com.caelum.jdbc.dao.ContatoDao,
					br.com.caelum.jdbc.modelo.*,
					java.text.SimpleDateFormat,
					javax.servlet.jsp.jstl.core.*"
					
			language="java" contentType="text/html; charset=ISO-8859-1"
    		pageEncoding="ISO-8859-1"%>
    		
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<c:import url="cabecalho.jsp" />
<!DOCTYPE html>
<html>
<head>
	<link href="jquery-ui-1.11.2.custom/jquery-ui.css" rel="stylesheet">
	<script src="jquery-ui-1.11.2.custom/external/jquery/jquery.js"></script>
	<script src="jquery-ui-1.11.2.custom/jquery-ui.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function alteraScript(){
	var id = document.getElementById("id").value;
	var nome = document.getElementById("nome").value;
	var email = document.getElementById("email").value;
	var endereco = document.getElementById("endereco").value;
	var dataNascimento = document.getElementById("dataNascimento").value;
		 
	document.location.href = "mvc?logica=AlteraContatoLogic&id="+id+"&nome="+nome+
		"&email="+email+"&endereco="+endereco+
		"&dataNascimento="+dataNascimento
}
</script>
</head>
<body>
	<form method="post">
		Id: <input type="text" id="id" name="id" value="${id}" disabled/><br /> 
		Nome: <input type="text" id="nome" name="nome" value="${nome}"/><br />	
		E-mail: <input type="text" id="email" name="email" value="${email}"/><br />	
		Endereço: <input type="text" id="endereco" name="endereco" value="${endereco}"/><br />	
		Data Nascimento: <input type="text" id="dataNascimento" name="dataNascimento" value="${dataNascimento}">
		<input type="button" value="Gravar" onclick="alteraScript();">
	</form>
	<c:import url="rodape.jsp" />	
</body>
</html>
