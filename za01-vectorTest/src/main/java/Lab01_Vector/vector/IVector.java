package Lab01_Vector.vector;

import java.util.ArrayList;

public interface IVector {
	public void add(IVector a) throws UnevenVectorsExecption;
	public void set(ArrayList<Integer> a);
	public ArrayList<Integer> get();
	public void sub(IVector a) throws UnevenVectorsExecption;
}
