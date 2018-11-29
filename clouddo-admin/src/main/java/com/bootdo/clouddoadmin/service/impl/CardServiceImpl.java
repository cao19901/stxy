package com.bootdo.clouddoadmin.service.impl;

import com.bootdo.clouddoadmin.dao.CardDao;
import com.bootdo.clouddoadmin.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardDao cardMapper;

    @Override
    public List<Map<String, Object>> list() {
        return cardMapper.list();
    }
}
