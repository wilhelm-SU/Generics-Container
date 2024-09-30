public class JadonContainer <T>
{
    //Attributes
    public T[] data;
    private int currentPosition;

    //Constructor
    public JadonContainer(int arraySize){
        data = (T[])new Object[arraySize];
        currentPosition = 0;
    }

    //Getters
    public T getValueOf(int position){
        return data[position];
    }

    public int getSize(){return currentPosition;}

    public int getIndexOf(T value){
        for(int i = 0; i < currentPosition; i++){
            if(data[i] == value){
                return i;
            }
        }
        return -1;
    }

    //Adding
    public void addValue(T value){
        if(currentPosition == data.length){
            T[] temp = (T[])new Object[(data.length)*2];
            for(int i = 0; i < currentPosition; i++){
                temp[i]  = data[i];
            }
            data = temp;
        }
        data[currentPosition] = value;
        currentPosition++;
    }

    public void addValue(int position, T value){
        if(currentPosition == data.length){
            T[] temp = (T[])new Object[currentPosition*2];
            for(int i = 0; i < currentPosition; i++){
                temp[i]  = data[i];
            }
            data = temp;
        }

        for(int i = currentPosition; i > position; i--){
            data[i] = data[i-1];
        }
        data[position] = value;
        currentPosition++;
    }

    public void addFirst(T value){
        for(int i = currentPosition; i > 0; i--){
            data[i] = data[i-1];
        }
        data[0] = value;
        currentPosition++;
    }

    //Removal
    public void removeValue(int position){
        for(int i = position+1; i <=currentPosition; i++){
            data[i-1] = data[i];
        }
        currentPosition--;
    }

    public void removeFirst(){
        for(int i = 1; i < currentPosition; i++){
            data[i-1] = data[i];
        }
        currentPosition--;
    }

    public void removeLast(){
        currentPosition--;
    }

    //True or false
    public boolean isEmpty(){
        T[] temp = (T[])new Object[0];
        if(data == temp){
            return true;
        } else{
            return false;
        }
    }

    public boolean doesContain(T value){
        for(int i = 0; i < currentPosition; i++){
            if(data[i] == value){
                return true;
            }
        }
        return false;
    }

    //Misc
    public void replace(int position, T value){
        data[position] = value;
    }

    @Override
    public String toString(){
        String x = "";
        for(int i = 0; i < currentPosition; i++){
            x = x + data[i] + " ";
        }
        return x + "}";
    }

    public void clear(){
        currentPosition = 0;
        data = (T[])new Object[0];
    }

    //write a toString to print something interesting

    //Clear array


}
