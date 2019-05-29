package idl.user;


/**
* user/CreatorPOA.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��idl
* 2019��5��22�� ������ ����07ʱ06��48�� CST
*/

public abstract class CreatorPOA extends org.omg.PortableServer.Servant
 implements CreatorOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("register", new java.lang.Integer (0));
    _methods.put ("login", new java.lang.Integer (1));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // user/Creator/register
       {
         User user = UserHelper.read (in);
         boolean $result = false;
         $result = this.register (user);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 1:  // user/Creator/login
       {
         User user = UserHelper.read (in);
         boolean $result = false;
         $result = this.login (user);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:user/Creator:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Creator _this() 
  {
    return CreatorHelper.narrow(
    super._this_object());
  }

  public Creator _this(org.omg.CORBA.ORB orb) 
  {
    return CreatorHelper.narrow(
    super._this_object(orb));
  }


} // class CreatorPOA
