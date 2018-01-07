<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Novo Cadastro</title>
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
	<div class="container">
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

		<s:form action="confirmarAlteracao" method="post"
			style="padding-top: 50px;">
			<fieldset>
				<legend>Alteração de Dados Cadastrais</legend>

				<div class="row">
					<div class="form-group col-md-1">
						<label for="nome">Código</label> <input
							class="form-control text-center" id="nome" name="contato.codigo"
							value="${contato.codigo}" readonly="readonly" />
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">
						<label for="nome">Nome</label> <input class="form-control"
							id="nome" name="contato.nome"
							placeholder="Digite o nome completo" value="${contato.nome}" />
					</div>
					<div class="form-group col-md-2">
						<label for="telefone">Telefone</label> <input class="form-control"
							id="nome" name="contato.telefone" placeholder="Digite o telefone"
							value="${contato.telefone}" />
					</div>
					<div class="form-group col-md-10">
						<label for="endereco">Endereço</label> <input class="form-control"
							id="txtEndereco" name="contato.rua"
							placeholder="Digite o endereço" value="${contato.rua}" />
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-6">
						<label for="bairro">Bairro</label> <input class="form-control"
							id="txtBairro" name="contato.bairro"
							placeholder="Digite o bairro" value="${contato.bairro}" />
					</div>
					<div class="form-group col-md-6">
						<label for="cidade">Cidade</label> <select class="form-control"
							id="estado-endereco" name="contato.endereco.codigo"
							required="required">
							<option value="${contato.endereco.cidade}"></option>
							<c:forEach items="${listaCidades}" var="cidade">
								<option value="${cidade.codigo}"
									${contato.endereco.codigo == cidade.codigo ? 'selected' : ''}>${cidade.cidade}</option>
							</c:forEach>
						</select>
						<!--<a href="#">
							<span class="glyphicon glyphicon-plus-sign"></span>
						</a>-->
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">
						<label for="lblEmail">Email</label> <input class="form-control"
							id="txtEmail" name="contato.email" placeholder="Digite o email"
							value="${contato.email}" />
					</div>
				</div>

				<hr />

				<div class="row">
					<div class="col-md-12">
						<button type="submit" class="btn btn-default">Alterar
							Dados</button>
						<s:a action="listarContatos" class="btn btn-default">Cancelar</s:a>
					</div>
				</div>
			</fieldset>
		</s:form>
	</div>
</body>
</html>