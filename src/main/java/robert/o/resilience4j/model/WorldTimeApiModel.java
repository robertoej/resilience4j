package robert.o.resilience4j.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorldTimeApiModel {

    @JsonProperty("utc_datetime")
    private String utcDatetime;
}
