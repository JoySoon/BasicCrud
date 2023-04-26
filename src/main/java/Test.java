import java.sql.*;

public class Test {
    public static void main(String[] args) {
        CRUD crud = new CRUD();
        // createPost 메소드를 통한 게시물 생성
        crud.createPost("작성자", "내용");

        // readPost 메소드를 통한 특정 게시물 조회
        ResultSet rs1 = crud.readPost(1);
        try {
            while (rs1.next()) {
                System.out.println("ID: " + rs1.getInt("ID"));
                System.out.println("작성자: " + rs1.getString("WRITER"));
                System.out.println("내용: " + rs1.getString("WRITING"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // readAllPosts 메소드를 통한 모든 게시물 조회
        ResultSet rs2 = crud.readAllPosts();
        try {
            while (rs2.next()) {
                System.out.println("ID: " + rs2.getInt("ID"));
                System.out.println("작성자: " + rs2.getString("WRITER"));
                System.out.println("내용: " + rs2.getString("WRITING"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
