package com.example.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.cobranca.model.StatusTitulo;
import com.example.cobranca.model.Titulo;
import com.example.cobranca.repository.Titulos;
import com.example.cobranca.service.CadastroTituloService;

@Controller
@RequestMapping("/titulos")
public class TituloController {

	private static final String CADASTRO_VIEW = "CadastroTitulo"; 
	
	@Autowired
	private Titulos titulos;
	
	@Autowired
	private CadastroTituloService cadastroTituloService;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Titulo());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Titulo titulo, Errors errors, RedirectAttributes attribute){
		if(errors.hasErrors()) {
			return CADASTRO_VIEW;
		}
		
		try {
			cadastroTituloService.salvar(titulo);		
			attribute.addFlashAttribute("mensagem", "Título salvo com sucesso!");
			return "redirect:/titulos/novo";
		} catch(DataIntegrityViolationException e) {
			errors.rejectValue("dataVencimento", null, e.getMessage());
			return CADASTRO_VIEW;
		}
	}
	
	@RequestMapping
	public ModelAndView pesquisar() {
		List<Titulo> todosTitulos = titulos.findAll();
		ModelAndView mv = new ModelAndView("PesquisaTitulos");
		mv.addObject("titulos", todosTitulos);
		return mv;
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Titulo titulo) {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(titulo);
		return mv;
	}
	
	@RequestMapping(value = "{codigo}",method = RequestMethod.DELETE)
	public String excluir(@PathVariable long codigo, RedirectAttributes attribute) {
		cadastroTituloService.excluir(codigo);
		attribute.addFlashAttribute("mensagem", "Título excluído com sucesso!");
		return "redirect:/titulos";
	}
	

	@RequestMapping(value = "/{codigo}/receber", method = RequestMethod.PUT)
	public String receber(@PathVariable Long codigo) {
		System.out.println("codig >>> " + codigo);
		return "ok";		
	}
	
	@ModelAttribute("statusTitulos")
	public List<StatusTitulo> todosStatusTitulos(){
		return Arrays.asList(StatusTitulo.values());
	}

}
