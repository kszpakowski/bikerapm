package pl.kszpakowski.bikeramp.maps.google;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "maps.google")
@ConstructorBinding
@RequiredArgsConstructor
@Getter
class GoogleMapsConfigurationProperties {

    private final String apiKey;
}
