package converters;

import org.aeonbits.owner.Config;
import java.net.URL;
@Config.Sources({
        "file:src/main/resources/browserstack.properties"
})

public interface BrowserStackConfig extends Config {
    @Key("username")
    String userName();
    String key();

    @DefaultValue("https://${username}:${key}@hub-cloud.browserstack.com/wd/hub")
    @ConverterClass(StringToURLConverter.class)
    URL browserStackURL();
}
