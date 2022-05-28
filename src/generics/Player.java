package generics;

//class to create a player of any team and of any sport
//to not be used as raw, must be extended to use
public abstract class Player {
    private final String name;
    public Player(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
