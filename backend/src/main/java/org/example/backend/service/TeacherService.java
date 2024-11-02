package org.example.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.example.backend.dox.ProcessScore;
import org.example.backend.dox.User;
import org.example.backend.repository.ProcessRepository;
import org.example.backend.repository.ScoreRepository;
import org.example.backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final ProcessRepository processRepository;
    private final UserRepository userRepository;
    private final ScoreRepository scoreRepository;

    @Value("${role.student}")
    private String student;

    @Transactional
    public Process addProcess(Process process){
        return processRepository.save(process);
    }


    @Transactional//添加得分 打分
    public ProcessScore addScore(ProcessScore score) {
        return scoreRepository.save(score);
    }

    //查看得分
    //查看自己组学生的得分
    public List<ProcessScore> scoreGroup(int group){
        return scoreRepository.findScoresByGroup(group);
    }
    //查看自己打的分
    public List<ProcessScore> scoreList(String tid){
        return scoreRepository.findScoresByTid(tid);
    }


    //查看用户
    //查看专业所有学生
    public List<User> studentList(String depId){
        return userRepository.findByDepIdAndRole(depId,student);
    }

    //查看自己组的学生
    public List<User> groupStudents(String depId,int group){
        return userRepository.findByDepIdAndRoleAndGroup(depId,student,group);
    }
    //自己自己的学生
    public List<User> myselfStudents(String depId,String tid){
        return userRepository.myselfStudents(depId,tid);
    }
}
