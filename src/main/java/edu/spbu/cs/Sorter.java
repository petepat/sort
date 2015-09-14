package sort;

public class Sorter {
	private int size;
	private int[] data;
	
	Sorter(int maxsize){
		size = -1;
		data = new int[maxsize];
	}
	public void AddData(int NewValue){
		int CurrentPlace;
		size+=1;
		data[size] = NewValue;
		CurrentPlace = size;
		while((CurrentPlace > 0)&&(data[CurrentPlace] > data[(CurrentPlace -1)/2])){
			swap(CurrentPlace, (CurrentPlace - 1)/2);
			CurrentPlace = (CurrentPlace-1)/2;
		}
	}
	public void sort(){
		int CurrentPlace;
		for(int i=size; i>0; i--){
			swap(0, i);
			CurrentPlace = 0;
			while(CurrentPlace > -1){
				CurrentPlace = Shift(CurrentPlace, i-1);
			}
		}
	} 
	private int Shift(int Place, int CurrentSize){
		if(2*Place + 1 > CurrentSize){
			return -1;
		}else{
			if(2*Place + 1 == CurrentSize){
				if(data[Place] < data[2*Place + 1]){
					swap(Place, 2*Place + 1);
					return 2*Place + 1;
				}else{
					return -1;
				}
			}else{
				if(data[2*Place + 1] > data[2*Place + 2]){
					if(data[Place] < data[2*Place + 1]){
						swap(Place, 2*Place + 1);
						return 2*Place + 1;
					}else{
						return -1;
					}
				}else{
					if(data[Place] < data[2*Place + 2]){
						swap(Place, 2*Place + 2);
						return 2*Place + 2;
					}else{
						return -1;
					}
				}
			}
		}
	}
	private void swap(int i, int j){
		int k;
		k = data[i];
		data[i] = data[j];
		data[j] = k;
	}
	public int GetValue(int Place){
		return data[Place];
	}
	public int ShowSize(){
		return size;
	}
}
