package heaps;

import java.util.List;
import java.util.ArrayList;

public class Heap {
    private List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    public void insert(int value) {
        heap.add(value);
        int index = heap.size() - 1;

        while (value > heap.get(parent(index)) && index > 0) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public Integer remove() {
        if (heap.size() == 0) return null;
        if (heap.size() == 1) return heap.remove(0);

        int maxValue = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));

        sinkDown(0);

        return maxValue;
    }

    private void sinkDown(int index) {
        int maxIndex = index;

        while(true) {
            int leftIndex = getLeftChildIndex(index);
            int rightIndex = getRightChildIndex(index);

            if (leftIndex < heap.size() && heap.get(leftIndex) > heap.get(index)) {
                maxIndex = leftIndex;
            }

            if (rightIndex < heap.size() && heap.get(rightIndex) > heap.get(maxIndex)) {
                maxIndex = rightIndex;
            }

            if (maxIndex != index) {
                swap(maxIndex, index);
                index = maxIndex;
            } else {
                return;
            }
        }
    }

    public int getLeftChildIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    public int getRightChildIndex(int parentIndex) {
        return parentIndex * 2 + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }
}
