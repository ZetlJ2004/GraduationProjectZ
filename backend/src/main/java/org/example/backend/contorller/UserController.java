package org.example.backend.contorller;

import lombok.RequiredArgsConstructor;
import org.example.backend.dox.User;
import org.example.backend.service.UserService;
import org.example.backend.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PatchMapping("password")
    public ResultVO patchPassword(@RequestBody User user, @RequestAttribute("uid")String uid) {
        userService.updateUserPassword(uid, user.getPassword());
        return ResultVO.ok();
    }

}
