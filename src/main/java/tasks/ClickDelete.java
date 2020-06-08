package tasks;

import interactions.AcceptTheAlert;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import userinterfaces.HomePage;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class ClickDelete implements Task {

    private WebDriver driver;

    public static ClickDelete theUSerCreated(WebDriver driver){
        return instrumented(ClickDelete.class, driver);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        String rowUser = actor.recall("rowUser").toString();

        OnStage.theActorInTheSpotlight().attemptsTo(

              //  Click.on(HomePage.DELETE_EMPLOYEE.of(rowUser))
              //  AcceptTheAlert.popUp(driver)

                Click.on(By.xpath("(//a[text() = 'Delete'])[1]"))
        );
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        BrowseTheWeb.as(actor).getAlert().accept();

    }
}
