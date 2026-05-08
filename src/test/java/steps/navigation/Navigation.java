package steps.navigation;

import io.cucumber.java.en.When;

public class Navigation {

    po.Navigation navigation = new po.Navigation();

    @When("I navigate to {string}")
    public void iNavigateToUrl(String url){
        navigation.navigateToUrl(url);
    }



}
