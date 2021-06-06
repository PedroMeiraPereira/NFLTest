package br.com.cotemig.testenfl.ui.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.testenfl.R
import br.com.cotemig.testenfl.models.Teams
import br.com.cotemig.testenfl.ui.activities.PlayersActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import kotlinx.android.synthetic.main.item_teams.view.*

class TeamsAdapter (var context: Context, var table: List<Teams>) :
        RecyclerView.Adapter<TeamsAdapter.TeamsHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamsHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_teams, parent, false)
        return TeamsHolder(view)
    }

    override fun onBindViewHolder(holder: TeamsHolder, position: Int) {
        holder.bind(context, table[position])
    }

    override fun getItemCount(): Int {
        return table.size
    }

    class TeamsHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(context: Context, teams: Teams){

            Glide.with(context).load(teams.strTeamBadge).into(itemView.strTeamBadge)

            itemView.strTeam.text = teams.strTeam
            itemView.strManager.text = teams.strManager
            itemView.strStadium.text = teams.strStadium
            itemView.strStadiumLocation.text = teams.strStadiumLocation
            itemView.intStadiumCapacity.text = teams.intStadiumCapacity

            itemView.time.setOnClickListener{
                var intent = Intent(context, PlayersActivity::class.java)
                intent.putExtra("team", teams)
                context.startActivity(intent)
            }

        }
    }

}