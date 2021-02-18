package by.bsuir.ksis.labs.first;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public class MacAddressGetter {

    public static String getMacAddress(InetAddress address) throws SocketException {
        NetworkInterface ni = NetworkInterface.getByInetAddress(address);
        if (ni != null) {
            byte[] hardwareAddress = ni.getHardwareAddress();
            String[] hexadecimal = new String[hardwareAddress.length];
            for (int i = 0; i < hardwareAddress.length; i++) {
                hexadecimal[i] = String.format("%02X", hardwareAddress[i]);
            }
            return String.join(":", hexadecimal);
        }
        return "No mac";
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getMacAddress(InetAddress.getLocalHost()));
        System.out.println(InetAddress.getLocalHost().isReachable(3000));
        //getAllMacAddressesInNetwork();
        //System.out.println(Arrays.toString(InetAddress.getAllByName("localhost")));
    }
}
