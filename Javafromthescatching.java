import java.io.PrintStream;
import java.util.ArrayList;
/**
*
* @author eaglclaws
*/
public class Javafromthescatching
{
	static ArrayList<Record> records = new ArrayList<Record>();
	private static int count = 100;
	/**
	* @param args the command line arguments
	*/
	public static void main(String[] args) 
	{

		for(int i = 0 ; i < 100 ; i++)
		{
			int x = count++;
			int y = (int)(Math.random()*10)%5;
			int z = (int)(Math.random()*10)%5;
			int a = (int)(Math.random()*10)%5;
			int b = (int)(Math.random()*10)%5;
			records.add(new Record(x, y, z, a, b));
		}
		System.out.println("-----------------------------------------------------------------------------------------------------------------");
		System.out.printf("|\t학번\t|\t국어\t|\t수학\t|\t영어\t|\t과학\t|\t합계\t|\t평균\t|\n");
		System.out.println("-----------------------------------------------------------------------------------------------------------------");
		for(int i = 0; i < 100 ; i++)
		{
			System.out.printf("|\t%03d\t|\t%2d\t|\t%2d\t|\t%2d\t|\t%2d\t|\t%2d\t|\t%1.2f\t|\n", records.get(i).getIdNumber(), records.get(i).getKorean(), records.get(i).getMath(), records.get(i).getEnglish(), records.get(i).getScience(), records.get(i).getsum(), records.get(i).average());//average(records.get(i)));
			System.out.println("-----------------------------------------------------------------------------------------------------------------");
		}

	}

	static float average(Record student) 
	{
		float avg;

		avg = (float)student.getsum()/4;

		return avg;
	}
}

class Record
{
	private int IdNumber;
	private int Korean;
	private int Math;
	private int English;
	private int Science;
	private int sum;
	private float avg;

	public Record(int x, int y, int z, int a, int b)
	{
		IdNumber = x;
		Korean = y;
		Math = z;
		English = a;
		Science = b;
		sum = y + z + a + b;
		avg = (float)sum / 4;
	}
	public int getIdNumber()
	{
		return IdNumber;
	}
	public int getKorean()
	{
		return Korean;
	}
	public int getMath()
	{
		return Math;
	}
	public int getEnglish()
	{
		return English;
	}
	public int getScience()
	{
		return Science;
	}
	public int getsum()
	{
		return sum;
	}
	public float average() 
	{
		return avg;
	}

}
