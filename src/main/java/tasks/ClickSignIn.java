package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.targets.Target;
import org.springframework.core.SpringVersion;
import userinterfaces.LoginPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickSignIn implements Task {

    private Target target;

    public ClickSignIn(Target target) {
        this.target = target;
    }

    public static ClickSignIn inLoginPage(Target target){
        return instrumented(ClickSignIn.class,target);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(target)
        );
    }
}
