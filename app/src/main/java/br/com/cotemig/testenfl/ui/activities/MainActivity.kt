package br.com.cotemig.testenfl.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.cotemig.testenfl.R
import br.com.cotemig.testenfl.models.Standings
import br.com.cotemig.testenfl.services.RetrofitInitializer
import br.com.cotemig.testenfl.ui.adapters.TableAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getStanding()
    }

    fun getStanding(){

        var s = RetrofitInitializer().serviceListaStandings()

        var call = s.getStanding()

        call.enqueue(object : retrofit2.Callback<List<Standings>>{
            override fun onResponse(call: Call<List<Standings>>?, response: Response<List<Standings>>?) {

                response?.let{
                    if(it.code()==200){

                        table.adapter = TableAdapter(this@MainActivity, it.body())
                        table.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                        //Toast.makeText(this@MainActivity, "Ok", Toast.LENGTH_LONG).show()

                    }
                }

            }

            override fun onFailure(call: Call<List<Standings>>?, t: Throwable?) {
                Toast.makeText(this@MainActivity, "erro", Toast.LENGTH_LONG).show()
            }
        })

    }

}