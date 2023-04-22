package com.example.accesskeybackend.template.service;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.validator.routines.InetAddressValidator;
import org.springframework.stereotype.Service;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
@Log4j2
public class CheckIpv6Service {

    public boolean isIpv6Support(String siteUrl) {

        String ipv6 = domainToIpv6(siteUrl);
        InetAddressValidator validator = InetAddressValidator.getInstance();
        return validator.isValidInet6Address(ipv6);

    }

    private String domainToIpv6(String siteUrl) {

        String result = "";
        try {
            InetAddress[] addresses = Inet6Address.getAllByName(siteUrl);
            for (InetAddress address : addresses) {
                if (address instanceof Inet6Address) {
                    log.debug(address.getHostAddress());
                    result = address.getHostAddress();
                } else {
                    log.debug(address.getHostAddress());
                }
            }
        } catch (UnknownHostException e) {
            log.debug(siteUrl);
        }
        return result;
    }
}