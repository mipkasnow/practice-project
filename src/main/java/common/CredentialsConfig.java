package common;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/credentials.properties")
public interface CredentialsConfig extends Config {
    String SupportPassword();

    String SupportLogin();

    String BaseUri();

    String BaseUrl();
}
