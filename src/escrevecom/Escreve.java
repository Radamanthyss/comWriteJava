/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escrevecom;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPort;
import jssc.SerialPortException;

/**
 *
 * @author Bruno
 */
class Escreve {

    SerialPort port;

    public Escreve() {
        port = new SerialPort("COM1");
    }

    public void roda() throws InterruptedException {
        try {
	    //TEST GIT
            port.openPort();
            port.setParams(4800, 8, 1, 0); // alternate technique
            
            
            for (int i = 0; i <= 550; i++) {
                port.writeString("i0  00000099000");
                TimeUnit.MILLISECONDS.sleep(300);
            }
            System.out.println("end");
            port.closePort();
        } catch (SerialPortException ex) {
            Logger.getLogger(EscreveCom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
