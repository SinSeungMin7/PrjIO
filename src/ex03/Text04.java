package ex03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Text04 {

	public static void main(String[] args) throws IOException {
		// zipcode.txt 파일 준비
		String path     = "D:/dev/java/PrjIO/src/ex03/";
		String filename = "zipcode.txt";   
		
		// 파일읽기 기능 호출
		FileReader fr = new FileReader(path + filename);
		// 버퍼읽기 기능 호출
		BufferedReader br   = new BufferedReader(fr);
		//키보드 검색 자료 
		Scanner in = new Scanner(System.in);
		System.out.println("동, 건물명 입력");
		String search = in.nextLine();
		// 한줄 저장할 변수
		String         line = "";
		br.readLine(); // 첫줄 읽어서 버리기
		
		int data  = 0;
		int tot = 0;
		
		while( (line = br.readLine()) != null ) {
			tot ++;
			
			String [] li = line.trim().split(","); 
			String ZIPCODE   = li[0].trim();
			String SIDO      = li[1].trim();
			String GUGUN     = li[2].trim();
			String DONG      = li[3].trim();
			String BUNJI     = li[4].trim();
			int    SEQ       = Integer.parseInt(li[5].trim());
			
			String fmt = "%s %s %s %s %s %d\n";
			String msg = String.format(fmt,
					ZIPCODE, SIDO, GUGUN, DONG, BUNJI, SEQ);
			
			if( DONG.indexOf(search) >= 0 ) {
				data ++;
			}
		}
		System.out.println("검색된 자료수 : " + data);
		System.out.println("전체 자료수  : " + tot);
		
		
		br.close();
		fr.close();
	}

}
