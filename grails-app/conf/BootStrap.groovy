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
            new Rank(art:1, belt:"White, Solid", uniform: "White", chevrons:"N/A", description: "Beginner", name: "White Belt", nameKr: "White Belt", team: 1, title:"None").save(failOnError: true)
            new Rank(art:1, belt:"Yellow, Solid", uniform: "White", chevrons:"N/A", description: "Level 1", name: "Yellow Belt", nameKr: "Yellow Belt", team: 1, title:"None").save(failOnError: true)
            new Rank(art:1, belt:"Orange, Solid", uniform: "White", chevrons:"N/A", description: "Level 1", name: "Orange Belt", nameKr: "Orange Belt", team: 1, title:"None").save(failOnError: true)
            new Rank(art:1, belt:"Green, Solid", uniform: "White", chevrons:"N/A", description: "Level 1", name: "Green Belt", nameKr: "Green Belt", team: 1, title:"None").save(failOnError: true)
            new Rank(art:1, belt:"Blue, Solid", uniform: "White", chevrons:"N/A", description: "Level 1", name: "Blue Belt", nameKr: "Blue Belt", team: 1, title:"None").save(failOnError: true)
            new Rank(art:1, belt:"Brown, Solid", uniform: "White Top, Black Pants", chevrons:"N/A", description: "Level 2", name: "Brown Belt", nameKr: "Brown Belt", team: 1, title:"None").save(failOnError: true)
            new Rank(art:1, belt:"Purple, Solid", uniform: "White Top, Black Pants", chevrons:"N/A", description: "Level 2", name: "Purple Belt", nameKr: "Purple Belt", team: 1, title:"None").save(failOnError: true)
            new Rank(art:1, belt:"Red, Solid", uniform: "White Top, Black Pants", chevrons:"N/A", description: "Level 2", name: "Red Belt", nameKr: "Red Belt", team: 1, title:"None").save(failOnError: true)
            new Rank(art:1, belt:"Black, Solid", uniform: "White Top with Black Collar, Black Pants", chevrons:"N/A", description: "Level 2", name: "Recommend Black Belt", nameKr: "Recommend Black  Belt", team: 1, title:"Mr/Ms").save(failOnError: true)
            new Rank(art:1, belt:"Black, Gold Embroidery, 1 Stripes", uniform: "White Top with Black Collar, Black Pants", chevrons:"N/A", description: "Black", name: "1st Degree Black Belt", nameKr: "1st Dan", team: 1, title:"Mr/Ms").save(failOnError: true)
            new Rank(art:1, belt:"Black, Gold Embroidery, 2 Stripes", uniform: "White Top with Black Collar, Black Pants", chevrons:"N/A", description: "Black", name: "2nd Degree Black Belt", nameKr: "2nd Dan", team: 1, title:"Mr/Ms").save(failOnError: true)
            new Rank(art:1, belt:"Black, Gold Embroidery, 3 Stripes", uniform: "Black", chevrons:"N/A", description: "Black", name: "3rd Degree Black Belt", nameKr: "3rd Dan", team: 1, title:"Junior Master").save(failOnError: true)
            new Rank(art:1, belt:"Black, Gold Embroidery, 4 Stripes", uniform: "Black", chevrons:"N/A", description: "Black", name: "4th Degree Black Belt", nameKr: "4th Dan", team: 1, title:"Junior Master").save(failOnError: true)
            new Rank(art:1, belt:"Black, Gold Embroidery, 5 Stripes", uniform: "Black", chevrons:"N/A", description: "Black", name: "5th Degree Black Belt", nameKr: "5th Dan", team: 1, title:"Master").save(failOnError: true)
            new Rank(art:1, belt:"Black, Gold Embroidery, 6 Stripes", uniform: "Black", chevrons:"N/A", description: "Black", name: "6th Degree Black Belt", nameKr: "6th Dan", team: 1, title:"Master").save(failOnError: true)
        }
    }
    def destroy = {
    }
}
