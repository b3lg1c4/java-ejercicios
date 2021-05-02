package data;

import java.sql.*;


public class DbConnection {

    private static DbConnection instance;
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String host = "localhost";
    private String port = "3306";
    private String user = "root";
    private String password = "";
    private String db = "javaMarket";
    private int connected = 0;
    private Connection conn = null;


    private DbConnection() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static DbConnection getDbInstance() {
        if (instance == null) {
            instance = new DbConnection();
        }

        return instance;
    }

    public Connection getConn() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db, user, password);
                connected = 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        connected += 1;
        return conn;

    }

    public void releaseConn(){
        connected-=1;
        try{
            if(connected == 0){
                conn.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
