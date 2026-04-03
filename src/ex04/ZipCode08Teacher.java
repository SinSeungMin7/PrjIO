package ex04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ZipCode08Teacher {

	public static void main(String[] args) {

		//String      path  = Zipcode07.class.getResource("").getPath(); // URL 오류를 개선하기위해 .getPath();를 사용한다
		// bin 에 저장
		String path = System.getProperty("user.dir") + "/src/ex04/"; 
		String    inFname = "zipcode_utf8.csv";
		String   outFname = "zipcode_busanjingu.csv";
		
		FileReader     fr = null;
		FileWriter     fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		int cnt = 0;
		
		try {
			fr = new FileReader( path + inFname );
			br = new BufferedReader(fr);
			
			// 8. zipcode_utf8.csv
//			   -> 서울.csv
//			      부산.csv
//			      
//			      ...
//			      충북.csv      
			br.readLine(); // 첫줄 skip
			String line     = "";
			String prevSido = "";
			while ( (line = br.readLine() ) != null ) {
				PostVo postVo =  new PostVo(line);
				String  sido = postVo.getSido();
								
				if ( !sido.equals(prevSido) ) { // 현재읽은 시도 sido 가 이전에읽은 prevSido와 같은지
					if( bw != null ) bw.close();
					if( fw != null ) fw.close();
					
					
					outFname   = path + sido + ".csv";
					File oFile = new File(outFname);
					if( oFile.exists() ) { // 만약 oFile이 존재한다면 지워라 
						oFile.delete();
						}
				
						fw = new FileWriter( oFile, true ); // true : append
						bw = new BufferedWriter(fw);
						
						prevSido = sido;
						cnt ++;
				} 
				
				bw.write( postVo.getAddress() + "\n" );
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if( br != null ) br.close();
				if( fr != null ) fr.close();
				
				if( bw != null ) bw.close();
				if( fw != null ) fw.close();
			} catch (IOException e) {
			}// try catch end			
		}
		System.out.println(cnt + "개 파일을 생성 했습니다");
	}

}
