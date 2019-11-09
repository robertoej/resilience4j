package robert.o.resilience4j.client.impl;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import robert.o.resilience4j.client.TimeClient;
import static robert.o.resilience4j.config.Instance.WORLDTIME_API;

import java.io.IOException;
import java.time.Instant;

@Slf4j
@Service
@RequiredArgsConstructor
public class WorldTimeClient implements TimeClient {

    private final String GENERIC_TIME_ERROR = "Failed to retrieve current time via World Time API";

    private final WorldTimeAPIRequests worldTimeApi;
    private final WorldClockAPIRequests worldClockApi;

    @Override
    @Retry(name = WORLDTIME_API)
    @CircuitBreaker(name = WORLDTIME_API)
    @Bulkhead(name = WORLDTIME_API)
    public String currentTime() throws IOException {
        return worldTimeApi.currentTime().execute().body().getUtcDatetime();
    }

    @Override
    public String circuitBreakerFallback(Exception e) throws IOException {
        log.error(GENERIC_TIME_ERROR, e);

        return worldClockApi.currentTime().execute().body().getCurrentDateTime();
    }

    @Override
    public String bulkheadFallback(Exception e) {
        log.error(GENERIC_TIME_ERROR, e);

        return Instant.now().toString();
    }
}
