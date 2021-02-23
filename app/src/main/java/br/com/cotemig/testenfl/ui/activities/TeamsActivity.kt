package br.com.cotemig.testenfl.ui.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.cotemig.testenfl.R
import br.com.cotemig.testenfl.models.ListaTeams
import br.com.cotemig.testenfl.models.Teams
import br.com.cotemig.testenfl.services.RetrofitInitializer
import br.com.cotemig.testenfl.ui.adapters.TeamsAdapter
import kotlinx.android.synthetic.main.activity_teams.*
import retrofit2.Call
import retrofit2.Response

class TeamsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teams)

        getTeam()
    }

    fun getTeam(){

        var s = RetrofitInitializer().serviceListaTeams()

        var call = s.getTeam()

        call.enqueue(object : retrofit2.Callback<ListaTeams>{

            override fun onResponse(call: Call<ListaTeams>?, response: Response<ListaTeams>?) {
                response?.let {
                    if(it.code()==200){

                        showTable(it.body().teams)
                        //Toast.makeText(this@TeamsActivity, "Ok", Toast.LENGTH_LONG).show()

                    }
                }
            }

            override fun onFailure(call: Call<ListaTeams>?, t: Throwable?) {
                Toast.makeText(this@TeamsActivity, "Erro", Toast.LENGTH_LONG).show()
            }
        })
    }

    fun showTable(teams: List<Teams>){

        teamsdesc.adapter = TeamsAdapter(this, teams)
        teamsdesc.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

}