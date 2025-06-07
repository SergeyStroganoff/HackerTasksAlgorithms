package org.stroganov.monostack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * A generic implementation of a monotonic stack that maintains elements
 * in strictly increasing or non-increasing order (default: increasing).
 * <p>
 * This implementation supports generic types that implement {@link Comparable}.
 * When a new value is pushed, all elements greater than or equal to it are removed.
 * This makes it useful for problems like "nearest smaller element to the left".
 *
 * @param <T> the type of elements held in this stack, must be comparable
 */
public class MonoStack<T extends Comparable<T>> {
    private final Deque<T> stack = new ArrayDeque<>();

    /**
     * Pushes a new value onto the stack after removing all elements
     * that are greater than or equal to it, thus maintaining monotonicity.
     *
     * @param value the value to push
     * @return the value that was pushed
     */


    public T push(T value) {
        while (!stack.isEmpty() && stack.peek().compareTo(value) >= 0) {
            stack.pop();
        }
        stack.push(value);
        return value;
    }

    /**
     * Returns the nearest smaller element (on the left) in the current stack
     * compared to the given value. If no such element exists, returns {@code null}.
     * <p>
     * Note: This operation mutates the stack by removing greater elements.
     *
     * @param value the value to compare against
     * @return the nearest smaller element, or {@code null} if none exists
     */

    public T getNearestSmallerIndex(T value) {
        while (!stack.isEmpty() && stack.peek().compareTo(value) >= 0) {
            stack.pop();
        }
        if (stack.isEmpty()) {
            return null;
        } else return stack.peek();
    }

    /**
     * Clears all elements from the stack.
     */
    public void clear() {
        stack.clear();
    }
}
