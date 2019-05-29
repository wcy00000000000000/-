package idl.item;


/**
* item/ItemListHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��idl
* 2019��5��22�� ������ ����07ʱ06��51�� CST
*/

public final class ItemListHolder implements org.omg.CORBA.portable.Streamable
{
  public Item value[] = null;

  public ItemListHolder ()
  {
  }

  public ItemListHolder (Item[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ItemListHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ItemListHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ItemListHelper.type ();
  }

}
