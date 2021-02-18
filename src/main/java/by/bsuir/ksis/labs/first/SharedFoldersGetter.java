package by.bsuir.ksis.labs.first;

import java.io.*;
import java.net.InetAddress;
import java.util.Locale;
import java.util.Scanner;

public class SharedFoldersGetter {

    private PrintWriter writer;

    public SharedFoldersGetter(String output) {
        writer = new PrintWriter(System.out);
    }

    public void getSharedFolders(InetAddress address) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        System.out.print("IP : ");
        String ip = scanner.next();
        System.out.print("Folder : ");
        String folder = scanner.next();
        String path = String.format("\\\\%s\\%s", ip, folder);

        File root = new File(path);
        if (root.exists()) {
            File[] list = root.listFiles();
            if (root.listFiles() != null) {
                for (File f : list) {
                    printFoldersRecursievly(f.getAbsolutePath());
                }
            }
        }
    }

    private void printFoldersRecursievly(String folderName) {
        File file = new File(folderName);
        if (file.exists() && file.isDirectory()) {
            writer.println(folderName);
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    printFoldersRecursievly(f.getAbsolutePath());
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.ENGLISH);
        MacAddressGetter.printMacAddress(InetAddress.getLocalHost());
        SharedFoldersGetter getter = new SharedFoldersGetter("output.txt");
        getter.getSharedFolders(InetAddress.getLocalHost());
    }

}
