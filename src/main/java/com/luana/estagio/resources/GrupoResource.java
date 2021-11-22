package com.luana.estagio.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luana.estagio.domain.Grupo;
import com.luana.estagio.services.GrupoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/grupos")
public class GrupoResource {
	
	@Autowired
	private GrupoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Grupo> findById(@PathVariable Integer id) {
		Grupo obj = service.findByid(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Grupo>> listAll(){
		List<Grupo> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Grupo> create(@RequestBody Grupo obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Grupo> update(@PathVariable Integer id, @RequestBody Grupo obj) {
		Grupo newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
}
