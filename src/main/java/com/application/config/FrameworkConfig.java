package com.application.config;

import converters.StringToURLConverter;
import org.aeonbits.owner.Config;
import java.net.URL;

@Config.Sources({
        //"system:properties",
       //"system:env",
        "file:src/main/resources/config.properties"
})
public interface FrameworkConfig extends Config {
    @ConverterClass(StringToURLConverter.class)
    @DefaultValue("http://127.0.0.1:4723/wd/hub")
    URL localAppiumServerURL();
}
