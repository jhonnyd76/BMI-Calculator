package connector;

public class DatabaseData {
    private final static String URL = "jdbc:mysql://localhost:3306/bmi-rechner";
    private final static String USER ="jhonnyd";
    private final static String PASSWORD ="Gniffi1234.";

    public static String getURL() {return URL;}
    public static String getUSER(){return USER;}
    public static String getPASSWORD() {return PASSWORD;}
}
