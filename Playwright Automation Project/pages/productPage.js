const { expect } = require("@playwright/test");
const { base_obj } = require("./baseClass");

exports.Products = class Products extends base_obj {

    constructor(page) {

        super(page)
        this.product1 = page.locator('(//div[@class="inventory_item_price"]/following-sibling::button)[1]')
        this.product1_name = page.locator('//div[text()="Sauce Labs Backpack"]')
        this.product2 = page.locator('(//div[@class="inventory_item_price"]/following-sibling::button)[2]')
        this.product3 = page.locator('(//div[@class="inventory_item_price"]/following-sibling::button)[3]')
        this.cart_icon = page.locator('//a[@data-test="shopping-cart-link"]')
        this.product_sort = page.locator('//select[@data-test="product-sort-container"]')
        this.check_sort = page.locator('//span[@data-test="active-option"]')
        this.burgerMenu = page.locator('//button[text()="Open Menu"]')
        this.logout_button = page.locator('//a[text()="Logout"]')

    }

    async clickProduct1() {
        await this.product1.click()
    }

    async clickProduct2() {
        await this.product2.click()
    }

    async clickProduct3() {
        await this.product3.click()
    }

    async clickCartIcon() {
        await this.cart_icon.click()
    }

    async validate_cart_with_product(val) {
        await expect(this.page.locator(`//span[text()="${val}"]`)).toBeVisible();
    }

    async change_ProductSorting(optionval) {
        await this.product_sort.selectOption(optionval);
    }

    async validate_sort(checkval) {
        await expect(this.check_sort).toContainText(checkval)
    }

    async validate_product1() {
        await expect(this.product1_name).toBeVisible()
    }

    async click_burger_icon() {
        await this.burgerMenu.click()
    }

    async click_logout() {
        await this.logout_button.click()
    }


}