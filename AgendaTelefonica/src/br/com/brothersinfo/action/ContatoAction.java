package br.com.brothersinfo.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import br.com.brothersinfo.bean.Contato;
import br.com.brothersinfo.bean.Endereco;
import br.com.brothersinfo.dao.ContatoDAO;
import br.com.brothersinfo.dao.EnderecoDAO;

@Namespace("/paginas")
public class ContatoAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public Contato contato;
	public List<Contato> listaContatos;
	public List<Endereco> listaCidades;
	public Long codigoContato;
	public String nomeContato = null;
	public String INDRA = "VIVO";

	public String getNomeContato() {
		return nomeContato;
	}

	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}

	public Long getCodigoContato() {
		return codigoContato;
	}

	public void setCodigoContato(Long codigoContato) {
		this.codigoContato = codigoContato;
	}

	@Action(value = "salvarContato", results = { @Result(name = "success", location = "/paginas/listarContatos.jsp") })
	public String salvarContato() {
		ContatoDAO dao = new ContatoDAO();
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		dao.salvar(contato);
		listaContatos = dao.listarContatos(nomeContato);
		listaCidades = enderecoDAO.listarEndereco(null);
		return SUCCESS;
	}

	@Action(value = "novoContato", results = { @Result(name = "success", location = "/paginas/novoContato.jsp") })
	public String novoContato() {
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		listaCidades = enderecoDAO.listarEndereco(null);
		return SUCCESS;
	}

	@Action(value = "alterarContato", results = {
			@Result(name = "success", location = "/paginas/alterarCadastro.jsp") })
	public String alteraContato() {
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		ContatoDAO dao = new ContatoDAO();
		listaCidades = enderecoDAO.listarEndereco(null);
		contato = new Contato();
		contato = dao.pegarContatoPeloCodigo(codigoContato);
		return SUCCESS;
	}

	@Action(value = "confirmarAlteracao", results = {
			@Result(name = "success", location = "/paginas/listarContatos.jsp") })
	public String confirmarAlteracao() {
		ContatoDAO dao = new ContatoDAO();
		dao.alterar(contato);
		listaContatos = dao.listarContatos(nomeContato);
		return SUCCESS;
	}

	@Action(value = "listarContatos", results = { @Result(name = "success", location = "/paginas/listarContatos.jsp") })
	public String listarContatos() {
		ContatoDAO dao = new ContatoDAO();
		listaContatos = dao.listarContatos(nomeContato);
		return SUCCESS;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public List<Contato> getListaContatos() {
		return listaContatos;
	}

	public void setListaContatos(List<Contato> listaContatos) {
		this.listaContatos = listaContatos;
	}

	public List<Endereco> getListaCidades() {
		return listaCidades;
	}
}
