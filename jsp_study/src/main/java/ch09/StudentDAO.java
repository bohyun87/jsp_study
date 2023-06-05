package ch09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//DAO 클래스: model의 역할을 하는 클래그
//model: 데이터베이스와 직접적으로 대화, controller에게 데이터를 넘겨준다.
public class StudentDAO {
	Connection conn = null; //데이터베이스의 연결을 담당
	PreparedStatement pstmt; //쿼리문의 실행을 담당

	final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
		
	//DB연결 메소드
	public void open() {
		try {
			Class.forName(JDBC_DRIVER); //드라이버 로드
			conn = DriverManager.getConnection(JDBC_URL, "test", "test1234");  //DB연결 (JDBC_URL, "오라클접속 사용자이름", "비밀번호")
			
		} catch (Exception e) {   //Exception 으로 변경
			e.printStackTrace();
		}  
	}
	
	
	//DB연결 닫는 메소드
	public void close() {
		try {
			//pstmt, conn 은 리소스(데이터를 읽고 쓰는 객체)이므로 사용 후 반드시 닫아줘야 한다.
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//학생 정보를 다 불러오는 메소드
	public ArrayList<Student> getAll(){
		open();  //DB오픈
		ArrayList<Student> students = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement("select * from student");
			
			//ResultSet: 데이터베이스 데이터를 받는 역할
			ResultSet rs = pstmt.executeQuery(); //쿼리문 실행(select 문 사용시)
			
			while(rs.next()) { //next(): 데이터를  1행씩 가져온다.  //rs.next(): 한 행 씩 값이 있는지 없는지 판단한다.
				
				//student 객체에 DB에서 얻어온 데이터를 담아준다.
				//데이터베이스의 데이터를 "엔티티 클래스, DO, DTO" 의 Student 클래스에 담기위해 객체생성
				Student s = new Student();  
				
				//s.setId("DB에서 얻어온 데이터");
				s.setId(rs.getInt("id"));
				s.setUsername(rs.getString("username"));
				s.setUniv(rs.getString("univ"));
				s.setBirth(rs.getDate("birth"));
				s.setEmail(rs.getString("email"));
				
				
				/*rs.getInt("id");  //rs.getInt("컬럼명")
				rs.getString("username");
				rs.getString("univ");
				rs.getDate("birth");
				rs.getString("email");*/
				
				students.add(s);   //ArrayList<Student> 에 DB에서 얻어온 데이터 넣기
				
			}
			
		} catch (SQLException e) {  //SQLException: 쿼리문을 실행하는 과정에서 예외발생
			e.printStackTrace();
		} finally {
			close();
		}
		
		return students;
	}
	
	
	//학생 정보를 입력하는 메소드
	public void insert(Student s) {
		open();
		try {
			
		//INSERT INTO STUDENT VALUES(id_seq.NEXTVAL, '박사랑', 'bb대학교', '2000-01-01', 'park@bbuniv.com');
			pstmt = conn.prepareStatement("insert into student values(id_seq.nextval, ?, ?, ?, ?)");
			
			//pstmt.setString(값을 넣어줄 위치, 넣어줄 데이터)  =>VARCHAR -> setString / Date -> setDate
			pstmt.setString(1, s.getUsername());   //1: 물음표 순서
			pstmt.setString(2, s.getUniv());
			pstmt.setDate(3, s.getBirth());
			pstmt.setString(4, s.getEmail());
			
			//실행구문
			pstmt.executeUpdate();  //insert, delete, update 실행할 때
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
}
