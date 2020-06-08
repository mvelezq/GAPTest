package StepsDefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import interactions.AcceptTheAlert;
import interactions.FindRowInTable;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import questions.ValidateElementExist;
import questions.ValidateMessageIsEquals;
import tasks.*;
import questions.VerifyUserCreate;
import userinterfaces.CreateUserPage;
import userinterfaces.HomePage;
import userinterfaces.LoginPage;


public class VacationsManagementStepDefinitions {

    @Managed(driver = "chrome")
    WebDriver driver;
  //  private WebDriver hisBrowser;

    @Before
    public void setStage(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("user");
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(driver));
    }


    @Given("^The user navigate to the login page$")
    public void theUserNavigateToTheLoginPage() {
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url("https://vacations-management.herokuapp.com/users/sign_in"));
    }

    @When("^The user enter the username and password$")
    public void theUserEnterTheUsernameAndPassword() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                FillLoginFields.inLoginPage()
        );
    }

    @And("^The user click login button$")
    public void theUserClickLoginButton() {
        OnStage.theActorInTheSpotlight().attemptsTo(ClickSignIn.inLoginPage(LoginPage.SING_IN_BUTTON));
    }

    @Then("^The user should see the logo$")
    public void theUserShouldSeeTheLogo() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.
                seeThat(ValidateElementExist.inThePage(HomePage.LOGO_IMAGE)));

    }

    @Then("^The user should see his user information$")
    public void theUserShouldSeeHisUserInformation() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.
                seeThat(ValidateElementExist.inThePage(HomePage.USER_BANNER)));
    }

    @Then("^The user should see the banner with the message (.*)$")
    public void theUserShouldSeeTheBannerWithTheMessageSignedInSuccessfully(String message) {

        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(
                ValidateMessageIsEquals.inTheBanner(HomePage.LOGIN_SUCCESS_BANNER), Matchers.equalTo(message)));
    }








    @Given("^The user click create new employee link$")
    public void theUserClickCreateNewEmployeeLink() {
        OnStage.theActorInTheSpotlight().wasAbleTo(ClickSignIn.inLoginPage(HomePage.CREATE_NEW_EMPLOYEE_BUTTON));
    }

    @When("^The user fill de form with his (.*), (.*), (.*), (.*), (.*) and (.*)$")
    public void theUserFillDeFormWithHisFirstnameLastnameEmailIdStartedworkingAndLeader(String firstname, String lastname, String email, String id, String startedworking, String leader) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                FillCreateEmployeeForm.inCreateEmployeePage(firstname,lastname,email,id,startedworking,leader)

        );
    }

    @Then("^The user verifies the entered fields (.*), (.*), (.*), (.*), (.*) and (.*)$")
    public void theUserVerifiesTheEnteredFieldsFirstnameLastnameEmailIdStartedworkingAndLeader(String firstname, String lastname, String email, String id, String startedworking, String leader) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen
                .seeThat(VerifyUserCreate.inTheTable(firstname,CreateUserPage.FIRST_NAME_LABEL)));
        OnStage.theActorInTheSpotlight().should(GivenWhenThen
                .seeThat(VerifyUserCreate.inTheTable(lastname,CreateUserPage.LAST_NAME_LABEL)));
        OnStage.theActorInTheSpotlight().should(GivenWhenThen
                .seeThat(VerifyUserCreate.inTheTable(email,CreateUserPage.EMAIL_LABEL)));
        OnStage.theActorInTheSpotlight().should(GivenWhenThen
                .seeThat(VerifyUserCreate.inTheTable(id,CreateUserPage.ID_LABEL)));
        OnStage.theActorInTheSpotlight().should(GivenWhenThen
                .seeThat(VerifyUserCreate.inTheTable(leader,CreateUserPage.LEADER_NAME_LABEL)));
        OnStage.theActorInTheSpotlight().should(GivenWhenThen
                .seeThat(VerifyUserCreate.inTheTable("0"+startedworking,CreateUserPage.START_WORKING_LABEL)));

    }

    @And("^The user return to the home page$")
    public void theUserReturnToTheHomePage() {
        OnStage.theActorInTheSpotlight().attemptsTo(ClickBack.toHomePage());
    }

    @And("^The user counts what is the row number of his user with his (.*)$")
    public void theUserCountsWhatIsTheRowsNumberOfHisUserwithhisleader(String leader) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                FindRowInTable.findTheLeader(HomePage.COLUM_TABLE_EMPLOYEES,leader)
        );
    }

    @When("^The user click delete in the register with his (.*)$")
    public void theUserClickDeleteHisUser(String leader) {
        OnStage.theActorInTheSpotlight().wasAbleTo(
                FindRowInTable.findTheLeader(HomePage.COLUM_TABLE_EMPLOYEES,leader),
                ClickDelete.theUSerCreated(driver)
        );
    }


    @Then("^The user does not exist in the employees information page$")
    public void theUserDoesnNotExisteInTheEmployeesInformationPage() {
    }


}
