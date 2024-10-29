package org.example.backend.contorller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.backend.component.JWTComponent;
import org.example.backend.dox.User;
import org.example.backend.exception.Code;
import org.example.backend.service.UserService;
import org.example.backend.vo.ResultVO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class LoginController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JWTComponent jwtComponent;
    @PostMapping("login")
    public ResultVO login(@RequestBody User user, HttpServletResponse response) {
        User user1 = userService.getUser(user.getAccount());
        if (user1 == null || !passwordEncoder.matches(user.getPassword(), user1.getPassword())) {
            return ResultVO.error(Code.LOGIN_ERROR);
        }
        String token = jwtComponent.encode(Map.of("uid",user1.getId(),"role",user1.getRole()));
        response.setHeader("token",token);
        response.setHeader("role",user1.getRole());
        return ResultVO.success(user1);
    }
}
