package com.example.rettucetest.controller

import com.example.rettucetest.dto.StudentReq
import com.example.rettucetest.dto.StudentRes
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class StudentController(

) {

    @PostMapping("/student")
    fun save(studentReq: StudentReq): StudentRes {
        return StudentRes("a")
    }
}

