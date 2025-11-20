import { endtoend_obj } from "../pages/endToEnd"
import { test, expect } from "@playwright/test"
const { validLogin } = require('../helpers/setup');
import { data } from "../data"


test.beforeEach('Login with valid creds', async ({ page }) => {
    await validLogin(page)
});

test.describe('Regression Suite', () => {
    test('Complete process of buying the products', async ({ page }) => {
        const endtoend = new endtoend_obj(page)
        // await page.pause()
        await endtoend.validate_product_page()
        await endtoend.clickProduct1()
        await endtoend.clickProduct2()
        await endtoend.clickProduct3()
        await endtoend.clickCartIcon()
        await endtoend.validate_cart_page_title()
        await endtoend.click_checkout()
        await endtoend.validate_information_page()
        await endtoend.information_fillFirstName(data.first_name)
        await endtoend.information_fillLastName(data.last_name)
        await endtoend.information_fillpinCode(data.pin_code)
        await endtoend.clickContinue()
        await endtoend.validate_overview_page()
        await endtoend.click_finish_button()
        await endtoend.validate_thankyou_messege()
    })

    test('Navigating to Home page after successfully buying the products', async ({ page }) => {
        const endtoend = new endtoend_obj(page)
        // await page.pause()
        await endtoend.validate_product_page()
        await endtoend.clickProduct1()
        await endtoend.clickProduct2()
        await endtoend.clickProduct3()
        await endtoend.clickCartIcon()
        await endtoend.validate_cart_page_title()
        await endtoend.click_checkout()
        await endtoend.validate_information_page()
        await endtoend.information_fillFirstName(data.first_name)
        await endtoend.information_fillLastName(data.last_name)
        await endtoend.information_fillpinCode(data.pin_code)
        await endtoend.clickContinue()
        await endtoend.validate_overview_page()
        await endtoend.click_finish_button()
        await endtoend.validate_thankyou_messege()
        await endtoend.click_backHome_button()
        await endtoend.validate_product_page()
    })

});
