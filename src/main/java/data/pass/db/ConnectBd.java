package data.pass.db;

import startup.init.start.InitStartup;
import javax.swing.*;
import java.sql.*;
/*
-Djava.library.path="C:\Users\fabio_rodriguez\OneDrive - TransCanada Corporation\Documents\IT\JODBC\sqljdbc_9.4\enu\auth\x64"
 */
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
            Class.forName(InitStartup.SERVER_CLASS);
            System.out.println("Driver Loaded");
            String jdbcUrl = "jdbc:sqlserver://" + InitStartup.DEFAULT_HOST + ":" + InitStartup.JDBC_PORT + ";databaseName=" + db + ";integratedSecurity=true";
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
     * Execute query insert - Using only execute instead executeQuery (select) using the current open connection.
     * @param con
     * @param qry
     * @throws SQLException
     */
    public static void execQueryInsert(Connection con, String qry) throws SQLException {
        try {
            Statement stmt = con.createStatement();
            stmt.execute(qry);
            stmt.closeOnCompletion();
        } catch (Exception e) {
            /*
            If Query Contains Errors
             */
            {
                System.out.println("-------------------ERROR---------------------");
                System.out.println("Error in Query: " + e);
                System.out.println("Fail Query: " + qry);

                try{
                    String errorQry = e.toString();
                    Connection cn = startConnection_WAuth(InitStartup.DEFAULT_BD_NAME);
                    Statement st = cn.createStatement();

                    String qrt = "INSERT INTO [dbo].["+InitStartup.DEFAULT_ERROR_LOG+"](errordesc,inputdesc) VALUES (´" + errorQry + "´,´" + qry + "´)";
                    qrt = qrt.replace("'", "");
                    qrt = qrt.replace("´", "'");
                    System.out.println("Error Query: " + qrt);
                    st.execute(qrt, Statement.RETURN_GENERATED_KEYS);
                    st.close();
                    cn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                System.out.println("-------------------ERROR---------------------");
            }
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
            Class.forName(InitStartup.SERVER_CLASS);
            String jdbcUrl = "jdbc:sqlserver://" + InitStartup.DEFAULT_HOST + ":" + InitStartup.JDBC_PORT + ";databaseName=" + dbName + ";integratedSecurity=true";
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
            System.out.println("Exception SQL: " + e);
            JOptionPane.showMessageDialog(null, "SQL Exception: " + e, "Error - SQL Exception", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return tableExist;
    }
}
