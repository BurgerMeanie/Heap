import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxHeapTest {
    @Test
    public void testHeapifyUp(){
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        maxHeap.heap.add(11);
        maxHeap.heap.add(5);
        maxHeap.heap.add(8);
        maxHeap.heap.add(3);
        maxHeap.heap.add(4);
        maxHeap.heap.add(15);

        maxHeap.size = 6;

        maxHeap.heapifyUp(5);
        assertEquals(15, maxHeap.heap.get(0));
    }

    @Test
    public void testInsert() {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        maxHeap.insert(0);
        maxHeap.insert(100);
        maxHeap.insert(40);
        maxHeap.insert(1);
        maxHeap.insert(75);
        maxHeap.insert(50);

        assertEquals("[100, 75, 50, 0, 1, 40]", maxHeap.heap.toString());
    }

    @Test
    public void testHeapifyDown() {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        maxHeap.heap.add(1);
        maxHeap.heap.add(11);
        maxHeap.heap.add(5);
        maxHeap.heap.add(8);
        maxHeap.heap.add(3);
        maxHeap.heap.add(4);

        maxHeap.size = 6;
        maxHeap.heapifyDown(0);

        assertEquals(11, maxHeap.heap.get(0));
        assertEquals("[11, 8, 5, 1, 3, 4]", maxHeap.heap.toString());
    }

    @Test
    public void testExtractFullHeap(){
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        maxHeap.heap.add(11);
        maxHeap.heap.add(5);
        maxHeap.heap.add(8);
        maxHeap.heap.add(3);
        maxHeap.heap.add(4);
        maxHeap.heap.add(1);

        maxHeap.size = 6;

        assertEquals(11, maxHeap.extract());
        assertEquals(5, maxHeap.size);
        assertEquals(8, maxHeap.extract());
        assertEquals(5, maxHeap.extract());
        assertEquals(4, maxHeap.extract());
        assertEquals(3, maxHeap.extract());
        assertEquals(1, maxHeap.extract());
        assertEquals(null, maxHeap.extract());
    }

    @Test
    public void testSort(){
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        maxHeap.insert(32);
        maxHeap.insert(432);
        maxHeap.insert(3);
        maxHeap.insert(4124);
        maxHeap.insert(5);
        maxHeap.insert(654);
        maxHeap.insert(322);
        maxHeap.insert(578);
        maxHeap.insert(87);
        maxHeap.insert(1);
        maxHeap.insert(2);

        maxHeap.sort();

        assertEquals("[1, 2, 3, 5, 32, 87, 322, 432, 578, 654, 4124]", maxHeap.heap.toString());
    }

    @Test
    public void testSortWithOneData(){
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        maxHeap.insert(32);

        maxHeap.sort();

        assertEquals("[32]", maxHeap.heap.toString());
    }

    @Test
    public void testSortWithTwoData(){
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        maxHeap.insert(32);
        maxHeap.insert(2);

        maxHeap.sort();

        assertEquals("[2, 32]", maxHeap.heap.toString());
    }
}