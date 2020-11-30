package dto;

import java.util.ArrayList;
import java.util.Arrays;

public class User {
    public int id = 2;
    public String login = "Alex";
    public String birthday = "29-06-2001";
    public String birthplace =  "Canada";
    public ArrayList<String> hobbies = new ArrayList<String>(Arrays.asList("skating", "skiing", "swimming"));
}
