import { test, expect } from "@playwright/test";
const { validLogin } = require('../helpers/setup');
import { Products } from "../pages/productPage";
import { data } from "../data"

test.beforeEach('Login with valid creds', async ({ page }) => {
    await validLogin(page)
});

test.describe('Smoke Suite', () => {
    test('logout functionality', async ({ page }) => {
        const product = new Products(page)
        await product.click_burger_icon()
        await product.click_logout()
        await expect(product.username_field).toBeVisible()
    })
});