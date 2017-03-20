package Lab01_Vector.vector;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;

public class VectorTest extends TestCase {

	@Test
	public void testcheckAddFunction() throws UnevenVectorsExecption{
		IVector vector = new Vector();
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		vector.set(a);
		vector.add(vector);
		assertEquals((Integer)2, vector.get().get(0));
		assertEquals((Integer)4, vector.get().get(1));
	}
	
	@Test
	public void testcheckStaticAddFunction() throws UnevenVectorsExecption{
		IVector vector = new Vector();
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		vector.set(a);
		vector.add(vector);
		assertEquals((Integer)2, vector.get().get(0));
		assertEquals((Integer)4, vector.get().get(1));
	}
	
	@Test
	public void testcheckGetAndSet() throws UnevenVectorsExecption{
		IVector vector = new Vector();
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		vector.set(a);
		
		IVector vector2 = new Vector();
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a2.add(3);
		a2.add(4);
		vector2.set(a2);
		
		IVector v3 = Vector.add(vector, vector2);
		
		assertEquals((Integer)4, v3.get().get(0));
		assertEquals((Integer)6, v3.get().get(1));
	}
	
	@Test (expected = UnevenVectorsExecption.class)
	public void testcheckAddFunction2() throws UnevenVectorsExecption{
		IVector vector = new Vector();
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		vector.set(a);
		
		IVector vector2 = new Vector();
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a2.add(3);
		a2.add(4);
		a2.add(3);
		vector2.set(a2);
		
		vector.add(vector2);
		
		//assertFalse(vector.get().size()==vector2.get().size());
	}
	
	@Test
	public void testSubFunction() throws UnevenVectorsExecption{
		IVector vector1 = new Vector();
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		vector1.set(a);
		
		IVector vector2 = new Vector();
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a2.add(3);
		a2.add(4);
		vector2.set(a2);
		
		vector2.sub(vector1);
		
		assertEquals((Integer)2, vector2.get().get(0));
		assertEquals((Integer)2, vector2.get().get(1));
	}
}
