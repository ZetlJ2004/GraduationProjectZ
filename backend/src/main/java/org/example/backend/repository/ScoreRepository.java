package org.example.backend.repository;

import org.example.backend.dox.ProcessScore;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends CrudRepository<ProcessScore,String> {

    @Query("SELECT * from score where student_id=:sid")
    public List<ProcessScore> findByStudentId(String sid);


    @Query("SELECT * from score where `group`=:group")
    public List<ProcessScore> findByGroup(int group);

    @Modifying
    @Query("UPDATE score s set s.detail=:detail where s.id=:sid")
    public ProcessScore updateDetailById(String sid,String detail);

    @Query("SELECT * from score where `group`=:group")
    public List<ProcessScore> findScoresByGroup(int group);

    @Query("SELECT * from score where teacher->>'$.teacherId'=:tid")
    public List<ProcessScore> findScoresByTid(String tid);
}