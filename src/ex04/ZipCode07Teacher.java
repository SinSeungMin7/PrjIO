package ex04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ZipCode07Teacher {

	public static void main(String[] args) {

	//	String      path  = Zipcode07.class.getResource("").getPath(); // URL 오류를 개선하기위해 .getPath();를 사용한다
		//String path = "/D:"
		String path = System.getProperty("user.dir") + "/src/ex04/"; 
		String    inFname = "zipcode_utf8.csv";
		String   outFname = "zipcode_busanjingu.csv";
		
		FileReader     fr = null;
		FileWriter     fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			fr = new FileReader( path + inFname );
			fw = new FileWriter( path + outFname);
			
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			// 7. 부산 부산진구의 우편번호를 파일( .csv )로 출력
			br.readLine(); // 첫줄 skip
			String line = "";
			while ( (line = br.readLine() ) != null ) {
				PostVo postVo =  new PostVo(line);
				
				String  sido = postVo.getSido();
				String gugun = postVo.getGugun();
				
				if( sido.equals( "부산" ) ) {
					if( gugun.contains( "진구" ) ) {
						String result = postVo.getAddress();
						System.out.println( result );
						bw.write( result + "\n" ); 
						// 결과가 bin에 저장된다
					} 
				} 
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if( fr != null ) br.close();
				if( fr != null ) fr.close();
				
				if( fr != null ) bw.close();
				if( fr != null ) fw.close();
			} catch (IOException e) {
			}			
		}
		
	}

}
