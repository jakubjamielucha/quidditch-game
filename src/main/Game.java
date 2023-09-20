package src.main;

import java.util.HashMap;

public class Game {
    HashMap<Team, Integer> scoreboard;
    private static int gameCount;
    private static final int QUAFFLE_POINTS = 10;
    private static final int SNITCH_POINTS = 150;

    public Game(Team home, Team away){
        this.scoreboard = new HashMap<Team, Integer>();
        this.scoreboard.put(new Team(home), 0);
        this.scoreboard.put(new Team(away), 0);
        gameCount++;
    }

    public static int getGameCount() {
        return gameCount;
    }

    public static int getQuafflePoints(){
        return QUAFFLE_POINTS;
    }

    public static int getSnitchPoints(){
        return SNITCH_POINTS;
    }

    public int getScore(Team team){
        return this.scoreboard.get(team);
    }

    public void setScore(Team team, Integer Score){
        if(team == null){
            throw new IllegalArgumentException("Pass the correct team!");
        }
        this.scoreboard.put(team, Score);
    }

    public Team getTeam(String name){

        return this.scoreboard.keySet().stream()
                .filter((key) -> key.getHouse().equals(name))
                .findFirst()
                .orElse(null);
    }
    public String simulate(String play){
        String placeholder = getPlaceholder(play);
        Team team = getRandomTeam();

        if(placeholder.equals(Team.getPositionChaser())){
            quaffleScore(team);
            return replacePlaceholder(play, placeholder, team.getChasers()[(int) (Math.random() * 3)]);
        }
        else if(placeholder.equals(Team.getPositionSeeker())){
            snitchScore(team);
            return replacePlaceholder(play, placeholder, team.getSeeker());
        }
        else if(placeholder.equals(Team.getPositionKeeper())){
            return replacePlaceholder(play, placeholder, team.getKeeper());
        } else {
            return " ";
        }
    }

    public Team getRandomTeam(){
        int random = (int)(Math.random() * 2);
        Object[] teams = scoreboard.keySet().toArray();
        return (Team)teams[random];
    }

    public String getPlaceholder(String play){
        return play.substring(play.indexOf("<") +1, play.indexOf(">"));
    }

    public String replacePlaceholder(String play, String placeholder, String replacement){
        return play.replace("<"+placeholder+">", replacement);
    }

    public void quaffleScore(Team team){
        this.setScore(team, this.getScore(team) + getQuafflePoints());
    }

    public void snitchScore(Team team){
        this.setScore(team, this.getScore(team) + getSnitchPoints());
    }




}
