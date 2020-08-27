package com.officialmilchi.ffa.utils;

import com.officialmilchi.ffa.SkyWarsFFA;

import java.sql.*;

/**
 * @author officialMilchi (philipp.spreitzer@icloud.com)
 * @created: 13/08/2020 - 22:11
 * @project: SkyWarsFFA
 */

public class MySQL {
    private String host = "";
    private String database = "";
    private String user = "";
    private String password = "";

    private Connection connection;

    public MySQL(String host, String database, String user, String password) {
        this.host = host;
        this.database = database;
        this.user = user;
        this.password = password;

        connect();
    }

    public MySQL(String host, String database, String user) {
        this.host = host;
        this.database = database;
        this.user = user;
        connect();
    }

    public MySQL() {
        this.host = "web01.example-host.com";
        this.database = "web-1002_skywarsffa";
        this.user = "testalde";
        this.password = "P1h2i3l4";
        connect();
    }


    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + database + "?autoReconnect=true", user, password);
            SkyWarsFFA.getInstance().getServer().getConsoleSender().sendMessage(SkyWarsFFA.PREFIX + "§aEs wurde eine Verbindung hergestellt.");
            createTable();
        } catch (Exception e) {
            SkyWarsFFA.getInstance().getServer().getConsoleSender().sendMessage(SkyWarsFFA.PREFIX + "§cEs konnte keine Verbindung herstellen!");
            // e.printStackTrace();
        }

    }

    public void disconnect() {
        try {
            if (connection != null) {
                connection.close();
                SkyWarsFFA.getInstance().getServer().getConsoleSender().sendMessage(SkyWarsFFA.PREFIX + "§aDie Verbindung wurde getrennt!");
            }
        } catch (SQLException ex) {
            SkyWarsFFA.getInstance().getServer().getConsoleSender().sendMessage(SkyWarsFFA.PREFIX + "§cDie Verbindung konnte nicht getrennt werden!");
            //  ex.printStackTrace();
        }
    }

    public void createTable() {
        try {
            connection.prepareStatement("CREATE TABLE IF NOT EXISTS SkyWarsFFA (size INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY, uuid VARCHAR(100), username VARCHAR(100), kills INT(16), deaths INT(16))").executeUpdate();
            SkyWarsFFA.getInstance().getServer().getConsoleSender().sendMessage(SkyWarsFFA.PREFIX + "§aEs wurde eine Tabelle erstellt.");
        } catch (SQLException e) {
            SkyWarsFFA.getInstance().getServer().getConsoleSender().sendMessage(SkyWarsFFA.PREFIX + "§cEs gab einen Fehler bei der erstellung der Tabelle!");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean isConnected() {
        return (connection != null);
    }

    public void update(String qry) {
        try {
            Statement st = connection.createStatement();
            st.executeUpdate(qry);
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePREPARE(String qry) {
        try {
            PreparedStatement st = connection.prepareStatement(qry);
            st.executeUpdate(qry);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getResult(String qry) {
        try {
            PreparedStatement st = connection.prepareStatement(qry);
            return st.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet query(String qry) {
        ResultSet rs = null;
        try {
            PreparedStatement st = connection.prepareStatement(qry);
            return st.executeQuery(qry);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}