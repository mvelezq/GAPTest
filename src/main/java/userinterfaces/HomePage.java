package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

    public static final Target LOGO_IMAGE = Target.the("Logo in the home page").locatedBy("#logo");
    public static final Target LOGIN_SUCCESS_BANNER = Target.the("Banner with success login with css").locatedBy("body:nth-child(2) div:nth-child(1) div:nth-child(3) div:nth-child(1) > p.flash_notice:nth-child(1)");
  //  public static final Target LOGIN_SUCCESS_BANNER = Target.the("Banner with success login with class with name").located(By.xpath("//p[@class='flash_notice']"));
    public static final Target USER_BANNER = Target.the("Banner with the user login").locatedBy("div:nth-child(1) div:nth-child(1) div:nth-child(2) ul:nth-child(2) > span:nth-child(1)");
 //   public static final Target USER_BANNER = Target.the("Banner with the user login with xpath").locatedBy("//span[contains(text(),'Welcome')]");

    public static final Target CREATE_NEW_EMPLOYEE_BUTTON = Target.the("Create new emplyee button").locatedBy("//a[contains(text(),'Create a new employee')]");
    public static final Target COLUM_TABLE_EMPLOYEES = Target.the("colums table employees in home page").locatedBy("//table//tr/td[4]");
    public static final Target DELETE_EMPLOYEE = Target.the("delete employee entered").locatedBy("//tr[{0}]//td[9]//a[1]");




}
