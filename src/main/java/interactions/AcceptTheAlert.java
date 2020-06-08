package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import userinterfaces.HomePage;

import java.awt.*;
import java.awt.event.KeyEvent;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class AcceptTheAlert implements Interaction {

    private WebDriver driver;

    public static AcceptTheAlert popUp(WebDriver driver) {

        return instrumented(AcceptTheAlert.class, driver);
    }

    @Override

    public <T extends Actor> void performAs(T actor) {

        // opcion 1
          BrowseTheWeb.as(actor).getAlert().accept();


        //opcion 2
    //    try {
        //    WebDriverWait wait = new WebDriverWait(driver, 2);
        //    wait.until(ExpectedConditions.alertIsPresent());
//            Alert alert = driver.switchTo().alert();
          //  System.out.println(alert.getText());
//            alert.accept();
//            System.out.println("aceptooo");

//        } catch (Exception e) {
//            //exception handling
//        }

        //opcion 3
//        ((WebDriverFacade) getDriver()).getProxiedDriver().switchTo().alert().accept();

        //opcion 4

//        Robot r = null;
//        try {
//            r = new Robot();
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
//
//        r.keyPress(KeyEvent.VK_ENTER);

     //   r.keyRelease(KeyEvent.VK_ENTER);
    }
}
