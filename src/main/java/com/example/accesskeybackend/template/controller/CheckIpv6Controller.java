package com.example.accesskeybackend.template.controller;

import com.example.accesskeybackend.template.service.CheckIpv6Service;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j
@RequestMapping("/api/web")
public class CheckIpv6Controller {

    @Autowired
    private CheckIpv6Service checkIpv6Service;

    @GetMapping("/checkIpv6Support")
    public ResponseEntity<Boolean> checkIpv6Support(@RequestParam String siteUrl) {
        log.info("respone: " + ResponseEntity.ok(checkIpv6Service.getRuntimeCommandOutput(siteUrl)));
        return ResponseEntity.ok(checkIpv6Service.getRuntimeCommandOutput(siteUrl));
    }

}