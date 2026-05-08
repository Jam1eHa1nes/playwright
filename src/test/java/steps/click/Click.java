package steps.click;

import com.microsoft.playwright.Locator;
import io.cucumber.java.en.And;

import static po.Click.elementRegistry;

public class Click {

    po.Click click = new po.Click();

    @And("I click on {word}")
    public void iClickOn(String elementName){
        Locator element = elementRegistry.get(elementName);
        if (element == null){
            throw new RuntimeException("The element '" + elementName +
                    "' is not defined within the elementRegistry within po.click");
        }

        click.iClickOn(element);
    }


}
