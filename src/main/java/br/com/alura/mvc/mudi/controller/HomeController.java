package br.com.alura.mvc.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping
	public String home(Model model, Principal principal) {
		//List<Pedido> pedidos = pedidoRepository.findAllByUsuario(principal.getName());
		//model.addAttribute("pedidos", pedidos);
		//return "home";
		
		Sort sort = Sort.by("dataDaEntrega").descending();
		PageRequest paginacao = PageRequest.of(0, 10, sort);
		
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE, paginacao);
		model.addAttribute("pedidos", pedidos);
		return "home";
	
		}
	}
		
		/*Pedido pedido = new Pedido();
		pedido.setNomeProduto("Xiaomi Redmi Note 8");
		pedido.setUrlImagem("https://images-na.ssl-images-amazon.com/images/I/81UgYuadkpL._AC_SL1500_.jpg");
		pedido.setUrlProduto(
				"https://www.amazon.com.br/Smartphone-Xiaomi-Redmi-Note-64GB/dp/B07Y8YWTFL/ref=sr_1_6?__mk_pt_BR=%C3%85M%C3%85%C5%BD%C3%95%C3%91&dchild=1&keywords=Xiaomi+Redmi+Note+8&qid=1600346040&sr=8-6");
		pedido.setDescricao("uma descrição qualquer para esse pedido");*/

	/*	@GetMapping("/{status}")
		public String porStatus(@PathVariable("status") String status, Model model) {
			List<Pedido> pedido = pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
			model.addAttribute("pedidos", pedido);
			model.addAttribute("status", status);
			return "home"; 
		}
		
		@ExceptionHandler(IllegalArgumentException.class)
		public String onError() {
			return "redirect:/home";
		} 

	} */


