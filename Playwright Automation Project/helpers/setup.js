import { base_obj } from "../pages/baseClass";
import { data } from "../data";

exports.validLogin = async function (page) {
    const login = new base_obj(page)
    await login.navigate()
    await login.login(data.correct_user, data.correct_password)
    await login.validate_product_page()
}
