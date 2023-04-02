package com.example.rettucetest.service

import com.example.rettucetest.domain.Student
import com.example.rettucetest.dto.StudentReq
import com.example.rettucetest.dto.StudentRes
import com.example.rettucetest.repository.StudentRedisRepository
import org.springframework.stereotype.Service

@Service
class StudentService(
    private val studentRedisRepository: StudentRedisRepository,
) {

    fun save(studentReq: StudentReq): StudentRes {
        studentRedisRepository.save(
            Student(
                id = studentReq.id,
                name = studentReq.name,
                grade = studentReq.grade
            )
        )

        return StudentRes(id = studentReq.id)
    }

    fun load(studentId: String): Student =
        studentRedisRepository.getStudent(studentId)
}
