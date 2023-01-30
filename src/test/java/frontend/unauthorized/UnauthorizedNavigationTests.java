package frontend.unauthorized;

import frontend.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Epic("UI тесты")
@Feature("Тесты открытой части сайта")
@Story("Тесты навигации")
public class UnauthorizedNavigationTests extends BaseTest {

    @Owner("Михаил")
    @TmsLink("mipkasnow")
    @Test(description = "Открываем домашнюю страницу и проверяем открытие формы авторизации")
    public void testCheckAuthFormOpening() {
        open("");
        $("#login-btn").click();
        $("[ng-click*='showLoginForm']").should(appear);
        sleep(3000);
    }

    @Test(description = "Открываем страницу закупок и проверяем наличие рекламного баннера")
    public void testCheckBannerOnPurchasesPage() {
        open("/purchases");
        $(".border_banner").should(appear);
    }

    @Test(description = "Открываем предложения и проверяем заголовок 'Позиции'")
    public void testCheckTitlePositions() {
        open("/positions");
        $(byText("Позиции")).should(appear);
    }

    @Test(description = "Открываем документы и проверяем заголовок")
    public void testCheckDocumentsTitle() {
        open("/documents");
        $(byText("Документы")).should(appear);
    }

    @Test(description = "Открываем удостоверяющие тесты и проверяем заголовок")
    public void testCheckTitleUdc() {
        open("/getds");
        $(byText("Удостоверяющие центры")).should(appear);
    }

    @Test(description = "Открываем контакты тесты и проверяем заголовок")
    public void testCheckTitleContacts() {
        open("/contacts");
        $(byText("Контакты")).should(appear);
    }
}
