const { expect } = require("@playwright/test")

exports.base_obj = class base_obj {


    constructor(page) {
        this.page = page
        this.username_field = page.locator('[data-test="username"]')
        this.password_field = page.locator('[data-test="password"]')
        this.login_button = page.locator('[data-test="login-button"]')
        this.productPage_Title = page.locator('//span[text()="Products"]')
    }


    async navigate() {
        await this.page.goto("https://www.saucedemo.com/")
    }
    async username(user) {
        await this.username_field.fill(user)
    }

    async password(user_password) {
        await this.password_field.fill(user_password)
    }

    async login(user, user_password) {
        await this.username(user)
        await this.password(user_password)
        await this.login_button.click()

    }

    async validate_product_page() {
        await expect(this.productPage_Title).toBeVisible()
    }

}