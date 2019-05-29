package idl.item;

/**
* item/ItemHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��idl
* 2019��5��22�� ������ ����07ʱ06��51�� CST
*/

public final class ItemHolder implements org.omg.CORBA.portable.Streamable
{
  public Item value = null;

  public ItemHolder ()
  {
  }

  public ItemHolder (Item initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ItemHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ItemHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ItemHelper.type ();
  }

}
