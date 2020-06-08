package userinterfaces;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target EMAIL_IMPUT = Target.the("Email imput login page").locatedBy("#user_email");
    public static final Target PASSWORD_IMPUT = Target.the("Password input login page").locatedBy("#user_password");
    public static final Target SING_IN_BUTTON = Target.the("Sing in button").located(By.xpath("//input[@name='commit']"));



}
