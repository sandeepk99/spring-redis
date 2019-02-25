package com.sandeep.cache.springredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class SpringRedisApplication {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory jcf = new JedisConnectionFactory();
		jcf.setUsePool(true);
		jcf.getPoolConfig().setMaxIdle(30);
		jcf.getPoolConfig().setMinIdle(10);
		return jcf;
	}

	@Bean
	RedisTemplate<String, AuthType> redisTemplate() {
		RedisTemplate<String, AuthType> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
        redisTemplate.setEnableTransactionSupport(true);


		return redisTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringRedisApplication.class, args);
	}

}
