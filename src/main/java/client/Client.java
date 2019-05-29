package client;

import idl.item.Item;
import idl.item.TodoList;
import idl.item.TodoListHelper;
import idl.user.Creator;
import idl.user.CreatorHelper;
import idl.user.User;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import java.util.Properties;
import java.util.Scanner;

public class Client {
    private ORB orb;
    private Creator creator;
    private TodoList todoList;
    private NamingContextExt namingContextExt;

    public static void main(String[] args) {
        Client client = new Client();
        client.init();
        client.start();
    }

    private void init() {
        System.out.println("Please input the ip address and the port of the orb server: ");
        Scanner scanner = new Scanner(System.in);
        String[] args = {};
        Properties properties = new Properties();
        properties.put("org.omg.CORBA.ORBInitialHost", scanner.next());
        properties.put("org.omg.CORBA.ORBInitialPort", scanner.next());
        orb = ORB.init(args, properties);
    }

    private void start() {
        try {
            namingContextExt = NamingContextExtHelper.narrow(
                    orb.resolve_initial_references("NameService")
            );
            creator = CreatorHelper.narrow(namingContextExt.resolve_str("creator"));
            String name;
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Please input the number to login or register: \n" +
                        "1. login \n2. register \n3. quit:");
                String option = scanner.next();
                if (option.equals("1")) {
                    System.out.println("Please input your name and password:");
                    name = scanner.next();
                    User user = new User(name, scanner.next());
                    if (creator.login(user)) {
                        name = user.name;
                        System.out.println(name + " successfully login");
                        break;
                    }
                } else if (option.equals("2")) {
                    System.out.println("Please input your register name and password:");
                    name = scanner.next();
                    User user = new User(name, scanner.next());
                    if (creator.register(user)) {
                        name = user.name;
                        System.out.println(name + " successfully registered");
                        break;
                    }
                } else if (option.equals("3")) {
                    System.exit(0);
                }
            }
            listOperation(name);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void listOperation(String name) {
        try {
            todoList = TodoListHelper.narrow(namingContextExt.resolve_str(name + "TodoList"));
            while (true) {
                System.out.println("Please input the number to choose the operations: \n" +
                        "1. add item \n2. query items \n3. delete item \n" +
                        "4. clear item \n5. quit:");
                Scanner scanner = new Scanner(System.in);
                String option = scanner.next();
                if (option.equals("1")) {
                    System.out.println("Please input the item's start and end time and its label, " +
                            "time should be in the format of yyyy-MM-dd:");
                    Item item = new Item();
                    item.start = scanner.next();
                    item.end = scanner.next();
                    item.label = scanner.next();
                    if (todoList.add(item)) {
                        System.out.println("item successfully added");
                    }
                } else if (option.equals("2")) {
                    System.out.println("Please input the items' start and end time, " +
                            "time should be in the format of yyyy-MM-dd:");
                    Item[] items = todoList.query(scanner.next(), scanner.next());
                    System.out.println("The items in the time period are:");
                    for (Item item : items) {
                        System.out.println("id: " + item.id + "\t start time: " + item.start
                                + "\t end time: " + item.end + "\t label: " + item.label);
                    }
                } else if (option.equals("3")) {
                    System.out.println("Please input the item id:");
                    if (todoList.delete(scanner.next())) {
                        System.out.println("item successfully deleted");
                    }
                } else if (option.equals("4")) {
                    if (todoList.clear()) {
                        System.out.println("to-do list successfully cleared");
                    }
                } else if (option.equals("5")) {
                    System.exit(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
