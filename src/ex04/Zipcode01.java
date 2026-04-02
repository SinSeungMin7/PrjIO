package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Zipcode01 {

	public static void main(String[] args) throws IOException {
		// ZIPCODE,SIDO,GUGUN,DONG,BUNJI,SEQ
		// 1. 전국의 롯데백화점의 갯수 출력
		
		String      path  = Zipcode01.class.getResource("").getPath(); // URL 오류를 개선하기위해 .getPath();를 사용한다
		String      fname = "zipcode_utf8.csv";
		File        file  = new File( path + fname ); // 파일 경로생성
		
		FileReader     fr = new FileReader(file);   // 파일읽기 생성
		BufferedReader br = new BufferedReader(fr); // 버퍼읽기 생성
		
		String      title = br.readLine(); // 제목줄 skip
		String      line  = "";
		int cnt = 0;
		while( (line = br.readLine() ) != null ) { // (line = br.readLine()) : 라인은 버퍼에서 한줄 읽은 것이다
			String   [] li = line.trim().split(",");  // 라인의(line) 앞뒤 공백을 제거하고(trim) 콤마 , 를 기준으로 자를것이다(split(","))
			String zipcode = li[0].trim(); // 라인의 0번째 올 자리의 혹시모를 앞뒤 공백을 제거한다
			String sido    = li[1].trim(); 
			String gugun   = li[2].trim(); 
			String dong    = li[3].trim(); 
			String bunji   = li[4].trim(); 
			int    seq     = Integer.parseInt(li[5].trim()); 
			
			// 1. 전국의 롯데백화점의 갯수 출력
//			if ( dong.contains("롯데백화점") ) {
			if ( dong.indexOf("현대백화점") > -1 ) {
				String fmt  = "[%s] %s %s %s %s %d\n";
				String addr = String.format(fmt,
						zipcode, sido, gugun, dong, bunji, seq);
				System.out.println(addr);
				cnt++;
			}
		}
		System.out.println(cnt + "건");
				
		br.close();
		fr.close();
		

	}

}
