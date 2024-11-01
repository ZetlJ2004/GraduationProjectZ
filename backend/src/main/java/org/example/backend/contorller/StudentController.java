package org.example.backend.contorller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.backend.service.StudentService;
import org.example.backend.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/student/")
public class StudentController {
    private final StudentService studentService;

    //查看所有待选导师
    @GetMapping("teachers")
    public ResultVO listTeacher(@RequestAttribute("depId")String depId){
        return ResultVO.success(Map.of("teachers",studentService.ListTeacher(depId)));
    }


    //选择老师   put的话前端需要传过来一个完整实体，没有提供完整的对象，其余属性应该被清空
    @PatchMapping("teachers/{tid}")
    public ResultVO chooseTeacher(@RequestAttribute("uid")String sid, @PathVariable String tid){
        studentService.chooseMentor(sid,tid);
        return ResultVO.ok();
    }
}
