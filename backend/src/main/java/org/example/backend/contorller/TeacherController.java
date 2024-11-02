package org.example.backend.contorller;

import lombok.RequiredArgsConstructor;
import org.example.backend.dox.ProcessScore;
import org.example.backend.service.TeacherService;
import org.example.backend.service.UserService;
import org.example.backend.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/teacher/")
public class TeacherController {
    private final TeacherService teacherService;
    private final UserService userService;


    //查看专业所有学生
    @GetMapping("students")
    public ResultVO studentList(@RequestAttribute("depId") String depId){
        return ResultVO.success(Map.of("students",teacherService.studentList(depId)));
    }
    //组内学生
    @GetMapping("students/group")
    public ResultVO studentGroup(@RequestAttribute("depId")String depId,@RequestAttribute("group")int group){
        return ResultVO.success(Map.of("groupStudents",teacherService.groupStudents(depId, group)));
    }
    //自己学生
    @GetMapping("students/self")
    public ResultVO studentMyself(@RequestAttribute("depId")String depId,@RequestAttribute("uid") String uid){

        return ResultVO.success(Map.of("myselfStudents",teacherService.myselfStudents(depId, uid)));
    }

    //添加过程
    @GetMapping("processes")
    public ResultVO processList(@RequestAttribute("depId") String depId){
        return ResultVO.success(Map.of("processes",userService.listProcess(depId)));
    }
    @PostMapping("processes")
    public ResultVO addProcess(Process process){
        return ResultVO.success(Map.of("process",teacherService.addProcess(process)));
    }


    //查看自己打的分数

    @GetMapping("scores")
    public ResultVO listScore(@RequestAttribute("uid") String tid){
        return ResultVO.success(Map.of("scores",teacherService.scoreList(tid)));
    }
    //查看自己组的分数
    @GetMapping("scores/group")
    public ResultVO scoreGroup(@RequestAttribute int group){
        return ResultVO.success(Map.of("scores",teacherService.scoreGroup(group)));
    }

    //打分
    @PostMapping("scores")
    public ResultVO addScore(ProcessScore score){
        return ResultVO.success(Map.of("score",teacherService.addScore(score)));
    }
}
