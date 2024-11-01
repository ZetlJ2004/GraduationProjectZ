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
public class Process {
    public static final String TUTOR = "AsImV";
    public static final String REVIEW = "zg0NS";

    @Id
    @CreatedBy
    private String id;
    private String depId;
    private String name;
    private int weight;
    private String parts;
    private String addPart;
    @ReadOnlyProperty
    @JsonIgnore
    private LocalDateTime createTime;
    @ReadOnlyProperty
    @JsonIgnore
    private LocalDateTime updateTime;

}
