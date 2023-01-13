import java.util.HashMap;
import java.util.Map;

/**
 * The Ranking class represent a ranking of teams.
 * Every Ranking is characterised by an HashMap in which every key is a team and the corresponding value is the score that that team has in the ranking.
 */
public class Ranking {
    private HashMap<Team,Integer> ranking;

    /**
     * Create a new Ranking object.
     */
    public Ranking(){
        this.ranking = new HashMap<>();
    }

    /**
     * Add a team to the ranking
     * @param team the team that is added to the ranking
     * @param score the score of that team in the ranking
     * @return true if the team is added successfully in the ranking, false if the team was already in the ranking.
     */
    public boolean addTeam(Team team, int score){
        if(ranking.containsKey(team))
            return false;
        ranking.put(team,score);
        return true;
    }

    /**
     * Create a String containing all the teams and their respective score.
     * @return a String containing all the pairs teamName - score if the HashMap is non-empty, a warning message otherwise
     */
    public String printRanking(){

        String info="";
        if(ranking.size()!=0){
            for (Map.Entry<Team,Integer> set:ranking.entrySet()) {
                info+= set.getKey().getTeamName()+" " + set.getValue()+"\n";
            }
        }else
            info="This ranking has no teams in it, try to add one with addTeam() method.";

        return info;
    }

    /**
     * modify the score of a team
     * @param team the team of which we want to modify the score
     * @param newScore the new score value
     */
    public void modifyScore(Team team, int newScore){
        ranking.put(team,newScore);
    }
}

