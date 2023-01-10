import java.util.Objects;

/**
 * The Player class represent a person that plays football. Every player is characterized by its name, surname and role in the team.
 */
public class Player {
    private String name, surname;
    public enum Role{
        Goalkeeper,
        Defender,
        Midfielder,
        Striker
    }
    private Role role;
    //save the team for which the player plays, so that if the role is changed it is possible to update the titled player set
    private Team team = null;
    /**
     * Create a new player
     * @param name - name of the player
     * @param surname - surname of the player
     * @param role - role of the player (the possible roles are Goalkeeper, Defender, Midfielder and Striker)
     */
    public Player(String name,String surname,Role role) {
        this.name = name;
        this.surname = surname;
        this.role = role;
    }

    /**
     * Save the team for which the player plays, so that if the role is changed it is possible to update the titled player set
     * @param team - the team for which the player plays
     */
    public void setTeam(Team team){
        this.team=team;
    }

    /**
     * Get the name of the player.
     * @return the name of the player
     */
    public String getName() {
            return name;
    }

    /**
     * Set a new name for a player.
     * @param name - the new name for the player
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Get the surname of the player.
     * @return the surname of the player
     */
    public String getSurname() {
        return surname;
    }
    /**
     * Set a new surname for a player.
     * @param surname - the new surname for the player
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }
    /**
     * Get the role of the player.
     * @return the role of the player
     */
    public Role getRole() {
        return role;
    }
    /**
     * Set a new role for a player.
     * @param role - the new role for the player
     */
    public void setRole(Role role) {
        this.role = role;
        if(team!=null)  //if the role of a player is changed the set of titled player may not be correct anymore
            team.createTitledPlayerList();
    }
    @Override
    public String toString(){
        return getName()+" "+getSurname() + " " + getRole();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null)
            return false;
        if(!(obj instanceof Player))
            return false;
        //two Player object are considered the same object if the name and surname are equals.
        return ((this.getName().equals(((Player) obj).getName())) && (this.getSurname().equals(((Player) obj).getSurname())));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, role);
    }
}
