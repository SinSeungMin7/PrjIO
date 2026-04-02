package ex04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Zipcode07 {

	public static void main(String[] args) throws IOException {
		// 7. 부산 부산진구의 우편번호를 파일( .csv )로 출력
		
		String      path  = Zipcode07.class.getResource("").getPath(); // URL 오류를 개선하기위해 .getPath();를 사용한다
		String      fname = "zipcode_utf8.csv";
		File        inFile  = new File( path + fname ); // 파일 경로생성
		
		if( !inFile.exists() ) { // infile 이 존재하지 않으면 즉시 종료
			System.out.println(fname + "이 없습니다");
			System.exit(-1); // 출력이 안되면 탈출
		}
		
		//파일 읽을 준비
		FileReader     fr = new FileReader(inFile);
		BufferedReader br = new BufferedReader(fr);
		
		//파일 쓰기
		String filename = "부산진구의 우편번호파일.csv";
		FileWriter fw = new FileWriter(path + filename);
		BufferedWriter bw = new BufferedWriter(fw);
		
		
		br.readLine(); // 제목줄 건너뛰기
		
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
			
			// 1. 부산의 부전2동 우편번호만 출력 (화면출력)
			if ( gugun.equals("부산진구") && sido.indexOf("부산") > -1 ) {
				String fmt  = "[%s] \n";
				String addr = String.format(fmt,
						zipcode);
				System.out.println(addr);
				cnt++;
				bw.write(addr);
			}
		}
		System.out.println(cnt + "건");
				
		bw.close();
		br.close();
		
		fr.close();
		fw.close();
				
		
	}
}