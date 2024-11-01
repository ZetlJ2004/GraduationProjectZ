package org.example.backend.dox;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProcessScore {
    @Id
    @CreatedBy
    private String id;
    private String studentId;
    private String teacher;
    private String processId;
    private String detail;
    @ReadOnlyProperty
    @JsonIgnore
    private LocalDateTime createTime;
    @ReadOnlyProperty
    @JsonIgnore
    private LocalDateTime updateTime;
}
