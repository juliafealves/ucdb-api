package com.juliafealves.ucdb.rest.controller;

import com.juliafealves.ucdb.rest.model.Disciplina;
import com.juliafealves.ucdb.rest.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RequestMapping({ "v1/disciplinas" })
@RestController
public class DisciplinaController {
  
  @Autowired
  private DisciplinaService disciplinaService;

  @PostMapping
  public ResponseEntity<Disciplina> salvar(@RequestBody Disciplina disciplina) {
    return new ResponseEntity<>(
      this.disciplinaService.salvar(disciplina),
      HttpStatus.CREATED
    );
  }

  @GetMapping("/{id}")
  public ResponseEntity<Disciplina> consultar(@PathVariable int id) {
    Disciplina disciplina = this.disciplinaService.consultar(id);

    if (disciplina == null) {
      throw new ResponseStatusException(
        HttpStatus.NOT_FOUND,
        "Disciplina não encontrada"
      );
    }

    return new ResponseEntity<>(disciplina, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<Disciplina>> listar() {
    return new ResponseEntity<>(this.disciplinaService.listar(), HttpStatus.OK);
  }

  @GetMapping("/ranking")
  public ResponseEntity<List<Disciplina>> listarMelhores() {
    return new ResponseEntity<>(
      this.disciplinaService.listarMelhores(),
      HttpStatus.OK
    );
  }

  @PutMapping("/{id}/nome")
  public ResponseEntity<Disciplina> editarNome(
    @PathVariable int id,
    @RequestBody Disciplina disciplina
  ) {
    Disciplina disciplinaAtual = this.disciplinaService.consultar(id);

    if (disciplinaAtual == null) {
      throw new ResponseStatusException(
        HttpStatus.NOT_FOUND,
        "Disciplina não encontrada"
      );
    }

    disciplinaAtual.setNome(disciplina.getNome());

    return new ResponseEntity<>(
      this.disciplinaService.editar(disciplinaAtual),
      HttpStatus.OK
    );
  }

  @PutMapping("/{id}/nota")
  public ResponseEntity<Disciplina> editarNota(
    @PathVariable int id,
    @RequestBody Disciplina disciplina
  ) {
    Disciplina disciplinaAtual = this.disciplinaService.consultar(id);

    if (disciplinaAtual == null) {
      throw new ResponseStatusException(
        HttpStatus.NOT_FOUND,
        "Disciplina não encontrada"
      );
    }

    disciplinaAtual.setNota(disciplina.getNota());

    return new ResponseEntity<>(
      this.disciplinaService.editar(disciplinaAtual),
      HttpStatus.OK
    );
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Disciplina> remover(@PathVariable int id) {
    Disciplina disciplina = this.disciplinaService.consultar(id);

    if (disciplina == null) {
      throw new ResponseStatusException(
        HttpStatus.NOT_FOUND,
        "Disciplina não encontrada"
      );
    }

    this.disciplinaService.remover(id);

    return new ResponseEntity<>(disciplina, HttpStatus.OK);
  }
}
