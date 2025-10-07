package br.senac.sp.sus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.senac.sp.sus.model.BancoSangue;

public class BancoSangueDao implements InterfaceDao<BancoSangue> {
	private Connection conexao;
	private String sql;
	private PreparedStatement stmt;


	public BancoSangueDao(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public void inserir(BancoSangue banco) throws SQLException {
		sql = "insert into banco_sangue (nome, cnpj, email, telefone, endereco) values (?,?,?,?,?)";
		stmt = conexao.prepareStatement(sql);
		stmt.setString(1, banco.getNome());
		stmt.setString(2, banco.getCnpj());
		stmt.setString(3, banco.getEmail());
		stmt.setString(4, banco.getTelefone());
		stmt.setString(5, banco.getEndereco());
		stmt.execute();
		stmt.close();
	}

	@Override
	public void alterar(BancoSangue objeto) throws SQLException {
		sql = "update banco_sangue set nome = ?, cnpj = ?, email = ?, telefone = ?, endereco = ? where id = ?";
		stmt = conexao.prepareStatement(sql);
		stmt.setString(1, objeto.getNome());
		stmt.setString(2, objeto.getCnpj());
		stmt.setString(3, objeto.getEmail());
		stmt.setString(4, objeto.getTelefone());
		stmt.setString(5, objeto.getEndereco());
		stmt.setInt(6, objeto.getId());
		stmt.execute();
		stmt.close();
	}

	@Override
	public void excluir(int id) throws SQLException {
		sql = "delete from banco_sangue where id = ?";
		stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.execute();
		stmt.close();
	}

	@Override
	public List<BancoSangue> listar() throws SQLException {
		sql = "select * from banco_sangue";
		List<BancoSangue> lista = new ArrayList<>();
		stmt = conexao.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while(rs.next()) {
			BancoSangue b = new BancoSangue();
			b.setId(rs.getInt("id"));
			b.setNome(rs.getString("nome"));
			b.setEmail(rs.getString("email"));
			b.setCnpj(rs.getString("cnpj"));
			b.setTelefone(rs.getString("telefone"));
			b.setEndereco(rs.getString("endereco"));
			lista.add(b);
		}
		rs.close();
		stmt.close();
		return lista;
	}

}
