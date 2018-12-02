package com.bootdo.clouddocms.controller;

import com.bootdo.clouddocms.domain.FileDO;
import com.bootdo.clouddocms.dto.FileDTO;
import com.bootdo.clouddocms.dto.convert.FileConvert;
import com.bootdo.clouddocms.service.FileService;
import com.bootdo.clouddocommon.context.FilterContextHandler;
import com.bootdo.clouddocommon.utils.FileUtils;
import com.bootdo.clouddocommon.utils.PageUtils;
import com.bootdo.clouddocommon.utils.Query;
import com.bootdo.clouddocommon.utils.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;



@RestController
@RequestMapping("/file")
public class FileController {
    @Value("${app.filePath}")
    String filePath;

    @Value("${app.pre}")
    String filePre;

    @Autowired
    private FileService fileService;

    @GetMapping("{id}")
    public ResultVO get(@PathVariable Long id) {
        FileDTO fileDTO = FileConvert.MAPPER.do2dto(fileService.get(id));
        return ResultVO.data(fileDTO);
    }

    @GetMapping("getToken")
    public ResultVO getToken() {
        return ResultVO.ok().put("token", FilterContextHandler.getToken()).put("url", "http://localhost:8002/api-cms/file/upload")
                .put("key", UUID.randomUUID().toString());
    }

    @PostMapping("upload")
    public ResultVO upload(MultipartFile file, String key) {
        try {
            String resPath = FileUtils.saveFile(file.getBytes(), filePath, key);
            fileService.save(new FileDO() {{
                setCreateDate(new Date());
                setUrl("http://localhost:8004" + filePre + "/"+resPath);
                setType(1);
            }});
            return ResultVO.ok().put("resPath", resPath);
        } catch (IOException e) {
            e.printStackTrace();
            return ResultVO.error("文件上传失败");
        }
    }


    @GetMapping
    public ResultVO list(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<FileDO> fileList = fileService.list(query);

        int total = fileService.count(query);

        PageUtils pageUtils = new PageUtils(fileList, total);
        return ResultVO.page(pageUtils);
    }


    @PostMapping
    public ResultVO save(FileDO file) {
        return ResultVO.operate(fileService.save(file) > 0);
    }


    @PutMapping
    public ResultVO update(FileDO file) {
        return ResultVO.operate(fileService.update(file) > 0);
    }


    @DeleteMapping
    public ResultVO remove(Long id) {
        return ResultVO.operate(fileService.remove(id) > 0);
    }


    @DeleteMapping("/batchRemove")
    public ResultVO remove(@RequestParam("ids[]") Long[] ids) {
        return ResultVO.operate(fileService.batchRemove(ids) > 0);
    }
}
