package com.juliafealves.ucdb.rest.service;

import com.juliafealves.ucdb.rest.model.Disciplina;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.*;

@Service
public class DisciplinaService {
  private Map<Integer, Disciplina> disciplinas;

  public DisciplinaService() {
    this.disciplinas = new HashMap<>();
  }

  public Disciplina salvar(Disciplina disciplina) {
    disciplina.setId(this.disciplinas.size() + 1);
    this.disciplinas.put(disciplina.getId(), disciplina);

    return disciplina;
  }

  public Disciplina consultar(int id) {
    return disciplinas.get(id);
  }

  public List<Disciplina> listar() {
    return new ArrayList<>(disciplinas.values());
  }

  public Disciplina editar(Disciplina disciplina) {
    this.disciplinas.replace(disciplina.getId(), disciplina);
    return this.disciplinas.get(disciplina.getId());
  }

  public List<Disciplina> listarMelhores() {
    List<Disciplina> melhores = new ArrayList<>(this.disciplinas.values());
    Collections.sort(melhores);

    return melhores;
  }

  public void remover(int id) {
    this.disciplinas.remove(id);
  }
}
