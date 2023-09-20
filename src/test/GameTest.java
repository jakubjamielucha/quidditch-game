package src.test;
import org.junit.Before;
import org.junit.Test;
import src.main.Game;
import src.main.Team;

import static org.junit.Assert.assertEquals;


public class GameTest {

    Game game;

    @Before
    public void setup(){
       game = new Game(new Team("GRYFFINDOR", "Oliver", "Harry",
                new String[] {"Angelina", "Ginny", "Katie"}), new Team("SLYTHERIN", "Vincent",  "Draco",
                new String[] {"Bridget", "Harper", "Malcolm"}));
    }

    @Test
    public void getPlaceholderTest(){
        assertEquals("chaser", game.getPlaceholder("<chaser> gets the next pass"));
    }

    @Test
    public void replacePlaceholderTest(){
        assertEquals("Katie gets the next pass",
                game.replacePlaceholder("<chaser> gets the next pass", "chaser", "Katie"));
    }

    @Test
    public void quaffleScoreTest(){
        game.quaffleScore(game.getTeam("GRYFFINDOR"));
        game.quaffleScore(game.getTeam("GRYFFINDOR"));
        assertEquals(Game.getQuafflePoints() * 2, game.getScore(game.getTeam("GRYFFINDOR")));
    }

    @Test
    public void snitchScoreTest(){
        Team team = game.getTeam("SLYTHERIN");
        game.snitchScore(team);
        assertEquals(Game.getSnitchPoints(), game.getScore(team));
    }








}
