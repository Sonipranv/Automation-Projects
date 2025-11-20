import { test, expect } from '@playwright/test';
import { base_obj } from '../pages/baseClass';
// const { validLogin } = require('../helpers/setup');
import { data } from '../data';

test.describe('Smoke Suite', () => {
  test('Login with valid creds', async ({ page }) => {
    const login = new base_obj(page)
    await login.navigate()
    await login.login(data.correct_user, data.correct_password)
    await expect(page.locator('//span[text()="Products"]')).toBeVisible()
  });
});

test.describe('Regression Suite', () => {
  test('Login with invalid creds', async ({ page }) => {
    const login = new base_obj(page)
    await login.navigate()
    await login.login(data.invalid_user, data.invalid_password)
    await expect(page.locator('//h3[@data-test="error"]')).toBeVisible()
  });

});