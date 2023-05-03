import java.util.ArrayList;
import java.util.Collections;
public class PackBins {
	private ArrayList<Container> containers;
	private ArrayList<Integer> objects;
	private int capacity;
	private int containerNum = 1;
	
	public PackBins(ArrayList<Integer> objects, int capacity) {
		this.objects = objects;
		this.capacity = capacity;
		this.containers = new ArrayList<>(this.objects.size());
	}
	
	public void pack() {
		
		this.containers.add(new Container(containerNum, capacity));
		
		for (Integer currentObject : objects) {
			boolean isPlaced = false;
			int container = 0;
			
			while (!isPlaced) {
				if (container == this.containers.size()) {
					Container newContainer = new Container(++containerNum, capacity);
					newContainer.insert(currentObject);
					this.containers.add(newContainer);
					isPlaced = true;
				} 
				else if (this.containers.get(container).insert(currentObject)) {
					isPlaced = true;
				}
				else {
					container++;
				}
				
			}
		}
	}
	
	public void print() {
		for(Container container : this.containers) {
			System.out.println(container);
		}
	}
	
}

class Container {
	private int containerNum;
	private int capacity;
	private int spaceLeft;
	private ArrayList<Integer> objects;
	
	public Container(int containerNum, int capacity) {
		this.containerNum = containerNum;
		this.capacity = capacity;
		this.objects = new ArrayList<Integer>();
	}
	
	public boolean insert(Integer object) {
		if (this.spaceLeft + object > this.capacity) {
			return false;
		}
		
		this.objects.add(object);
		this.spaceLeft += object;
		
		return true;
	}
	
	@Override
	public String toString() {
		String container = "Container "+ this.containerNum +" contains objects with weight ";
		
		for(Integer object : this.objects) {
			container += object + " ";
		}
		
		return container;
	}
	
}