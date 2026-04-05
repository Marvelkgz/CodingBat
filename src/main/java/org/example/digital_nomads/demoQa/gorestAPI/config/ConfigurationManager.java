package org.example.digital_nomads.demoQa.gorestAPI.config;

import org.aeonbits.owner.ConfigCache;

public class ConfigurationManager {

    public static AppConfig getBaseConfig() {
        return ConfigCache.getOrCreate(AppConfig.class);
    }
}
