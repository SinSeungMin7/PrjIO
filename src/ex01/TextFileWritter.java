package ex01;
import java.io.FileWriter;   
import java.io.IOException;

public class TextFileWritter {

	public static void main(String[] args) throws IOException {
		String [] names = {"Rm", "진", "슈가", "제이홉", "지민", "뷔", "정국"};
		
		String filename = "D:\\dev\\java\\PrjIO\\src\\ex01\\bts.txt";
		FileWriter fw  = new FileWriter(filename); // 빨간줄 이유 file 은 usb에 저장하지만 지금은 usb가 없기 떄문에 예외처리를 해야한다
		
		for (int i = 0; i < names.length; i++) {
			fw.write( ( i + 1 ) + "." + names[i] + "\n");
		}
		fw.close();
		
		System.out.println(filename + "이" + names.length + "줄 저장되었습니다");
		
	}
}
