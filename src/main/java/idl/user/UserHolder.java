package idl.user;

/**
* user/UserHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��idl
* 2019��5��22�� ������ ����07ʱ06��48�� CST
*/

public final class UserHolder implements org.omg.CORBA.portable.Streamable
{
  public User value = null;

  public UserHolder ()
  {
  }

  public UserHolder (User initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = UserHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    UserHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return UserHelper.type ();
  }

}
