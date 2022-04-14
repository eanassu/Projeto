package br.com.vemprafam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.vemprafam.pojo.Funcionario;

public class DaoFuncionario {
	private Connection conn;
	private String url = "jdbc:hsqldb:hsql://localhost/";
	public DaoFuncionario() {
		super();
		try {
			conn = DriverManager.getConnection(url,"SA","");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public List<Funcionario> getFuncionarios() {
		List<Funcionario> result = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(
				"SELECT re,nome,salario,datanascimento from funcionarios");
			ResultSet rs = pstmt.executeQuery();
			while( rs.next() ) {
				result.add(new Funcionario(rs.getInt(1),
						rs.getString(2),rs.getDouble(3),rs.getDate(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return result;
	}
	public void inserirFuncionario(Funcionario funcionario) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(
					"INSERT INTO funcionarios values(?,?,?,?)");
			pstmt.setInt(1, funcionario.getRe());
			pstmt.setString(2, funcionario.getNome());
			pstmt.setDouble(3, funcionario.getSalario());
			pstmt.setDate(4, 
			new java.sql.Date(funcionario.getDataNascimento().getTime()));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
	}
}
