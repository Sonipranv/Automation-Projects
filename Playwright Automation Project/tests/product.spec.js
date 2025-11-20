import { test, expect } from '@playwright/test';
const { validLogin } = require('../helpers/setup');
import { Products } from '../pages/productPage';

test.beforeEach('Login with valid creds', async ({ page }) => {
  await validLogin(page)
});



test.describe('Smoke Suite', () => {

  test('Adding one iteam in the cart', async ({ page }) => {
    const product = new Products(page)
    await product.clickProduct1()
    await product.validate_cart_with_product(1)
  });

  test('checking product sorting functionality', async ({ page }) => {
    const product = new Products(page)
    // await page.pause()
    await product.validate_sort('Name (A to Z)')
    await product.change_ProductSorting('za')
    await product.validate_sort('Name (Z to A)')
  });

});


test.describe('Regression Suite', () => {
  test('Adding multiple iteams in the cart', async ({ page }) => {
    const product = new Products(page)
    await product.clickProduct1()
    await product.clickProduct2()
    await product.clickProduct3()
    await product.validate_cart_with_product(3)
  });

  test('Adding multiple iteams in the cart and removing them', async ({ page }) => {
    const product = new Products(page)
    await product.clickProduct1()
    await product.clickProduct2()
    await product.clickProduct3()
    // await page.pause()
    await product.validate_cart_with_product(3)
    await product.clickProduct1()
    await product.clickProduct2()
    await product.clickProduct3()
  });
});


test.afterEach("close page", async ({ page }) => {
  await page.close()
})



