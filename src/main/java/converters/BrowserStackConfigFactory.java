package converters;

import org.aeonbits.owner.ConfigCache;

public class BrowserStackConfigFactory {
    private BrowserStackConfigFactory(){}

public static BrowserStackConfig getConfig()
    {
    return ConfigCache.getOrCreate(BrowserStackConfig.class);
    }
}
