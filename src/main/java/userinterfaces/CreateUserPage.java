package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CreateUserPage {

    public static final Target FIRST_NAME_INPUT = Target.the("").locatedBy("//input[@id='employee_first_name']");
    public static final Target LAST_NAME_INPUT = Target.the("").locatedBy("#employee_last_name");
    public static final Target EMAIL_INPUT = Target.the("").locatedBy("#employee_email");
    public static final Target ID_INPUT = Target.the("").locatedBy("#employee_identification");
    public static final Target LEADER_NAME_INPUT = Target.the("").locatedBy("#employee_leader_name");
    public static final Target YEAR_INPUT = Target.the("").locatedBy("#employee_start_working_on_1i");
    public static final Target MONTH_INPUT = Target.the("").locatedBy("#employee_start_working_on_2i");
    public static final Target DAY_INPUT = Target.the("").locatedBy("#employee_start_working_on_3i");
    public static final Target CREATE_EMPLOYEE_BUTTON = Target.the("").locatedBy("div:nth-child(3) div:nth-child(1) form.new_employee:nth-child(2) div.actions:nth-child(8) > input:nth-child(1)");
    public static final Target BACK_BUTTON = Target.the("").locatedBy("//a[contains(text(),'Back')]");

    public static final Target FIRST_NAME_LABEL = Target.the("").locatedBy("//body//p[2]");
    public static final Target LAST_NAME_LABEL = Target.the("").locatedBy("//body//p[3]");
    public static final Target EMAIL_LABEL = Target.the("").locatedBy("//body//p[4]");
    public static final Target ID_LABEL = Target.the("").locatedBy("//body//p[5]");
    public static final Target LEADER_NAME_LABEL = Target.the("").locatedBy("//body//p[6]");
    public static final Target START_WORKING_LABEL = Target.the("").locatedBy("//body//p[7]");

}
