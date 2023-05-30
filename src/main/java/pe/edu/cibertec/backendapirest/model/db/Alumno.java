package pe.edu.cibertec.backendapirest.model.db;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "alumno")
public class Alumno {
    @Id
    private String idalumno;
    @Column(name="apealumno")
    private String apealumno;
    @Column(name="nomalumno")
    private String nomalumno;
    @Column(name="proce")
    private String proce;

    /*@JsonBackReference
    @ManyToOne
    @JoinColumn(name = "idesp")
    private Especialidad especialidad;*/

}
