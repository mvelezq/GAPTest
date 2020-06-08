package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.targets.Target;
import userinterfaces.LoginPage;
import utils.enums.Constants;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class FillLoginFields implements Task {


    public static FillLoginFields inLoginPage(){
        return instrumented(FillLoginFields.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Enter.theValue(Constants.EMAIL.getValue()).into(LoginPage.EMAIL_IMPUT),
                Enter.theValue(Constants.PASSWORD.getValue()).into(LoginPage.PASSWORD_IMPUT)

        );

    }
}
