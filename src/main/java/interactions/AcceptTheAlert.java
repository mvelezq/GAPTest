package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AcceptTheAlert implements Interaction {



    public static AcceptTheAlert popUp() {
        return instrumented(AcceptTheAlert.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
          BrowseTheWeb.as(actor).getAlert().accept();

    }
}
