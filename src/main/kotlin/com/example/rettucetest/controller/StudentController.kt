package com.example.rettucetest.controller

import com.example.rettucetest.domain.Student
import com.example.rettucetest.dto.StudentReq
import com.example.rettucetest.dto.StudentRes
import com.example.rettucetest.service.StudentService
import org.springframework.web.bind.annotation.*


@RestController
class StudentController(
    private val studentService: StudentService
) {

    @PostMapping("/student")
    fun save(@RequestBody studentReq: StudentReq): StudentRes {
        return studentService.save(studentReq)
    }

    @GetMapping("/student/{studentId}")
    fun load(@PathVariable studentId: String): Student {
        return studentService.load(studentId)
    }
}

