package calculator.entity;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class IndexQueue {

    private final Queue<Integer> queue;

    public IndexQueue() {
        this.queue = new PriorityQueue<>();
    }

    public void offer(Integer integer) {
        if (integer < 0) {
            throw new IllegalArgumentException("Index must be positive");
        }

        queue.offer(integer);
    }

    public void poll() {
        queue.poll();
    }

    public boolean isIndexProcess(int idx) {
        if (queue.isEmpty()) {
            return false;
        }

        return idx == queue.peek();
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
}
