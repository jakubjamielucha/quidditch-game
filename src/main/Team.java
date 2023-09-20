package src.main;

import javax.crypto.spec.PSource;
import java.util.Arrays;
import java.util.Objects;

public class Team {

    private static final String POSITION_CHASER = "chaser";
    private static final String POSITION_SEEKER = "seeker";
    private static final String POSITION_KEEPER = "keeper";
    private String seeker;
    private String keeper;
    private String[] chasers;
    private String house;

    public Team(String house, String keeper, String seeker, String[] chasers){
        if(house == null || keeper == null || seeker == null || chasers == null){
            throw new  IllegalArgumentException("One or more values are missing!");
        }
        if(house.isBlank() || keeper.isBlank() || seeker.isBlank()){
            throw new  IllegalArgumentException("One or more values are missing!");
        }
        if(!(chasers.length == 3)){
            throw new  IllegalArgumentException("Must have three chasers.");
        }
        if((hasNull(chasers) || hasBlank(chasers))){
            throw new  IllegalArgumentException("One or more of the chasers are missing");
        }
        this.seeker = seeker;
        this.keeper = keeper;
        this.house = house;
        this.chasers = Arrays.copyOf(chasers, chasers.length);
    }

    public Team(Team source){
        this.seeker = source.seeker;
        this.keeper = source.keeper;
        this.chasers = Arrays.copyOf(source.chasers, source.chasers.length);
        this.house = source.house;
    }

    public String toString(){
        return "House: " + this.house + "\n" +
                "Keeper: " + this.keeper + "\n" +
                "Seeker: "  + this.seeker + "\n" +
                "Chasers: " + Arrays.toString(this.chasers) + "\n";
    }

    public static boolean hasNull(String[] array){
        return Arrays.stream(array)
                .anyMatch(element -> element == null);
    }

    public static boolean hasBlank (String[] array){
        return Arrays.stream(array)
                .anyMatch(element -> element.isBlank());
    }

    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }
        if(!(obj instanceof Team)){
            return false;
        }
        Team team = (Team)obj;
        return this.house.equals(team.house) &&
                this.keeper.equals(team.keeper) &&
                this.seeker.equals(team.seeker) &&
                Arrays.toString(this.chasers).equals(Arrays.toString(team.chasers));
    }

    public int hashCode(){
        return Objects.hash(house, keeper, seeker, Arrays.toString(this.chasers));
        }

    public String getSeeker(){
        return seeker;
    }

    public String getKeeper(){
        return keeper;
    }

    public String getHouse() {
        return house;
    }

    public String[] getChasers(){
        return Arrays.copyOf(chasers, chasers.length);
    }

    public void setSeeker(String seeker) {
        checkParam(seeker);
        this.seeker = seeker;
    }

    public void setHouse(String house) {
        checkParam(house);
        this.house = house;
    }

    public void setKeeper(String keeper) {
        checkParam(keeper);
        this.keeper = keeper;
    }

    public void setChasers(String[] chasers) {
        if((hasNull(chasers) || hasBlank(chasers)) || chasers.length != 3){
            throw new  IllegalArgumentException("The array you provided is incorrect!");
        }
        this.chasers = Arrays.copyOf(chasers, chasers.length);
    }

    public static String getPositionChaser() {
        return POSITION_CHASER;
    }

    public static String getPositionSeeker() {
        return POSITION_SEEKER;
    }

    public static String getPositionKeeper() {
        return POSITION_KEEPER;
    }

    public void checkParam(String param){
        if(param == null || param.isBlank()){
            throw new IllegalArgumentException("The value you provided is incorrect!");
        }
    }
}
