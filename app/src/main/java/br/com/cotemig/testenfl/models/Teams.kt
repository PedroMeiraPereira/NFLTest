package br.com.cotemig.testenfl.models

import java.io.Serializable

data class Teams(
        var idTeam: String = "",
        var strTeam: String = "",
        var strTeamShort: String = "",
        var strManager: String = "",
        var strStadium: String = "",
        var strStadiumThumb: String = "",
        var strStadiumLocation: String = "",
        var intStadiumCapacity: String = "",
        var strTeamBadge: String = ""
):Serializable