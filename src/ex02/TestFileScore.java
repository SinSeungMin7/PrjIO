package ex02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestFileScore {

	public static void main(String[] args) throws IOException {
		String     path     = "D:/dev/java/PrjIO/src/ex02/";
		String     filename = "data.txt";
		
		FileReader     fr   = new FileReader(path + filename);
		BufferedReader br   = new BufferedReader(fr);
		
		// 출력파일
		String    filename2 = "result.txt";
		FileWriter     fw   = new FileWriter(path + filename2, true);
		// true 는 append 옵션이다 추가하는방식중에 insert : 중간중간 추가할수있다, append : 마지막에 붙인다
		// append : false 나 생략 -> 생성되는 파일이 OverWrite 된다 -> 덮어쓴다
		//       기존 파일이 존재하면 덮어쓰고 없으면 새로 만든다
		// append : true         -> 생성되는 파일이 Append 된다 -> 내용이 된다
		BufferedWriter bw   = new BufferedWriter(fw);
		
		String         line = "";
		br.readLine();
		
		String title = "번호 이름 국어 영어 수학 총점 평균\n";
		System.out.println(title);
		bw.write( title );
		
		while( (line = br.readLine()) != null ) {
			// System.out.println(line);
			String [] li = line.trim().split(",");
			int     num = Integer.parseInt(li[0].trim());
			String name = li[1].trim();
			int     kor = Integer.parseInt(li[2].trim());
			int     eng = Integer.parseInt(li[3].trim());
			int    math = Integer.parseInt(li[4].trim());
			int     tot = kor + eng + math;
			double  avg = tot / 3.0; // 소수이하 두자리로 반올림 : %.2f
			
			String fmt = "%d %s %d %d %d %d %.2f\n";
			String msg = String.format(fmt,
					num, name, kor, eng, math, tot, avg);
			System.out.print(msg);
			bw.write(msg);
		}
		
		br.close();
		bw.close();
		
		fr.close();
		fw.close();
		
	}

}
