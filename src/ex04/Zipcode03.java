package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Zipcode03 {

	public static void main(String[] args) throws IOException {
		// ZIPCODE,SIDO,GUGUN,DONG,BUNJI,SEQ
		// 3. 부산, 울산, 대구 우편번호
//			부산:3605 cnt1
//			울산:820  cnt2
//			대구:2782 cnt3
		
		//File
		String      path  = Zipcode03.class.getResource("").getPath(); // URL 오류를 개선하기위해 .getPath();를 사용한다
		String      fname = "zipcode_utf8.csv";
		File        file  = new File( path + fname ); // 파일 경로생성
		if ( !file.exists() ) {
			System.out.println(file + "이 없습니다");
			System.exit(-1); // 프로그램 강제 종료
			// 0 (정상 종료): "계획대로 모든 작업이 완벽하게 끝났다"는 뜻입니다.
			// 0 이 아닌 숫자 (비정상 종료): "문제가 생겨서 도중에 꺼졌다"는 뜻입니다. 보통 **1**이나 **-1**을 가장 많이 사용합니다.
			// 많은 라이브러리와 시스템 함수들이 에러가 발생했을 때 리턴값으로 -1을 반환합니다. 그 관습이 exit 코드에도 이어진 것
		}
		
		FileReader     fr = new FileReader(file);   // 파일읽기 생성
		BufferedReader br = new BufferedReader(fr); // 버퍼읽기 생성
		
		String      title = br.readLine(); // 제목줄 skip
		String      line  = "";
		
		int cnt1 = 0; // 부산
		int cnt2 = 0; // 대구
		int cnt3 = 0; // 울산
		
		System.out.println("부산, 울산, 대구 우편번호");
		
		while( (line = br.readLine() ) != null ) { // (line = br.readLine()) : 라인은 버퍼에서 한줄 읽은 것이다
			String   [] li = line.trim().split(",");  // 라인의(line) 앞뒤 공백을 제거하고(trim) 콤마 , 를 기준으로 자를것이다(split(","))
			String zipcode = li[0].trim(); // 라인의 0번째 올 자리의 혹시모를 앞뒤 공백을 제거한다
			String sido    = li[1].trim(); 
			String gugun   = li[2].trim(); 
			String dong    = li[3].trim(); 
			String bunji   = li[4].trim(); 
			int    seq     = Integer.parseInt(li[5].trim()); 
			
			// 3. 부산, 울산, 대구 우편번호
//			부산:3605 cnt1
//			울산:820  cnt2
//			대구:2782 cnt3		
			switch (sido) {
			case "부산" : cnt1++; break;
			case "대구" : cnt2++; break;
			case "울산" : cnt3++; break;
			}
			
		}
		System.out.println("부산" + cnt1 + "건");
		System.out.println("대구" + cnt2 + "건");
		System.out.println("울산" + cnt3 + "건");
			
		br.close();
		fr.close();
		

	}

}