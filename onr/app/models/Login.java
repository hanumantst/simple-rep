package models;

/**
 * Created by hanumant on 5/2/16.
 */
import java.util.*;
import javax.persistence.*;

import play.data.validation.Constraints.*;

import com.avaje.ebean.Model;

@Entity
public class Login extends Model {
    @Required
    @Email
    public String email;

    @Required
    public String password;

    Login(){    }

    Login(String email,String passoword){
        this.email=email;
        this.password=passoword;
    }
    public static Finder<String,Login> find = new Finder<String,Login>(String.class, Login.class);

    public static Login authenticate(String email,String password){

        return Login.find.where().eq("email",email).eq("password",password).findUnique();
    }
}
