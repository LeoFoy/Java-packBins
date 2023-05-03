import java.util.Scanner;
import java.util.ArrayList;
public class Ch11PA1
{
	public static void main(String args[])
    {
    	Scanner input = new Scanner(System.in);
    	int capacity = 10;
    	int n;
    	ArrayList<Integer> objects = new ArrayList<>();
    	
        System.out.print("Enter the number of objects: ");
        n = input.nextInt();
        
        System.out.print("Enter the weight of the objects: ");
        for(int i=0; i < n; i++)
            objects.add(input.nextInt());
        
        PackBins packContainer = new PackBins(objects, capacity);
        packContainer.pack();
        packContainer.print();
        
    }
    
}

