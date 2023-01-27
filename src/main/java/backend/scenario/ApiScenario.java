package backend.scenario;

import backend.context.Context;
import backend.endpoint.Endpoint;
import backend.pojo.response.auth.login.PojoResLogin;
import backend.service.ApiServiceNoAuth;
import common.CredentialsConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;

import java.util.HashMap;

public class ApiScenario {

    private final CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
    private final String password = config.SupportPassword();
    private final String login = config.SupportLogin();

    @Step("Получение токена саппорта и установка его в статик контекст")
    public void getSupportTokenAndSetToContext() {
        HashMap<String, Object> cred = new HashMap<>();
        cred.put("login", login);
        cred.put("password", password);

        Context.tokenSupport = ApiServiceNoAuth
                .postToPojoJsonPathResult(Endpoint.Auth.Post.login(), cred, PojoResLogin.class).getTokenId();
    }
}
