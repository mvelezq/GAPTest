package interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FindRowInTable implements Interaction {

    private Target target;
    private String leader;

    public FindRowInTable(Target target, String leader) {
        this.target = target;
        this.leader = leader;
    }

    public static FindRowInTable findTheLeader(Target target, String leader) {

        return instrumented(FindRowInTable.class, target, leader);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        List<WebElementFacade> list = new ArrayList<WebElementFacade>(target.resolveAllFor(actor));

        int count = 0;
        int row = 0;
        int rowInTable = 0;
        int rowInXpath = 0;

        for (WebElementFacade s : list) {
            if (s.getText().equals(leader)) {
                row = count;
                rowInTable = row + 1;
                rowInXpath = rowInTable + 1;
                System.out.println("The user is in the row " + rowInTable + " inside the table");
                actor.remember("rowUser", rowInXpath);
                break;

            }
            count++;

        }

    }


}
