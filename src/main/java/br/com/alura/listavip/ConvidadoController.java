package br.com.alura.listavip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.alura.enviadorEmail.EmailService;
import br.com.alura.listavip.model.Convidado;
import br.com.alura.listavip.repository.ConvidadoRepository;

@Controller
public class ConvidadoController {

	@Autowired
	private ConvidadoRepository repository; // para que o Spring disponibilize um objeto com as características de um
											// repository capaz de retornar objetos de Convidado

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("listaconvidados")
	public String listaConvidados(Model model) {

		Iterable<Convidado> convidados = repository.findAll(); // capturar todos os registros presentes no banco de
																// dados. retornar todos os registro em um Iterable por
																// onde podemos iterar.
		model.addAttribute("convidados", convidados);// deixamos disponível para a página por meio do Model

		return "listaconvidados";
	}

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email,
			@RequestParam("telefone") String telefone, Model model) { // dados recebidos do formulario

		Convidado novoConvidado = new Convidado(nome, email, telefone);
		repository.save(novoConvidado); // salva no bd

		new EmailService().enviar(nome, email); // uilizando o jar enviadorEmail

		Iterable<Convidado> convidados = repository.findAll();
		model.addAttribute("convidados", convidados); // recarrega a lista de convidados ao salvar o novo convidado

		return "listaconvidados";
	}
}