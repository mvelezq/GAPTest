package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import userinterfaces.CreateUserPage;

public class VerifyUserCreate implements Question<Boolean> {

    private String value;
    private Target target;


    public VerifyUserCreate(String value, Target target) {
        this.value = value;
        this.target = target;

    }

    public static VerifyUserCreate inTheTable(String value, Target target){
        return new VerifyUserCreate (value,target);
    }


    @Override
    public Boolean answeredBy(Actor actor) {

        System.out.println("The value entered in the register is -"+ value);
        System.out.println("The Value in the vacation management application is -" + parseInfo(target.resolveFor(actor).getText()));
        System.out.println("______________________________________________________________________");
        return parseInfo(target.resolveFor(actor).getText()).equals(value);
    }

    public String parseInfo(String infoTarget ){

        String info;

        String[] infoPase= infoTarget.split(": ");
        info=infoPase[1];

        return info;

    }
}
