package com.validador_correlatividades;

import java.util.List;

public class Inscripcion {
    private Alumno alumno;
    private final List<Materia> materias;

    public Inscripcion(Alumno alumno, List<Materia> materias) {
        this.alumno = alumno;
        this.materias = materias;
    }

    boolean aprobada(){
        return materias.stream().allMatch(materia -> materia.cumpleCorrelatividad(alumno));
    }

}
