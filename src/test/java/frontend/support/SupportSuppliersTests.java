package frontend.support;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Epic("UI тесты")
@Feature("Тесты саппорта")
@Story("Тесты по работе с разделом 'Поставщики'")
public class SupportSuppliersTests extends SupportBaseTest {

    private void goSupplierPage() {
        open("/orgs/user");
    }

    @Test(description = "Поиск поставщика")
    public void testSearchSupplier() {
        goSupplierPage();
        $("#filterInput").setValue("Майоров");
        $("[ng-click*='searchStart']").click();
        $("[ng-dblclick='clickRow(org)']").$(byText("Майоров Виктор Анатольевич")).should(appear);
    }
}
