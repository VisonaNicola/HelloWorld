import java.util.*;

/**
 * The Team class represent a collection of Players.
 * Every team is characterized by a set of players, the coach's name, the name of the stadium, the name of the team and the scheme of the team.
 */
public class Team {
    private HashSet<Player> players, titledPlayers;
    private String coachName, stadiumName, teamName;
    private int[] teamScheme = {3,5,2};

    /**
     * Create a new team specifying the list of players.
     * The default scheme is [3,5,2] but any array of 3 element in which the sum of the 3 elements is 10 will be accepted.
     * @param players an HashSet that contains all the players that will be part of the team
     * @param coachName the name of the coach
     * @param stadiumName the name of the stadium in which the team plays
     * @param teamName the name of the team
     */
    public Team(HashSet<Player> players,String coachName,String stadiumName,String teamName){
        this.players = players;
        this.coachName = coachName;
        this.stadiumName = stadiumName;
        this.teamName=teamName;
        this.titledPlayers = null;
        createTitledPlayerList();
    }
    /**
     * Create a new team.
     * The set of players is not specified, so this method creates an empty set.
     * The default scheme is [3,5,2] but any array of 3 element in which the sum of the 3 elements is 10 will be accepted.
     * @param coachName the name of the coach
     * @param stadiumName the name of the stadium in which the team plays
     * @param teamName the name of the team
     */
    public Team(String coachName,String stadiumName,String teamName){
        this.players = new HashSet<>();
        this.coachName = coachName;
        this.stadiumName = stadiumName;
        this.teamName=teamName;
        this.titledPlayers = null;
        createTitledPlayerList();
    }

    /**
     * Create a new team specifying the list of players.
     * @param players an HashSet that contains all the players that will be part of the team
     * @param coachName the name of the coach
     * @param stadiumName the name of the stadium in which the team plays
     * @param teamName the name of the team
     * @param teamScheme the scheme that the team will use in a match
     */
    public Team(HashSet<Player> players,String coachName,String stadiumName,String teamName, int[] teamScheme){
        this.players = players;
        this.coachName = coachName;
        this.stadiumName = stadiumName;
        this.teamName=teamName;
        this.titledPlayers = null;
        setTeamScheme(teamScheme);
        createTitledPlayerList();
    }
    /**
     * Create a new team.
     * The set of players is not specified, so this method creates an empty set.
     * @param coachName the name of the coach
     * @param stadiumName the name of the stadium in which the team plays
     * @param teamName the name of the team
     * @param teamScheme the scheme that the team will use in a match
     */
    public Team(String coachName,String stadiumName,String teamName,int[] teamScheme){
        this.players = new HashSet<>();
        this.coachName = coachName;
        this.stadiumName = stadiumName;
        this.teamName=teamName;
        this.titledPlayers = null;
        setTeamScheme(teamScheme);
        createTitledPlayerList();
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
     * @param players the new set of players
     */
    public void setPlayers(HashSet<Player> players) {
        for (Player p: players) {
            p.setTeam(this);
        }
        this.players = players;
        createTitledPlayerList();
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
     * @param coachName the new name of coach
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
     * @param stadiumName the new name of stadium
     */
    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }
    /**
     * Get the scheme of the team.
     * @return the scheme of the team
     */
    public int[] getTeamScheme(){
        return teamScheme;
    }

    /**
     * set a new scheme for the team
     * @param newScheme the new scheme for the team must be an array of length 3 and the sum of the 3 elements must be 10
     * @return true if all criteria are met, false otherwise
     */
    public boolean setTeamScheme(int[] newScheme){
        if(newScheme==null || newScheme.length!=3)
            return false;
        int sum =0;
        for (int i = 0; i < 3; i++) {
            if(newScheme[i]<=0) //if there is a non-positive number the scheme is not correct
                return false;
            sum+=newScheme[i];
        }
        if(sum!=10)
            return false;
        this.teamScheme=newScheme;
        createTitledPlayerList();   //if the scheme is changed the set of titled player must be recreated
        return true;
    }




    /**
     * Add a new player to the team.
     * @param player the new player
     */
    public void addPlayer(Player player){
        player.setTeam(this);
        players.add(player);

        if(titledPlayers==null){
            createTitledPlayerList();
        }

    }

    /**
     * remove a player from the team
     * @param player the player that will be removed from the team
     * @return true, if the player was in the set of players, false otherwise
     */
    public boolean removePlayer(Player player){
        boolean result = players.remove(player);
        createTitledPlayerList();
        return result;
    }

    /**
     * Modify the role of a player in the team
     * @param name name of the player that we want to modify the role
     * @param surname surname of the player that we want to modify the role
     * @param newRole new role for the player
     * @return true if the player is in the team (so that the role can be modified), false otherwise
     */
    public boolean modifyRole(String name, String surname, Player.Role newRole){
        boolean playerFound=false;
        for (Player p: players) {
            if(p.equals(new Player(name,surname, newRole))){
                p.setRole(newRole);
                playerFound=true;
                //createTitledPlayerList();
            }
        }
        return playerFound;
    }

    /**
     * Return the list of all players in the team as a String
     * @return A String containing name, surname and role of all players in the team.
     */
    public String printTeam(){
        String info = "";
        for (Player p: players) {
            info+=p+"\n";
        }
        return info;
    }

    /**
     * Create the set of titled players with respect to the team scheme.
     * The set of titled players can be created only if there are enough players in the players set to fulfill every role according to the scheme.
     * @return true if it is possible to create the set of titled player (there are enough players for each role), false otherwise
     */
    public boolean createTitledPlayerList(){

        if(players.size()<11) //not enough players for a team
            return false;

        HashSet<Player> tempTitled = new HashSet<>();
        int ndef=0, nmid=0, nstri =0;
        boolean goalkeeper = false;
        //cicle through the set of players, for each player verify if the role is needed in the set of titled players, if yes add the player to the set.
        //To verify if a role is needed in the list verify if the number of players with that role that are already in the set is lower
        //than the maximum amount for that role in the current scheme
        for (Player p: players) {
            if(p.getRole()== Player.Role.Defender && ndef<teamScheme[0]){
                ndef++;
                tempTitled.add(p);
            }else if(p.getRole()== Player.Role.Midfielder && nmid<teamScheme[1]){
                nmid++;
                tempTitled.add(p);
            }else if(p.getRole()== Player.Role.Striker && nstri<teamScheme[2]){
                nstri++;
                tempTitled.add(p);
            }else if(p.getRole()== Player.Role.Goalkeeper && !goalkeeper){
                tempTitled.add(p);
                goalkeeper=true;
            }
        }
        //if all roles are filled, the set of titled player is valid
        //System.out.println(goalkeeper && ndef==teamScheme[0] && nmid==teamScheme[1] && nstri==teamScheme[2]);
        if(goalkeeper && ndef==teamScheme[0] && nmid==teamScheme[1] && nstri==teamScheme[2]){
            titledPlayers = tempTitled;
            return true;
        }
        titledPlayers = null;    //if a titled set cannot be created, create an empty one
        return false;
    }

    /**
     * Return the list of titled players as a String, including information about the scheme.
     * If it's not possible to create a list of titled player given the current set of players and the current scheme, returns a warning message
     * @return A String containing name, surname and role of all titled players in the team if possible, a warning message otherwise
     */
    public String printTitledTeam(){
        String info = "Scheme: ["+teamScheme[0]+","+teamScheme[1]+","+teamScheme[2]+"]\n";
        if(titledPlayers!=null){
            for (Player p: titledPlayers) {
                info+=p+"\n";
            }
        }else
            info += "With the current scheme and set of players it's not possible to create a set of titled players";
        return info;
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
        //return new CompareTeamsByName().compare(this,(Team) obj)==0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamName);
    }
}
