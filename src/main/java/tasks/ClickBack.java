package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.targets.Target;
import userinterfaces.CreateUserPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickBack implements Task {

    public static ClickBack toHomePage(){
        return instrumented(ClickBack.class);
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                  Click.on(CreateUserPage.BACK_BUTTON)
        );
    }
}
