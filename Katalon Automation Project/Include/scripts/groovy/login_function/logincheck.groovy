package login_function
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class logincheck {
	@Given("I navigate to login page")

	def navigate_login() {

		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
		WebUI.waitForPageLoad(10)
	}


	@When("I enter valid credentials username & password and click login")
	def click_valid_login() {


		WebUI.setText(findTestObject("Object Repository/login_OrangeHRM/Username"), GlobalVariable.validuser)
		WebUI.setText(findTestObject("Object Repository/login_OrangeHRM/Password"), GlobalVariable.validpassword)
		WebUI.click(findTestObject("Object Repository/login_OrangeHRM/button_Login"))
	}

	@When("I enter invalid credentials username & password and click login")

	def click_invalid_login() {
		WebUI.setText(findTestObject("Object Repository/login_OrangeHRM/Username"), GlobalVariable.invaliduser)
		WebUI.setText(findTestObject("Object Repository/login_OrangeHRM/Password"), GlobalVariable.invalidpassword)
		WebUI.click(findTestObject("Object Repository/login_OrangeHRM/button_Login"))
	}

	@Then("I shoud see Dashboard or a {string} messege")

	def verification(String Welcome) {

		WebUI.verifyElementText(findTestObject("Object Repository/login_OrangeHRM/Dashboard"), GlobalVariable.Successfull_verification)
		WebUI.delay(1)
		String path = 'C:/Users/Mechlin_123/Katalon Studio/demo project/screen shot/dashboard.png'
		WebUI.takeScreenshot(path)
		WebUI.waitForPageLoad(10)
	}


	@Then("I should see an error saying {string}")

	def invalid_cvarification(String invalid_credentials) {

		WebUI.verifyElementText(findTestObject("Object Repository/login_OrangeHRM/Invalid credentials"), GlobalVariable.Unsuccessfull_verification)
		WebUI.waitForPageLoad(10)
		String path = 'C:/Users/Mechlin_123/Katalon Studio/demo project/screen shot/Invalid.png'
		WebUI.takeScreenshot(path)
	}
}