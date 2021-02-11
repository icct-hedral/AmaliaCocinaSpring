package com.empresa.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.empresa.demo.interfaz.IPlato;
import com.empresa.demo.model.Carrito;
import com.empresa.demo.model.Plato;
import com.empresa.demo.model.PlatoParaVender;
import com.empresa.demo.servicio.PlatoServices;

@Controller
@RequestMapping
public class PlatoPedidoController {
	
	@Autowired
	PlatoServices service;
	
	@Autowired
	IPlato platoRepository;
	
	List<Carrito> listaCarrito=new ArrayList<>();
	int item = 0;
	double totalPagar=0.0;
	int cantidad=1;
	
	@GetMapping(value="/platospedidos")
	public String vistaPlatosPedidos(Model model) {
		
		List<Plato> platos=service.listar();
		model.addAttribute("platos",platos);
		return "listaplatospedidos";

	}
	
	
	@GetMapping(value="/agregarcarrito/{id}")
	public String agregarCarrito(@PathVariable String id,Model model,Plato pl) {
		
		
		pl=service.listarId(id);
		
		//

		//
		item=item+1;
		
		Carrito car=new Carrito();
		car.setItem(item);
		car.setIdProducto(pl.getId_plato());
		car.setNombres(pl.getNombre());
		car.setDescripcion(pl.getDescripcion());
		car.setPrecioCompra(pl.getPrecio());
		car.setCantidad(cantidad);
		car.setSubTotal(cantidad*pl.getPrecio());
		listaCarrito.add(car);
		
		model.addAttribute("contador", listaCarrito.size());
		return "listaplatospedidos";
	}
	
	
	@GetMapping(value="/listarcarrito")
	public String carrito(Model model) {
		
		
		totalPagar=0.0;
		model.addAttribute("carrito", listaCarrito);
		return "listacarrito";
	}
	
	//<<<<<<<<<<<<<<<<EN DESARROLLO>>>>>>>>>>>>>> 
	
	//dos métodos que nos ayudan a guardar y a obtener el carrito
	/*private ArrayList<PlatoParaVender> obtenerCarrito(HttpServletRequest request) {
	    ArrayList<PlatoParaVender> carrito = (ArrayList<PlatoParaVender>) request.getSession().getAttribute("carrito");
	    if (carrito == null) {
	        carrito = new ArrayList<>();
	    }
	    return carrito;
	}

	private void guardarCarrito(ArrayList<PlatoParaVender> carrito, HttpServletRequest request) {
	    request.getSession().setAttribute("carrito", carrito);
	}
	
	//método que muestra la vista, pasándole la variable del total del carrito:
	
	@GetMapping(value = "/")
	public String interfazVender(Model model, HttpServletRequest request) {
	    model.addAttribute("plato", new Plato());
	    
	    float total = 0;
	    
	    
	    ArrayList<PlatoParaVender> carrito = this.obtenerCarrito(request);
	    for (PlatoParaVender p: carrito) total += p.getTotal();
	   
	    model.addAttribute("total", total);
	    return "listacarrito";
	}
	
	@PostMapping(value = "/agregar/{id}")
	public String agregarAlCarrito(@PathVariable String id,@ModelAttribute Plato plato, HttpServletRequest request, RedirectAttributes redirectAttrs) {
	    ArrayList<PlatoParaVender> carrito = this.obtenerCarrito(request);
	    //
	    Plato platoBuscadoPorId = platoRepository.findFirstById(id);
	    //
	    if (platoBuscadoPorId == null) {
	        redirectAttrs
	                .addFlashAttribute("mensaje", "El producto con el código " + plato.getId_plato() + " no existe")
	                .addFlashAttribute("clase", "warning");
	        return "redirect:/vender/";
	    }
	    if (platoBuscadoPorId.sinStock()) {
	        redirectAttrs
	                .addFlashAttribute("mensaje", "El producto está agotado")
	                .addFlashAttribute("clase", "warning");
	        return "redirect:/vender/";
	    }
	    /*boolean encontrado = false;
	    for (PlatoParaVender productoParaVenderActual : carrito) {
	        if (productoParaVenderActual.getCodigo().equals(productoBuscadoPorCodigo.getCodigo())) {
	            productoParaVenderActual.aumentarCantidad();
	            encontrado = true;
	            break;
	        }
	    }
	    if (!encontrado) {
	        carrito.add(new PlatoParaVender(productoBuscadoPorCodigo.getNombre(), productoBuscadoPorCodigo.getCodigo(), productoBuscadoPorCodigo.getPrecio(), productoBuscadoPorCodigo.getExistencia(), productoBuscadoPorCodigo.getId(), 1f));
	    }*/
	  /*  this.guardarCarrito(carrito, request);
	    return "redirect:/vender/";
	}*/
	

}
