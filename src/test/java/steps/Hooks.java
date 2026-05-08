package steps;

import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import po.Click;

public class Hooks {
    public static Page page;
    private static Browser browser;
    private static Playwright playwright;
    private static BrowserContext context;

    @Before
    public void setup() {
        // 1. Load properties via the steps.ConfigReader
        ConfigReader.loadProperties();

        String browserName = ConfigReader.getProperty("browser");
        boolean isHeadless = Boolean.parseBoolean(ConfigReader.getProperty("headless"));

        // 2. Initialize Playwright
        playwright = Playwright.create();

        // 3. Launch the specific browser based on the property file/CLI
        switch (browserName.toLowerCase()) {
            case "firefox" -> browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(isHeadless));
            case "webkit" -> browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(isHeadless));
            default -> browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(isHeadless));
        }

        // 4. Create context and page
        context = browser.newContext();
        page = context.newPage();

        po.Click click = new Click();
        click.registerElements();
        click.addRemoveElements();
    }

    @After
    public void tearDown() {
        // It's safer to close in this order: Page -> Context -> Browser -> Playwright
        if (page != null) page.close();
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}