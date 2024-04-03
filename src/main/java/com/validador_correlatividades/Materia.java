package com.validador_correlatividades;

import java.util.List;

public class Materia {
    private List<Materia> correlativas;

    public Materia(List<Materia> correlativas) {
        this.correlativas = correlativas;
    }

    public boolean cumpleCorrelatividad(Alumno alumno){
        return alumno.aproboMaterias(correlativas);
    }

}
