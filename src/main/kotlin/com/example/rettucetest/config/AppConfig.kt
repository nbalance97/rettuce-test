package com.example.rettucetest.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate

@Configuration
@EnableConfigurationProperties(value = [Aws::class])
class AppConfig(
    private val aws: Aws
) {

    // Set 해주기 위해서는 리더가 아닌 원 Redis를 읽어와야 함. (리더는 ReadOnly)
    @Bean
    fun redisConnectionFactory(): RedisConnectionFactory =
        LettuceConnectionFactory(RedisStandaloneConfiguration(aws.host, aws.port))

    @Bean
    fun redisTemplate(redisConnectionFactory: RedisConnectionFactory): RedisTemplate<String, String> {
        val template = RedisTemplate<String, String>()
        template.setConnectionFactory(redisConnectionFactory)

        return template
    }
}

@ConfigurationProperties(prefix = "aws")
data class Aws(
    val host: String,
    val port: Int,
)
