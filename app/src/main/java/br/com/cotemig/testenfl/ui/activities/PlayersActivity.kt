package br.com.cotemig.testenfl.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.cotemig.testenfl.R
import br.com.cotemig.testenfl.models.Players
import br.com.cotemig.testenfl.services.RetrofitInitializer
import br.com.cotemig.testenfl.ui.adapters.PlayersAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_players.*
import retrofit2.Call
import retrofit2.Response

class PlayersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_players)

        getPlayer()

    }

    fun getPlayer(){

        var s = RetrofitInitializer().serviceListaPlayers()

        var call = s.getPlayer()

        call.enqueue(object : retrofit2.Callback<List<Players>>{

            override fun onResponse(call: Call<List<Players>>?, response: Response<List<Players>>?) {

                response?.let{
                    if(it.code()==200){
                        showTable(it.body())
                        //Toast.makeText(this@PlayersActivity, "Ok", Toast.LENGTH_LONG).show()
                    }
                }
            }

            override fun onFailure(call: Call<List<Players>>?, t: Throwable?) {
                Toast.makeText(this@PlayersActivity, "Erro", Toast.LENGTH_LONG).show()
            }
        })
    }

    fun showTable(players: List<Players>){
        playerdesc.adapter = PlayersAdapter(this, players)
        playerdesc.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

}