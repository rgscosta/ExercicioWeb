package br.com.ifpe.aulaweb.contato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/contatos")
public class ContatoController {

	@Autowired
	private ContatoService service;
	
	@GetMapping("/")
	public ModelAndView listarContatos() {
		ModelAndView mv = new ModelAndView("contato/contatos-list");
		mv.addObject("lista", service.listarTodos());
		return mv;
	}
	
	@GetMapping("/novo")
	public String exibirForm(@ModelAttribute Contato contato) {
		return "contato/contato-form";
	}
	
	@PostMapping("/salvar")
	public String salvarContato(@Valid @ModelAttribute Contato contato, 
			Errors result) {
		if(result.hasErrors()) {
			return "contato/contato-form";
		}
		service.salvarContato(contato);
		return "redirect:/contatos/";
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView exibirEdicao(@PathVariable("id") int id) {
		Contato cont = service.buscarPorId(id);
		ModelAndView mv = new ModelAndView("contato/contato-form");
		mv.addObject("contato", cont);
		return mv;
	}

	@GetMapping("/remover/{id}")
	public ModelAndView remover(@PathVariable("id") int id) {
		service.excluir(id);
		return listarContatos();
	}

}
