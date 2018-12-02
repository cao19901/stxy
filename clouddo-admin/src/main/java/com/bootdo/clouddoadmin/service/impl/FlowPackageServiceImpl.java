package com.bootdo.clouddoadmin.service.impl;

import com.bootdo.clouddoadmin.dao.FlowPackageDao;
import com.bootdo.clouddoadmin.dto.FlowPackageDTO;
import com.bootdo.clouddoadmin.service.FlowPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 曹晓维
 */
@Service
public class FlowPackageServiceImpl implements FlowPackageService {

    @Autowired
    private FlowPackageDao flowPackageMapper;

    @Override
    public List<FlowPackageDTO> list() {
        return flowPackageMapper.list();
    }
}
