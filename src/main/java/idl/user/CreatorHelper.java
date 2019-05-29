package idl.user;


/**
* user/CreatorHelper.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��idl
* 2019��5��22�� ������ ����07ʱ06��48�� CST
*/

abstract public class CreatorHelper
{
  private static String  _id = "IDL:user/Creator:1.0";

  public static void insert (org.omg.CORBA.Any a, Creator that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static Creator extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (CreatorHelper.id (), "Creator");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static Creator read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_CreatorStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, Creator value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static Creator narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Creator)
      return (Creator)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      _CreatorStub stub = new _CreatorStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static Creator unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Creator)
      return (Creator)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      _CreatorStub stub = new _CreatorStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
