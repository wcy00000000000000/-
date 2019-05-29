package idl.item;


/**
* item/TodoListPOA.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��idl
* 2019��5��22�� ������ ����07ʱ06��51�� CST
*/

public abstract class TodoListPOA extends org.omg.PortableServer.Servant
 implements TodoListOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("_get_itemList", new java.lang.Integer (0));
    _methods.put ("_set_itemList", new java.lang.Integer (1));
    _methods.put ("_get_userName", new java.lang.Integer (2));
    _methods.put ("_set_userName", new java.lang.Integer (3));
    _methods.put ("add", new java.lang.Integer (4));
    _methods.put ("query", new java.lang.Integer (5));
    _methods.put ("delete", new java.lang.Integer (6));
    _methods.put ("clear", new java.lang.Integer (7));
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
       case 0:  // item/TodoList/_get_itemList
       {
         Item $result[] = null;
         $result = this.itemList ();
         out = $rh.createReply();
         ItemListHelper.write (out, $result);
         break;
       }

       case 1:  // item/TodoList/_set_itemList
       {
         Item newItemList[] = ItemListHelper.read (in);
         this.itemList (newItemList);
         out = $rh.createReply();
         break;
       }

       case 2:  // item/TodoList/_get_userName
       {
         String $result = null;
         $result = this.userName ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 3:  // item/TodoList/_set_userName
       {
         String newUserName = in.read_string ();
         this.userName (newUserName);
         out = $rh.createReply();
         break;
       }

       case 4:  // item/TodoList/add
       {
         Item item = ItemHelper.read (in);
         boolean $result = false;
         $result = this.add (item);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 5:  // item/TodoList/query
       {
         String start = in.read_string ();
         String end = in.read_string ();
         Item $result[] = null;
         $result = this.query (start, end);
         out = $rh.createReply();
         ItemListHelper.write (out, $result);
         break;
       }

       case 6:  // item/TodoList/delete
       {
         String id = in.read_string ();
         boolean $result = false;
         $result = this.delete (id);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 7:  // item/TodoList/clear
       {
         boolean $result = false;
         $result = this.clear ();
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
    "IDL:item/TodoList:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public TodoList _this() 
  {
    return TodoListHelper.narrow(
    super._this_object());
  }

  public TodoList _this(org.omg.CORBA.ORB orb) 
  {
    return TodoListHelper.narrow(
    super._this_object(orb));
  }


} // class TodoListPOA
