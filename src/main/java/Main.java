public class Main {
    public static void main(String[] args) {

        //Create first team
        int[] scheme = {4,4,2};
        Team t1 = new Team("coach1","stadium1","Juventus",scheme);
        //add players
        t1.addPlayer(new Player("a","a", Player.Role.Defender));
        t1.addPlayer(new Player("b","a", Player.Role.Defender));
        t1.addPlayer(new Player("c","a", Player.Role.Defender));
        t1.addPlayer(new Player("d","a", Player.Role.Defender));
        t1.addPlayer(new Player("e","a", Player.Role.Defender));


        t1.addPlayer(new Player("f","a", Player.Role.Midfielder));
        t1.addPlayer(new Player("g","a", Player.Role.Midfielder));
        t1.addPlayer(new Player("h","a", Player.Role.Midfielder));
        t1.addPlayer(new Player("i","a", Player.Role.Midfielder));
        t1.addPlayer(new Player("j","a", Player.Role.Midfielder));


        t1.addPlayer(new Player("k","a", Player.Role.Striker));
        t1.addPlayer(new Player("l","a", Player.Role.Striker));
        t1.addPlayer(new Player("m","a", Player.Role.Striker));
        t1.addPlayer(new Player("n","a", Player.Role.Striker));
        t1.addPlayer(new Player("o","a", Player.Role.Striker));


        t1.addPlayer(new Player("p","a", Player.Role.Goalkeeper));
        t1.addPlayer(new Player("q","a", Player.Role.Goalkeeper));
        t1.addPlayer(new Player("r","a", Player.Role.Goalkeeper));


        Team t2 = new Team("coach2","stadium2","Juventus",scheme);
        /*Ranking r = new Ranking();
        r.addTeam(t1,0);
        r.addTeam(t2,2);
        System.out.println(r.printRanking());*/


        System.out.println("All players:\n"+t1.printTeam());
        System.out.println("\n\n");
        System.out.println("Titled players:\n"+t1.printTitledTeam());


        //change role of a player
        t1.modifyRole("j","a", Player.Role.Goalkeeper);

        //change scheme
        int[] newScheme = {3,5,2};
        t1.setTeamScheme(newScheme);
        System.out.println("\n\n");
        System.out.println("Titled players:\n"+t1.printTitledTeam());


        //change role of a player
        t1.modifyRole("j","a", Player.Role.Midfielder);

        System.out.println("\n\n");
        System.out.println("Titled players:\n"+t1.printTitledTeam());

        //try set invalid scheme
        System.out.println("\n\n");
        newScheme = new int[] {5,5,5};
        System.out.println("The new scheme is valid? "+t1.setTeamScheme(newScheme));
        System.out.println("Titled players:\n"+t1.printTitledTeam());



    }
}