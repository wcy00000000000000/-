package idl.item;


/**
* item/Item.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��idl
* 2019��5��22�� ������ ����07ʱ06��51�� CST
*/

public final class Item implements org.omg.CORBA.portable.IDLEntity
{
  public int id = (int)0;
  public String start = null;
  public String end = null;
  public String label = null;

  public Item ()
  {
  } // ctor

  public Item (int _id, String _start, String _end, String _label)
  {
    id = _id;
    start = _start;
    end = _end;
    label = _label;
  } // ctor

} // class Item
