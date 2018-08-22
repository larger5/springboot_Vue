package com.cun.itaem.controller;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSException;
import com.cun.itaem.entity.Production;
import com.cun.itaem.service.ProductionService;
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
public class ProductionController {

    @Autowired
    private ProductionService productionService;

    @GetMapping("getProductionById/{id}")
    public Map<String, Object> getProductionById(@PathVariable Integer id) {
        Production productionById = productionService.getProductionById(id);
        if(productionById==null){
            return Json.fail();
        }else {
            return Json.success(productionById);
        }

    }

    @DeleteMapping("deleteProductionById/{id}")
    public Map<String, Object> deleteProductionById(@PathVariable Integer id) {
        Production productionById = productionService.getProductionById(id);
        if(productionById==null){
            return Json.fail();
        }else{
            productionService.deleteProductionById(id);
            return Json.success(productionById);
        }
    }

    @GetMapping("getAllProductions")
    public Map<String, Object> getAllProductions() {
        List<Production> allProductions = productionService.getAllProductions();
        if (allProductions.size() == 0) {
            return Json.fail();
        } else {
            return Json.success(allProductions);
        }
    }

    @PostMapping("insertProduction")
    public Map<String, Object> insertProduction(Production production,
                                               @RequestParam(value = "fileupload", required = false) MultipartFile fileupload)
            throws OSSException, ClientException, IOException {
        if (fileupload != null) {
            production.setPath(Oss.getUrl(fileupload));
        }
        productionService.insertProduction(production);
        return Json.success(production);
    }

    @PutMapping("updateProduction")
    public Map<String, Object> updateProduction(Production production,
                                               @RequestParam(value = "fileupload", required = false) MultipartFile fileupload)
            throws OSSException, ClientException, IOException {
        if (fileupload != null) {
            production.setPath(Oss.getUrl(fileupload));
        }
        productionService.updateProduction(production);
        return Json.success(production);
    }
}
