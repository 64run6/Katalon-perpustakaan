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

WebUI.openBrowser('')
WebUI.maximizeWindow()

TClogin()
//TC01()
//TC02()
//TC03()
//TC04()
//TC05()
//TC06()
//TC07()
//TC08()
//TC09()
//TC10()
//TC11()
//TC12()
//TC13()
//TC14()
//TC20()
//TC21()
//TC22()
//TC23()
//TC24()
//TC25()
//TC26()
//TC27()
//TC28()
//TC29()
//TC30()
//TC31()
//TC32()
//TC38()
//TC39()
//TC40()
//TC41()
TC42()


def TClogin() {
	WebUI.navigateToUrl('http://192.168.100.186:5173/signin')
	WebUI.delay(2)
	WebUI.setText(findTestObject('Object Repository/Login/input_NPM_npm'), '888')
	WebUI.setText(findTestObject('Object Repository/Login/input_Password_password'), '888')
	WebUI.click(findTestObject('Object Repository/Login/button_Login'))
	WebUI.waitForAlert(10)
	WebUI.acceptAlert()
}
def TC01() {
	boolean isLoginSuccessful
	String message, tcID
	tcID = "TC001"
		
	WebUI.navigateToUrl('http://192.168.100.186:5173/signin')
	
	// Masukan Nim
	WebUI.setText(findTestObject('Object Repository/Login/input_NPM_npm'), '888')
	isLoginSuccessful = WebUI.getAttribute(findTestObject('Object Repository/Login/input_NPM_npm'), 'value') == '888'
	message =  "Masukan NIM"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	// Masukan Password
	WebUI.setText(findTestObject('Object Repository/Login/input_Password_password'), '888')
	isLoginSuccessful = WebUI.getAttribute(findTestObject('Object Repository/Login/input_Password_password'), 'value') == '888'
	message =  "Masukan Password"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	// Klik tombol login dan verifikasi
	WebUI.click(findTestObject('Object Repository/Login/button_Login'))
	WebUI.waitForAlert(10)
	WebUI.acceptAlert()
	
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Login/h2_Selamat Datang di Perpustakaan Nurtanio Bandung'),10)
	message = "Berhasil Click Tombol Login"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	}
def TC02() {
	boolean isLoginSuccessful
	String message, tcID
	tcID = "TC002"

	WebUI.navigateToUrl('http://192.168.100.186:5173/register')
	
	WebUI.setText(findTestObject('Object Repository/Register/input_Nama_nama'), 'Muhamad')
	isLoginSuccessful = WebUI.getAttribute(findTestObject('Object Repository/Register/input_Nama_nama'), 'value') == 'Muhamad'
	message =  "Input Nama"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	WebUI.setText(findTestObject('Object Repository/Register/input_NPM_npm'), '6006')
	isLoginSuccessful = WebUI.getAttribute(findTestObject('Object Repository/Register/input_NPM_npm'), 'value') == '6006'
	message =  "Input NPM"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	WebUI.setText(findTestObject('Object Repository/Register/input_Password_password'), '6006')
	isLoginSuccessful = WebUI.getAttribute(findTestObject('Object Repository/Register/input_Password_password'),'value') == '6006'
	message =  "Input Password"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	WebUI.click(findTestObject('Object Repository/Register/button_Register'))
	WebUI.waitForAlert(10)
	WebUI.acceptAlert()
	
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Register/h2_Welcome Back'), 10)
	message = "Redirect to Login page"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	}
def TC03() {


	boolean isLoginSuccessful
	String message, tcID
	tcID = "TC003"
	
	WebUI.navigateToUrl('http://192.168.100.186:5173')
	
	WebUI.setText(findTestObject('Object Repository/Search/input_E-Book_search'), 'informatika')
	isLoginSuccessful = WebUI.getAttribute(findTestObject('Object Repository/Search/input_E-Book_search'), 'value') == 'informatika'
	message =  "Input Judul Buku"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)

	WebUI.click(findTestObject('Object Repository/Search/button_Cari'))
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Search/h2_Hasil Pencarian untuk informatika'), 10)
	message = "Redirect to Hasil Pencarian"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	}
def TC04() {
	boolean isLoginSuccessful
	String message, tcID
	tcID = "TC004"
	
	WebUI.navigateToUrl('http://192.168.100.186:5173')
	
	WebUI.click(findTestObject('Object Repository/Kategori/a_Rak Buku'))
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Kategori/a_Rak Buku'), 10)
	message = "Click Rak Buku"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Kategori/a_Rak Buku'), 10)
	message = "Click Kategori"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	WebUI.click(findTestObject('Object Repository/Kategori/a_Kategori'))
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Kategori/h2_Pilih kategori buku yang kamu mau baca yaak ()'), 10)
	message = "Redirect to kategori page"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	WebUI.click(findTestObject('Object Repository/Kategori/img_Pilih kategori buku yang kamu mau baca yaak ()_icon'))
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Kategori/h2_Buku Kategori INFORMATIKA'), 10)
	message = "Click Kategori informatika"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	}
def TC05() {
	boolean isLoginSuccessful
	String message, tcID
	tcID = "TC005"
	
	WebUI.click(findTestObject('Object Repository/Kategori/a_Rak Buku'))
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Kategori/a_Rak Buku'), 10)
	message = "Click Rak Buku"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Kategori/a_Rak Buku'), 10)
	message = "Click Kategori"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	WebUI.click(findTestObject('Object Repository/Kategori/a_Kategori'))
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Kategori/h2_Pilih kategori buku yang kamu mau baca yaak ()'), 10)
	message = "Redirect to kategori page"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	WebUI.click(findTestObject('Object Repository/Kategori/p_Penerbangan'))
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Kategori/h2_Buku Kategori PENERBANGAN'), 10)
	message = "Click Kategori Penerbangan"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	WebUI.scrollToPosition(0, 100)
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Kategori/img_Theory of Flight_cover-buku'), 10)
	message = "Click Buku"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	
	WebUI.click(findTestObject('Object Repository/Kategori/img_Theory of Flight_cover-buku'))
	WebUI.scrollToPosition(0, 0)
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Kategori/h1_ADVANCE AIRCRAFT SYSTEMS'), 10)
	message = "Redirect to Detail Buku page"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	}
def TC06() {
	boolean isLoginSuccessful
	String message, tcID
	tcID = "TC006"
		
	WebUI.openBrowser('')
	WebUI.navigateToUrl('http://192.168.100.186:5173/signin')

	WebUI.setText(findTestObject('Object Repository/Login/input_NPM_npm'), '888')
	isLoginSuccessful = WebUI.getAttribute(findTestObject('Object Repository/Login/input_NPM_npm'), 'value') == '888'
	message =  "Masukan NIM"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)

	WebUI.setText(findTestObject('Object Repository/Login/input_Password_password'), '889')
	isLoginSuccessful = WebUI.getAttribute(findTestObject('Object Repository/Login/input_Password_password'), 'value') == '889'
	message =  "Masukan Password"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	WebUI.click(findTestObject('Object Repository/Login/button_Login'))

	WebUI.waitForAlert(10)
	WebUI.acceptAlert()
	
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Login/h2_Welcome Back'),10)
	message = "Shown message: Login gagal! Periksa NPM dan Password. "
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)}
def TC07() {
	boolean isLoginSuccessful
	String message, tcID
	tcID = "TC007"
		
	WebUI.openBrowser('')
	WebUI.navigateToUrl('http://192.168.100.186:5173/signin')

	WebUI.setText(findTestObject('Object Repository/Login/input_NPM_npm'), '8888')
	isLoginSuccessful = WebUI.getAttribute(findTestObject('Object Repository/Login/input_NPM_npm'), 'value') == '8888'
	message =  "Masukan NIM"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)

	WebUI.setText(findTestObject('Object Repository/Login/input_Password_password'), '889')
	isLoginSuccessful = WebUI.getAttribute(findTestObject('Object Repository/Login/input_Password_password'), 'value') == '889'
	message =  "Masukan Password"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	WebUI.click(findTestObject('Object Repository/Login/button_Login'))
	WebUI.delay(2)
	WebUI.waitForAlert(10)
	WebUI.acceptAlert()
	
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Login/h2_Welcome Back'),10)
	message = "Shown message: Login gagal! Periksa NPM dan Password. "
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)}
def TC08() {
	boolean isLoginSuccessful
	String message, tcID
	tcID = "TC008"

	WebUI.navigateToUrl('http://192.168.100.186:5173/register')
	
	WebUI.setText(findTestObject('Object Repository/Register/input_Nama_nama'), 'garus1')
	isLoginSuccessful = WebUI.getAttribute(findTestObject('Object Repository/Register/input_Nama_nama'), 'value') == 'garus1'
	message =  "Input Nama"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
//	WebUI.setText(findTestObject('Object Repository/Register/input_NPM_npm'), '-')
//	isLoginSuccessful = WebUI.getAttribute(findTestObject('Object Repository/Register/input_NPM_npm'), 'value') == '-'
//	message =  "Input NPM"
//	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	WebUI.setText(findTestObject('Object Repository/Register/input_Password_password'), '00022')
	isLoginSuccessful = WebUI.getAttribute(findTestObject('Object Repository/Register/input_Password_password'),'value') == '00022'
	message =  "Input Password"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	WebUI.click(findTestObject('Object Repository/Register/button_Register'))
	
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Register/h2_Welcome Back'),10)
	message = "tidak dapat membuat akun karena NPM kosong"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	}
def TC09() {
	boolean isLoginSuccessful
	String message, tcID
	tcID = "TC009"

	WebUI.navigateToUrl('http://192.168.100.186:5173/register')
	
//	WebUI.setText(findTestObject('Object Repository/Register/input_Nama_nama'), 'garus1')
//	isLoginSuccessful = WebUI.getAttribute(findTestObject('Object Repository/Register/input_Nama_nama'), 'value') == 'garus1'
//	message =  "Input Nama"
//	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	WebUI.setText(findTestObject('Object Repository/Register/input_NPM_npm'), '555')
	isLoginSuccessful = WebUI.getAttribute(findTestObject('Object Repository/Register/input_NPM_npm'), 'value') == '555'
	message =  "Input NPM"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	WebUI.setText(findTestObject('Object Repository/Register/input_Password_password'), '555')
	isLoginSuccessful = WebUI.getAttribute(findTestObject('Object Repository/Register/input_Password_password'),'value') == '555'
	message =  "Input Password"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	WebUI.click(findTestObject('Object Repository/Register/button_Register'))
	
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Register/h2_Welcome Back'),10)
	message = "tidak dapat membuat akun karena Nama kosong"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	}
def TC10() {
	boolean isLoginSuccessful
	String message, tcID
	tcID = "TC010"

	WebUI.navigateToUrl('http://192.168.100.186:5173/register')
	
	WebUI.setText(findTestObject('Object Repository/Register/input_Nama_nama'), 'garus1')
	isLoginSuccessful = WebUI.getAttribute(findTestObject('Object Repository/Register/input_Nama_nama'), 'value') == 'garus1'
	message =  "Input Nama"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	WebUI.setText(findTestObject('Object Repository/Register/input_NPM_npm'), '555')
	isLoginSuccessful = WebUI.getAttribute(findTestObject('Object Repository/Register/input_NPM_npm'), 'value') == '555'
	message =  "Input NPM"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
//	WebUI.setText(findTestObject('Object Repository/Register/input_Password_password'), '555')
//	isLoginSuccessful = WebUI.getAttribute(findTestObject('Object Repository/Register/input_Password_password'),'value') == '555'
//	message =  "Input Password"
//	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	WebUI.click(findTestObject('Object Repository/Register/button_Register'))
	
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Register/h2_Welcome Back'),10)
	message = "tidak dapat membuat akun karena Password kosong"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	}
def TC11() {
	boolean isLoginSuccessful
	String message, tcID
	tcID = "TC011"
	WebUI.click(findTestObject('Object Repository/Search/button_Cari'))
	
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Search/button_Cari'),10)
	message = "Tidak ada action apa apa"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)}
def TC12() {
	boolean isLoginSuccessful
	String message, tcID
	tcID = "TC012"

	WebUI.navigateToUrl('http://192.168.100.186:5173/register')
	
	WebUI.setText(findTestObject('Object Repository/Register/input_Nama_nama'), 'arif')
	isLoginSuccessful = WebUI.getAttribute(findTestObject('Object Repository/Register/input_Nama_nama'), 'value') == 'arif'
	message =  "Input Nama"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	WebUI.setText(findTestObject('Object Repository/Register/input_NPM_npm'), '888')
	isLoginSuccessful = WebUI.getAttribute(findTestObject('Object Repository/Register/input_NPM_npm'), 'value') == '888'
	message =  "Input NPM Terdaftar"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	WebUI.setText(findTestObject('Object Repository/Register/input_Password_password'), '888')
	isLoginSuccessful = WebUI.getAttribute(findTestObject('Object Repository/Register/input_Password_password'),'value') == '888'
	message =  "Input Password"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	WebUI.click(findTestObject('Object Repository/Register/button_Register'))
	WebUI.waitForAlert(10)
	WebUI.acceptAlert()
	
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Register/h2_Welcome Back'),10)
	message = "tidak dapat membuat akun karena NPM sudah terdaftar"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
}
def TC13() {
	boolean isLoginSuccessful
	String message, tcID
	tcID = "TC013"
	
	WebUI.navigateToUrl('http://192.168.100.186:5173/signin')
	
	WebUI.click(findTestObject('Object Repository/Register/a_Daftar di sini'))
	
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Register/h2_Welcome Back'),10)
	message = "Direct to register"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	}
def TC14() {
	boolean isLoginSuccessful
	String message, tcID
	tcID = "TC014"
	
	WebUI.click(findTestObject('Object Repository/Logout/img_Cari_rounded-circle dropdown-toggle'))
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Logout/img_Cari_rounded-circle dropdown-toggle'),10)
	message = "Deteksi login"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	WebUI.click(findTestObject('Object Repository/Logout/button_Logout'))
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Login/h2_Welcome Back'),10)
	message = "Berhasil Logout"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)}
def TC20() {
	boolean isLoginSuccessful
	String message, tcID
	tcID = "TC020"

	WebUI.navigateToUrl('http://192.168.100.186:5173/register')
	
	WebUI.setText(findTestObject('Object Repository/Register/input_Nama_nama'), 'dfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdf')
	isLoginSuccessful = WebUI.getAttribute(findTestObject('Object Repository/Register/input_Nama_nama'), 'value') == 'dfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdf'
	message =  "Input Nama lebih dari 255 huruf"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	WebUI.setText(findTestObject('Object Repository/Register/input_NPM_npm'), '000111')
	isLoginSuccessful = WebUI.getAttribute(findTestObject('Object Repository/Register/input_NPM_npm'), 'value') == '000111'
	message =  "Input NPM"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	WebUI.setText(findTestObject('Object Repository/Register/input_Password_password'), '000111')
	isLoginSuccessful = WebUI.getAttribute(findTestObject('Object Repository/Register/input_Password_password'),'value') == '000111'
	message =  "Input Password"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	WebUI.click(findTestObject('Object Repository/Register/button_Register'))
	WebUI.waitForAlert(10)
	WebUI.acceptAlert()
	
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Register/h2_Welcome Back'), 10)
	message = "Stay on register page"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)}
def TC21() {
	boolean isLoginSuccessful
	String message, tcID
	tcID = "TC021"
	
	WebUI.navigateToUrl('http://192.168.100.186:5173/kategori/informatika/detailbuku/14195')
	
	WebUI.scrollToElement(findTestObject('Object Repository/Komentar/div_Berikan Komentar'),2)
	WebUI.click(findTestObject('Object Repository/Komentar/span_'))
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Komentar/div_'),10)
	message =  "Memberi rating buku"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	WebUI.setText(findTestObject('Object Repository/Komentar/textarea_Komentar Kamu_komentar'), 'mantap')
	isLoginSuccessful = WebUI.getAttribute(findTestObject('Object Repository/Komentar/textarea_Komentar Kamu_komentar'), 'value') == 'mantap'
	message =  "Memberi komentar buku"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	WebUI.click(findTestObject('Object Repository/Komentar/button_Kirim Komentar'))
	WebUI.waitForAlert(10)
	WebUI.acceptAlert()
	WebUI.scrollToElement(findTestObject('Object Repository/Komentar/h2_Ulasan Pengguna'),2)
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Komentar/h2_Ulasan Pengguna'),10)
	message =  "Melihat Komentar"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)}
def TC22() {
	boolean isLoginSuccessful
	String message, tcID
	tcID = "TC022"
	
	WebUI.navigateToUrl('http://192.168.100.186:5173/kategori/informatika/detailbuku/14195')
	
	WebUI.click(findTestObject('Object Repository/wishlist/button_Wishlist'))
	WebUI.waitForAlert(10)
	WebUI.acceptAlert()
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/wishlist/button_Wishlist'),10)
	message =  "Click +wishlist"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	
	WebUI.navigateToUrl('http://192.168.100.186:5173/bookmark/888')
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/wishlist/h1_Daftar Bookmark Favoritmu'),10)
	message =  "Cek wishlist"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
}
def TC23() {
	boolean isLoginSuccessful
	String message, tcID
	tcID = "TC023"
	
	WebUI.click(findTestObject('Object Repository/Logout/img_Cari_rounded-circle dropdown-toggle'))
	WebUI.click(findTestObject('Object Repository/wishlist/a_Bookmark'))
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/wishlist/h1_Daftar Bookmark Favoritmu'),10)
	message =  "Masuk ke halaman Bookmark"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
		
	WebUI.click(findTestObject('Object Repository/wishlist/button_Hapus'))
	WebUI.waitForAlert(10)
	WebUI.acceptAlert()
	
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/wishlist/h1_Daftar Bookmark Favoritmu'),10)
	message =  "Wishlist Buku Terhapus"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
}
def TC24() {
	boolean isLoginSuccessful
	String message, tcID
	tcID = "TC024"
	
	WebUI.navigateToUrl('http://192.168.100.186:5173/kategori/informatika/detailbuku/14195')
	
	WebUI.scrollToElement(findTestObject('Object Repository/Komentar/div_Berikan Komentar'),2)
	WebUI.click(findTestObject('Object Repository/Komentar/span_'))
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Komentar/div_'),10)
	message =  "Memberi rating buku"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
//	WebUI.setText(findTestObject('Object Repository/Komentar/textarea_Komentar Kamu_komentar'), 'mantap')
//	isLoginSuccessful = WebUI.getAttribute(findTestObject('Object Repository/Komentar/textarea_Komentar Kamu_komentar'), 'value') == 'mantap'
//	message =  "Memberi komentar buku"
//	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
//	
	WebUI.click(findTestObject('Object Repository/Komentar/button_Kirim Komentar'))
	WebUI.waitForAlert(10)
	WebUI.acceptAlert()
	WebUI.scrollToElement(findTestObject('Object Repository/Komentar/h2_Ulasan Pengguna'),2)
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Komentar/h2_Ulasan Pengguna'),10)
	message =  "Tidak Ada komentar terbaru"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)}
def TC25() {
	boolean isLoginSuccessful
	String message, tcID
	tcID = "TC025"
	
	WebUI.navigateToUrl('http://192.168.100.186:5173/kategori/informatika/detailbuku/14195')
	
	WebUI.scrollToElement(findTestObject('Object Repository/Komentar/div_Berikan Komentar'),2)
//	WebUI.click(findTestObject('Object Repository/Komentar/span_'))
//	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Komentar/div_'),10)
//	message =  "Memberi rating buku"
//	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	WebUI.setText(findTestObject('Object Repository/Komentar/textarea_Komentar Kamu_komentar'), 'mantap')
	isLoginSuccessful = WebUI.getAttribute(findTestObject('Object Repository/Komentar/textarea_Komentar Kamu_komentar'), 'value') == 'mantap'
	message =  "Memberi komentar buku"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
//
	WebUI.click(findTestObject('Object Repository/Komentar/button_Kirim Komentar'))
	WebUI.waitForAlert(10)
	WebUI.acceptAlert()
	WebUI.scrollToElement(findTestObject('Object Repository/Komentar/h2_Ulasan Pengguna'),2)
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Komentar/h2_Ulasan Pengguna'),10)
	message =  "Tidak Ada komentar terbaru"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)}
def TC26() {
	boolean isLoginSuccessful
	String message, tcID
	tcID = "TC026"
	
	WebUI.navigateToUrl('http://192.168.100.186:5173/kategori/informatika/detailbuku/14195')
	
	
	WebUI.scrollToElement(findTestObject('Object Repository/Komentar/div_Berikan Komentar'),2)
//	WebUI.click(findTestObject('Object Repository/Komentar/span_'))/
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Komentar/button_Kirim Komentar'),10)
	message =  "Click button Komentar"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
//	WebUI.setText(findTestObject('Object Repository/Komentar/textarea_Komentar Kamu_komentar'), 'mantap')
//	isLoginSuccessful = WebUI.getAttribute(findTestObject('Object Repository/Komentar/textarea_Komentar Kamu_komentar'), 'value') == 'mantap'
//	message =  "Memberi komentar buku"
//	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	WebUI.click(findTestObject('Object Repository/Komentar/button_Kirim Komentar'))
	WebUI.waitForAlert(10)
	WebUI.acceptAlert()
	WebUI.scrollToElement(findTestObject('Object Repository/Komentar/h2_Ulasan Pengguna'),2)
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Komentar/h2_Ulasan Pengguna'),10)
	message =  "Komentar tidak ada"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)}
def TC27() {
	boolean isLoginSuccessful
	String message, tcID
	tcID = "TC027"
	
	WebUI.navigateToUrl('http://192.168.100.186:5173/kategori/informatika/detailbuku/14195')
	
	
	WebUI.scrollToElement(findTestObject('Object Repository/Komentar/div_Berikan Komentar'),2)
	WebUI.click(findTestObject('Object Repository/Komentar/span_'))
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Komentar/button_Kirim Komentar'),10)
	message =  "Click Rating"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	WebUI.setText(findTestObject('Object Repository/Komentar/textarea_Komentar Kamu_komentar'), 'cakep')
	isLoginSuccessful = WebUI.getAttribute(findTestObject('Object Repository/Komentar/textarea_Komentar Kamu_komentar'), 'value') == 'cakep'
	message =  "Beri komentar buku"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	WebUI.click(findTestObject('Object Repository/Komentar/button_Kirim Komentar'))
	WebUI.waitForAlert(10)
	WebUI.acceptAlert()
	WebUI.scrollToElement(findTestObject('Object Repository/Komentar/h2_Ulasan Pengguna'),2)
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Komentar/h2_Ulasan Pengguna'),10)
	message =  "Komentar tidak Masuk karena belum login"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)}
def TC28() {
	boolean isLoginSuccessful
	String message, tcID
	tcID = "TC028"
	
	WebUI.navigateToUrl('http://192.168.100.186:5173/kategori/informatika/detailbuku/14195')
	WebUI.delay(2)
	
	
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/wishlist/button_Wishlist'),10)
	message =  "Click +wishlist"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	WebUI.click(findTestObject('Object Repository/wishlist/button_Wishlist'))
	WebUI.waitForAlert(10)
	WebUI.acceptAlert()
	
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Login/h2_Welcome Back'),10)
	message =  "WishList tidak masuk karena belum Login"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)}
def TC29() {
	boolean isLoginSuccessful
	String message, tcID
	tcID = "TC029"
	
	WebUI.navigateToUrl('http://192.168.100.186:5173/kategori/informatika/detailbuku/14195')
	WebUI.delay(2)
	WebUI.click(findTestObject('Object Repository/wishlist/button_Pinjam Buku'))
	WebUI.delay(2)
	WebUI.waitForAlert(10)
	WebUI.acceptAlert()
	
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/wishlist/button_Pinjam Buku'),10)
	message =  "Click Pinjam Buku"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)}
def TC30() {
	boolean isLoginSuccessful
	String message, tcID
	tcID = "TC030"
	
	WebUI.navigateToUrl('http://192.168.100.186:5173/kategori/informatika/detailbuku/14195')
	WebUI.delay(1)
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/wishlist/button_Pinjam Buku'),10)
	message =  "Click Pinjam Buku"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	WebUI.click(findTestObject('Object Repository/wishlist/button_Pinjam Buku'))
	WebUI.delay(2)
	WebUI.waitForAlert(10)
	WebUI.acceptAlert()
	
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Login/h2_Welcome Back'),10)
	message =  "Tidak Bisa Pinjam buku karena Belum Login"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)}
def TC31() {
	boolean isLoginSuccessful
	String message, tcID
	tcID = "TC031"
	
	WebUI.navigateToUrl('http://192.168.100.186:5173')
	WebUI.click(findTestObject('Object Repository/Kategori/a_Rak Buku'))
	
	WebUI.click(findTestObject('Object Repository/Search/a_E-Book'))
	WebUI.switchToWindowIndex(1)
	WebUI.waitForPageLoad(5)
	WebUI.delay(2)
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Search/div_HOME'), 10)
	message = "Redirect to unnurbandung.perpustakaan.co.id"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	WebUI.switchToWindowIndex(0)
}
def TC32() {
	boolean isLoginSuccessful
	String message, tcID
	tcID = "TC032"
	
	WebUI.navigateToUrl('http://192.168.100.186:5173')
	WebUI.click(findTestObject('Object Repository/Login/a_Tentang Kami'))
	
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Login/h1_Tentang Kami'),10)
	message = "Redirect Tentang Kami"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
}
def TC38() {
	boolean isLoginSuccessful
	String message, tcID
	tcID = "TC038"
	
	WebUI.navigateToUrl('http://192.168.100.186:5173')
	WebUI.click(findTestObject('Object Repository/Kategori/a_Rak Buku'))
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Kategori/a_Rak Buku'),10)
	message = "Click Rak Buku"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	WebUI.click(findTestObject('Object Repository/Kategori/a_Favorit Pembaca'))
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Kategori/a_Favorit Pembaca'),10)
	message = "Click Favorit Pembaca"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Kategori/h1_Buku Favorit Pembaca'),10)
	message = "Redirict to Laman Favorit Buku"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
}
def TC39() {
	boolean isLoginSuccessful
	String message, tcID
	tcID = "TC039"
	WebUI.navigateToUrl('http://192.168.100.186:5173')
	
	WebUI.click(findTestObject('Object Repository/Logout/img_Cari_rounded-circle dropdown-toggle'))
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Login/img_Cari_rounded-circle dropdown-toggle'),10)
	message = "Click Profil"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Login/a_Login'),10)
	message = "Click Login"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	WebUI.click(findTestObject('Object Repository/Login/a_Login'))
	
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Login/h2_Welcome Back'),10)
	message = "Redirect to Login"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	}
def TC40() {
	boolean isLoginSuccessful
	String message, tcID
	tcID = "TC040"
	
	WebUI.click(findTestObject('Object Repository/Logout/img_Cari_rounded-circle dropdown-toggle'))
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/wishlist/a_Bookmark'),10)
	message = "Click Profil"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	WebUI.click(findTestObject('Object Repository/wishlist/a_Bookmark'))
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/wishlist/a_Bookmark'),10)
	message = "Click bookmark "
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/wishlist/h1_Daftar Bookmark Favoritmu'),10)
	message = "Redirect to bookmark "
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	}
def TC41() {
	boolean isLoginSuccessful
	String message, tcID
	tcID = "TC041"
	
	WebUI.click(findTestObject('Object Repository/Kategori/a_Rak Buku'))
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Kategori/a_Rak Buku'),10)
	message = "Click Rak Buku"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	WebUI.click(findTestObject('Object Repository/Kategori/a_Favorit Pembaca'))
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Kategori/a_Favorit Pembaca'),10)
	message = "Click Favorit Pembaca"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Kategori/h1_Buku Favorit Pembaca'),10)
	message = "Redirict to Laman Favorit Buku"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
	
	WebUI.selectOptionByIndex(findTestObject('Object Repository/Kategori/select_Rating TertinggiRating Terendah'), 1)
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Kategori/a_Favorit Pembaca'),10)
	message = "Click Rating Terendah "
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)\
	
	isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/Kategori/p_1.0  5'),10)
	message = "Rating Terendah"
	CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)
}
def TC42() {
boolean isLoginSuccessful
String message, tcID
tcID = "TC042"

WebUI.navigateToUrl('http://192.168.100.186:5173/kategori/informatika/detailbuku/14195')

WebUI.click(findTestObject('Object Repository/wishlist/button_Wishlist'))
WebUI.delay(3)
WebUI.waitForAlert(10)
WebUI.acceptAlert()
isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/wishlist/button_Wishlist'),10)
message =  "Click +wishlist"
CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)

WebUI.click(findTestObject('Object Repository/wishlist/button_Wishlist'))
WebUI.delay(3)
WebUI.waitForAlert(10)
WebUI.acceptAlert()
isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/wishlist/button_Wishlist'),10)
message =  "Buku sudah ada di wishlist"
CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)

WebUI.navigateToUrl('http://192.168.100.186:5173/bookmark/888')
isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Object Repository/wishlist/h1_Daftar Bookmark Favoritmu'),10)
message =  "Cek wishlist"
CustomKeywords.'excelReporting.Configuration.writeLoginResult'(tcID, message, isLoginSuccessful)}
WebUI.closeBrowser()