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
        port = new SerialPort("COM2");
    }

    public void roda() throws InterruptedException {
        try {
            port.openPort();
            port.setParams(4800, 8, 1, 0); // alternate technique

            for (int i = 0; i <= 180; i++) {
//                port.writeString("i0  00000099000");
//                port.writeString("St 34,00  00000000500/n");
                port.writeBytes("St 34,00  00000000500".getBytes());//Write data to port
                TimeUnit.MILLISECONDS.sleep(300);
            }

            System.out.println("end");
            port.closePort();
        } catch (SerialPortException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
