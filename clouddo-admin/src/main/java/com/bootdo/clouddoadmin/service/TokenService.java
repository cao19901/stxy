package com.bootdo.clouddoadmin.service;

import org.springframework.stereotype.Service;


@Service
public interface TokenService {

    String createToken(Long userId);

    Long getUserIdByToken(String token);

    boolean removeToken(String token);
}
