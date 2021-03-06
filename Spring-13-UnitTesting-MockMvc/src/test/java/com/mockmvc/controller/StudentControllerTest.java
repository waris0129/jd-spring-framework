package com.mockmvc.controller;

import com.mockmvc.entity.Student;
import com.mockmvc.service.StudentService;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@SpringBootTest // it would bring all the context/ beans
@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;


    @MockBean
    StudentService studentService;

    @Test
    void getStudent_data() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/student").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "{\n" +
                        "\"id\": 1,\n" +
                        "\"firstName\": \"mike\",\n" +
                        "\"lastName\": \"smith\",\n" +
                        "\"age\": 20\n" +
                        "}\n" +
                        "]"))
                .andReturn();


    }


    @Test
    void getStudentData() throws Exception {

        String expect = "[\n" +
                "{\n" +
                "\"id\": 0,\n" +
                "\"firstName\": \"waris\",\n" +
                "\"lastName\": \"nihmat\",\n" +
                "\"age\": 20\n" +
                "}\n" +
                "]";

        when(studentService.getStudent_data())
                .thenReturn(Arrays.asList(
                new Student("waris","nihmat",20)));

        mockMvc.perform(MockMvcRequestBuilders.get("/student").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expect))
                .andReturn();

    }


    @Test
    void jsonAssert() throws JSONException {
        String actual = "[\n" +
                "{\n" +
                "\"id\": 1,\n" +
                "\"firstName\": \"mike\",\n" +
                "\"lastName\": \"smith\",\n" +
                "\"age\": 20\n" +
                "}\n" +
                "]";

        String expect = "[\n" +
                "{\n" +
                "\"id\": 1,\n" +
                "\"firstName\": \"mike\",\n" +
                "\"lastName\": \"smith\",\n" +
                "\"age\": 20\n" +
                "}\n" +
                "]";


        JSONAssert.assertEquals(expect,actual,true);

    }




}