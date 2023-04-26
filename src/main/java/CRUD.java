import java.sql.*;

public class CRUD {
    private static final String URL = "jdbc:mysql://aws.connect.psdb.cloud/firstdb?sslMode=VERIFY_IDENTITY";
    private static final String USERNAME = "023j5brn8rzzlnoth130";
    private static final String PASSWORD = "pscale_pw_j5ypxIdTGdygZO5hV390Wk8N1v5pIO1RktUioepj61i";

    public void createPost(String writer, String writing) {
        String sql = "INSERT INTO post (WRITER, WRITING) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, writer);
            pstmt.setString(2, writing);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePost(int id, String writer, String writing) {
        String sql = "UPDATE post SET WRITER = ?, WRITING = ? WHERE ID = ?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, writer);
            pstmt.setString(2, writing);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePost(int id) {
        String sql = "DELETE FROM post WHERE ID = ?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet readPost(int id) {
        String sql = "SELECT * FROM post WHERE ID = ?";
        ResultSet rs = null;
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet readAllPosts() {
        String sql = "SELECT * FROM post";
        ResultSet rs = null;
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement stmt = conn.createStatement()) {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
