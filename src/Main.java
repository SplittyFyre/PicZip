import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
	private static boolean isDigit(char c) {
		return (c >= '0') && (c <= '9');
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner jin = new Scanner(System.in);

		int width = Integer.parseInt(jin.nextLine());
		
		StringBuilder encodedBuffer = new StringBuilder();
		boolean flag;
		while (true) {
			String line = jin.nextLine();
			flag = line.substring(line.length() - 3).equals(">>>");
			System.out.println(line.substring(line.length() - 3));
			System.out.println();
			if (flag) {
				encodedBuffer.append(line.substring(0, line.length() - 3));
			}
			else {
				encodedBuffer.append(line);
				break;
			}
			
		}
		
		String encodedData = encodedBuffer.toString();
		
		StringBuilder output = new StringBuilder();
		
		int i = -1;
		char c = '#';
		String numstr = "";
		
		System.out.println();
		System.out.println(encodedData);

		while (true) {
			numstr = "";
			while (isDigit((c = encodedData.charAt(++i)))) {
				numstr += c;
			}
			
			
			int num = Integer.parseInt(numstr);
			
			if (c == '.') {
				char toapp = encodedData.charAt(++i);
				for (int j = 0; j < num; j++) {
					output.append(toapp);
				}
			}
			else if (c == ':') {
				int n = i;
				for (i = n + 1; i < n + 1 + num; i++) {
					output.append(encodedData.charAt(i));
				}
				i--; // previous for loop overshoots index by one
			}
			else {
				System.out.println("INVALID IDENTIFIER '" + c + "'");
				System.exit(0);
			}
			
			if (i >= encodedData.length() - 1) {
				break;
			}
			
		}
		
		String out = output.toString();
		int cnt = 0;
		for (int j = 0; j < out.length(); j++) {
			System.out.print(out.charAt(j));
			cnt++;
			if (cnt == width) {
				cnt = 0;
				System.out.print('\n');
			}
		}
		
		System.out.println();
		
		jin.close();
	}

}
