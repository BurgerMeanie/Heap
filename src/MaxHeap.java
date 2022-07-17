import java.util.ArrayList;

public class MaxHeap<T extends Comparable<T>> {
    protected ArrayList<T> heap;
    protected int size;

    public MaxHeap(){
        this.heap = new ArrayList<>();
        this.size = 0;
    }

    //insert
    public void insert(T data){
        //add the data at the end of the heap
        this.heap.add(data);

        //increase the size
        this.size = this.size + 1;

        //heapify up
        this.heapifyUp(this.size - 1);

    }

    //extract
    protected T extract(){
        if(this.size > 0){
            //get whatever is at the top if the heap
            T temp = this.heap.get(0);

            //move the end of the heap to the front
            this.heap.set(0, this.heap.get(this.size - 1));
            //remove the end node
            this.heap.remove(this.size - 1);
            //decrease size
            this.size = this.size - 1;

            if(this.size > 1){
                //heapify
                this.heapifyDown(0);
            }
            return temp;
        }
        //the heap is empty
        return null;
    }

    //heapifyUp
    protected void heapifyUp(int index){
        // get the parent index
        int parentIndex = (int) Math.floor((index - 1) / 2);

        // test is the parent bigger than the child
        T parent = this.heap.get(parentIndex);
        T child = this.heap.get(index);
        if (parent.compareTo(child) < 0){
            // swap it
            this.heap.set(parentIndex, child);
            this.heap.set(index, parent);

            //recurse
            this.heapifyUp(parentIndex);
        }
    }

    //heapifyDown
    protected void heapifyDown(int index){
        //get the left and right children indices
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        //set the max to the one that we are heapifying
        int maxIndex = index;

        //figure out which of values is the max
        if(leftIndex < this.size && this.heap.get(leftIndex).compareTo(this.heap.get(maxIndex)) > 0){
            maxIndex = leftIndex;
        }

        if(rightIndex < this.size && this.heap.get(rightIndex).compareTo(this.heap.get(maxIndex)) > 0){
            maxIndex = rightIndex;
        }

        //do we need to swap and keep heapifying
        if(maxIndex != index){
            //swap
            T temp = this.heap.get(index);
            this.heap.set(index, this.heap.get(maxIndex));
            this.heap.set(maxIndex, temp);

            //recurse
            this.heapifyDown(maxIndex);
        }
    }

    /***
     * This method should essentially change the heap into an ordered list
     *
     * Because insert should be the only method used to add data to
     * the list, we will not be doing an initial heapify - it should
     * already be a valid heap. Instead, we will be extracting, and
     * ensuring we do not touch the extracted data. The extracted data
     * will be placed at the end of the ArrayList.
     *
     * 1. Swap the data at the top of the heap with the data at
     * the end of the ArrayList.
     * 2. HeapifyDown the data that is at the top of the list, without
     * moving the data we have already swapped to the bottom.
     * 3. Continue until the entire heap is sorted.
     *
     * @return sortedList
     */
    protected void sort(){
        if(this.heap.size() > 0){
            /*
            A heap of two would just need swapped, so we just swap them here
            with their own method. This is helpful because the formulas for
            larger heaps don't work with a heap size of two.
             */
            if(this.heap.size() == 2){
                //get whatever is at the top if the heap
                T temp = this.heap.get(0);

                //move the end of the heap to the front
                this.heap.set(0, this.heap.get(this.heap.size() - 1));

                //move the top of the heap to the bottom
                this.heap.set(this.heap.size() - 1, temp);
            }
            for(int i = 1; i < this.heap.size() - 1; i++) {
                //get whatever is at the top if the heap
                T temp = this.heap.get(0);

                //move the end of the heap to the front
                this.heap.set(0, this.heap.get(this.heap.size() - i));

                //move the top of the heap to the bottom
                this.heap.set(this.heap.size() - i, temp);
                int index = 0;

                while(index < this.heap.size() - i) {
                    //get the left and right children indices
                    int leftIndex = 2 * index + 1;
                    int rightIndex = 2 * index + 2;
                    if (leftIndex >= this.heap.size() - i || rightIndex >= this.heap.size() - i){
                        break;
                    }

                    //set the max to the one that we are heapifying
                    int maxIndex = index;

                    //figure out which of values is the max
                    if (leftIndex < this.heap.size() && this.heap.get(leftIndex).compareTo(this.heap.get(maxIndex)) > 0) {
                        maxIndex = leftIndex;
                    }

                    if (rightIndex < this.heap.size() && this.heap.get(rightIndex).compareTo(this.heap.get(maxIndex)) > 0) {
                        maxIndex = rightIndex;
                    }

                    //do we need to swap and keep heapifying
                    if (maxIndex != index) {
                        //swap
                        T temp1 = this.heap.get(index);
                        this.heap.set(index, this.heap.get(maxIndex));
                        this.heap.set(maxIndex, temp1);
                        index = maxIndex;
                    } else {
                        index = this.heap.size();
                    }
                }
            }
        }
    }
}