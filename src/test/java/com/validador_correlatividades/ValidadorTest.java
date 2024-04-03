package com.validador_correlatividades;

import com.validador_correlatividades.Alumno;
import com.validador_correlatividades.Inscripcion;
import com.validador_correlatividades.Materia;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ValidadorTest {
    
    
    @Test
    public void alumnoAproboMaterias() {

        Alumno alumno = new Alumno(new ArrayList<>());
        Materia analisisMatematico = new Materia(new ArrayList<>());
        Materia disenioDeSistemas = new Materia(new ArrayList<>());
        Materia sistemasOperativos = new Materia(new ArrayList<>());
        Materia economia = new Materia(new ArrayList<>());

        alumno.agregarAprobada(analisisMatematico);
        alumno.agregarAprobada(disenioDeSistemas);
        alumno.agregarAprobada(sistemasOperativos);
        alumno.agregarAprobada(economia);

        List<Materia> materias = new ArrayList<>();
        materias.add(analisisMatematico);
        materias.add(disenioDeSistemas);
        materias.add(sistemasOperativos);

        assertTrue(alumno.aproboMaterias(materias));
    }


    @Test
    public void materiaCumpleCorrelativas() {
        Alumno alumno = new Alumno(new ArrayList<>());
        Materia analisisMatematico = new Materia(new ArrayList<>());
        Materia disenioDeSistemas = new Materia(new ArrayList<>());
        Materia discreta = new Materia(new ArrayList<>());
        Materia analisisDeSistemas = new Materia(new ArrayList<>());
        Materia economia = new Materia(new ArrayList<>());
        Materia sistemasOperativos = new Materia(Arrays.asList(discreta, analisisDeSistemas));
        Materia materiaQueNadieAprobo = new Materia(new ArrayList<>());
        Materia materiaEspecial = new Materia(Arrays.asList(materiaQueNadieAprobo));

        alumno.agregarAprobada(analisisMatematico);
        alumno.agregarAprobada(disenioDeSistemas);
        alumno.agregarAprobada(analisisDeSistemas);
        alumno.agregarAprobada(discreta);
        alumno.agregarAprobada(economia);

        List<Materia> materias = new ArrayList<>();
        materias.add(analisisMatematico);
        materias.add(disenioDeSistemas);
        materias.add(sistemasOperativos);

        assertTrue(sistemasOperativos.cumpleCorrelatividad(alumno));
        assertFalse(materiaEspecial.cumpleCorrelatividad(alumno));
    }

    @Test
    public void inscripcionAprobada() {

        Alumno alumno = new Alumno(new ArrayList<>());
        Materia analisisMatematico = new Materia(new ArrayList<>());
        Materia disenioDeSistemas = new Materia(new ArrayList<>());
        Materia discreta = new Materia(new ArrayList<>());
        Materia analisisDeSistemas = new Materia(new ArrayList<>());
        Materia economia = new Materia(new ArrayList<>());
        Materia sistemasOperativos = new Materia(Arrays.asList(discreta, analisisDeSistemas));
        Materia materiaQueNadieAprobo = new Materia(new ArrayList<>());
        Materia materiaEspecial = new Materia(Arrays.asList(materiaQueNadieAprobo));

        alumno.agregarAprobada(analisisMatematico);
        alumno.agregarAprobada(disenioDeSistemas);
        alumno.agregarAprobada(sistemasOperativos);
        alumno.agregarAprobada(economia);

        List<Materia> materias = new ArrayList<>();
        materias.add(analisisMatematico);
        materias.add(disenioDeSistemas);
        materias.add(sistemasOperativos);
        

        Inscripcion inscripcionAprobada = new Inscripcion(alumno, Arrays.asList(economia, analisisMatematico, sistemasOperativos));
        Inscripcion inscripcionRechazada = new Inscripcion(alumno, Arrays.asList(materiaEspecial, economia));

        assertTrue(inscripcionAprobada.aprobada());
        assertFalse(inscripcionRechazada.aprobada());
    }
}