package com.example.rettucetest.repository

import com.example.rettucetest.domain.Student
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Repository
import java.lang.IllegalArgumentException

@Repository
class StudentRedisRepository(
    private val redisTemplate: RedisTemplate<String, String>,
    private val objectMapper: ObjectMapper,
) {

    fun save(student: Student) {
        println("deserialize: ${objectMapper.writeValueAsString(student)}")

        redisTemplate.opsForValue().set(student.id, objectMapper.writeValueAsString(student))
    }

    fun getStudent(id: String): Student {
        val studentJson = redisTemplate.opsForValue().get(id)
            ?: throw IllegalArgumentException("존재하지 않는 학생 정보입니다.")

        // Serialize 하여 데이터 로딩
        return objectMapper.readValue<Student>(studentJson)
    }
}
