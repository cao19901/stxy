package com.bootdo.clouddoadmin.service.impl;

import com.bootdo.clouddoadmin.dao.CardMapper;
import com.bootdo.clouddoadmin.dao.ClientCardRelationDao;
import com.bootdo.clouddoadmin.domain.ImportCardInfoDO;
import com.bootdo.clouddoadmin.dto.ClientCardRelationDTO;
import com.bootdo.clouddoadmin.dto.IotcardDTO;
import com.bootdo.clouddoadmin.service.CardService;
import com.bootdo.clouddocommon.enums.CardOwnTypeEnum;
import com.bootdo.clouddocommon.utils.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardMapper cardMapper;

    @Autowired
    private ClientCardRelationDao clientCardRelationMapper;

    @Override
    public List<Map<String, Object>> list(Map<String , Object> params) {
        return cardMapper.list();
    }


    /**
     * @param collect          excel 中读取的卡信息 和 拼接好的其他信息参数
     * @param importCardInfoDO 前台传递的参数列表
     */
    @Override
    @Transient // 插入两张表 保持事务的一致性
    public void saveCards(List<IotcardDTO> collect, ImportCardInfoDO importCardInfoDO) {

        cardMapper.insertList(collect);
        if (StringUtils.isNotEmpty(importCardInfoDO.getClientId())) { // 如果导入的是否选择了客户 , 则走下面的逻辑
            List<ClientCardRelationDTO> cardRelationDTOList = collect.stream().map((e) -> {
                ClientCardRelationDTO cardRelationDTO = new ClientCardRelationDTO();
                BeanUtils.copyProperties(e, cardRelationDTO);
                cardRelationDTO.setClientId(importCardInfoDO.getClientId());
                cardRelationDTO.setOwnClientId(importCardInfoDO.getClientId());
                cardRelationDTO.setType(CardOwnTypeEnum.OWNER.getCode());
                return cardRelationDTO;
            }).collect(Collectors.toList());
            clientCardRelationMapper.insertList(cardRelationDTOList);
        }

    }
}
