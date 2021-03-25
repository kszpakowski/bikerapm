package pl.kszpakowski.bikeramp.maps.google;

import com.google.maps.GeoApiContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
class GoogleMapsConfiguration {

    private final GoogleMapsConfigurationProperties config;

    @Bean
    public GeoApiContext geoApiContext(){
        return new GeoApiContext.Builder()
                .apiKey(config.getApiKey())
                .build();
    }

}
