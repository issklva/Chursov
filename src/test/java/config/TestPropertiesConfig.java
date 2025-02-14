package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties",
        "classpath:default.properties",

})
public interface TestPropertiesConfig extends org.aeonbits.owner.Config{




}
