import com.jebwerkz.dojoMaster.art.Art
import com.jebwerkz.dojoMaster.team.Team
import com.jebwerkz.dojoMaster.rank.Rank
import com.jebwerkz.dojoMaster.rank.RankTitle
import com.jebwerkz.dojoMaster.curriculum.Level
import com.jebwerkz.dojoMaster.User
import com.jebwerkz.dojoMaster.UserRole
import com.jebwerkz.dojoMaster.Role
import com.jebwerkz.dojoMaster.person.Person

import java.text.SimpleDateFormat

class BootStrap {

    def sdf = new SimpleDateFormat("MM/dd/yyyy")
    
    def init = { servletContext ->

        if(!Role.count()){
            def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
            def userRole = new Role(authority: 'ROLE_USER').save(flush: true)
            def instructorRole = new Role(authority: 'ROLE_INSTRUCTOR').save(flush:true)

            def testUser = new User(username: 'admin', enabled: true, password: 'admin')
            testUser.save(flush:true)

            UserRole.create testUser, adminRole, true
            UserRole.create testUser, userRole, true
        }

        if(!Art.count()) {
            new Art(name:"Taekwondo", nameKr:"태권도", description:"Korean art: The Way of Hand and Foot").save(failOnError: true)
            new Art(name:"Hapkido", nameKr:"합기도", description:"Korean art: The Way of Coordinated Power").save(failOnError: true)
            new Art(name:"Mukido", nameKr:"무기도", description:"Korean art: The Way of Weapons").save(failOnError: true)
        }

        if(!Team.count()) {
            new Team(name:"Gold Team", color:"Gold", description: "Goal Oriented Lifeskills Development", chineseCharacter: "Gold").save(failOnError: true)
            new Team(name:"Blue Team", color:"Blue", description: "Building Leaders of Unmatched Excellence", chineseCharacter: "Blue").save(failOnError: true)
        }

        if(!RankTitle.count()) {
            new RankTitle(title: "None").save(failOnError: true)
            new RankTitle(title: "Mr./Ms.").save(failOnError: true)
            new RankTitle(title: "Junior Master").save(failOnError: true)
            new RankTitle(title: "Master").save(failOnError: true)
        }

        if(!Level.count()) {
           new Level(art:1, name:"Beginner").save(failOnError: true) 
           new Level(art:1, name:"Level 1").save(failOnError: true) 
           new Level(art:1, name:"Level 2").save(failOnError: true) 
           new Level(art:1, name:"Black Belt").save(failOnError: true) 
           new Level(art:2, name:"Beginner").save(failOnError: true) 
           new Level(art:2, name:"Yellow Belt").save(failOnError: true) 
           new Level(art:2, name:"Blue Belt").save(failOnError: true) 
           new Level(art:2, name:"Red Belt").save(failOnError: true) 
           new Level(art:2, name:"Black Belt").save(failOnError: true) 
        }

        if(!Rank.count()) {
            //Junior Taekwondo Ranks


            //Adult Taekwondo Ranks
            new Rank(art:1, belt:"White, Solid", uniform: "White", chevrons:"N/A", description: "Beginner", name: "White Belt", nameKr: "White Belt", team: 1, title:1, level:1).save(failOnError: true)
            new Rank(art:1, belt:"Yellow, Solid", uniform: "White", chevrons:"N/A", description: "Level 1", name: "Yellow Belt", nameKr: "Yellow Belt", team: 1, title:1, level:2).save(failOnError: true)
            new Rank(art:1, belt:"Orange, Solid", uniform: "White", chevrons:"N/A", description: "Level 1", name: "Orange Belt", nameKr: "Orange Belt", team: 1, title:1, level:2).save(failOnError: true)
            new Rank(art:1, belt:"Green, Solid", uniform: "White", chevrons:"N/A", description: "Level 1", name: "Green Belt", nameKr: "Green Belt", team: 1, title:1, level:2).save(failOnError: true)
            new Rank(art:1, belt:"Blue, Solid", uniform: "White", chevrons:"N/A", description: "Level 1", name: "Blue Belt", nameKr: "Blue Belt", team: 1, title:1, level:2).save(failOnError: true)
            new Rank(art:1, belt:"Brown, Solid", uniform: "White Top, Black Pants", chevrons:"N/A", description: "Level 2", name: "Brown Belt", nameKr: "Brown Belt", team: 1, title:1, level:3).save(failOnError: true)
            new Rank(art:1, belt:"Purple, Solid", uniform: "White Top, Black Pants", chevrons:"N/A", description: "Level 2", name: "Purple Belt", nameKr: "Purple Belt", team: 1, title:1, level:3).save(failOnError: true)
            new Rank(art:1, belt:"Red, Solid", uniform: "White Top, Black Pants", chevrons:"N/A", description: "Level 2", name: "Red Belt", nameKr: "Red Belt", team: 1, title:1, level:3).save(failOnError: true)
            new Rank(art:1, belt:"Black, Solid", uniform: "White Top with Black Collar, Black Pants", chevrons:"N/A", description: "Level 2", name: "Recommend Black Belt", nameKr: "Recommend Black  Belt", team: 1, title:2, level:3).save(failOnError: true)
            new Rank(art:1, belt:"Black, Gold Embroidery, 1 Stripes", uniform: "White Top with Black Collar, Black Pants", chevrons:"N/A", description: "Black", name: "1st Degree Black Belt", nameKr: "1st Dan", team: 1, title:2, level:4).save(failOnError: true)
            new Rank(art:1, belt:"Black, Gold Embroidery, 2 Stripes", uniform: "White Top with Black Collar, Black Pants", chevrons:"N/A", description: "Black", name: "2nd Degree Black Belt", nameKr: "2nd Dan", team: 1, title:2, level:4).save(failOnError: true)
            new Rank(art:1, belt:"Black, Gold Embroidery, 3 Stripes", uniform: "Black", chevrons:"N/A", description: "Black", name: "3rd Degree Black Belt", nameKr: "3rd Dan", team: 1, title:3, level:4).save(failOnError: true)
            new Rank(art:1, belt:"Black, Gold Embroidery, 4 Stripes", uniform: "Black", chevrons:"N/A", description: "Black", name: "4th Degree Black Belt", nameKr: "4th Dan", team: 1, title:3, level:4).save(failOnError: true)
            new Rank(art:1, belt:"Black, Gold Embroidery, 5 Stripes", uniform: "Black", chevrons:"N/A", description: "Black", name: "5th Degree Black Belt", nameKr: "5th Dan", team: 1, title:4, level:4).save(failOnError: true)
            new Rank(art:1, belt:"Black, Gold Embroidery, 6 Stripes", uniform: "Black", chevrons:"N/A", description: "Black", name: "6th Degree Black Belt", nameKr: "6th Dan", team: 1, title:4, level:4).save(failOnError: true)
        
            //Hapkido Ranks
            new Rank(art:2, belt:"White, Solid", uniform: "White", chevrons:"N/A", description: "Beginner", name: "White Belt", nameKr: "White Belt", team: 1, title:1, level:5).save(failOnError: true)
            new Rank(art:2, belt:"Yellow, Solid", uniform: "White", chevrons:"N/A", description: "Level 1", name: "Yellow Belt", nameKr: "Yellow Belt", team: 1, title:1, level:6).save(failOnError: true)
            new Rank(art:2, belt:"Blue, Solid", uniform: "White", chevrons:"N/A", description: "Level 1", name: "Blue Belt", nameKr: "Blue Belt", team: 1, title:1, level:7).save(failOnError: true)
            new Rank(art:2, belt:"Red, Solid", uniform: "White Top, Black Pants", chevrons:"N/A", description: "Red Belt", name: "Red Belt", nameKr: "Red Belt", team: 1, title:1, level:8).save(failOnError: true)
            new Rank(art:2, belt:"Black, Solid", uniform: "White Top, Black Pants", chevrons:"N/A", description: "Black Belt", name: "Black Belt", nameKr: "Black Belt", team: 1, title:1, level:9).save(failOnError: true)

            //Junior Mukido Ranks
            

            //Adult Mukido Ranks
        }

        if(!Person.count()) {
            def jevans = new Person(firstName:"Jeremiah", lastName:"Evans", dateOfBirth: sdf.parse("06/22/1987")).save(failOnError: true)

        }



    }
    def destroy = {
    }
}
