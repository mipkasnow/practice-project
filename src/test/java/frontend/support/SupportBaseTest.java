package frontend.support;

import frontend.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.open;

public class SupportBaseTest extends BaseTest {

    @BeforeSuite
    public void getSupportToken() {
        apiScenario.getSupportTokenAndSetToContext();
    }

    @BeforeMethod
    public void authSupport() {
        open("");
        authSupportViaSessionStorage();
    }
}
