import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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


}
