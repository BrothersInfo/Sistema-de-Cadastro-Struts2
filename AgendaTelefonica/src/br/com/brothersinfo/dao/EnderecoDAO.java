package br.com.brothersinfo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.brothersinfo.bean.Endereco;
import br.com.brothersinfo.util.FabricaConexao;

public class EnderecoDAO {

	public boolean salvar(Endereco endereco) {
		boolean valor = false;
		PreparedStatement ps = null;
		String SQL = "INSERT INTO endereco (cidade) VALUES(?)";
		try {
			ps = FabricaConexao.getConexao().prepareStatement(SQL);
			ps.setString(1, endereco.getCidade());
			ps.executeUpdate();
			valor = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			FabricaConexao.desconectar();
		}
		return valor;
	}

	public boolean alterar(Endereco endereco) {
		boolean valor = false;
		PreparedStatement ps = null;
		String SQL = "UPDATE endereco SET cidade = ? WHERE codigo = ?";
		try {
			// ps = FabricaConexao.getConexao().prepareStatement(SQL);
			ps = FabricaConexao.getConexao().prepareStatement(SQL);
			ps.setString(1, endereco.getCidade());
			ps.setLong(2, endereco.getCodigo());
			ps.executeUpdate();
			valor = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			FabricaConexao.desconectar();
		}
		return valor;
	}

	public boolean excluir(Long codigo) {
		boolean valor = false;
		PreparedStatement ps = null;
		String SQL = "DELETE FROM endereco WHERE codigo = ?";
		try {
			// ps = FabricaConexao.getConexao().prepareStatement(SQL);
			ps = FabricaConexao.getConexao().prepareStatement(SQL);
			ps.setLong(1, codigo);
			ps.executeUpdate();
			valor = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			FabricaConexao.desconectar();
		}
		return valor;
	}

	public List<Endereco> listarEndereco(String nomeCidade) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String SQL = null;
		if (nomeCidade == null || nomeCidade.isEmpty()) {
			SQL = "SELECT * FROM endereco LIMIT 50";
		} else {
			SQL = "SELECT * FROM endereco WHERE cidade LIKE '" + nomeCidade + "%' LIMIT 50";
		}

		List<Endereco> enderecos = new ArrayList<>();
		try {
			// ps = FabricaConexao.getConexao().prepareStatement(SQL);
			ps = FabricaConexao.getConexao().prepareStatement(SQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				Endereco endereco = new Endereco();
				endereco.setCidade(rs.getString("cidade"));
				endereco.setCodigo(rs.getLong("codigo"));
				enderecos.add(endereco);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			FabricaConexao.desconectar();
		}
		return enderecos;
	}

	public Endereco pegarCidadePeloCodigo(Long codigo) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String SQL = "SELECT * FROM endereco WHERE codigo = ?";
		Endereco endereco = null;
		try {
			// ps = FabricaConexao.getConexao().prepareStatement(SQL);
			ps = FabricaConexao.getConexao().prepareStatement(SQL);
			ps.setLong(1, codigo);
			rs = ps.executeQuery();
			if (rs.next()) {
				endereco = new Endereco();
				endereco.setCidade(rs.getString("cidade"));
				endereco.setCodigo(rs.getLong("codigo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			FabricaConexao.desconectar();
		}
		return endereco;
	}

	public Endereco buscarEnderecoCodigoContato(Long codigo) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String SQL = "SELECT * FROM endereco WHERE codigo = ?";
		Endereco endereco = null;
		try {
			// ps = FabricaConexao.getConexao().prepareStatement(SQL);
			ps = FabricaConexao.getConexao().prepareStatement(SQL);
			ps.setLong(1, codigo);
			rs = ps.executeQuery();
			if (rs.next()) {
				endereco = new Endereco();
				endereco.setCidade(rs.getString("cidade"));
				endereco.setCodigo(rs.getLong("codigo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			FabricaConexao.desconectar();
		}
		return endereco;
	}

}
