package frontend;

import backend.scenario.ApiScenario;
import backend.spec.Specification;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import common.AllureAttach;
import common.CredentialsConfig;
import common.RetryAnalyzer;
import frontend.helpers.MyFactory;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import org.aeonbits.owner.ConfigFactory;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import java.util.logging.Level;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class BaseTest {

    protected final ApiScenario apiScenario = new ApiScenario();
    private final CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
    private final String baseUrl = config.BaseUrl();

    @BeforeSuite
    public void config(ITestContext context) {
        for (ITestNGMethod method: context.getAllTestMethods()){
            method.setRetryAnalyzerClass(RetryAnalyzer.class);
        }

        Specification.installSpecification200();
        selenideConfig();
    }

    @AfterMethod
    public void tearDown() {
        AllureAttach.screenshotAs("Last screenshot");
        AllureAttach.pageSource();
        closeWebDriver();
    }

    private void selenideConfig() {
        Configuration.browser = MyFactory.class.getName();
        Configuration.timeout = 12000;
        Configuration.fastSetValue = true;
        Configuration.baseUrl = baseUrl;
        Configuration.headless = true;
        Configuration.browserSize = "1920x1080";


        SelenideLogger.addListener(
                "AllureSelenide", new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true)
                        .includeSelenideSteps(true)
                        .enableLogs(LogType.BROWSER, Level.WARNING)
        );
    }

    protected void visualizeMouseClick(){
        executeJavaScript("function onClick(event) {\n" +
                "        var e = event || window.event;\n" +
                "        var target = e.target || e.srcElement;\n" +
                "        target.style['box-sizing'] = 'border-box';\n" +
                "        target.style['border'] = '2px solid green';\n" +
                "      }\n" +
                "    \n" +
                "      document.addEventListener('click', onClick);");
    }
}
