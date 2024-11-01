package org.example.backend.contorller;

import lombok.RequiredArgsConstructor;
import org.example.backend.dox.Department;
import org.example.backend.service.AdminService;
import org.example.backend.dox.User;
import org.example.backend.service.UserService;
import org.example.backend.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/admin/")
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;
    private final AdminService adminService;
    //直接添加用户（无需求）
    @PostMapping("users")
    public ResultVO postUser(@RequestBody User user){
        userService.addUser(user);
        return ResultVO.ok();
    }
    //修改任意用户密码
    @PutMapping("users/{account}/password")
    public ResultVO putPassword(@PathVariable String account){
        userService.updateUserPassword(account);
        return ResultVO.ok();
    }
    //查看所有用户
    @GetMapping("users")
    public ResultVO getUsers(){
        return ResultVO.success(userService.getAllUsers());
    }

    //部门查看
    @GetMapping("departments")
    public ResultVO departmentList(){
        return ResultVO.success(Map.of("department",adminService.listDepartment()));
    }
    //添加
    @PostMapping("departments")
    public ResultVO addDepartment(Department department){
        return ResultVO.success(Map.of("department",adminService.addDepartment(department)));
    }

}
