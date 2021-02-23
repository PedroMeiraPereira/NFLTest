package br.com.cotemig.testenfl.services

import br.com.cotemig.testenfl.models.ListaTeams
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitInitializer {

    companion object {
        private val okHttpClient: OkHttpClient by lazy {
            OkHttpClient.Builder()
                .addInterceptor { chain ->
                    val newRequest = chain.request().newBuilder()
                    chain.proceed(newRequest.build())
                }
                .addInterceptor(HttpLoggingInterceptor().also { it ->
                    it.level = HttpLoggingInterceptor.Level.BODY
                })
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build()
        }

    }

    private val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://api.sportsdata.io/v3/nfl/scores/json/Standings/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofitSportsDB = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://www.thesportsdb.com/api/v1/json/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun serviceListaStandings(): StandingService {
        return retrofit.create(StandingService::class.java)
    }

    fun serviceListaTeams(): TeamService {
        return retrofitSportsDB.create(TeamService::class.java)
    }
}