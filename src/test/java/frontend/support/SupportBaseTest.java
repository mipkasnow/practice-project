package frontend.support;

import backend.context.Context;
import com.codeborne.selenide.Selenide;
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
        visualizeMouseClick();
        Selenide.sessionStorage().setItem("key", Context.tokenSupport);
    }
}
