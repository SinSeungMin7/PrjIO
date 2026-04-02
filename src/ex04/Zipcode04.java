package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Zipcode04 {

	public static void main(String[] args) throws IOException {
		// ZIPCODE,SIDO,GUGUN,DONG,BUNJI,SEQ
		// 3. 부산, 울산, 대구 우편번호
//			부산:3605 cnt1
//			울산:820  cnt2
//			대구:2782 cnt3
		//키보드
		Scanner in = new Scanner(System.in);
		System.out.println("검색할 시도를 입력하시오(부산, 대구, 경남)");
		String sidos       = in.nextLine();
		String [] sis      = sidos.trim().split(","); 
		   int [] cnt      = new int[sis.length];
		   
		for (int i = 0; i < sis.length; i++) {
			sis[i]        =  sis[i].trim();
			
			cnt[i]        = 0;
		}		
		
		//File
		String      path  = Zipcode04.class.getResource("").getPath(); // URL 오류를 개선하기위해 .getPath();를 사용한다
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
				
		while( (line = br.readLine() ) != null ) { // (line = br.readLine()) : 라인은 버퍼에서 한줄 읽은 것이다
			String   [] li = line.trim().split(",");  // 라인의(line) 앞뒤 공백을 제거하고(trim) 콤마 , 를 기준으로 자를것이다(split(","))
			String zipcode = li[0].trim(); // 라인의 0번째 올 자리의 혹시모를 앞뒤 공백을 제거한다
			String sido    = li[1].trim(); 
			String gugun   = li[2].trim(); 
			String dong    = li[3].trim(); 
			String bunji   = li[4].trim(); 
			int    seq     = Integer.parseInt(li[5].trim()); 
			
			// 3. 부산, 울산, 대구 우편번호
//			sis      cnt
//			부산:3605 cnt[0]
//			대구:2782 cnt[1]
//			경남:820  cnt[2]
			for (int i = 0; i < sis.length; i++) {
				if( sido.equals( sis[i] ) ) {
					cnt[i]++;
				}
			}

		}
		
	    for (int i = 0; i < sis.length; i++) {
			System.out.println(sis[i] + ":" + cnt[i] + "건");
		}
			
		br.close();
		fr.close();
		


	}
}
