package com.application.config;
import org.aeonbits.owner.ConfigCache;
public final class configFactory {
    private configFactory(){
    }

    public static FrameworkConfig getConfig(){
        return ConfigCache.getOrCreate(FrameworkConfig.class);
    }
}
