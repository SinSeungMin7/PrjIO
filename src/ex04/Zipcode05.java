package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class Zipcode05 {

	public static void main(String[] args) throws IOException {
		// 4. 한국의 시도명 출력 - 17건 
//		   서울
//		   부산
//		   ... 
//		   충북
		
		HashSet<String> set = new HashSet<>();
		
		String      path  = Zipcode05.class.getResource("").getPath(); // URL 오류를 개선하기위해 .getPath();를 사용한다
		String      fname = "zipcode_utf8.csv";
		File        inFile  = new File( path + fname ); // 파일 경로생성
		
		if( !inFile.exists() ) { // infile 이 존재하면
			System.out.println(fname + "이 없습니다");
			System.exit(-1); // 출력이 안되면 탈출
		}
		
		//파일 읽을 준비
		FileReader     fr = new FileReader(inFile);
		BufferedReader br = new BufferedReader(fr);
		
		br.readLine(); // 제목줄 건너뛰기
		
		String line = ""; // line 만들어서 초기화
		
		int totcnt = 0;
		
		long startTime = System.nanoTime(); // 시작 시간
		
		while ((line = br.readLine() ) != null) {
			PostVo vo = new PostVo(line);
			
			set.add(vo.getSido());			
			totcnt++;
		}
		
		long endTime = System.nanoTime();
		
		double execTime = (endTime - startTime)/1000.0/1000.0/1000.0;
		
		br.close();
		fr.close();
		
		System.out.println("전체 자료수:" + totcnt);
		System.out.println("실행 시간:" + execTime + "s");
		
		
	}
}