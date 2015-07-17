<%@ page 	import ="	java.util.*,br.com.caelum.jdbc.dao.ContatoDao,
					br.com.caelum.jdbc.modelo.*,
					java.text.SimpleDateFormat,
					javax.servlet.jsp.jstl.core.*"
					
			language="java" contentType="text/html; charset=ISO-8859-1"
    		pageEncoding="ISO-8859-1"%>
    		
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
    			
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
	.table{
   		border: 1px solid black;
   		max-height: 1px;
	}
	
	.table td{
		border: 1px solid black;
   		max-height: 1px;
	}
	
	.table tr{
		border: 1px solid black;
   		max-height: 1px;
	}
	
	.table th{
		border: 1px solid black;
   		max-height: 1px;
	}
	
</style>

</head>
<body>

<!-- 		Cabeçalho -->
	
	<table id="listaContatos" border="1" bordercolor="1" >	
		<tr>
		<th>ID</th>
		<th>Nome</th>
		<th>Email</th>
		<th>Endereço</th>
		<th>Data de Nascimento</th>
		</tr>
		
		<c:forEach var="contato" items="${contatos}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
				<td>${id.count}</td>
				<td>${contato.nome}</td>				
				<td>
<%-- 					<c:if test="${not empty contato.email}"> --%>
<%-- 						<a href="mailto:${contato.email}">${contato.email}</a> --%>
<%-- 					</c:if> --%>
<%-- 					<c:if test="${empty contato.email}"> --%>
<!-- 						E-mail não informado -->
<%-- 					</c:if> --%>
					
					<c:choose>
						<c:when test="${not empty contato.email}">
							<a href="mailto:${contato.email}">${contato.email}</a>
						</c:when>
						<c:otherwise>
							E-mail não informado
						</c:otherwise>
					</c:choose>
					
				</td>
				<td>${contato.endereco}</td>
				<td>
					<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" />
				</td>
				<td>
					<a href="mvc?logica=IniciaAlteraContatoLogic&id=${contato.id}&nome=${contato.nome}
								&email=${contato.email}&endereco=${contato.endereco}
								&dataNascimento=${contato.dataNascimento.time}">Alterar</a>
				</td>
				<td>
					<a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a>
				</td>
			</tr>
		</c:forEach>			
	</table>
	<br/>

<%-- 	<% 
	request.setAttribute( "teste", contato); 
	%>

	<display:table name="teste" class="table">
	   	<display:column property="id" sortable="true" title="ID" />
	   	<display:column property="nome" title="Nome" />
	   	<display:column property="email" title="Email" />
	   	<display:column property="endereco" title="Endereço" />
	    <display:column property="dataNascimento.time" format="{0,date,dd-MM-yyyy}" sortable="true" title="Data de Nascimento" />
    </display:table> --%>
    
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/> 
	<c:import url="rodape.jsp" />	
</body>
</html>