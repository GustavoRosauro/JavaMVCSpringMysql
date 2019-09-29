package com.pessoa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pessoa.dao.PessoaDAO;
import com.pessoa.model.PessoaModel;

@Service
public class PessoaServiceImpl implements PessoaService{

	PessoaDAO pessoaDAO;
	
	@Autowired
	public void setPessoa(PessoaDAO pessoa) {
		this.pessoaDAO = pessoa;
	}

	public List<PessoaModel> listaPessoas() {
		return pessoaDAO.listaPessoas();
	}

	public void addPessoa(PessoaModel pessoa) {
		pessoaDAO.addPessoa(pessoa);
	}

	public void updatePessoa(PessoaModel pessoa) {
		pessoaDAO.updatePessoa(pessoa);		
	}

	public void deletarPessoa(int id) {
		pessoaDAO.deletarPessoa(id);		
	}

	public PessoaModel findUserById(int id) {
		return pessoaDAO.findUserById(id);
	}

}
