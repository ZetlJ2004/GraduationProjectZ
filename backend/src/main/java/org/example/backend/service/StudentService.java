package org.example.backend.service;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.example.backend.dox.ProcessScore;
import org.example.backend.dox.User;
import org.example.backend.repository.ScoreRepository;
import org.example.backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@RequestMapping()
public class StudentService {
    private final UserRepository userRepository;
    private final ScoreRepository scoreRepository;

    private String teacher;

    //查看所有导师
    public List<User> ListTeacher(String depId){
        return userRepository.findByDepIdAndRole(depId,teacher);
    }
    //选择导师
    public void chooseMentor(String sid,String tid){
        userRepository.updateStudentById(sid, tid);
    }
    //查看得分
    public List<ProcessScore> myScore(String studentId){
        return scoreRepository.findByStudentId(studentId);
    }
    //上传文件
}
