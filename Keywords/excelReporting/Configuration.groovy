package excelReporting

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.configuration.RunConfiguration

import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.*
import org.apache.poi.ss.util.CellRangeAddress

import java.text.SimpleDateFormat
import java.util.Date
import java.io.*

public class Configuration {

	private static String lastTestCaseId = ""
	private static Set<String> existingTestCases = new HashSet<>()

	@Keyword
	synchronized def writeLoginResult(String tcId, String message, boolean isSuccess) {
		String filePath = "D:/KULIAH/baru/ReportFungsionalPerpus.xlsx"
		String screenshotDir = RunConfiguration.getProjectDir() + "/Screenshots"
		File file = new File(filePath)
		Workbook workbook
		Sheet sheet
		boolean isNewFile = false

		try {
			// Buat screenshot
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())
			String screenshotFileName = "Screenshot_" + tcId + "_" + timestamp + ".png"
			String screenshotPath = screenshotDir + "/" + screenshotFileName

			File screenshotFolder = new File(screenshotDir)
			if (!screenshotFolder.exists()) {
				screenshotFolder.mkdirs()
			}

			WebUI.takeScreenshot(screenshotPath)

			if (file.exists() && file.length() > 0) {
				FileInputStream fis = new FileInputStream(file)
				workbook = WorkbookFactory.create(fis)
				sheet = workbook.getSheetAt(0)
				fis.close()
			} else {
				workbook = new XSSFWorkbook()
				sheet = workbook.createSheet("Login Results")
				isNewFile = true
			}

			// Styles
			Font boldFont = workbook.createFont()
			boldFont.setBold(true)

			CellStyle centerStyle = workbook.createCellStyle()
			centerStyle.setAlignment(HorizontalAlignment.CENTER)

			CellStyle borderedStyle = workbook.createCellStyle()
			borderedStyle.setBorderTop(BorderStyle.THIN)
			borderedStyle.setBorderBottom(BorderStyle.THIN)
			borderedStyle.setBorderLeft(BorderStyle.THIN)
			borderedStyle.setBorderRight(BorderStyle.THIN)

			CellStyle headerStyle = workbook.createCellStyle()
			headerStyle.cloneStyleFrom(borderedStyle)
			headerStyle.setFont(boldFont)
			headerStyle.setAlignment(HorizontalAlignment.CENTER)

			// Jika file baru, buat judul dan header kolom
			int currentRow = sheet.getLastRowNum() + 1
			if (isNewFile) {
				// Judul
				Row titleRow = sheet.createRow(0)
				Cell titleCell = titleRow.createCell(0)
				sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4))
				for (int i = 0; i <= 4; i++) {
					titleRow.createCell(i).setCellStyle(borderedStyle)
				}
				titleCell.setCellValue("Perpustakaan Web Chrome")
				titleCell.setCellStyle(headerStyle)

				// Header kolom
				Row headerRow = sheet.createRow(1)
				String[] headers = [
					"TC ID",
					"Message",
					"Capture",
					"Status",
					"Note"
				]
				for (int i = 0; i < headers.length; i++) {
					Cell cell = headerRow.createCell(i)
					cell.setCellValue(headers[i])
					cell.setCellStyle(headerStyle)
				}
				currentRow = 2
			} else {
				currentRow = sheet.getLastRowNum() + 1
			}

			// Jika TC belum pernah ditulis, buat header TC
			if (!existingTestCases.contains(tcId)) {
				Row tcHeaderRow = sheet.createRow(currentRow++)
				Cell tcHeaderCell = tcHeaderRow.createCell(0)
				sheet.addMergedRegion(new CellRangeAddress(tcHeaderRow.getRowNum(), tcHeaderRow.getRowNum(), 0, 4))
				for (int i = 0; i <= 4; i++) {
					tcHeaderRow.createCell(i).setCellStyle(borderedStyle)
				}
				tcHeaderCell.setCellValue("[" + tcId + "]")
				tcHeaderCell.setCellStyle(headerStyle)
				existingTestCases.add(tcId)
			}

			// Tambahkan baris data
			Row row = sheet.createRow(currentRow)
			Cell cell0 = row.createCell(0)
			cell0.setCellValue(tcId)
			cell0.setCellStyle(borderedStyle)

			Cell cell1 = row.createCell(1)
			cell1.setCellValue(message)
			cell1.setCellStyle(borderedStyle)

			// Tambah gambar
			FileInputStream imageStream = new FileInputStream(screenshotPath)
			byte[] bytes = imageStream.bytes
			int pictureIdx = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG)
			imageStream.close()

			CreationHelper helper = workbook.getCreationHelper()
			Drawing<?> drawing = sheet.createDrawingPatriarch()
			ClientAnchor anchor = helper.createClientAnchor()
			anchor.setCol1(2)
			anchor.setRow1(currentRow)
			Picture pict = drawing.createPicture(anchor, pictureIdx)
			pict.resize(1)

			Cell cell3 = row.createCell(3)
			cell3.setCellValue(isSuccess ? "VALID" : "INVALID")
			cell3.setCellStyle(borderedStyle)

			Cell cell4 = row.createCell(4)
			cell4.setCellValue("")
			cell4.setCellStyle(borderedStyle)

			// Autosize kolom
			for (int i = 0; i <= 4; i++) {
				sheet.autoSizeColumn(i)
			}

			// Simpan file
			FileOutputStream out = new FileOutputStream(file)
			workbook.write(out)
			out.close()
			workbook.close()
		} catch (Exception e) {
			println "Gagal menulis ke Excel: ${e.message}"
		}
	}
}
