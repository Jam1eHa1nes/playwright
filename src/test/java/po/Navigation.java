package po;

import static steps.Hooks.page;

public class Navigation {

    public void navigateToUrl(String url){
        page.navigate(url);
    }


}
