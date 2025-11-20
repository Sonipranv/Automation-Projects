const { expect } = require("@playwright/test");
const { cart_obj } = require("./cart");


exports.endtoend_obj = class endtoend_obj extends cart_obj {

    constructor(page) {

        super(page)
        this.firstName_field = page.locator('//input[@placeholder="First Name"]')
        this.lastName_field = page.locator('//input[@placeholder="Last Name"]')
        this.pinCode_field = page.locator('//input[@placeholder="Zip/Postal Code"]')
        this.continue_button = page.locator('//input[@id="continue"]')
        this.information_page_title = page.locator('//span[text()="Checkout: Your Information"]')
        this.Overview_page_title = page.locator('//span[text()="Checkout: Overview"]')
        this.finish_button = page.locator('//button[text()="Finish"]')
        this.order_finish_title = page.locator('//h2[text()="Thank you for your order!"]')
        this.backHome_button = page.locator('//button[text()="Back Home"]')
    }


    async information_fillFirstName(val) {
        await this.firstName_field.fill(val)
    }


    async information_fillLastName(val) {
        await this.lastName_field.fill(val)
    }

    async information_fillpinCode(val) {
        await this.pinCode_field.fill(val)
    }

    async clickContinue() {
        await this.continue_button.click()
    }

    async validate_information_page() {
        await expect(this.information_page_title).toBeVisible()
    }

    async validate_overview_page() {
        await expect(this.Overview_page_title).toBeVisible()
    }

    async click_finish_button() {
        await this.finish_button.click()
    }

    async validate_thankyou_messege() {
        await expect(this.order_finish_title).toBeVisible()
    }

    async click_backHome_button() {
        await this.backHome_button.click()
    }


}