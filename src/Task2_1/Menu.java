package Task2_1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Menu {

    private String saveFileName = "pudge.bin";
    private ResourceBundle bundle;

    public Menu(ResourceBundle bundle) {
        this.bundle = bundle;
    }

    public void process() {
        Pudge pudge = null;
        System.out.println(bundle.getString("hello"));
        Scanner in = new Scanner(System.in);
        boolean exit = false;
        while (in.hasNextInt() && !exit) {
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    pudge = createPudge(in);
                    break;
                case 2:
                    if (pudge == null) {
                        System.out.println(bundle.getString("noPudge"));
                    } else {
                        savePudge(pudge);
                    }
                    break;
                case 3:
                    pudge = loadPudge();
                    break;
                default:
                    exit = true;
            }
            System.out.println(bundle.getString("hello"));
        }
        in.close();
        System.out.println(bundle.getString("goodbye"));
    }

    private Pudge createPudge(Scanner in) {
        System.out.println(bundle.getString("ultimate"));

        String ultimate = in.next();

        System.out.println(bundle.getString("intelligence"));
        while (!in.hasNextInt()) {
            System.out.println(bundle.getString("notAnInteger"));
            in.next();
        }
        int intelligence = in.nextInt();

        System.out.println(bundle.getString("agility"));
        while (!in.hasNextInt()) {
            System.out.println(bundle.getString("notAnInteger"));
            in.next();
        }
        int agility = in.nextInt();

        System.out.println(bundle.getString("strength"));
        while (!in.hasNextInt()) {
            System.out.println(bundle.getString("notAnInteger"));
            in.next();
        }
        int strength = in.nextInt();

        Pudge pudge = new Pudge(ultimate, intelligence, agility, strength);

        System.out.println(bundle.getString("pudgeCreated") + pudge);
        return pudge;
    }

    private void savePudge(Pudge pudge){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(saveFileName);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(pudge);
            System.out.println(bundle.getString("pudgeSaved")  + pudge);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Pudge loadPudge() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(saveFileName);
            ois = new ObjectInputStream(fis);
            Pudge pudge = (Pudge) ois.readObject();
            System.out.println(bundle.getString("pudgeLoaded") + pudge);
            return pudge;
        } catch (FileNotFoundException e) {
            System.out.println(bundle.getString("noSavedPudge"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
