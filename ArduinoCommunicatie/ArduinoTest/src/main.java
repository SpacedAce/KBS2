import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.util.Enumeration;
import java.io.IOException;


public class main {
	public static BufferedReader input;
	public static OutputStream output;
	private static int c;
	
	public static void main(String[] args) {


		try {
			Setup obj = new Setup();
			c = 0;
			obj.initialize();
			input = Setup.input;
			output = Setup.output;
			InputStreamReader Ir = new InputStreamReader(System.in);
			BufferedReader Br = new BufferedReader(Ir);
			while (c != 3) {
				System.out.println("LED ON / OFF MENU.");
				System.out.println("1.LED ON");
				System.out.println("2.LED OFF");
				System.out.print("Enter your choice :");
				c = Integer.parseInt(Br.readLine());

				switch (c) {
				case 1:
					TestClass.writeData("1");
					break;

				case 2:
					TestClass.writeData("0");
					break;

				case 3:
					System.exit(0);
				}
			}

			String inputLine = input.readLine();
			System.out.println(inputLine);

			obj.close();		

		} catch (Exception e) {
		}

	}
	
	public static void setC(int x){
		c = x;
	}

}
