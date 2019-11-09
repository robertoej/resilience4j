package robert.o.resilience4j.client;

import java.io.IOException;

public interface TimeClient {

    String currentTime() throws IOException;

    String circuitBreakerFallback(Exception e) throws IOException;

    String bulkheadFallback(Exception e);
}
