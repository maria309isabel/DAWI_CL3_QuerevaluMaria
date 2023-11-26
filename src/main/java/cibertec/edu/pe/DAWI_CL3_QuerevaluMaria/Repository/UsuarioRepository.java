package cibertec.edu.pe.DAWI_CL3_QuerevaluMaria.Repository;

import cibertec.edu.pe.DAWI_CL3_QuerevaluMaria.Model.bd.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends
        JpaRepository<Usuario, Integer>
{
    Usuario findByNomusuario(String nomusuario);
}
