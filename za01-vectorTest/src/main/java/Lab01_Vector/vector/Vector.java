package Lab01_Vector.vector;

import java.util.ArrayList;

public class Vector implements IVector {
	private ArrayList<Integer> values = new ArrayList<Integer>();
	
	public void add(IVector a) throws UnevenVectorsExecption {
		values = Vector.add(this,a).get();
		
	}


	public void set(ArrayList<Integer> a) {
		values=a;
		
	}

	public ArrayList<Integer> get() {
		return values;
	}
	
	public static IVector add(IVector a, IVector b) throws UnevenVectorsExecption{
		//assert (a.get().size() != b.get().size()) : "nierowne rozmiary list";
		if (a.get().size()!=b.get().size())
		{
			throw new UnevenVectorsExecption("nierowne");
		}
		IVector newVector = new Vector();
		if (a.get().size()==b.get().size())
		{
			for (int i=0;i<a.get().size();i++)
			{
				newVector.get().add(a.get().get(i)+b.get().get(i));
			}
		}
		return newVector;
	}


	public void sub(IVector a) throws UnevenVectorsExecption {
		values = Vector.sub(this,a).get();
	}
	
	public static IVector sub(IVector a, IVector b) throws UnevenVectorsExecption{
		//assert (a.get().size() != b.get().size()) : "nierowne rozmiary list";
		if (a.get().size()!=b.get().size())
		{
			throw new UnevenVectorsExecption("nierowne");
		}
		IVector newVector = new Vector();
		if (a.get().size()==b.get().size())
		{
			for (int i=0;i<a.get().size();i++)
			{
				newVector.get().add(a.get().get(i)-b.get().get(i));
			}
		}
		return newVector;
	}


}
