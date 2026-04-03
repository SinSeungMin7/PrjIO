package ex04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Zipcode06teacher { // 공식

	public static void main(String[] args) {
		String         fn = "D:/dev/java/PrjIO/src/ex04/zipcode_utf8.csv";
		FileReader     fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(fn);
			br = new BufferedReader(fr);
			
			// 6.부산의 부전2동 우편번호만 화면 출력
			br.readLine(); // 제목줄 스킵
			String line = "";
			while( (line = br.readLine() ) != null ) {
				PostVo postVo = new PostVo(line); // 한줄 라인을 잘라서 postVo에 저장
				// System.out.println(postVo);
				String   sido = postVo.getSido(); // 자른 것중 sido 를 저장
				String   dong = postVo.getDong(); // 자른 거중 dong 을 저장
				
				if( sido.equals("부산") && dong.startsWith("부전2동") ) {
					System.out.println( postVo );
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(fn + "파일이 없습니다 ");
			// e.printStackTrace(); // 에러메시지를 표출할때 쓰는 문법
		} catch (IOException e) {
			System.out.println("데이터 입력에 문제가 있습니다");
		} catch (Exception e) { // exception 은 자식이 위에 있어야 한다
			System.out.println("문제발생: " + e.getMessage() );
		} finally { // Exception 발생과 상관없이 무조건 실행
			try {
				if( br != null ) br.close();
				if( fr != null ) fr.close();
			} catch (IOException e) {
			}
			
		}
		
		System.out.println("작업 끝");
		
	}

}
