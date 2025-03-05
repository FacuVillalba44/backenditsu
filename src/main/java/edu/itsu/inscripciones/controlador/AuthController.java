package edu.itsu.inscripciones.controlador;

import org.springframework.beans.factory.annotation.Autowired;
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
public class AuthController {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        Usuario usuario = usuarioServicio.buscarUsuarioPorEmail(loginRequest.getEmailUsuario());
        if (usuario != null && passwordEncoder.matches(loginRequest.getClaveAcceso(), usuario.getClaveAcceso())) {
            String token = Jwts.builder()
                .setSubject(usuario.getEmailUsuario())
                .claim("idRol", usuario.getIdRol())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(SignatureAlgorithm.HS512, "secretKey")
                .compact();
            return token;
        } else {
            throw new RuntimeException("Credenciales inválidas");
        }
    }
}