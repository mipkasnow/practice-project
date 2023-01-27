package frontend.support;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

@Epic("UI тесты")
@Feature("Тесты саппорта")
@Story("Тесты навигации")
public class SupportNavigationTests extends SupportBaseTest {

    @Test(description = "Навигация в ЛК Саппорт по ссылкам")
    public void testNavigationViaLinks() {
        open("/orgs/user");
        $x("//h2[contains(text(),'Поставщики')]").should(appear);
        open("/orgs/customer");
        $x("//h2[contains(text(),'Заказчики')]").should(appear);
    }

}
