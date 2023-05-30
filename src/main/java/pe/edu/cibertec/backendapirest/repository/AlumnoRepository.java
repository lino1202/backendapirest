package pe.edu.cibertec.backendapirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.backendapirest.model.db.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, String> {
}
