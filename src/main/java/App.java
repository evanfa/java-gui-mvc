import data.pass.db.ConnectBd;

public class App {

    public static final String DEFAULT_BD_NAME = "SQL_Dumps";
    public static String DEFAULT_TABLE_COMS = "library_db";

    public static void main(String[] args) {

        System.out.println("Verification: " + ConnectBd.executeTableVerification(DEFAULT_BD_NAME, DEFAULT_TABLE_COMS));

    }
}
