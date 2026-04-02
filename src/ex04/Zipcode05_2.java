package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Zipcode05_2 {

	public static void main(String[] args) throws IOException {
		// 4. 한국의 시도명 출력 - 17건 
//		   서울 8080
//		   부산 3605 <-- 이렇게 나오기 숙제
//		   ... 
//		   충북		
		List<String>     sidoList = new ArrayList<>();  // 결과값을 작성할 빈 수첩을 만든다
		List<Integer> sidoCntList = new ArrayList<>(); 
		
		String      path  = Zipcode05_2.class.getResource("").getPath(); // URL 오류를 개선하기위해 .getPath();를 사용한다
		String      fname = "zipcode_utf8.csv";
		File        inFile  = new File( path + fname ); // 파일 경로생성
		
		if( !inFile.exists() ) { // infile 이 존재하지 않으면 즉시 종료
			System.out.println(fname + "이 없습니다");
			System.exit(-1); // 출력이 안되면 탈출
		}
		
		//파일 읽을 준비
		FileReader     fr = new FileReader(inFile);
		BufferedReader br = new BufferedReader(fr);
		
		br.readLine(); // 제목줄 건너뛰기
		
		String     line = ""; // line 만들어서 초기화
		int      totcnt = 0;  // 전체 자료수
		int         pos = -1;  // (-1)인 이유 잘모르겠음 공부! 시도 위치 position 처음에는 -1 이었지만
		int     sidoCnt = 0;  // 시도별 주소수
		String prevSido = ""; // 시도의 이전주소
		
		
		long startTime = System.nanoTime();		// 시간
				
		while ((line = br.readLine() ) != null) { // 한줄을 읽는데 빈칸이 아닐경우
			PostVo vo = new PostVo(line); // 한라인을 들고와서 vo 에 저장
			String sido = vo.getSido(); // vo 에 저장된 값을 sido 에 저장
						
			if(!sido.equals(prevSido)) { // 현재 읽은 sido 가  이전 prevSido와 다른지 확인
				sidoList.add( sido );
				sidoCntList.add( 1 ); // 이미 첫줄을 읽은 상태이기 때문에 1을 부여한다 // 위에서 첫줄을 읽고 건너 뛰엇기 때문
				prevSido = sido; // 메모지를 새로운 시도(sido)로 쓴다
				//	System.out.println( sido );
				pos++; // 시도 갯수
			} else {
				sidoCnt = sidoCntList.get(pos) + 1; // 각 시도별 주소 수
				sidoCntList.set(pos, sidoCnt);				
			}
			totcnt++;  // 총 카운트
		}
		
		long endTime = System.nanoTime();
		double execTime = (endTime - startTime)/1000.0/1000.0/1000.0;
		
		br.close();
		fr.close();
		
		for (int i = 0; i < sidoList.size(); i++) {
			System.out.println( 
					sidoList.get(i) + "=" + sidoCntList.get(i) );
		}
				
		System.out.println("시도 자료수:" + (pos + 1));
		System.out.println("전체 자료수:" + totcnt);
		System.out.println("실행 시간:" + execTime + "s");
		
		
	}
}