package pe.edu.cibertec.backendapirest.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.backendapirest.model.db.Alumno;
import pe.edu.cibertec.backendapirest.service.AlumnoService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/alumno")
public class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("")
    public ResponseEntity<List<Alumno>> listarAlumnos(){
        List<Alumno> alumnoList = new ArrayList<>();
        alumnoService.listarAlumnos().forEach(alumnoList::add);
        if(alumnoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(alumnoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> obtenerAlmunoxID(@PathVariable("id") String id){
        return new ResponseEntity<>(alumnoService.buscarAlumnoxID(id).get(), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Alumno> crearAlumno(@RequestBody Alumno alumno){
        Alumno newAlumno = new Alumno();
        newAlumno.setIdalumno(alumno.getIdalumno());
        newAlumno.setNomalumno(alumno.getNomalumno());
        newAlumno.setApealumno(alumno.getApealumno());
        newAlumno.setProce(alumno.getProce());
        return new ResponseEntity<>(alumnoService.registrarAlumno(newAlumno),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> actualizarAlumno(@PathVariable("id") String id, @RequestBody Alumno alumno){
        Alumno updateAlumno = alumnoService.buscarAlumnoxID(id).get();
        //updateAlumno.setIdalumno(alumno.getIdalumno());
        updateAlumno.setNomalumno(alumno.getNomalumno());
        updateAlumno.setApealumno(alumno.getApealumno());
        updateAlumno.setProce(alumno.getProce());
        return new ResponseEntity<>(alumnoService.registrarAlumno(updateAlumno),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarAlumno(@PathVariable("id")String id){
        return ResponseEntity.status(HttpStatus.OK).body(alumnoService.eliminarAlumnoxID(id));
    }
}
