package com.github.owljoa.study.member.controller;

import com.github.owljoa.study.member.entity.Member;
import com.github.owljoa.study.member.service.MemberService;
import com.github.owljoa.study.utils.MemberExcelExporter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @GetMapping("/member/export/excel")
  public void exportToExcel(HttpServletResponse response) throws IOException {
    response.setContentType("application/octet-stream");
    DateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
    String currentDateTime = dateFormatter.format(new Date());

    String headerKey = "Content-Disposition";
    String headerValue = "attachment; filename=members_" + currentDateTime + ".xlsx";
    response.setHeader(headerKey, headerValue);

    List<Member> memberList = memberService.getAllMember();

    MemberExcelExporter excelExporter = new MemberExcelExporter(memberList);
    excelExporter.export(response);
  }
}
