package robert.o.resilience4j.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import robert.o.resilience4j.client.impl.WorldClockAPIRequests;
import robert.o.resilience4j.client.impl.WorldTimeAPIRequests;

@Configuration
public class TimeClientConfig {

    @Bean
    public WorldTimeAPIRequests worldTimeApi(@Value("${time_api.worldtime_api.base_url}") String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        return retrofit.create(WorldTimeAPIRequests.class);
    }

    @Bean
    public WorldClockAPIRequests worldClockApi(@Value("${time_api.worldclock_api.base_url}") String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        return retrofit.create(WorldClockAPIRequests.class);
    }
}
