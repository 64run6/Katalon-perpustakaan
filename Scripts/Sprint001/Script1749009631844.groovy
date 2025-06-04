import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


	boolean isLoginSuccessful
	String message

	WebUI.openBrowser(null)
	
	WebUI.navigateToUrl('http://192.168.100.186:5173/signin')
	
	isLoginSuccessful =WebUI.setText(findTestObject('Object Repository/Login/input_NPM_npm'), '888')
	message =  "Masukan Nim "
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'('TC001',message ,isLoginSuccessful)
	
	isLoginSuccessful = WebUI.setText(findTestObject('Object Repository/Login/input_Password_password'), '888')
	message =  "Masukan Password "
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'('TC002',message ,isLoginSuccessful)
	
	WebUI.click(findTestObject('Object Repository/Login/button_Login'))
	
	WebUI.waitForAlert(10)
	
	WebUI.acceptAlert()
	
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Login/h2_Selamat Datang di Perpustakaan Nurtanio Bandung'),10)
	message = "Berhasil Click Tombol Login"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'('TC003', message, isLoginSuccessful)
	
	
	WebUI.closeBrowser()
	