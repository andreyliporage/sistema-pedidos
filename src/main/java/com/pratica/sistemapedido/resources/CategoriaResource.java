package com.pratica.sistemapedido.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categories")
public class CategoriaResource {

	@RequestMapping(method = RequestMethod.GET)
	public String testaRest() {
		return "REST está funcionando!";
	}
}
