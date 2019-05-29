package idl.item;

/**
* item/TodoListHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��idl
* 2019��5��22�� ������ ����07ʱ06��51�� CST
*/

public final class TodoListHolder implements org.omg.CORBA.portable.Streamable
{
  public TodoList value = null;

  public TodoListHolder ()
  {
  }

  public TodoListHolder (TodoList initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = TodoListHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    TodoListHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return TodoListHelper.type ();
  }

}
