import java.util.ArrayList;
import java.util.List;

public class Ranking {
    private List<TeamAndRanking> ranking;

    public Ranking(){
        this.ranking = new ArrayList<>();
    }
    public void addTeam(Team t, int score){
        ranking.add(new TeamAndRanking(t,score));
    }
    public String printRanking(){
        String info="";
        if(ranking.size()!=0){
            for (TeamAndRanking teamandrank: ranking) {
                info+=teamandrank.toString();
            }
        }else
            info="This ranking has no teams in it, try to add one with addTeam() method.";

        return info;
    }
    public void modifyScore(Team t, int newScore){
        for (TeamAndRanking teamAndRanking : ranking) {
            if (t.equals(teamAndRanking.getTeam()))
                teamAndRanking.modifyScore(newScore);
        }
    }

    //private class to manage teams as a team-score pair
    private class TeamAndRanking{
        Team team;
        int score;
        private TeamAndRanking(Team team, int score){
            this.team = team;
            this.score = score;
        }

        private Team getTeam() {
            return team;
        }

        private void setTeam(Team team) {
            this.team = team;
        }

        public String toString(){
            return team.toString() + " " + score+"\n";
        }


        private void modifyScore(int newScore){
            this.score = newScore;
        }
    }
}

