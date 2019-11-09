package robert.o.resilience4j.client.impl;

import retrofit2.Call;
import retrofit2.http.GET;
import robert.o.resilience4j.model.WorldTimeApiModel;

/**
 * Fetches time from http://worldtimeapi.org
 */
public interface WorldTimeAPIRequests {

    @GET("api/timezone/America/Sao_Paulo")
    Call<WorldTimeApiModel> currentTime();
}
