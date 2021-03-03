package com.cybertek.implementation;

import com.cybertek.dto.ProjectDTO;
import com.cybertek.entity.ProjectEntity;
import com.cybertek.mapper.Mapper;
import com.cybertek.mapper.ProjectMapper;
import com.cybertek.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    @Mock
    ProjectRepository projectRepository;

    @Mock
    ProjectMapper projectMapper;

    @InjectMocks
    ProjectServiceImpl projectService;

    @Mock
    ProjectDTO projectDTO;

    @Test
    void findProjectByProjectCode() {

        ProjectEntity projectEntity = new ProjectEntity();
        ProjectDTO projectDTO = new ProjectDTO();


        when(projectRepository.findByProjectCode("PR001")).thenReturn(projectEntity);
        when(projectMapper.convertToProjectDto(projectEntity)).thenReturn(projectDTO);

        ProjectDTO projectDTO1 = projectService.findProjectByProjectCode("PR001");

        verify(projectRepository).findByProjectCode(Mockito.anyString());
        verify(projectMapper).convertToProjectDto(Mockito.any(ProjectEntity.class));

        assertNotNull(projectDTO1);
    }


    @Test
    void getByProjectCode_Exception_Test(){

        when(projectRepository.findByProjectCode("")).thenThrow(new RuntimeException("Project Not Found"));

        Throwable exception = assertThrows(RuntimeException.class,()->projectService.findProjectByProjectCode(""));

        verify(projectRepository).findByProjectCode(Mockito.anyString());

        assertEquals(exception.getMessage(),"Project Not Found");
    }


    @Test
    void save() {

        ProjectDTO projectDTO = new ProjectDTO();
        ProjectEntity projectEntity = new ProjectEntity();



        when(projectMapper.convertToProjectEntity(projectDTO)).thenReturn(projectEntity);
        when(projectRepository.save(projectEntity)).thenReturn(projectEntity);

        ProjectEntity projectEntity1 = projectService.save(projectDTO);

        assertNotNull(projectEntity1);

        verify(projectRepository).save(projectEntity);

    }
}