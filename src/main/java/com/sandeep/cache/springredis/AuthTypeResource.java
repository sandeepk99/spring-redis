package com.sandeep.cache.springredis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class AuthTypeResource {

    private AuthTypeRepository authTypeRepository;

    public AuthTypeResource(AuthTypeRepository authTypeRepository) {
        this.authTypeRepository = authTypeRepository;
    }

    @GetMapping("/add")
    public AuthType add(){

        List<String> phoneList = new ArrayList();
        phoneList.add("123432123");
        phoneList.add("341234321");


        AuthType authType = new AuthType(phoneList,"AC123" , UUID.randomUUID().toString());
        authTypeRepository.save(authType);

        return authTypeRepository.findById(authType.getAuthId());
    }

    @GetMapping("/all")
    public Map<String,AuthType> all(){

        return authTypeRepository.findAll();


    }

    @GetMapping("/flush")
    public void deleteAll(){

        authTypeRepository.flush();


    }


}
