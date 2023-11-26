package cibertec.edu.pe.DAWI_CL3_QuerevaluMaria.Model.bd;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idrol;

    @Column(name="nomrol")
    private String nomrol;
}
