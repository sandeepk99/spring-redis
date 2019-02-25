package com.sandeep.cache.springredis;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class AuthTypeRepositoryImpl implements AuthTypeRepository {


    private RedisTemplate<String, AuthType> redisTemplate;

    private HashOperations hashOperations;

    public AuthTypeRepositoryImpl(RedisTemplate<String, AuthType> redisTemplate) {

        this.redisTemplate = redisTemplate;
        hashOperations=redisTemplate.opsForHash();
    }

    @Override
    public void save(AuthType authType) {
        hashOperations.put("DEPOSIT",authType.getAuthId(),authType);
    }

    @Override
    public Map<String,AuthType> findAll() {
        return hashOperations.entries("DEPOSIT");
    }

    @Override
    public void update(AuthType authType) {
        hashOperations.put("DEPOSIT",authType.getAuthId(),authType);
    }

    @Override
    public void delete(String authId) {
        hashOperations.delete("DEPOSI",authId);
    }

    @Override
    public AuthType findById(String authId) {
        return (AuthType)hashOperations.get("DEPOSI",authId);
    }

    @Override
    public void flush() {
        hashOperations.entries("DEPOSIT").clear();
    }
}
