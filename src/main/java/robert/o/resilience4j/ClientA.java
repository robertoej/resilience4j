package robert.o.resilience4j;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Slf4j
@Service
public class ClientA implements Client {

    @Override
    @CircuitBreaker(name = Config.BACKEND, fallbackMethod = "fallback")
    public String currentTime() {
        throw new RuntimeException("Could not get time");
    }

    public String fallback(Exception e) {
        log.error("Failed to retrieve current time", e);

        return Instant.now().toString();
    }
}
