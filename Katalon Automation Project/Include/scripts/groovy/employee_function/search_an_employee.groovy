package employee_function
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
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




class search_an_employee {
	@Given("I am on the {string} page")

	def Employee_List(String employee_list) {

		CucumberKW.runFeatureFileWithTags("Include/features/login_function/login.feature", ((['@tag1']) as String[]))
		WebUI.click(findTestObject("Object Repository/PIM_module_OrangeHRM/PIM"))
		WebUI.delay(2)
	}

	@When("I search for {string} in the {string} field")

	def Search_employee(String name , String list) {

		WebUI.setText(findTestObject("Object Repository/PIM_module_OrangeHRM/input"), name)
		WebUI.delay(2)
		WebUI.click(findTestObject("Object Repository/PIM_module_OrangeHRM/button_Search"))
	}

	@Then("I should see {string} in search results with correct details")

	def correct_details(String name) {


		WebUI.verifyElementText(findTestObject("Object Repository/PIM_module_OrangeHRM/Check_firstname"), GlobalVariable.firstname)
		WebUI.verifyElementText(findTestObject("Object Repository/PIM_module_OrangeHRM/Check_lastname"), GlobalVariable.lastname)
		WebUI.delay(2)
		String path = 'C:/Users/Mechlin_123/Katalon Studio/demo project/screen shot/employee_searched.png'
		WebUI.takeScreenshot(path)
	}
}