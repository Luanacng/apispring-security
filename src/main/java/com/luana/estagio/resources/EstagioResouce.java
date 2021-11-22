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

import com.luana.estagio.domain.Estagio;
import com.luana.estagio.services.EstagioService;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/estagios")
public class EstagioResouce {
	
	@Autowired
	private EstagioService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Estagio> findById(@PathVariable Integer id) {
		Estagio obj = service.findByid(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value= "/open")
	public ResponseEntity<List<Estagio>> listOpen() {
		List<Estagio> list = service.findAllOpen();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value= "/closed")
	public ResponseEntity<List<Estagio>> listClosed() {
		List<Estagio> list = service.findAllClosed();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping
	public ResponseEntity<List<Estagio>> listAll(){
		List<Estagio> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Estagio> create(@RequestBody Estagio obj) {
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
	public ResponseEntity<Estagio> update(@PathVariable Integer id, @RequestBody Estagio obj) {
		Estagio newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}

}
