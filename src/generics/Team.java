package generics;

import java.util.ArrayList;

//class to create a team for a specific sport involving players of only that sport
//Team<T> -> team of specific sport
//t extends Player -> to set and upper bound to kind of
public class Team<T extends Player> implements Comparable<Team<T>> {
    private final String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;
    public Team(String name) {
        this.name = name;
    }
    //members -> list of all players in the team
    private final ArrayList<T> members = new ArrayList<>();
    public String getName() {
        return name;
    }
    //add a player to the team
    public void addPlayer(T player) {
        if (members.contains(player)) {
            System.out.println(player.getName() + " is already on this team");
        } else {
            members.add(player);
            System.out.println(player.getName() + " picked for team " + this.name);
        }
    }
    //to get total number of players in the team
    public int numPlayers() {
        return this.members.size();
    }
    public void matchResult(Team<T> opponent, int ourScore, int theirScore) {
        String message;
        if(ourScore > theirScore) {
            won++;
            message = " beat ";
        } else if(ourScore == theirScore) {
            tied++;
            message = " drew with ";
        } else {
            lost++;
            message = " lost to ";
        }
        played++;
        if(opponent != null) {
            System.out.println(this.getName() + message + opponent.getName());
            //also add respective score to the opponent's team
            opponent.matchResult(null, theirScore, ourScore);
        }
    }
    public int ranking() {
        return (won * 2) + tied;
    }
    @Override
    public int compareTo(Team<T> team) {
        return Integer.compare(team.ranking(), this.ranking());
    }
}























