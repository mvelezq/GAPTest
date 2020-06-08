package tasks;

import interactions.AcceptTheAlert;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import userinterfaces.HomePage;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class ClickDelete implements Task {

    private String leader;

    public ClickDelete(String leader) {
        this.leader = leader;
    }

    public static ClickDelete theUSerCreated(String leader){
        return instrumented(ClickDelete.class, leader);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        OnStage.theActorInTheSpotlight().attemptsTo(

                Click.on(HomePage.DELETE_EMPLOYEE.of(leader)),
                AcceptTheAlert.popUp()

        );

    }
}
