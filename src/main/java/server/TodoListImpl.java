package server;

import dao.ItemDao;
import idl.item.Item;
import idl.item.TodoListPOA;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;


public class TodoListImpl extends TodoListPOA {
    Item[] items;
    String name;
    ItemDao itemDao = new ItemDao();

    @Override
    public Item[] itemList() {
        return items;
    }

    @Override
    public void itemList(Item[] newItemList) {
        items = newItemList;
    }

    @Override
    public String userName() {
        return name;
    }

    @Override
    public void userName(String newUserName) {
        name = newUserName;
    }

    @Override
    public boolean add(Item item) {
        ArrayList<Item> list = new ArrayList<Item>(Arrays.asList(items));
        list.add(item);
        items = list.toArray(new Item[] { });
        pojo.Item item1 = new pojo.Item();
        item1.setId(item.id);
        item1.setLabel(item.label);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            item1.setStart(simpleDateFormat.parse(item.start));
            item1.setEnd(simpleDateFormat.parse(item.end));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return itemDao.addItem(name, item1);
    }

    @Override
    public Item[] query(String start, String end) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String start1 = null;
        String end1 = null;
        try {
            start1 = simpleDateFormat.format(simpleDateFormat.parse(start));
            end1 = simpleDateFormat.format(simpleDateFormat.parse(start));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ArrayList<Item> list = new ArrayList<>();
        for (Item item : items) {
            if (item.start.compareTo(start1) >= 0 && item.end.compareTo(end1) <= 0) {
                list.add(item);
            }
        }
        return list.toArray(new Item[] { });
    }

    @Override
    public boolean delete(String id) {
        ArrayList<Item> list = new ArrayList<>();
        for (Item item : items) {
            if (!id.equals("" + item.id)) {
                list.add(item);
            }
        }
        items = list.toArray(new Item[] { });
        return itemDao.deleteItem(Integer.parseInt(id));
    }

    @Override
    public boolean clear() {
        items = new Item[]{};
        return itemDao.removeItem(name);
    }
}
