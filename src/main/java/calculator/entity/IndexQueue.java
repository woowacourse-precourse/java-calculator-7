package calculator.entity;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class IndexQueue {

    private final Queue<Integer> queue;

    public IndexQueue() {
        this.queue = new PriorityQueue<>();
    }


    public void offer(Index index) {
        Integer idx = index.value;
        queue.offer(idx);
    }


    public void poll() {
        queue.poll();
    }

    public boolean isIndexProcess(Index index) {
        if (queue.isEmpty()) {
            return false;
        }

        Integer idx = index.value;
        Integer peekIdx = queue.peek();

        return idx.equals(peekIdx);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Queue<Integer> compareQueue = ((IndexQueue) o).queue;
        return Objects.equals(queue, compareQueue);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(queue);
    }

    @Override
    public String toString() {
        return "IndexQueue{" + "queue=" + queue + '}';
    }
}
