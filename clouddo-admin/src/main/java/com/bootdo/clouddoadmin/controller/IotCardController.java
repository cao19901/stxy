package com.bootdo.clouddoadmin.controller;


import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.fastjson.JSON;
import com.bootdo.clouddoadmin.domain.ImportCardInfoDO;
import com.bootdo.clouddoadmin.dto.CardEecelInfo;
import com.bootdo.clouddoadmin.dto.IotcardDTO;
import com.bootdo.clouddoadmin.service.CardService;
import com.bootdo.clouddocommon.enums.GlobalEnum;
import com.bootdo.clouddocommon.enums.SaleStateEnum;
import com.bootdo.clouddocommon.exception.MyRuntimeException;
import com.bootdo.clouddocommon.utils.PageUtils;
import com.bootdo.clouddocommon.utils.ResultVO;
import com.bootdo.clouddocommon.utils.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@Slf4j
@RequestMapping("/card")
public class IotCardController extends BaseController {

    @Autowired
    private  CardService cardService ;

    /**
     * 获取物联网卡信息列表
     * @param params
     * @return
     */
    @GetMapping
    public ResultVO list(@RequestParam Map<String, Object> params) {
        PageHelper.offsetPage(PageUtils.getOffset(params),PageUtils.getLimit(params));

        List<Map<String, Object>> list = cardService.list(params);
        PageInfo<Map<String, Object>> mapPageInfo = new PageInfo<>(list);

        return  ResultVO.ok();
    }


    /**
     * 导入 物联网卡信息
     * @param importCardInfoDO
     * @return
     */
    @PostMapping("/import")
    public ResultVO importCardInfoFromExecl(@RequestBody ImportCardInfoDO importCardInfoDO ){
        log.debug("导入卡信息的参数是 " + JSON.toJSON(importCardInfoDO));
        InputStream inputStream = null ;
        List<IotcardDTO> collect = new ArrayList<>();
        try {
             inputStream = new FileInputStream(importCardInfoDO.getExcelPath()) ;
             if (inputStream == null ){
                 throw new MyRuntimeException(GlobalEnum.ERROE901);
             }
             List<Object> cardEecelInfoList = EasyExcelFactory.read(inputStream, new Sheet(1, 1, CardEecelInfo.class));
                //读取excel 中的信息, 放入list 中
                collect = cardEecelInfoList.stream().map((e) -> {
                IotcardDTO iotcardDTO = new IotcardDTO();
                BeanUtils.copyProperties(e, iotcardDTO);
                return excelInfoToCardDTO(importCardInfoDO, iotcardDTO);
            }).collect(Collectors.toList());

            cardService.saveCards(collect , importCardInfoDO ) ;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (null != inputStream){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return ResultVO.ok();
    }

    private IotcardDTO excelInfoToCardDTO(@RequestBody ImportCardInfoDO importCardInfoDO, IotcardDTO iotcardDTO) {
        String iccid = iotcardDTO.getIccid();
        iotcardDTO.setClienIccid(iccid.substring(7, iccid.length()));
        iotcardDTO.setSupplierId(importCardInfoDO.getSupplierId());
        iotcardDTO.setPackageId(importCardInfoDO.getPackageId());
        if (StringUtils.isNotEmpty(importCardInfoDO.getCardType())) {
            iotcardDTO.setCardType(importCardInfoDO.getCardType());
        }
        if (StringUtils.isNotEmpty(importCardInfoDO.getClientId())) {
            iotcardDTO.setSaleState(SaleStateEnum.SALING.getCode());
        }else{
            iotcardDTO.setSaleState(SaleStateEnum.UNBIND.getCode());
        }
        return iotcardDTO;
    }


}
