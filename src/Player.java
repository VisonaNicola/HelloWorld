import java.util.Objects;

/**
 * The Player class represent a person that plays football. Every player is identified by its name, surname and role in the team.
 */
public class Player {
    private String name, surname,role;

    /**
     * Create a new player
     * @param name - name of the player
     * @param surname - surname of the player
     * @param role - role of the player
     */
    public Player(String name,String surname,String role) {
        this.name = name;
        this.surname = surname;
        this.role = role;
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
    public String getRole() {
        return role;
    }
    /**
     * Set a new role for a player.
     * @param role - the new role for the player
     */
    public void setRole(String role) {
        this.role = role;
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
