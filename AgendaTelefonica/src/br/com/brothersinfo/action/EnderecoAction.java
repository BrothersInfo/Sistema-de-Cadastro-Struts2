package br.com.brothersinfo.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import br.com.brothersinfo.bean.Endereco;
import br.com.brothersinfo.dao.EnderecoDAO;

public class EnderecoAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public Endereco cidade;
	public List<Endereco> listaCidades;
	public Long codigoCidade;
	public String nomeCidade;

	@Action(value = "listarCidades", results = { @Result(name = "success", location = "/paginas/listarCidades.jsp") })
	public String listarEnderecos() {
		System.out.println("jQuery.:");
		EnderecoDAO dao = new EnderecoDAO();
		listaCidades = dao.listarEndereco(nomeCidade);
		return SUCCESS;
	}

	public String listar() {
		EnderecoDAO dao = new EnderecoDAO();
		listaCidades = dao.listarEndereco(nomeCidade);
		return SUCCESS;
	}

	@Action(value = "alterarCidade", results = { @Result(name = "success", location = "/paginas/alterarCidade.jsp") })
	public String alterarCidade() {
		EnderecoDAO dao = new EnderecoDAO();
		cidade = new Endereco();
		cidade = dao.pegarCidadePeloCodigo(codigoCidade);
		return SUCCESS;
	}

	@Action(value = "salvarCidade", results = { @Result(name = "success", location = "/paginas/listarCidades.jsp") })
	public String salvarCidade() {
		EnderecoDAO dao = new EnderecoDAO();
		dao.salvar(cidade);
		listaCidades = dao.listarEndereco(nomeCidade);
		return SUCCESS;
	}

	@Action(value = "novaCidade", results = { @Result(name = "success", location = "/paginas/novaCidade.jsp") })
	public String novaCidade() {
		return SUCCESS;
	}

	@Action(value = "confirmarAlteracaoCidade", results = {
			@Result(name = "success", location = "/paginas/listarCidades.jsp") })
	public String confirmarAlteracaoCidade() {
		EnderecoDAO dao = new EnderecoDAO();
		dao.alterar(cidade);
		listaCidades = dao.listarEndereco(nomeCidade);
		return SUCCESS;
	}

	@Action(value = "demo1")
	public void demo1() {
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = response.getWriter();

			out.print("BrothersInfo Informática...");
			out.flush();
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Long getCodigoCidade() {
		return codigoCidade;
	}

	public void setCodigoCidade(Long codigoCidade) {
		this.codigoCidade = codigoCidade;
	}

	public Endereco getCidade() {
		return cidade;
	}

	public void setCidade(Endereco cidade) {
		this.cidade = cidade;
	}

	public List<Endereco> getListaCidades() {
		return listaCidades;
	}

	public void setListaCidades(List<Endereco> listaCidades) {
		this.listaCidades = listaCidades;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
}
