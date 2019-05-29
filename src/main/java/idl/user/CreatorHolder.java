package idl.user;

/**
* user/CreatorHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��idl
* 2019��5��22�� ������ ����07ʱ06��48�� CST
*/

public final class CreatorHolder implements org.omg.CORBA.portable.Streamable
{
  public Creator value = null;

  public CreatorHolder ()
  {
  }

  public CreatorHolder (Creator initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CreatorHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CreatorHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CreatorHelper.type ();
  }

}
