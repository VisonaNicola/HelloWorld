import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void myFirstTest(){
        Player p = new Player("Pinco","Pallino", Player.Role.Defender);
        assertEquals("Pinco",p.getName());
    }

    @Test
    public void rolePlayerChangedTest(){
        Player p = new Player("Pinco","Pallino", Player.Role.Defender);
        p.setRole(Player.Role.Striker);
        assertEquals(Player.Role.Striker,p.getRole());
    }

    @Test
    public void compareToTest(){
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

        String treesetprint = "";
        TreeSet<Player> treeset = new TreeSet<>(t1.getPlayers());
        for (Player p :treeset) {
            treesetprint+=p;
        }

        String arraylistprint = "";
        ArrayList<Player> l = new ArrayList<>(t1.getPlayers());
        l.sort(new ComparePlayers());
        for (Player p :l) {
            arraylistprint+=p;
        }
        assertEquals(treesetprint,arraylistprint);
    }

}
