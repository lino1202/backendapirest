package pe.edu.cibertec.backendapirest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.backendapirest.model.db.Alumno;
import pe.edu.cibertec.backendapirest.repository.AlumnoRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> listarAlumnos(){
        return alumnoRepository.findAll();
    }

    public Optional<Alumno> buscarAlumnoxID(String idA){
        Optional<Alumno> alumno = alumnoRepository.findById(idA);
        if(alumno.isEmpty()){
            return Optional.empty();
        }else {
            return alumno;
        }
    }

    public Alumno registrarAlumno(Alumno alumno){
        return alumnoRepository.save(alumno);
    }

    public HashMap<String,String> eliminarAlumnoxID(String idA){
        HashMap<String,String> respuesta = new HashMap<String, String>();
        alumnoRepository.deleteById(idA);
        respuesta.put("mensaje","Alumno eliminado exitosamente");
        return respuesta;

    }
}
