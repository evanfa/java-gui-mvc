package data.pass.db;

import java.sql.Connection;
import java.sql.DriverManager;
import vault.init.VaultLoader;

public class ConnectBd {
    /**
     * Function that returns a connection with the default host and the required Database
     * @param db DatabaseName
     * @return Connection
     */
    public static Connection startConnection_WAuth(String db) {
        Connection con = null;
        try {
            Class.forName(VaultLoader.sqlSerClass);
            System.out.println("Driver Loaded");
            String jdbcUrl = "jdbc:sqlserver://" + VaultLoader.getDefaultHost() + ":" + VaultLoader.getJdbcPort() + ";databaseName=" + db + ";integratedSecurity=true";
            con = DriverManager.getConnection(jdbcUrl);
            //Statement stmt = con.createStatement();
            //stmt.executeQuery("SET NOCOUNT ON");
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
        return con;
    }
}
