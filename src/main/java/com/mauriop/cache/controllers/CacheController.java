package com.mauriop.cache.controllers;

import com.mauriop.cache.services.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/")
public class CacheController {

    @Autowired
    CacheService cacheService;

    @RequestMapping(value = "/get-cache/{value}", method = RequestMethod.GET)
    public String getCache(@PathVariable String value)
    {
        return cacheService.cacheThis(value, UUID.randomUUID().toString());
    }


    @RequestMapping(value = "/evict-cache/{value}", method = RequestMethod.DELETE)
    public ResponseEntity evictCache(@PathVariable String value)
    {
        cacheService.forgetAboutThis(value);

        return new ResponseEntity("Cache evicted successfully", HttpStatus.ACCEPTED);
    }
}
