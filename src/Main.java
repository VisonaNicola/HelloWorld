public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        //Create ranking
        Ranking r = new Ranking();

        //Create first team
        Team t1 = new Team("coach1","stadium1");

        //add players
        t1.addPlayer(new Player("Pinco", "Pallino","defender"));
        t1.addPlayer(new Player("Mario", "Rossi","attacker"));
        t1.addPlayer(new Player("Gino", "Bianchi","goal keeper"));
        r.addTeam(t1,0);

        //Create second team
        Team t2 = new Team("coach2","stadium2");

        //add players
        t2.addPlayer(new Player("Francesco", "Verdi","defender"));
        t2.addPlayer(new Player("Alberto", "Arancioni","attacker"));
        t2.addPlayer(new Player("Alessandro", "Neri","goal keeper"));
        r.addTeam(t2,0);

        //print ranking
        System.out.println(r.printRanking());

        //modify team1 and team2 score
        r.modifyScore(t1,2);
        r.modifyScore(t2,4);

        //print ranking
        System.out.println(r.printRanking());

        //verify if t1 and t2 are the same team
        //System.out.println(t1.equals(t2));

        //modify info about a player
        t1.getPlayers().get(0).setName("Antonio");
        t1.getPlayers().get(0).setSurname("Blu");
        t1.getPlayers().get(0).setRole("attacker");

        //print ranking
        System.out.println(r.printRanking());
    }
}