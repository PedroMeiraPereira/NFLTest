package br.com.cotemig.testenfl.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.testenfl.R
import br.com.cotemig.testenfl.models.Players
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_players.view.*

class PlayersAdapter (var context: Context, var table: List<Players>) :
    RecyclerView.Adapter<PlayersAdapter.PlayersHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayersHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_players, parent, false)
        return PlayersHolder(view)
    }

    override fun onBindViewHolder(holder: PlayersHolder, position: Int) {
        holder.bind(context, table[position])
    }

    override fun getItemCount(): Int {
        return table.size
    }

    class PlayersHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            fun bind(context: Context, players: Players){

                Glide.with(context).load(players.PhotoUrl).into(itemView.photoUrl)

                itemView.name.text = players.Name
                itemView.position.text = players.Position
                itemView.college.text = players.College
                itemView.heightP.text = players.Height
                itemView.weightP.text = players.Weight.toString()
            }
        }
}