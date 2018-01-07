package br.com.brothersinfo.bean;

public class Endereco {
	private Long codigo;
	private String cidade;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "Endereco [codigo=" + codigo + ", cidade=" + cidade + "]";
	}

}
