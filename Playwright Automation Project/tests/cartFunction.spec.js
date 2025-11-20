import { test, expect } from "@playwright/test"
import { cart_obj } from "../pages/cart";
const { validLogin } = require('../helpers/setup');
import { data } from "../data";

test.beforeEach('Login with valid creds', async ({ page }) => {
    await validLogin(page)
});


test.describe('Smoke Suite', () => {

    test('successful navigation to cart page', async ({ page }) => {
        const cart_access = new cart_obj(page)

        await cart_access.clickCartIcon()
        await cart_access.validate_cart_page_title()
    });

});


test.describe('Regression Suite', () => {

    test('verifying added product is present on cart page', async ({ page }) => {
        const cart_access = new cart_obj(page)
        //    await page.pause()
        await cart_access.validate_product1()
        await cart_access.clickProduct1()
        await cart_access.clickCartIcon()
        await cart_access.validate_cart_page_title()
        await cart_access.validate_product1()
    });

    test('verifying cart count after removing objects', async ({ page }) => {
        const cart_access = new cart_obj(page)
        //    await page.pause()

        await cart_access.clickProduct1()
        await cart_access.clickProduct2()
        await cart_access.clickProduct3()
        await cart_access.clickCartIcon()
        await cart_access.validate_cart_page_title()
        await cart_access.validate_cart_with_product(3)
        await cart_access.clickProduct1()
        await cart_access.clickProduct1()
        await cart_access.clickProduct1()
        await expect(cart_access.cart_badge).toBeHidden()
    });

    test('navigating back to product page from cart page', async ({ page }) => {
        const cart_access = new cart_obj(page)
        // await page.pause()
        await cart_access.clickCartIcon()
        await cart_access.validate_cart_page_title()
        await cart_access.click_continuShoping()
        await cart_access.validate_product_page()
    });

});


test.afterEach("close page", async ({ page }) => {

    await page.close()
});



