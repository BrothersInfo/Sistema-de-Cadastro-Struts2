<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Agenda de Contatos</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<div id="main" class="container">
		<nav class="navbar navbar-inverse navbar-fixed-top"
			style="padding-top: 80px;">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand"
						href="http://localhost:8080/AgendaTelefonica">Agenda de
						Contatos V1.0</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><s:a action="novoContato">Novo Contato</s:a></li>
						<li><s:a action="listarContatos">Listar Contatos</s:a></li>
						<li><s:a action="novaCidade">Cadastrar Cidades</s:a></li>
						<li><s:a action="listarCidades">Listar Cidades</s:a></li>
						<li><a href="listarContatos">Sair</a></li>
					</ul>
				</div>
			</div>
		</nav>

		<s:form id="formu" style="padding-top: 50px;" method="post"
			action="listarContatos">
			<fieldset>
				<legend>Listagem de Contatos Cadastrados no Sistema</legend>

				<div class="row">
					<div class="col-md-6" style="padding-right: 0px;">
						<input type="text" class="form-control" id="pesquisar"
							name="nomeContato"
							placeholder="Digite o nome do contato para pesquisar">
					</div>
					<button type="submit" class="btn btn-default">Buscar</button>
				</div>

				<table class="table table-condesed table-hover">
					<tr>
						<th>Código</th>
						<th>Nome do Contato</th>
						<!--<th>Rua</th>
					<th>Bairro</th>
					<th>Cidade</th>-->
						<th>Telefone</th>
						<th>Email</th>
						<th colspan="2" style="width: 5%;">OPÇÕES</th>
					</tr>
					<s:iterator var="c" value="listaContatos">
						<s:url id="url" action="alterarContato">
							<s:param name="codigoContato" value="codigo" />
						</s:url>
						<tr>
							<td>${c.codigo}</td>
							<td>${c.nome}</td>
							<td>${c.telefone}</td>
							<td>${c.email}</td>
							<td class="btn btn-default"><s:a href="%{url}"
									style="text-decoration:none">ALTERAR</s:a></td>
						</tr>
					</s:iterator>
				</table>
			</fieldset>
		</s:form>
	</div>
</body>
</html>