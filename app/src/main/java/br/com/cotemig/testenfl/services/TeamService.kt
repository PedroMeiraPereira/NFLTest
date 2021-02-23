package br.com.cotemig.testenfl.services

import br.com.cotemig.testenfl.models.ListaTeams
import retrofit2.Call
import retrofit2.http.GET

interface TeamService {

    @GET("search_all_teams.php?l=NFL")
    fun getTeam() : Call<ListaTeams>
}