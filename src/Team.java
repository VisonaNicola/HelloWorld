import java.util.*;

/**
 * The Team class represent a collection of Players.
 * Every team is characterized by a set of players, the coach's name, the name of the stadium and the name of the team.
 */
public class Team {
    private HashSet<Player> players;
    private String coachName, stadiumName, teamName;

    /**
     * Create a new team specifying the list of players.
     * @param players - an HashSet that contains all the players that will be part of the team
     * @param coachName - the name of the coach
     * @param stadiumName - the name of the stadium in which the team plays
     * @param teamName - the name of the team
     */
    public Team(HashSet<Player> players,String coachName,String stadiumName,String teamName){
        this.players = players;
        this.coachName = coachName;
        this.stadiumName = stadiumName;
        this.teamName=teamName;
    }
    /**
     * Create a new team.
     * The set of players is not specified, so this method creates an empty set.
     * @param coachName - the name of the coach
     * @param stadiumName - the name of the stadium in which the team plays
     * @param teamName - the name of the team
     */
    public Team(String coachName,String stadiumName,String teamName){
        this.players = new HashSet<>();
        this.coachName = coachName;
        this.stadiumName = stadiumName;
        this.teamName=teamName;
    }

    /**
     * Get the team name.
     * @return the team name
     */
    public String getTeamName() {
        return teamName;
    }
    /**
     * Get the set of the players.
     * @return the set of the players
     */
    public HashSet<Player> getPlayers() {
        return players;
    }

    /**
     * Set a new list of players that overwrites the old one.
     * @param players - the new set of players
     */
    public void setPlayers(HashSet<Player> players) {
        this.players = players;
    }
    /**
     * Get the name of the coach.
     * @return the name of the coach
     */
    public String getCoachName() {
        return coachName;
    }
    /**
     * Set the name of the coach.
     * @param coachName - the new name of coach
     */
    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }
    /**
     * Get the name of the stadium.
     * @return the name of the stadium
     */
    public String getStadiumName() {
        return stadiumName;
    }
    /**
     * Set the name of the stadium.
     * @param stadiumName - the new name of stadium
     */
    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    /**
     * Add a new player to the team.
     * @param player - the new player
     */
    public void addPlayer(Player player){
        players.add(player);
    }

    /**
     * remove a player from the team
     * @param player - the player that will be removed from the team
     * @return true, if the player was in the set of players, false otherwise
     */
    public boolean removePlayer(Player player){
        return players.remove(player);
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

        //assume that 2 teams cannot have the same name
        return this.getTeamName() == ((Team) obj).getTeamName();
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamName);
    }
}
