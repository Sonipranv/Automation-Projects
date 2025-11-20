package employee_function
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.ctc.wstx.shaded.msv_core.grammar.xmlschema.KeyConstraint
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

import java.awt.KeyEventDispatcher
import java.awt.Robot
import java.awt.event.KeyEvent
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection


class add_an_employee {

	@Given("I am logged into Orangehrm System")

	def login() {

		CucumberKW.runFeatureFileWithTags("Include/features/login_function/login.feature", ((['@tag1']) as String[]))
	}

	@When("I navigate to {string} module and click on {string}")

	def PIM_module(String PIM , String add_employee) {

		WebUI.click(findTestObject('Object Repository/PIM_module_OrangeHRM/PIM'))

		WebUI.click(findTestObject('Object Repository/PIM_module_OrangeHRM/Add Employee'))
	}

	@And("I fill required fields First Name: {string} , Last Name: {string} and upload a profile picture")

	def required_fields(String firstname , lastname) {

		WebUI.setText(findTestObject('Object Repository/PIM_module_OrangeHRM/FirstName'), firstname)

		WebUI.setText(findTestObject('Object Repository/PIM_module_OrangeHRM/LastName'), lastname)


		WebUI.click(findTestObject("Object Repository/PIM_module_OrangeHRM/Upload Image"))

		String photo_path = "C:\\Users\\Mechlin_123\\Downloads\\employe_photo.jpg"

		StringSelection copy_photo = new StringSelection(photo_path)

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(copy_photo, null)

		Robot robot = new Robot()

		robot.keyPress(KeyEvent.VK_CONTROL)
		robot.keyPress(KeyEvent.VK_V)
		robot.keyRelease(KeyEvent.VK_CONTROL)
		robot.keyRelease(KeyEvent.VK_V)
		robot.keyPress(KeyEvent.VK_ENTER)
		robot.keyRelease(KeyEvent.VK_ENTER)



		WebUI.setText(findTestObject('Object Repository/PIM_module_OrangeHRM/Employee Id'), '01')
		WebUI.click(findTestObject("Object Repository/PIM_module_OrangeHRM/button_Save"))
	}

	@Then("I should see the employee is added successfully in the system")

	def saved() {

		WebUI.verifyElementText(findTestObject('Object Repository/PIM_module_OrangeHRM/Success'), 'Success')

		WebUI.delay(3)

		String path = 'C:/Users/Mechlin_123/Katalon Studio/demo project/screen shot/employee_added.png'
		WebUI.takeScreenshot(path)
	}
}