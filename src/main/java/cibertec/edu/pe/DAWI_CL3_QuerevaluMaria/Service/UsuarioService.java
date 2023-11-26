package cibertec.edu.pe.DAWI_CL3_QuerevaluMaria.Service;

import cibertec.edu.pe.DAWI_CL3_QuerevaluMaria.Model.bd.Rol;
import cibertec.edu.pe.DAWI_CL3_QuerevaluMaria.Model.bd.Usuario;
import cibertec.edu.pe.DAWI_CL3_QuerevaluMaria.Repository.RolRepository;
import cibertec.edu.pe.DAWI_CL3_QuerevaluMaria.Repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
@AllArgsConstructor
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder =
            new BCryptPasswordEncoder();
    public Usuario findByNomusuario(String nomusuario){
        return usuarioRepository.findByNomusuario(nomusuario);
    }
    public Usuario saveUser(Usuario usuario){
        usuario.setPassword(
                bCryptPasswordEncoder.encode(usuario.getPassword())
        );
        Rol usuarioRol = rolRepository.findByNomrol("USER");
        usuario.setRoles(new HashSet<>(Arrays.asList(usuarioRol)));
        usuario.setActivo(true);
        return usuarioRepository.save(usuario);
    }


}
