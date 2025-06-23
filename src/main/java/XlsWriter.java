import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;

public class XlsWriter {

    public static void generateExcel(Collection<Statistics> statistics, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Statistics");

        // Create header style
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);

        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(headerFont);

        // Create header row
        Row headerRow = sheet.createRow(0);
        String[] headers = {"Profile", "Average Grade", "Students Count", "Universities Count", "University Name"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        // Fill data rows
        int rowNum = 1;
        for (Statistics stat : statistics) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(stat.getProfile());
            Cell gradeCell = row.createCell(1);
            if (stat.getAverageGrade() != null) {
                gradeCell.setCellValue(stat.getAverageGrade());
            } else {
                gradeCell.setCellValue("N/A"); // or leave blank, or any other indicator
            }
            row.createCell(2).setCellValue(stat.getStudentsCount());
            row.createCell(3).setCellValue(stat.getUniversitiesCount());
            row.createCell(4).setCellValue(stat.getUniversityName());
        }

        // Auto-size columns
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write to file
        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
        }
        workbook.close(); // Close workbook to release resources
    }
}