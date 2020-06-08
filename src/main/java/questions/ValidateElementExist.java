package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ValidateElementExist implements Question<Boolean> {

    private Target target;

    public ValidateElementExist(Target target) {
        this.target = target;
    }

    public static ValidateElementExist inThePage(Target target){
        return new ValidateElementExist(target);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return target.resolveFor(actor).isVisible();
    }
}
