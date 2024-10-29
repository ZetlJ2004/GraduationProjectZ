package org.example.backend.contorller;

import lombok.RequiredArgsConstructor;
import org.example.backend.dox.User;
import org.example.backend.service.UserService;
import org.example.backend.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/")
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;
    @PostMapping("users")
    public ResultVO postUser(@RequestBody User user){
        userService.addUser(user);
        return ResultVO.ok();
    }

    @PutMapping("users/{account}/password")
    public ResultVO putPassword(@PathVariable String account){
        userService.updateUserPassword(account);
        return ResultVO.ok();
    }
    @GetMapping("users")
    public ResultVO getUsers(){
        return ResultVO.success(userService.getAllUsers());
    }
}
