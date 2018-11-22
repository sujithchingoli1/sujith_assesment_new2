import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('AddAdminTC'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.phptravels.net/admin')

WebUI.setText(findTestObject('TourDetailsCreate/Page_Administator Login/input_email'), 'sujith@inapp.com')

WebUI.setText(findTestObject('TourDetailsCreate/Page_Administator Login/input_password'), 'inapp123')

WebUI.click(findTestObject('TourDetailsCreate/Page_Administator Login/span_Login'))

WebUI.click(findTestObject('TourDetailsCreate/Page_Dashboard/a_Tours'))

WebUI.click(findTestObject('TourDetailsCreate/Page_Dashboard/a_Tours_1'))

WebUI.click(findTestObject('TourDetailsCreate/Page_Tours Management/button_Add'))

def internalData = findTestData('DataFileForTourCreation/AddTourData')

int i = 1

WebUI.setText(findTestObject('Common/fieldData', [('dynamicvariable') : 'tourname']), internalData.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'maxadult']), internalData.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'adultprice']), internalData.getValue(i++, 1))

WebUI.click(findTestObject('TourDetailsCreate/ChildButton'))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'maxchild']), internalData.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'childprice']), internalData.getValue(i++, 1))

WebUI.click(findTestObject('TourDetailsCreate/Infant Button'))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'maxinfant']), internalData.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'infantprice']), internalData.getValue(i++, 1))

WebUI.click(findTestObject('TourDetailsCreate/StarDropdown'))

WebUI.click(findTestObject('TourDetailsCreate/StarSelection', [('value') : internalData.getValue(i++, 1)]))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'tourdays']), internalData.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'tournights']), internalData.getValue(i++, 1))

WebUI.click(findTestObject('TourDetailsCreate/TourTypeDrop'))

WebUI.click(findTestObject('TourDetailsCreate/TypeSelection', [('type') : internalData.getValue(i++, 1)]))

WebUI.click(findTestObject('TourDetailsCreate/LocationDropdown'))

WebUI.setText(findTestObject('TourDetailsCreate/SearchLocation'), 'paris')

WebUI.click(findTestObject('TourDetailsCreate/LocationSelection'))

WebUI.click(findTestObject('TourDetailsCreate/ClickInclusions'))

WebUI.delay(5)

WebUI.click(findTestObject('TourDetailsCreate/Select All'))

WebUI.delay(5)

WebUI.click(findTestObject('TourDetailsCreate/Select All'))

def tourfacilitiesinclude = findTestData('DataFileForTourCreation/Inclusions')

for (def index : (1..tourfacilitiesinclude.getRowNumbers())) {
    WebUI.click(findTestObject('TourDetailsCreate/IncludeFacilities', [('includefacilities') : tourfacilitiesinclude.getValue(
                    1, index)]))
}

WebUI.click(findTestObject('TourDetailsCreate/ClickExclusions'))

def tourfacilitiesexclude = findTestData('DataFileForTourCreation/Exclusions')

for (def indexe : (1..tourfacilitiesexclude.getRowNumbers())) {
    WebUI.click(findTestObject('TourDetailsCreate/ExcludeFacilities', [('excludefacilities') : tourfacilitiesexclude.getValue(
                    1, indexe)]))
}

WebUI.click(findTestObject('TourDetailsCreate/SubmitTour'))

WebUI.closeBrowser()

