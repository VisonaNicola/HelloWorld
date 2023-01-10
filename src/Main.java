public class Main {
    public static void main(String[] args) {
        //Create ranking
        Ranking r = new Ranking();

        //Create first team
        Team t1 = new Team("coach1","stadium1","Juventus");
        //add players
        Player p = new Player("Pinco", "Pallino","defender");
        t1.addPlayer(p);
        t1.addPlayer(new Player("Mario", "Rossi","attacker"));
        t1.addPlayer(new Player("Gino", "Bianchi","goal keeper"));
        r.addTeam(t1,0);


        //Create second team
        Team t2 = new Team("coach2","stadium2","Inter");
        //add players
        t2.addPlayer(new Player("Francesco", "Verdi","defender"));
        t2.addPlayer(new Player("Alberto", "Arancioni","attacker"));
        t2.addPlayer(new Player("Alessandro", "Neri","goal keeper"));
        r.addTeam(t2,0);

        //print ranking
        //System.out.println(r.printRanking());

        //modify team1 and team2 score
        r.modifyScore(t1,2);
        r.modifyScore(t2,4);
        //print ranking
        System.out.println(r.printRanking());



        //verify if t1 and t2 are the same team
        //System.out.println(t1.equals(t2));

        //modify info about a player
        t1.removePlayer(new Player("Pinco", "Pallino","defender"));
        t1.addPlayer(new Player("Antonio","Blu","attacker"));
        //print ranking
        System.out.println(r.printRanking());


        //print an empty rank
        //Ranking r2 = new Ranking();
        //r2.modifyScore(t1,8);
        //System.out.println(r2.printRanking());


        //try adding a team that has the same name of a team already in the rank
        Team t3 = new Team("coach3","stadium3","Inter");
        t3.addPlayer(p);
        t3.addPlayer(new Player("aaa", "bbb","attacker"));
        t3.addPlayer(new Player("ccc", "ddd","goal keeper"));
        System.out.println(r.addTeam(t3,0));//false because the "Inter" team is already in the ranking
        System.out.println(r.printRanking());
    }
}