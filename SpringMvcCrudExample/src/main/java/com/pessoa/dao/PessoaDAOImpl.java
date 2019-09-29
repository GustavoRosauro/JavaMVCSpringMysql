package com.pessoa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.pessoa.model.PessoaModel;

@Repository
public class PessoaDAOImpl implements PessoaDAO {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}	
		public List<PessoaModel> listaPessoas() {
		String sql = "SELECT ID,NOME,IDADE FROM PESSOA";
		
		List<PessoaModel> lista = namedParameterJdbcTemplate.query(sql, getSqlParameterbyModel(null), new PessoaMapper());		
		return lista;
	}
	private SqlParameterSource getSqlParameterbyModel(PessoaModel pessoa) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if(pessoa != null) {
			paramSource.addValue("id", pessoa.getId());
			paramSource.addValue("nome", pessoa.getNome());
			paramSource.addValue("idade", pessoa.getIdade());
		}
		return paramSource;
	}
	
	private static final class PessoaMapper implements RowMapper<PessoaModel>{
		public PessoaModel mapRow(ResultSet rs, int rowNum) throws SQLException{
			PessoaModel pessoa = new PessoaModel();
			pessoa.setId(rs.getInt("ID"));
			pessoa.setNome(rs.getString("NOME"));
			pessoa.setIdade(rs.getInt("IDADE"));
			return pessoa;
		}
	}

	public void addPessoa(PessoaModel pessoa) {
		String sql = "INSERT INTO PESSOA (NOME,IDADE) VALUES(:nome, :idade)";
		namedParameterJdbcTemplate.update(sql, getSqlParameterbyModel(pessoa));
	}

	public void updatePessoa(PessoaModel pessoa) {
		String sql = "UPDATE PESSOA SET NOME = :nome, IDADE = :idade WHERE ID = :id";
		namedParameterJdbcTemplate.update(sql, getSqlParameterbyModel(pessoa));
	}

	public void deletarPessoa(int id) {
		String sql = "DELETE FROM PESSOA WHERE ID = :id";
		namedParameterJdbcTemplate.update(sql, getSqlParameterbyModel(new PessoaModel(id)));
	}

	public PessoaModel findUserById(int id) {
		String sql = "SELECT ID,NOME,IDADE FROM PESSOA WHERE ID = :id";
		return namedParameterJdbcTemplate.queryForObject(sql,getSqlParameterbyModel(new PessoaModel(id)), new PessoaMapper());
	}

}
