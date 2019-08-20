package com.juliafealves.ucdb.rest.model;

import java.util.Objects;

public class Disciplina implements Comparable {
  private int id;
  private String nome;
  private double nota;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getNota() {
    return nota;
  }

  public void setNota(double nota) {
    this.nota = nota;
  }

  @Override
  public boolean equals(Object objeto) {
    if (this == objeto) return true;
    if (objeto == null || getClass() != objeto.getClass()) return false;
    Disciplina that = (Disciplina) objeto;
    return getId() == that.getId();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public int compareTo(Object objeto) {
    Disciplina outro = (Disciplina) objeto;
    if (this == objeto || this.getNota() == outro.getNota()) return 0;

    if (this.getNota() < outro.getNota()) {
      return 1;
    }

    return -1;
  }
}
