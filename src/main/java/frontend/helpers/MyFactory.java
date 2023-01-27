package frontend.helpers;

import com.codeborne.selenide.Browser;
import com.codeborne.selenide.Config;
import com.codeborne.selenide.webdriver.ChromeDriverFactory;

import java.util.List;

import static org.codehaus.groovy.runtime.InvokerHelper.asList;

public class MyFactory extends ChromeDriverFactory {
    @Override
    protected List<String> createChromeArguments(Config config, Browser browser) {
        return asList("--proxy-bypass-list=<-loopback>"); // no "--no-sandbox" here
    }
}
