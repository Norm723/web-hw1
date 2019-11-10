import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Question4 {
	private FileWriter  file;
	public Question4() throws IOException {
		file = new FileWriter("question4.html");
	}

	public void draw() throws IOException {
		firstPart();
		Scanner sc = new Scanner(System.in);
		System.out.println("please insert a number between 1-50");
		String inputNum = sc.next();
		int numCol = 0;
		try {
			numCol = Integer.parseInt(inputNum);
			if(numCol > 50 || numCol <1) {
				System.out.println("invalid number");
				sc.close();
				return;
			}
		}catch (NumberFormatException e) {
			System.out.println("invalid number");
			return;
		}
		drawColumns(numCol);
		lastPart();
		file.close();
		sc.close();
	}

	private void drawColumns(int result) throws IOException {
		for (int i = 0; i < result; i++) {
			int modeNumber = i % 3;
			switch (modeNumber) {
			case 0:
				file.write("\t\t\t\t\t"+"<td style=\"height: 100vh;background-color: blue;\"></td>"+"\r\n");
				break;
			case 1:
				file.write("\t\t\t\t\t"+"<td style=\"height: 100vh;background-color:red;\"></td>"+"\r\n");
				break;
			case 2:
				file.write("\t\t\t\t\t"+"<td style=\"height: 100vh;background-color: green;\"></td>"+"\r\n");
				break;

			default:
				break;
			}
		}

	}

	private void firstPart() throws IOException {
		file.write("<!DOCTYPE html>\r\n" + 
				"<html>\r\n\t" + 
				"<head>\r\n\t\t" + 
				"<title>\r\n\t\t\t" + 
				"question4\r\n\t\t" + 
				"</title>\r\n\t" + 
				"</head>\r\n\t" + 
				"<body style=\"overflow:hidden;margin:0;\">\r\n\t\t" + 
				"<table style=\"width: 100%; border-collapse: collapse;\">\r\n\t\t\t" + 
				"<tbody>\r\n\t\t\t\t" + 
				"<tr>\r\n");
	}

	private void lastPart() throws IOException {
		file.write("\t\t\t\t"+"</tr>\r\n" + 
				"\t\t\t</tbody>\r\n" + 
				"\t\t</table>\r\n" + 
				"\t</body>\r\n" + 
				"</html>");
	}



	public static void main(String[] args) {
		try {
			Question4 splitscreen = new Question4();
			splitscreen.draw();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



}
