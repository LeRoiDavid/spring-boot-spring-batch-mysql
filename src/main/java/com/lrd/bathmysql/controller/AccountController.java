package com.lrd.bathmysql.controller;

import org.springframework.batch.core.BatchStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("laod")
    @ResponseBody
    public BatchStatus load(){


        return null;
    }
}
