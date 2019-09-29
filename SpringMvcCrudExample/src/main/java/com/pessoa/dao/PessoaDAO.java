package com.pessoa.dao;

import java.util.List;

import com.pessoa.model.PessoaModel;

public interface PessoaDAO {

		public List<PessoaModel> listaPessoas();
		
		public void addPessoa(PessoaModel pessoa);
		
		public void updatePessoa(PessoaModel pessoa);
		
		public void deletarPessoa(int id);
		
		public PessoaModel findUserById(int id);
}
