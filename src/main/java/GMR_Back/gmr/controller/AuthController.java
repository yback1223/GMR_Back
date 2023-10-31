package GMR_Back.gmr.controller;

import GMR_Back.gmr.controller.service.AuthService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/checkToken")
    public ResponseEntity<String> checkToken(@RequestBody String tokenFromApp) {
        JSONObject jsonToken = new JSONObject(tokenFromApp);
        String dataFromKakao = authService.authenticateWithKakao(jsonToken.getString("Token"));

        return ResponseEntity.ok("good !!!");
    }
}
