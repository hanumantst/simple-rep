package controllers;

/**
 * Created by hanumant on 5/2/16.
 */

import play.data.Form;
import play.mvc.*;
import play.libs.Json;
import views.html.*;
import models.*;

public class LoginController extends Controller {

    final static Form<Login> blankform = Form.form(Login.class);

    public static Result SendForm() {

        return ok(loginform.render(blankform));
    }

    public static Result Validate() {

        Form<Login> login_data = Form.form(Login.class).bindFromRequest();

        if (login_data.hasErrors()) {
            return badRequest(loginform.render(login_data));
        }
        else {
            Login data = login_data.get();

            Login result = Login.authenticate(data.email, data.password);
            if (result == null) {
                login_data.reject("password", "Email or password may be wrong");
                return badRequest(loginform.render(login_data));
            }
            else {
                return ok(Json.toJson(result));
            }
        }
    }
}
