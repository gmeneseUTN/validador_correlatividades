package com.validador_correlatividades;

import java.util.List;

public class Alumno {
    private final List<Materia> materiasAprobadas;

    public Alumno(List<Materia> materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }

    public void agregarAprobada(Materia materia){
        this.materiasAprobadas.add(materia);
    }

    public boolean aproboMaterias(List<Materia> materias){
        return materiasAprobadas.containsAll(materias);
    }

}
