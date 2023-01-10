import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TeamTest {
    @Test
    public void rolePlayerOfATeamChangedTest(){
        Team t = new Team("coach1","stadium1","Milan");
        Player p = new Player("Pinco","Pallino", Player.Role.Defender);
        t.addPlayer(p);
        //p.setRole(Player.Role.Striker);
        t.modifyRole(p.getName(),p.getSurname(), Player.Role.Striker);
        assertEquals(Player.Role.Striker,p.getRole());
    }

    @Test
    public void fullTeamTest(){
        //Create first team
        int[] scheme = {3,5,2};
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

        t1.modifyRole("j","a", Player.Role.Goalkeeper);
        assertEquals("Scheme: [3,5,2]\nWith the current scheme and set of players it's not possible to create a set of titled players", t1.printTitledTeam());
    }

    @Test
    public void negativeNumberInNewScheme(){
        int[] scheme = {3,5,-2};
        Team t1 = new Team("coach1","stadium1","Juventus");
        assertFalse(t1.setTeamScheme(scheme));
    }

    @Test
    public void invalidNewScheme(){
        int[] scheme = {5,5,5};
        Team t1 = new Team("coach1","stadium1","Juventus");
        assertFalse(t1.setTeamScheme(scheme));
    }
}
