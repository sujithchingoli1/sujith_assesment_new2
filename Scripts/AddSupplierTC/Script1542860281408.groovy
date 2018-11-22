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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.phptravels.net/admin')

WebUI.setText(findTestObject('SupplierDetailsCreate/Page_Administator Login/input_email'), 'admin@phptravels.c')

WebUI.setText(findTestObject('SupplierDetailsCreate/Page_Administator Login/input_email'), 'admin@phptravels.com')

WebUI.setText(findTestObject('SupplierDetailsCreate/Page_Administator Login/input_password'), 'demoadmin')

WebUI.click(findTestObject('SupplierDetailsCreate/Page_Administator Login/button_Login'))

WebUI.click(findTestObject('SupplierDetailsCreate/Page_Dashboard/a_Accounts'))

WebUI.click(findTestObject('SupplierDetailsCreate/Page_Dashboard/a_Suppliers'))

WebUI.click(findTestObject('SupplierDetailsCreate/Page_Suppliers Management/button_Add'))

def ExcelData = findTestData('DataFileForSupplierCreation')

int i = 1

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'fname']), ExcelData.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'lname']), ExcelData.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'email']), ExcelData.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'password']), ExcelData.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'mobile']), ExcelData.getValue(i++, 1))

WebUI.click(findTestObject('AdminDetailsCreate/ClickCountryDropDown'))

WebUI.delay(1)

WebUI.click(findTestObject('AdminDetailsCreate/select_Algeria', [('Country') : ExcelData.getValue(i++, 1)]))

WebUI.delay(5)

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'address1']), ExcelData.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'address2']), ExcelData.getValue(i++, 1))

WebUI.click(findTestObject('SupplierDetailsCreate/ClickSupplier'))

WebUI.click(findTestObject('SupplierDetailsCreate/SelectApplier', [('supplier') : ExcelData.getValue(i++, 1)]))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'itemname']), ExcelData.getValue(i++, 1))

WebUI.click(findTestObject('SupplierDetailsCreate/ClickAssignHotel'))

WebUI.click(findTestObject('SupplierDetailsCreate/SelectAssignHotel', [('assignhotel') : ExcelData.getValue(i++, 1)]))

WebUI.click(findTestObject('SupplierDetailsCreate/ClickAssignTours'))

WebUI.click(findTestObject('SupplierDetailsCreate/SelectAssignTours', [('assigntours') : ExcelData.getValue(i++, 1)]))

WebUI.click(findTestObject('SupplierDetailsCreate/ClickSelectCars'))

WebUI.click(findTestObject('SupplierDetailsCreate/SelectSelectCars', [('assigncars') : ExcelData.getValue(i++, 1)]))

def dbdataForPermission = findTestData('DataFileAdminCreation/permissions')

for (def index : (1..dbdataForPermission.getRowNumbers())) {
    for (def indexc : (1..dbdataForPermission.getColumnNumbers())) {
        WebUI.scrollToElement(findTestObject('AdminDetailsCreate/add_edit_remove_checkbox', [('value') : dbdataForPermission.getValue(
                        indexc, index)]), 10)

        WebUI.click(findTestObject('AdminDetailsCreate/add_edit_remove_checkbox', [('value') : dbdataForPermission.getValue(
                        indexc, index)]))
    }
}

WebUI.click(findTestObject('SupplierDetailsCreate/SupplierSubmit'))

not_run: WebUI.closeBrowser()

