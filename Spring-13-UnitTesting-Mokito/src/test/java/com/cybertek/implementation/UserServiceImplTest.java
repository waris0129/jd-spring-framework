package com.cybertek.implementation;

import com.cybertek.exception.TicketingException;
import com.cybertek.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserRepository userRepository;


    @Test
    void deleteByUserName() {
        userService.deleteByUserName("mike@cybertek.com");

        verify(userRepository).deleteByUsername("mike@cybertekschool.com");

    }
}