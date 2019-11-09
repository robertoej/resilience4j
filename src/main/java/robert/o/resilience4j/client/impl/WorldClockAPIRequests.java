package robert.o.resilience4j.client.impl;

import retrofit2.Call;
import retrofit2.http.GET;
import robert.o.resilience4j.model.WorldClockApiModel;
import robert.o.resilience4j.model.WorldTimeApiModel;

/**
 * Fetches time from http://worldclockapi.com/
 */
public interface WorldClockAPIRequests {

    @GET("api/json/utc/now")
    Call<WorldClockApiModel> currentTime();
}
