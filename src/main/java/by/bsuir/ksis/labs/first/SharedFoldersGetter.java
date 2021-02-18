package by.bsuir.ksis.labs.first;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class SharedFoldersGetter {

    public static void getSharedFolders(InetAddress address) {
        String ip = address.getHostAddress();
        System.out.println(ip);
        String path = "\\\\192.168.0.103\\d";
        System.out.println(path);
        File root = new File(path);
        if (root.exists()) {
            File[] list = root.listFiles();
            if (root.listFiles() != null) {
                for (File f : list) {
                    printFoldersRecoursievly(f.getAbsolutePath());
                }
            }
        }
    }

    private static void printFoldersRecoursievly(String folderName) {
        File file = new File(folderName);
        if (file.exists() && file.isDirectory()) {
            System.out.println(folderName);
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    printFoldersRecoursievly(f.getAbsolutePath());
                }
            }
        }
    }

    public static void main(String[] args) throws UnknownHostException {
        getSharedFolders(InetAddress.getLocalHost());
    }

}
