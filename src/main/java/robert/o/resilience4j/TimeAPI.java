package robert.o.resilience4j;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TimeAPI {

    private final Client client;

    @GetMapping
    public String getTime() {
        return client.currentTime();
    }
}
