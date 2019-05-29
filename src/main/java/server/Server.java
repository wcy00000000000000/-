package server;

import idl.item.Item;
import idl.item.TodoList;
import idl.item.TodoListHelper;
import idl.user.Creator;
import idl.user.CreatorHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import java.util.Properties;
import java.util.Scanner;

public class Server {
    private ORB orb;
    private POA rootPOA;
    private NamingContextExt namingContextExt;

    public static void main(String[] args) {
        Server server = new Server();
        server.init();
        server.start();
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
            rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPOA.the_POAManager().activate();
            CreatorImpl creatorImpl = new CreatorImpl();
            creatorImpl.setServer(this);
            Creator creator = CreatorHelper.narrow(rootPOA.servant_to_reference(creatorImpl));
            namingContextExt = NamingContextExtHelper.narrow(
                    orb.resolve_initial_references("NameService")
            );
            NameComponent[] path = namingContextExt.to_name("creator");
            namingContextExt.rebind(path, creator);
            System.out.println("Server successfully start.");
            orb.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTodoList(String name, Item[] items) {
        try {
            TodoListImpl todoListImpl = new TodoListImpl();
            todoListImpl.itemList(items);
            todoListImpl.userName(name);
            TodoList todoList = TodoListHelper.narrow(rootPOA.servant_to_reference(todoListImpl));
            NameComponent[] path = namingContextExt.to_name(name + "TodoList");
            namingContextExt.rebind(path, todoList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
