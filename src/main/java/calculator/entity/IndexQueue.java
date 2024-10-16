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
        queue.offer(index.value);
    }


    public void poll() {
        queue.poll();
    }

    public boolean isIndexProcess(Index index) {
        if (queue.isEmpty()) {
            return false;
        }

        return index.value == queue.peek();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IndexQueue that = (IndexQueue) o;
        return Objects.equals(queue, that.queue);
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
