package com.cybertek.implementation;

import com.cybertek.dto.TaskDTO;
import com.cybertek.entity.TaskEntity;
import com.cybertek.mapper.TaskMapper;
import com.cybertek.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

    @InjectMocks
    TaskServiceImpl taskService;

    @Mock
    TaskRepository taskRepository;

    @Mock
    TaskMapper taskMapper;


    @ParameterizedTest
    @ValueSource(longs = {1l,2l,3l})
    void findByIdTest(Long arg){
        TaskEntity task = new TaskEntity();

        when(taskRepository.findById(arg)).thenReturn(Optional.of(task));
        when(taskMapper.convertToTaskDTO(task)).thenReturn(new TaskDTO());

        taskService.findTaskById(arg);

        verify(taskRepository).findById(arg);
    }


    @Test
    void findByIdTest_BDD(){
        // given

        TaskEntity task = new TaskEntity();
        given(taskRepository.findById(Mockito.anyLong())).willReturn(Optional.of(task));
        given(taskMapper.convertToTaskDTO(task)).willReturn(new TaskDTO());


        // when
        taskService.findTaskById(Mockito.anyLong());

        // then
        then(taskRepository).should().findById(Mockito.anyLong());
        then(taskRepository).should(never()).findById(-5l);


    }

}