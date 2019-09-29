package com.pessoa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pessoa.model.PessoaModel;
import com.pessoa.service.PessoaService;

@Controller
@RequestMapping(value="/pessoa")
public class PessoaController {

	@Autowired
	PessoaService pessoaService;
	
	@RequestMapping(value="/list", method= RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("pessoa/pessoa_page");
		List<PessoaModel> list = pessoaService.listaPessoas();
		model.addObject("listaPessoa",list);
		return model;
	}
	@RequestMapping(value="/add", method= RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView model = new ModelAndView("pessoa/pessoa_form");
		PessoaModel pessoa = new PessoaModel();		
		model.addObject("pessoaForm",pessoa);
		return model;
	}
	@RequestMapping(value="/update/{id}", method= RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") int id) {
		ModelAndView model = new ModelAndView("pessoa/pessoa_form");
		PessoaModel pessoa = pessoaService.findUserById(id);		
		model.addObject("pessoaForm",pessoa);
		return model;
	}
	@RequestMapping(value="/save", method= RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("pessoaForm") PessoaModel pessoa) {		
		if(pessoa != null && pessoa.getId() != null) {
			//update
			pessoaService.updatePessoa(pessoa);
		}else {
			//add
			pessoaService.addPessoa(pessoa);
		}
		return new ModelAndView("redirect:/pessoa/list");
	}
	@RequestMapping(value="/delete/{id}", method= RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") int id) {
		pessoaService.deletarPessoa(id);		
		return new ModelAndView("redirect:/pessoa/list");
	}
}
