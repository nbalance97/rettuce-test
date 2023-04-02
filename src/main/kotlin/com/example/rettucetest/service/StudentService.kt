package com.example.rettucetest.service

import com.example.rettucetest.dto.StudentReq
import com.example.rettucetest.dto.StudentRes
import com.example.rettucetest.repository.StudentRedisRepository
import org.springframework.stereotype.Service

@Service
class StudentService(
    private val studentRedisRepository: StudentRedisRepository,
) {

    fun save(studentReq: StudentReq): StudentRes {

        return StudentRes(id = studentReq.id)
    }
}
