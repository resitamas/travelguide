package sap.com.travelguide.network;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.swagger.annotations.Api;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sap.com.travelguide.utils.GsonHelper;

/**
 * Created by I344065 on 2018. 01. 18..
 */

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        return new OkHttpClient().newBuilder();
    }


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(NetworkConfig.SERVICE_ENDPOINT).client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonHelper.getGson())).build();
    }

    @Provides
    @Singleton
    public WeatherApi provideTripApi(Retrofit retrofit){
        return retrofit.create(WeatherApi.class);
    }

}
