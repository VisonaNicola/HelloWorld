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
        for (TeamAndRanking teamandrank: ranking) {
            info+=teamandrank.toString();
        }
        return info;
    }
    public void modifyScore(Team t, int newScore){
        for (TeamAndRanking teamAndRanking : ranking) {
            if (t.equals(teamAndRanking.getTeam()))
                teamAndRanking.modifyScore(newScore);
        }
    }
    private class TeamAndRanking{
        Team team;
        int score;
        private TeamAndRanking(Team team, int score){
            this.team = team;
            this.score = score;
        }

        public Team getTeam() {
            return team;
        }

        public void setTeam(Team team) {
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

