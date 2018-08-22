package com.cun.itaem.controller;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSException;
import com.cun.itaem.entity.Direction;
import com.cun.itaem.service.DirectionService;
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
public class DirectionController {

    @Autowired
    private DirectionService directionService;

    @GetMapping("getDirectionById/{id}")
    public Map<String, Object> getDirectionById(@PathVariable Integer id) {
        Direction directionById = directionService.getDirectionById(id);
        if(directionById==null){
            return Json.fail();
        }else {
            return Json.success(directionById);
        }

    }

    @DeleteMapping("deleteDirectionById/{id}")
    public Map<String, Object> deleteDirectionById(@PathVariable Integer id) {
        Direction directionById = directionService.getDirectionById(id);
        if(directionById==null){
            return Json.fail();
        }else{
            directionService.deleteDirectionById(id);
            return Json.success(directionById);
        }
    }

    @GetMapping("getAllDirections")
    public Map<String, Object> getAllDirections() {
        List<Direction> allDirections = directionService.getAllDirections();
        if (allDirections.size() == 0) {
            return Json.fail();
        } else {
            return Json.success(allDirections);
        }
    }

    @PostMapping("insertDirection")
    public Map<String, Object> insertDirection(Direction direction,
                                               @RequestParam(value = "fileupload", required = false) MultipartFile fileupload)
            throws OSSException, ClientException, IOException {
        if (fileupload != null) {
            direction.setPath(Oss.getUrl(fileupload));
        }
        directionService.insertDirection(direction);
        return Json.success(direction);
    }

    @PutMapping("updateDirection")
    public Map<String, Object> updateDirection(Direction direction,
                                               @RequestParam(value = "fileupload", required = false) MultipartFile fileupload)
            throws OSSException, ClientException, IOException {
        if (fileupload != null) {
            direction.setPath(Oss.getUrl(fileupload));
        }
        directionService.updateDirection(direction);
        return Json.success(direction);
    }
}
