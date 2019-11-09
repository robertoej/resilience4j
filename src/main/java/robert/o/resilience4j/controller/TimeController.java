package robert.o.resilience4j.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import robert.o.resilience4j.client.TimeClient;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class TimeController {

    private final TimeClient worldTimeClient;
    private final TimeClient worldClockClient;

    @GetMapping("clock_api")
    public String getClockApiTime() throws IOException {
        return worldClockClient.currentTime();
    }

    @GetMapping("time_api")
    public String getTimeApiTime() throws IOException {
        return worldTimeClient.currentTime();
    }
}
