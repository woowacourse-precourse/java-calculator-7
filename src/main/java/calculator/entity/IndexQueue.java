package calculator.entity;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class IndexQueue {

    private final Queue<Index> queue;

    public IndexQueue() {
        this.queue = new PriorityQueue<>();
    }

    public void offer(Index index) {
        queue.offer(index);
    }

    public Index peek() {
        return queue.peek();
    }

    public void poll() {
        queue.poll();
    }

    public boolean isIndexProcess(Index index) {
        if (queue.isEmpty()) {
            return false;
        }

        Index peekIdx = this.peek();
        return index.equals(peekIdx);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Queue<Index> comapereQueue = ((IndexQueue) o).queue;
        return Objects.equals(queue, comapereQueue);
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
