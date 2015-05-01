import com.jebwerkz.dojoMaster.art.Art
import com.jebwerkz.dojoMaster.team.Team
import com.jebwerkz.dojoMaster.rank.Rank

class BootStrap {

    def init = { servletContext ->
        if(!Art.count()) {
            new Art(name:"Taekwondo", nameKr:"태권도", description:"Korean art: The Way of Hand and Foot").save(failOnError: true)
            new Art(name:"Hapkido", nameKr:"합기도", description:"Korean art: The Way of Coordinated Power").save(failOnError: true)
            new Art(name:"Mukido", nameKr:"무기도", description:"Korean art: The Way of Weapons").save(failOnError: true)
        }

        if(!Team.count()) {
            new Team(name:"Gold Team", color:"Gold", description: "Goal Oriented Lifeskills Development").save(failOnError: true)
            new Team(name:"Blue Team", color:"Blue", description: "Building Leaders of Unmatched Excellence").save(failOnError: true)
        }

        if(!Rank.count()) {
            new Rank(art:1, belt:"White, Solid", description: "Beginner", name: "White Belt", nameKr: "White Belt", team: 1, title:"None").save(failOnError: true)

        }
    }
    def destroy = {
    }
}
