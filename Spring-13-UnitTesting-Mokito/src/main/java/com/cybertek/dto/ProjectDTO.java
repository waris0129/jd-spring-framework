package com.cybertek.dto;

import com.cybertek.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProjectDTO {

    private String projectName;
    private String projectCode;
    private UserDTO assignedManager;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate projectStartDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate projectEndDate;

    private String projectDetail;
    private Status projectStatus;

    private int completeTaskCounts;
    private int unfinishedTaskCounts;
}