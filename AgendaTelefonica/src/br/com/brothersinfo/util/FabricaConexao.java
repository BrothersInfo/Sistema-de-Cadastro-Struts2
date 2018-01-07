package br.com.brothersinfo.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.jndi.JndiTemplate;

public class FabricaConexao {

	private static Connection conexao = null;

	public static DataSource getDataSource() {
		DataSource dataSource = null;
		try {
			Properties brothers = new Properties();
			brothers.setProperty("sourceLegado", "java:jboss/sistema");
			JndiTemplate template = new JndiTemplate();
			dataSource = (DataSource) template.lookup(brothers.getProperty("sourceLegado"));
			System.out.println("BrothersInfo System - Conexão utilizando JNDI funcionando corretamente");
		} catch (NamingException ne) {
			System.out.println("ERRO\n" + ne.getMessage());
		}
		return dataSource;
	}

	public static Connection getConexao() {
		try {
			conexao = getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conexao;
	}

	public static void desconectar() {
		try {
			if (conexao != null) {
				conexao.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
