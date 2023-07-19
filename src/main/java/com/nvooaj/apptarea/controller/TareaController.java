package com.nvooaj.apptarea.controller;

import com.nvooaj.apptarea.entity.Tarea;
import com.nvooaj.apptarea.service.TareaService;
import com.nvooaj.apptarea.service.ValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/tareas")
public class TareaController {

	@Autowired
	private TareaService tareaService;
	@Autowired
	private ValidationErrorService validationService;

	@GetMapping
	public ResponseEntity<?> listarTareas() {
		try {
			List<Tarea> tareas = new ArrayList<Tarea>();

			tareaService.listarTareas().forEach(tareas::add);

			if (tareas.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tareas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@PostMapping
	public ResponseEntity<Tarea> agregarTarea(@Valid @RequestBody Tarea tarea, BindingResult result) {
		try {
			ResponseEntity errors = validationService.validate(result);
			if(errors != null) return errors;

			Tarea _tarea = tareaService.agregarTarea(tarea);
			return new ResponseEntity<Tarea>(_tarea,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editarTarea(@PathVariable Long id,@Valid @RequestBody Tarea tarea, BindingResult result) {

		ResponseEntity errors = validationService.validate(result);
		if(errors != null) return errors;

		tarea.setId(id);
		Tarea tareaSaved = tareaService.editarTarea(tarea);
		if (tareaSaved != null){
			return new ResponseEntity<>(tareaSaved, HttpStatus.OK);
		}else{
			return new ResponseEntity<>("Tarea con id "+ id + "No existe ", HttpStatus.NOT_FOUND);
		}



	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> removerTarea(@PathVariable Long id) {
		tareaService.remover(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
