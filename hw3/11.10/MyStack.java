import java.util.ArrayList;

public class MyStack extends ArrayList
{
	public MyStack()
	{
		super();
	}

	public MyStack(int size)
	{
		super(size);
	}

	void push(Object F)
	{
		add(0, F);
	}

	Object pop()
	{
		return remove(0);
	}

	Object peep()
	{
		return get(0);
	}
	int getSize()
	{
		return size();
	}
}
