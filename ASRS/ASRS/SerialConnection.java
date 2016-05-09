/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASRS;
// Door: Jeroen Gerrese, s1097417, ICTM2b, WTJ01

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier; 
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent; 
import gnu.io.SerialPortEventListener; 
import java.util.Enumeration;

/**
 *
 * @author Jeroen Gerrese
 */

    public class SerialConnection implements SerialPortEventListener {
	SerialPort serialPort;
        
        /** The port we're normally going to use. */
	private static final String PORT_NAMES[] = {
                        "COM3", // Windows
                        "/dev/ttyACM3", // Linux
                        "/dev/ttyUSB0", // Linux
                        "/dev/ttyUSB1", // Linux
	};
	/**
	* A BufferedReader which will be fed by a InputStreamReader 
	* converting the bytes into characters 
	* making the displayed results codepage independent
	*/
	private BufferedReader input;
	/** The output stream to the port */
	private OutputStream output;
	/** Milliseconds to block while waiting for port open */
	private static final int TIME_OUT = 2000;
	/** Default bits per second for COM port. */
	private static final int DATA_RATE = 9600;
        private static final String naam = "Arduino 1";

	public void initialize() {
                
            CommPortIdentifier portId = null;
		Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

		//First, Find an instance of serial port as set in PORT_NAMES.
                System.out.println("Trying on:");
		while (portEnum.hasMoreElements() || portId ==null) {
			CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
			for (String portName : PORT_NAMES) {
                            System.out.println("    " + portName);
				if (currPortId.getName().equals(portName) || currPortId.getName().startsWith(portName)) {
					portId = currPortId;
                                        System.out.println("Device found on " + portId.getName());
					break;
                                        
				}else{
                                    System.out.println("Could not find COM port.");
                                    
                                }
                             
			}
		}

		try {
			// open serial port, and use class name for the appName.
			serialPort = (SerialPort) portId.open(this.getClass().getName(),
					TIME_OUT);
                        System.out.println("Opening port " + portId.getName());

			// set port parameters
			serialPort.setSerialPortParams(DATA_RATE,
					SerialPort.DATABITS_8,
					SerialPort.STOPBITS_1,
					SerialPort.PARITY_NONE);
                        System.out.println("Setting the port with");

			// open the streams
			input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
			output = serialPort.getOutputStream();
                        System.out.println("Opening the Stream");
                        System.out.println(input);
                        System.out.println(output);

			// add event listeners
                        System.out.println("Adding Listeners");
			serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(true);
		} catch (Exception e) {
                        System.out.println("Crap");
			System.err.println(e.toString());
		}
	}

	/**
	 * This should be called when you stop using the port.
	 * This will prevent port locking on platforms like Linux.
	 */
	public synchronized void close() {
		if (serialPort != null) {
			serialPort.removeEventListener();
			serialPort.close();
		}
	}

	/**
	 * Handle an event on the serial port. Read the data and print it.
	 */
	public synchronized void serialEvent(SerialPortEvent oEvent) {
		if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
				String inputLine=input.readLine();
				System.out.println(inputLine);
			} catch (Exception e) {
				System.err.println(e.toString());
			}
		}
		// Ignore all the other eventTypes, but you should consider the other ones.
	}

    public static String getNaam() {
        return naam;
    }

	
        
        
        
}

