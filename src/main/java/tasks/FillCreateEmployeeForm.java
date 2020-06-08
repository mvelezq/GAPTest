package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actors.OnStage;

import userinterfaces.CreateUserPage;

import java.util.Arrays;
import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillCreateEmployeeForm implements Task {

    private String firstname;
    private String lastname;
    private String email;
    private String id;
    private String startedworking;
    private String leader;

    public FillCreateEmployeeForm(String firstname, String lastname, String email, String id, String startedworking, String leader) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.id = id;
        this.startedworking = startedworking;
        this.leader = leader;
    }

    public static FillCreateEmployeeForm inCreateEmployeePage(String firstname, String lastname, String email, String id, String startedworking, String leader ){
        return instrumented(FillCreateEmployeeForm.class,firstname,lastname,email,id,startedworking,leader);
    }

    public List<String> parseTheDate( ){
        String year;
        String month;
        String day;

        String[] dateComplete = startedworking.split("/");
        day=dateComplete[1];
        month=dateComplete[0];
        year=dateComplete[2];

        List<String> dateSeparate =  Arrays.asList(day,month,year);

        return dateSeparate;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Enter.theValue(firstname).into(CreateUserPage.FIRST_NAME_INPUT),
                Enter.theValue(lastname).into(CreateUserPage.LAST_NAME_INPUT),
                Enter.theValue(email).into(CreateUserPage.EMAIL_INPUT),
                Enter.theValue(id).into(CreateUserPage.ID_INPUT),
                Enter.theValue(leader).into(CreateUserPage.LEADER_NAME_INPUT),
                SelectFromOptions.byValue(parseTheDate().get(0)).from(CreateUserPage.DAY_INPUT),
                SelectFromOptions.byValue(parseTheDate().get(1)).from(CreateUserPage.MONTH_INPUT),
                SelectFromOptions.byValue(parseTheDate().get(2)).from(CreateUserPage.YEAR_INPUT),
                Click.on(CreateUserPage.CREATE_EMPLOYEE_BUTTON)


        );

    }

}
