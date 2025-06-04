package excelReporting

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.configuration.RunConfiguration

import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.*

import java.text.SimpleDateFormat
import java.nio.file.*
import java.util.Date
import java.io.*

public class Configuration {

	@Keyword
	synchronized def writeLoginResult(String No, String Massage, boolean isSuccess) {
		String filePath = "C:/KULIAH/baru/Perpus.xlsx"
		String screenshotDir = RunConfiguration.getProjectDir() + "/Screenshots"
		File file = new File(filePath)
		Workbook workbook
		Sheet sheet

		try {
			// Buat screenshot
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())
			String screenshotFileName = "Screenshot_" + No + "_" + timestamp + ".png"
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

				Row header = sheet.createRow(0)
				header.createCell(0).setCellValue("No")
				header.createCell(1).setCellValue("Massage")
				header.createCell(2).setCellValue("ScreenShot")
			}

			int lastRow = sheet.getLastRowNum() + 2
			Row row = sheet.createRow(lastRow)
			row.createCell(0).setCellValue(No)
			row.createCell(1).setCellValue(Massage)

			FileInputStream imageStream = new FileInputStream(screenshotPath)
			byte[] bytes = imageStream.bytes
			int pictureIdx = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG)
			imageStream.close()

			CreationHelper helper = workbook.getCreationHelper()
			Drawing<?> drawing = sheet.createDrawingPatriarch()
			ClientAnchor anchor = helper.createClientAnchor()
			anchor.setCol1(2)
			anchor.setRow1(lastRow)
			Picture gbr = drawing.createPicture(anchor, pictureIdx)
			gbr.resize(2)

			FileOutputStream out = new FileOutputStream(file)
			workbook.write(out)
			out.close()
			workbook.close()
		} catch (Exception e) {
			println "Gagal menulis ke Excel: ${e.message}"
		}
	}
}
