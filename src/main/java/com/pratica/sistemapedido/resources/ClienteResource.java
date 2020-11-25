package com.pratica.sistemapedido.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pratica.sistemapedido.domain.Cliente;
import com.pratica.sistemapedido.dto.ClienteDTO;
import com.pratica.sistemapedido.dto.ClienteNewDTO;
import com.pratica.sistemapedido.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> find(@PathVariable Integer id) {
		Cliente cliente = service.find(id);
		return ResponseEntity.ok().body(cliente);
	} 
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody ClienteNewDTO newDto) {
		Cliente cliente = service.fromDto(newDto);
		cliente = service.insert(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody @Valid ClienteDTO clienteDto, @PathVariable Integer id) {
		Cliente cliente = service.fromDto(clienteDto);
		cliente.setId(id);
		cliente = service.update(cliente);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll() {
		List<Cliente> list = service.findAll();
		List<ClienteDTO> dtoList = list.stream().map(cliente -> new ClienteDTO(cliente)).collect(Collectors.toList());
		return ResponseEntity.ok().body(dtoList);
	}
	
	@GetMapping(value = "/page")
	public ResponseEntity<Page<ClienteDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Cliente> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<ClienteDTO> dtoList = list.map(categoria -> new ClienteDTO(categoria));
		return ResponseEntity.ok().body(dtoList);
	}
}
