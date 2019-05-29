package idl.user;


/**
* user/User.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��idl
* 2019��5��22�� ������ ����07ʱ06��48�� CST
*/

public final class User implements org.omg.CORBA.portable.IDLEntity
{
  public String name = null;
  public String password = null;

  public User ()
  {
  } // ctor

  public User (String _name, String _password)
  {
    name = _name;
    password = _password;
  } // ctor

} // class User
