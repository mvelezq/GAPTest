package questions;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import userinterfaces.HomePage;


public class ValidateUserDoesnExist implements Question<Boolean> {
    private String leader;

    public ValidateUserDoesnExist(String leader) {
        this.leader = leader;
    }

    public Boolean answeredBy(Actor actor) {
         return Visibility.of(HomePage.FIND_EMPLOYEE.of(leader)).viewedBy(actor).resolve();

    }

    public static ValidateUserDoesnExist inThePage(String leader) {
        return new ValidateUserDoesnExist(leader);
    }
}


