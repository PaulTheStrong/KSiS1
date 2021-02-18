package by.bsuir.ksis.labs.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Enumeration;

public class MacAddressGetter {

    public static void printMacAddress(InetAddress address) throws IOException {
        Enumeration<NetworkInterface> ni = NetworkInterface.getNetworkInterfaces();
        while (ni.hasMoreElements()) {
            byte[] ha = ni.nextElement().getHardwareAddress();
            if (ha != null) {
                System.out.printf("%02x-%02x-%02x-%02x-%02x-%02x\n",
                            ha[0], ha[1], ha[2], ha[3], ha[4], ha[5]);

            }
        }
    }

    public static void main(String[] args) throws IOException {
    }
}
