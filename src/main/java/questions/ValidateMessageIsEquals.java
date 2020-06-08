package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ValidateMessageIsEquals implements Question<String> {


    private Target target;


    public ValidateMessageIsEquals(Target target) {
        this.target = target;

    }

    public static ValidateMessageIsEquals inTheBanner(Target target){
        return new ValidateMessageIsEquals(target);
    }


    @Override
    public String answeredBy(Actor actor) {

        return target.resolveFor(actor).getText();
    }
}
