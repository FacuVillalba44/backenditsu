package edu.itsu.inscripciones.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.itsu.inscripciones.dto.LoginRequest;
import edu.itsu.inscripciones.servicio.UsuarioServicio;
import org.springframework.security.crypto.password.PasswordEncoder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import edu.itsu.inscripciones.modelo.Usuario;
import java.util.Date;

@RestController
@RequestMapping("/itsuapi/auth")
@CrossOrigin(origins = "https://4200-idx-itsufront-1737645545390.cluster-vpxjqdstfzgs6qeiaf7rdlsqrc.cloudworkstations.dev")
public class AuthController {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        Usuario usuario = usuarioServicio.buscarUsuarioPorEmail(loginRequest.getEmailUsuario());
        if (usuario != null && passwordEncoder.matches(loginRequest.getClaveAcceso(), usuario.getClaveAcceso())) {
            // Crear token JWT
            String token = Jwts.builder()
                .setSubject(usuario.getEmailUsuario())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 24 horas
                .signWith(SignatureAlgorithm.HS512, "secretKey") // Clave secreta (cámbiala por una segura)
                .compact();
            return token;
        } else {
            throw new RuntimeException("Credenciales inválidas");
        }
    }
}