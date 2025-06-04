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
Tc001() {
    WebUI.openBrowser(null)

    WebUI.navigateToUrl('http://192.168.100.186:5173/signin')
	
	GlobalVariable.fileName = "TestReport"
    CustomKeywords.'excelReporting.Configuration.excelReportings'(
        GlobalVariable.fileName,
        findTestObject('Object Repository/Login/input_MASUK_account'),
        'TC01', '1. Input NIM'
    )
    WebUI.setText(findTestObject('Object Repository/Login/input_MASUK_account'), '55201122066')

    CustomKeywords.'excelReporting.Configuration.excelReportings'(
        GlobalVariable.fileName,
        findTestObject('Object Repository/Login/input_MASUK_password'),
        'TC01', '2. Input Password'
    )
    WebUI.setEncryptedText(findTestObject('Object Repository/Login/input_MASUK_password'), 'GxKgGrWX2Z7n8zPL97BtEg==')

    CustomKeywords.'excelReporting.Configuration.excelReportings'(
        GlobalVariable.fileName,
        findTestObject('Object Repository/Login/button_Masuk eStudy'),
        'TC01', '3. Klik Tombol Login'
    )
    WebUI.click(findTestObject('Object Repository/Login/button_Masuk eStudy'))

    boolean isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Login/p_Halo MUHAMAD TIGAR PRIATNA,'), 10)


    WebUI.closeBrowser()
}