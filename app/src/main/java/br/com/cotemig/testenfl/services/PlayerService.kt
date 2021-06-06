package br.com.cotemig.testenfl.services

import br.com.cotemig.testenfl.models.Players
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PlayerService {
    @GET("{user}?key=0d7369d8f1374febaa309f7e2b8f6532")
    fun getPlayer(@Path("user") user: String) : Call<List<Players>>
}