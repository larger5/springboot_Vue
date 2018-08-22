package com.cun.itaem.controller;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSException;
import com.cun.itaem.entity.Honor;
import com.cun.itaem.entity.Honor;
import com.cun.itaem.service.HonorService;
import com.cun.itaem.utils.Json;
import com.cun.itaem.utils.Oss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@EnableSwagger2
public class HonorController {

    @Autowired
    private HonorService honorService;

    @GetMapping("getHonorById/{id}")
    public Map<String, Object> getHonorById(@PathVariable Integer id) {
        Honor honorById = honorService.getHonorById(id);
        if(honorById==null){
            return Json.fail();
        }else {
            return Json.success(honorById);
        }

    }

    @DeleteMapping("deleteHonorById/{id}")
    public Map<String, Object> deleteHonorById(@PathVariable Integer id) {
        Honor honorById = honorService.getHonorById(id);
        if(honorById==null){
            return Json.fail();
        }else{
            honorService.deleteHonorById(id);
            return Json.success(honorById);
        }
    }

    @GetMapping("getAllHonors")
    public Map<String, Object> getAllHonors() {
        List<Honor> allHonors = honorService.getAllHonors();
        if (allHonors.size() == 0) {
            return Json.fail();
        } else {
            return Json.success(allHonors);
        }
    }

    @PostMapping("insertHonor")
    public Map<String, Object> insertHonor(Honor honor,
                                               @RequestParam(value = "fileupload", required = false) MultipartFile fileupload)
            throws OSSException, ClientException, IOException {
        if (fileupload != null) {
            honor.setPath(Oss.getUrl(fileupload));
        }
        honorService.insertHonor(honor);
        return Json.success(honor);
    }

    @PutMapping("updateHonor")
    public Map<String, Object> updateHonor(Honor honor,
                                               @RequestParam(value = "fileupload", required = false) MultipartFile fileupload)
            throws OSSException, ClientException, IOException {
        if (fileupload != null) {
            honor.setPath(Oss.getUrl(fileupload));
        }
        honorService.updateHonor(honor);
        return Json.success(honor);
    }
}
