package com.github.owljoa.study.utils;

import com.github.owljoa.study.member.entity.Member;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MemberExcelExporter {
  private final XSSFWorkbook workbook;
  private XSSFSheet sheet;
  private final List<Member> memberList;

  public MemberExcelExporter(List<Member> memberList) {
    this.memberList = memberList;
    workbook = new XSSFWorkbook();
  }

  public void export(HttpServletResponse response) throws IOException {
    final int COLUMN_COUNT = 4;

    writeHeader();
    writeData();

    for (int i = 0; i < COLUMN_COUNT; i++) {
      sheet.autoSizeColumn(i);
    }

    ServletOutputStream outputStream = response.getOutputStream();
    workbook.write(outputStream);
    workbook.close();

    outputStream.close();
  }

  private void writeHeader() {
    sheet = workbook.createSheet("Members");

    Row row = sheet.createRow(0);

    CellStyle style = workbook.createCellStyle();
    XSSFFont font = workbook.createFont();
    font.setBold(true);
    font.setFontHeight(16);
    style.setFont(font);

    addCell(row, 0, "번호", style);
    addCell(row, 1, "이름", style);
    addCell(row, 2, "팀번호", style);
    addCell(row, 3, "팀이름", style);
  }

  private void addCell(Row row, int columnNumber, Object value, CellStyle style) {
    Cell cell = row.createCell(columnNumber);

    if (value instanceof Long) {
      cell.setCellValue((Long) value);
    } else if (value instanceof Boolean) {
      cell.setCellValue((Boolean) value);
    } else {
      cell.setCellValue((String) value);
    }

    cell.setCellStyle(style);
  }

  private void writeData() {
    int rowNumber = 1;

    CellStyle style = workbook.createCellStyle();
    XSSFFont font = workbook.createFont();
    font.setFontHeight(14);
    style.setFont(font);

    for (Member member : memberList) {
      Row row = sheet.createRow(rowNumber);

      int columnNumber = 0;

      addCell(row, columnNumber, member.getId(), style);
      columnNumber += 1;
      addCell(row, columnNumber, member.getName(), style);
      columnNumber += 1;
      addCell(row, columnNumber, member.getTeam().getId(), style);
      columnNumber += 1;
      addCell(row, columnNumber, member.getTeam().getName(), style);

      rowNumber += 1;
    }
  }
}
