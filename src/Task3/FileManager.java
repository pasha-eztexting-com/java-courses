package Task3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {

    public FileManager() {
    }

    public void run() {
        File root = new File("/Users/pavloprokofiev");
        Scanner in = new Scanner(System.in);

        System.out.println("Allowed commands: 'cd ..', 'cd dir', 'ls', 'less f1', 'copy f1 f2', 'exit'");
        do {
            System.out.print(root.getAbsolutePath() + "$");
            String command = in.nextLine();
            if (command.equals("cd ..")) {
                root = root.getParentFile();
                continue;
            }
            if (command.startsWith("cd ")) {
                File newRoot = new File(root.getAbsolutePath() + "/" + command.substring(3));
                if (newRoot.exists()) {
                    root = newRoot;
                }
                else {
                    System.out.println("No such file or directory");
                }
                continue;
            }
            if (command.equals("ls")) {
                ls(root);
                continue;
            }

            if (command.startsWith("less ")) {
                less(root, command);
                continue;
            }

            if (command.startsWith("copy ")) {
                copy(root, command);
                continue;
            }
            if (command.equals("exit")) {
                return;
            }
            System.out.println(command + " is not a valid command");
        } while (true);
    }

    private void ls(File root) {
        for (File f : root.listFiles()) {
            if (f.isDirectory()) {
                System.out.println(f.getName());
            }
        }
        for (File f : root.listFiles()) {
            if (f.isFile()) {
                System.out.println(f.getName());
            }
        }
    }

    private void less(File root, String command) {
        File f = new File(root.getAbsolutePath() + "/" + command.substring(5));
        if (f.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(root.getAbsolutePath() + "/" + command.substring(5)));) {
                String str;
                while ((str = br.readLine()) != null) {
                    System.out.println(str);
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("No such file or directory");
        }
    }

    private void copy(File root, String command) {
        String[] files = command.split(" ");
        if (files.length != 3) {
            System.out.println("copy syntax is 'copy f1 f2'");
            return;
        }
        File newFile = new File(root.getAbsolutePath() + "/" + files[1]);
        if (!newFile.exists()) {
            System.out.println("No such file as " + root.getAbsolutePath() + "/" + files[1]);
            return;
        }
        if (!newFile.isFile()) {
            System.out.println(root.getAbsolutePath() + "/" + files[1] + " is not a file");
            return;
        }
        try (FileInputStream fis = new FileInputStream(root.getAbsolutePath() + "/" + files[1]); FileOutputStream fos = new FileOutputStream(
                root.getAbsolutePath() + "/" + files[2]);) {
            int ch;
            while ((ch = fis.read()) != -1) {
                fos.write(ch);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Copied " + root.getAbsolutePath() + "/" + files[1] + " to " + root.getAbsolutePath() + "/" + files[2]);
    }
}
