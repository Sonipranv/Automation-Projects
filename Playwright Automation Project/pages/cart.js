const { expect } = require("@playwright/test");
const { Products } = require("./productPage");


exports.cart_obj = class cart_obj extends Products {

    constructor(page) {
        super(page)
        this.cart_page_title = page.locator('//span[text()="Your Cart"]')
        this.checkout_button = page.locator('//button[text()="Checkout"]')
        this.cart_badge = page.locator('//span[@data-test="shopping-cart-badge"]')
        this.continuShoping_Button = page.locator('//button[text()="Continue Shopping"]')
    }

    async validate_cart_page_title() {
        await expect(this.cart_page_title).toBeVisible()
    }

    async click_checkout() {
        await this.checkout_button.click()
    }

    async click_continuShoping() {
        await this.continuShoping_Button.click()
    }
}