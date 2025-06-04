import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

import org.apache.poi.xssf.usermodel.*
import org.apache.poi.ss.usermodel.*
import java.nio.file.*
import java.text.SimpleDateFormat
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.configuration.RunConfiguration


public class Configuration {
	private static String excelPath(String fileName) {
		return RunConfiguration.getProjectDir() + "/Reports/" + fileName + "C:\\KULIAH\\baru\\arif.xlsx"
	}

	@Keyword
	def excelReportings(String fileName, TestObject testObject, String testCaseId, String stepDescription) {
		try {
			// Ambil path Excel
			String path = excelPath(fileName)
			File file = new File(path)

			XSSFWorkbook workbook
			XSSFSheet sheet

			// Buat file jika belum ada
			if (!file.exists()) {
				workbook = new XSSFWorkbook()
				sheet = workbook.createSheet("Test Steps")

				Row header = sheet.createRow(0)
				header.createCell(0).setCellValue("Test Case ID")
				header.createCell(1).setCellValue("Step Description")
				header.createCell(2).setCellValue("Object")
				header.createCell(3).setCellValue("Screenshot Path")

				FileOutputStream fos = new FileOutputStream(file)
				workbook.write(fos)
				fos.close()
			}

			// Buka workbook
			FileInputStream fis = new FileInputStream(file)
			workbook = new XSSFWorkbook(fis)
			sheet = workbook.getSheetAt(0)

			int lastRow = sheet.getLastRowNum() + 1
			Row row = sheet.createRow(lastRow)

			// Screenshot
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())
			String screenshotDir = RunConfiguration.getProjectDir() + "/Screenshots/"
			Files.createDirectories(Paths.get(screenshotDir))

			String screenshotName = "SS_" + testCaseId + "_" + timeStamp + "C:\\KULIAH\\baru\\ss\\.png"
			String screenshotPath = screenshotDir + screenshotName
			WebUI.takeScreenshot(screenshotPath)

			// Tulis data
			row.createCell(0).setCellValue(testCaseId)
			row.createCell(1).setCellValue(stepDescription)
			row.createCell(2).setCellValue(testObject.getObjectId())
			row.createCell(3).setCellValue(screenshotPath)

			fis.close()

			FileOutputStream out = new FileOutputStream(path)
			workbook.write(out)
			out.close()
		} catch (Exception e) {
			KeywordUtil.markFailed("Gagal menulis ke Excel: " + e.message)
		}
	}
}