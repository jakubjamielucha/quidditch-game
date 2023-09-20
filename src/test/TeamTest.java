package src.test;


import org.junit.Test;
import src.main.Team;

import static org.junit.Assert.assertTrue;

public class TeamTest {

    @Test
    public void hasNullTest(){
        String[] chasers = new String[] {null, "Ginny", "Katie"};
        assertTrue(Team.hasNull(chasers));
    }

    @Test
    public void hasBlankTest(){
        String[] chasers = new String[] {"   ", "Ginny", "Katie"};
        assertTrue(Team.hasBlank(chasers));
    }


}
