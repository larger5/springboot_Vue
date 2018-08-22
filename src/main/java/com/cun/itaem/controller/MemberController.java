package com.cun.itaem.controller;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSException;
import com.cun.itaem.entity.Member;
import com.cun.itaem.entity.Member;
import com.cun.itaem.service.MemberService;
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
public class MemberController {
    
    @Autowired
    private MemberService memberService;

    @GetMapping("getMemberById/{id}")
    public Map<String, Object> getMemberById(@PathVariable Integer id) {
        Member memberById = memberService.getMemberById(id);
        if(memberById==null){
            return Json.fail();
        }else {
            return Json.success(memberById);
        }

    }

    @DeleteMapping("deleteMemberById/{id}")
    public Map<String, Object> deleteMemberById(@PathVariable Integer id) {
        Member memberById = memberService.getMemberById(id);
        if(memberById==null){
            return Json.fail();
        }else{
            memberService.deleteMemberById(id);
            return Json.success(memberById);
        }
    }

    @GetMapping("getAllMembers")
    public Map<String, Object> getAllMembers() {
        List<Member> allMembers = memberService.getAllMembers();
        if (allMembers.size() == 0) {
            return Json.fail();
        } else {
            return Json.success(allMembers);
        }
    }

    @PostMapping("insertMember")
    public Map<String, Object> insertMember(Member member,
                                               @RequestParam(value = "fileupload", required = false) MultipartFile fileupload)
            throws OSSException, ClientException, IOException {
        if (fileupload != null) {
            member.setPath(Oss.getUrl(fileupload));
        }
        memberService.insertMember(member);
        return Json.success(member);
    }

    @PutMapping("updateMember")
    public Map<String, Object> updateMember(Member member,
                                               @RequestParam(value = "fileupload", required = false) MultipartFile fileupload)
            throws OSSException, ClientException, IOException {
        if (fileupload != null) {
            member.setPath(Oss.getUrl(fileupload));
        }
        memberService.updateMember(member);
        return Json.success(member);
    }
}
