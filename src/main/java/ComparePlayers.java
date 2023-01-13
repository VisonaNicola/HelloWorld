import java.util.Comparator;

/**
 * This class is used to compare 2 Players.
 */
public class ComparePlayers implements Comparator<Player> {
    /**
     * This method compare the surnames of the 2 players, if the surname is the same it will check the names, if the name is the same, it will check the role.
     * @param p1 the first player to be compared.
     * @param p2 the second player to be compared.
     * @return a value >0 if the first player is higher (in alphabetical order) than the second, 0 if they are equals, <0 otherwise.
     */
    @Override
    public int compare(Player p1, Player p2) {
        if(p1 == null && p2 == null)
            return 0;
        if(p1 != null && p2 == null)
            return 1;
        if(p1 == null && p2 != null)
            return -1;


        int compareSurname = p1.getSurname().compareTo(p2.getSurname());
        if(compareSurname!=0)
            return compareSurname;

        int compareName = p1.getName().compareTo(p2.getName());
        if(compareName!=0)
            return compareName;

        return p1.getRole().compareTo(p2.getRole());
    }
}
