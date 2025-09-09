package com.erika;
import java.sql.*;
import java.util.*;

public class TaskDAO {
    public void create(String title) throws Exception {
        try (Connection c = DB.connect();
             PreparedStatement ps = c.prepareStatement("INSERT INTO tasks(title) VALUES(?)")) {
            ps.setString(1, title);
            ps.executeUpdate();
        }
    }

    public List<String> list() throws Exception {
        List<String> out = new ArrayList<>();
        try (Connection c = DB.connect();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery("SELECT id,title,done FROM tasks ORDER BY id")) {
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                boolean done = rs.getBoolean(3);
                out.add(id + ": " + title + " [" + (done ? "done" : "open") + "]");
            }
        }
        return out;
    }

    public void toggleDone(int id) throws Exception {
        try (Connection c = DB.connect();
             PreparedStatement ps = c.prepareStatement("UPDATE tasks SET done = NOT done WHERE id=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws Exception {
        try (Connection c = DB.connect();
             PreparedStatement ps = c.prepareStatement("DELETE FROM tasks WHERE id=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
