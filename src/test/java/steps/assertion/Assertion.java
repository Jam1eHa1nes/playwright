package steps.assertion;

import com.microsoft.playwright.Locator;
import io.cucumber.java.en.And;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static po.Click.elementRegistry;

public class Assertion {

    @And("I should see {word} is visible")
    public void iShouldSeeElementIsVisible(String located){
        Locator element = elementRegistry.get(located);
        if (element == null){
            throw new RuntimeException("The element '"+ located
            + "' is not defined within the elementRegistry");
        }

        assertTrue(element.isVisible() ,"Element '" + located + "' was not visible");
    }

    @And("I shouldn't see {word} is visible")
    public void iShouldNotSeeElementIsVisible(String located){
        Locator element = elementRegistry.get(located);
        if (element == null){
            throw new RuntimeException("The element '"+ located
                    + "' is not defined within the elementRegistry");
        }

        assertFalse(element.isVisible() ,"Element '" + located + "' was visible");
    }



}
