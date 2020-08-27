package com.officialmilchi.ffa.utils;

import com.officialmilchi.ffa.SkyWarsFFA;
import org.bukkit.entity.Player;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * @author officialMilchi (philipp.spreitzer@icloud.com)
 * @created: 13/08/2020 - 22:11
 * @project: SkyWarsFFA
 */
public class Stats {
    public static boolean playerExists(UUID uuid) {
        ResultSet rs = SkyWarsFFA.getInstance().getMySQL().query("SELECT * FROM SkyWarsFFA WHERE uuid='" + uuid.toString() + "'");
        try {
            if (rs.next()) {
                return rs.getString("uuid") != null;
            }
            rs.close();
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static boolean playerExistsByName(String username) {
        ResultSet rs = SkyWarsFFA.getInstance().getMySQL().query("SELECT * FROM SkyWarsFFA WHERE username='" + username + "'");
        try {
            if (rs.next()) {
                return rs.getString("username") != null;
            }
            rs.close();
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static void createPlayer(Player player){
        if (!playerExists(player.getUniqueId())){
            create(player.getName(),player.getUniqueId());
        }
        if (!playerExistsByName(player.getName())){
            setName(player.getName(),player.getUniqueId());
        }
    }

    public static int getKills(UUID uuid) {
        return get("kills",  "uuid", uuid.toString());
    }
    public static int getDeaths(UUID uuid) {
        return get("deaths",  "uuid", uuid.toString());
    }
    public static UUID getUUID(String username) {
        return UUID.fromString(getString("uuid",  "username", username));
    }
    public static String getUsername(UUID uuid) {
        return getString("username",  "uuid", uuid.toString());
    }

    private static void setKills(UUID uuid,int size) {
        SkyWarsFFA.getInstance().getMySQL().updatePREPARE("UPDATE SkyWarsFFA SET kills='" + size + "' WHERE uuid='" + uuid.toString() + "'");
    }

    private static void setDeaths(UUID uuid,int size) {
        SkyWarsFFA.getInstance().getMySQL().updatePREPARE("UPDATE SkyWarsFFA SET deaths='" + size + "' WHERE uuid='" + uuid.toString() + "'");
    }

    public static void addKill(UUID uuid){
        setKills(uuid,getKills(uuid)+1);
    }
    public static void addDeath(UUID uuid){
        setDeaths(uuid,getDeaths(uuid)+1);
    }


    private static Integer get(String select,String where, String results) {
        ResultSet rs = SkyWarsFFA.getInstance().getMySQL()
                .query("SELECT " + select + " FROM SkyWarsFFA WHERE " + where + "='" + results + "'");
        try {
            if (rs.next()) {
                return rs.getInt(select);
            }
        } catch (SQLException ex) {
            return -1;
        }
        return -1;
    }
    private static String getString(String select,String where, String results) {
        ResultSet rs = SkyWarsFFA.getInstance().getMySQL()
                .query("SELECT " + select + " FROM SkyWarsFFA WHERE " + where + "='" + results + "'");
        try {
            if (rs.next()) {
                return rs.getString(select);
            }
        } catch (SQLException ex) {
            return "Error";
        }
        return "Error";
    }

    public static void setName(String name, UUID uuid) {
        SkyWarsFFA.getInstance().getMySQL().updatePREPARE("UPDATE SkyWarsFFA SET username='" + name + "' WHERE UUID='" + uuid.toString() + "'");
    }

    public static void create(String name, UUID uuid){
        MySQL mySQL = SkyWarsFFA.getInstance().getMySQL();
        mySQL.updatePREPARE("INSERT INTO SkyWarsFFA (uuid, username, kills, deaths) VALUES ('" + uuid.toString() + "','" + name + "','0','0','');");
    }

    public static int getRank(UUID uuid) {
        int rank = -1;
        try {
            ResultSet result = SkyWarsFFA.getInstance().getMySQL().query("SELECT * FROM SkyWarsFFA ORDER BY kills DESC");
            while (result.next()) {
                String uuid2 = result.getString("uuid");
                if (uuid2.equalsIgnoreCase(uuid.toString())) {
                    rank = result.getRow();
                    break;
                }
            }
            result.close();
        } catch (Exception var5) {
            var5.printStackTrace();
        }
        return rank;
    }

}
