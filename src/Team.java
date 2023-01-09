import java.util.ArrayList;
import java.util.List;

public class Team {
    List<Player> players;
    String coachName, stadiumName;

    public Team(List<Player> players,String coachName,String stadiumName){
        this.players = players;
        this.coachName = coachName;
        this.stadiumName = stadiumName;
    }
    public Team(String coachName,String stadiumName){
        this.players = new ArrayList<>();
        this.coachName = coachName;
        this.stadiumName = stadiumName;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public void addPlayer(Player p){
        players.add(p);
    }
    public String toString(){
        String playerinfo ="";
        for(Player p : players){
            playerinfo+=p.toString()+" ";
        }
        return playerinfo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj== null)
            return false;
        if(!(obj instanceof Team))
            return false;

        //assume that a coach cannot coach 2 different teams
        if(this.getCoachName() == ((Team) obj).getCoachName())
            return true;
        else
            return  false;
    }
}
