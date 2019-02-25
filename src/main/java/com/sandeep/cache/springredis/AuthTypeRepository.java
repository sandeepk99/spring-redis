package com.sandeep.cache.springredis;


import java.util.Map;

public interface AuthTypeRepository {

    void save(AuthType authType);

    Map<String,AuthType> findAll();

    void update(AuthType auth);

    void delete(String authId);

    AuthType findById(String authId);

    void  flush();

}
