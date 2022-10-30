package data.pass.db;

import startup.init.vault.loader.VaultLoader;

import javax.swing.*;
import java.sql.*;

public class ConnectBd {
    /**
     * Function that returns a connection with the default host and the required Database
     *
     * @param db DatabaseName
     * @return Connection
     */
    public static Connection startConnection_WAuth(String db) {
        Connection con = null;
        try {
            Class.forName(VaultLoader.DEFAULT_JDBC_SQLSERVER);
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

    /**
     * Execute Query Insert - Using only execute instead executeQuery (select)
     *
     * @param db  Database Name
     * @param qry String Query
     * @throws SQLException
     */
    public static void execQueryInsert(String db, String qry) throws SQLException {
        try {
            Connection con = startConnection_WAuth(db);
            Statement stmt = con.createStatement();
            stmt.execute(qry);
            stmt.closeOnCompletion();
            con.close();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Query Fails. Verify.", "Error in Query", JOptionPane.ERROR_MESSAGE);
            System.out.println("Query Fail: " + e);
            System.out.println("Query: " + qry);
            e.printStackTrace();
        }
    }

    /**
     * Verify if object (table) exist
     *
     * @param dbName    Database Name
     * @param tableName Table Name
     * @return boolean
     */
    public static boolean executeTableVerification(String dbName, String tableName) {
        boolean tableExist = false;
        try {
            Class.forName(VaultLoader.DEFAULT_JDBC_SQLSERVER);
            String jdbcUrl = "jdbc:sqlserver://" + VaultLoader.getDefaultHost() + ":" + VaultLoader.getJdbcPort() + ";databaseName=" + dbName + ";integratedSecurity=true";
            Connection con = DriverManager.getConnection(jdbcUrl);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT OBJECT_ID FROM sys.objects WHERE name = '" + tableName + "';");
            if (rs != null) {
                tableExist = true;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            JOptionPane.showMessageDialog(null, "Exception: " + e, "Error - SQL Exception", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return tableExist;
    }
}
