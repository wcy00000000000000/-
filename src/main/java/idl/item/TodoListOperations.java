package idl.item;


import java.text.ParseException;

/**
* item/TodoListOperations.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��idl
* 2019��5��22�� ������ ����07ʱ06��51�� CST
*/

public interface TodoListOperations 
{
  Item[] itemList ();
  void itemList (Item[] newItemList);
  String userName ();
  void userName (String newUserName);
  boolean add (Item item);
  Item[] query (String start, String end);
  boolean delete (String id);
  boolean clear ();
} // interface TodoListOperations
