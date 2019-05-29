package server;

import dao.ItemDao;
import dao.UserDao;
import idl.item.Item;
import idl.user.CreatorPOA;
import idl.user.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CreatorImpl extends CreatorPOA {
    private Server server;

    public void setServer(Server server) {
        this.server = server;
    }

    @Override
    public boolean register(User user) {
        UserDao userDao = new UserDao();
        if (userDao.getUser(user.name) == null) {
            server.createTodoList(user.name, new Item[]{});
            System.out.println(user.name + " has just registered");
            pojo.User user1 = new pojo.User();
            user1.setName(user.name);
            user1.setPassword(user.password);
            return userDao.insertUser(user1);
        }
        return false;
    }

    @Override
    public boolean login(User user) {
        UserDao userDao = new UserDao();
        if (userDao.getUser(user.name) != null) {
            if (user.password.equals(userDao.getUser(user.name).getPassword())) {
                ItemDao itemDao = new ItemDao();
                ArrayList<idl.item.Item> list = new ArrayList<>();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                for (pojo.Item item : itemDao.getItems(user.name)) {
                    list.add(new Item(item.getId(), simpleDateFormat.format(item.getStart()),
                            simpleDateFormat.format(item.getEnd()), item.getLabel()));
                }
                server.createTodoList(user.name, list.toArray(new Item[]{}));
                System.out.println(user.name + " has just login");
                return true;
            }
        }
        return false;
    }
}
