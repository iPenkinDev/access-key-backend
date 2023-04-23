package com.example.accesskeybackend.template.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.validator.routines.InetAddressValidator;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Data
@Log4j
public class CheckIpv6Service {

    public boolean getRuntimeCommandOutput(String siteUrl) {
        try {
            Process process = Runtime.getRuntime().exec("nslookup -query=AAAA " + siteUrl);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String result = "";
            while ((result = reader.readLine()) != null) {

                String str = result.replace("Address:", "");
                if (isIpv6Support(str.trim())) {
                    return true;
                }
            }
        } catch (Exception e) {
            log.info(e);
        }
        return false;
    }

    private boolean isIpv6Support(String ipAddress) {
        InetAddressValidator validator = InetAddressValidator.getInstance();
        return validator.isValidInet6Address(ipAddress);
    }
}