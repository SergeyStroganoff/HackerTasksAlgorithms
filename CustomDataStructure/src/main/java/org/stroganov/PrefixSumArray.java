package org.stroganov;

import java.util.ArrayList;
import java.util.List;

public class PrefixSumArray {
    private List<Long> prefixSum = new ArrayList<>();
    private final List<Integer> arrayList = new ArrayList<>();

    public PrefixSumArray(List<Integer> arrayList) {
        for (Integer value : arrayList) {
            add(value);
        }
    }

    public PrefixSumArray() {
    }

    private void recalculate(int index) {
        for (int i = index; i < arrayList.size(); i++) {
            if (i > 0) {
                prefixSum.set(i, prefixSum.get(i - 1) + arrayList.get(i));
            } else {
                prefixSum.set(i, Long.valueOf(arrayList.get(0)));
            }
        }
    }

    public void add(Integer value) {
        arrayList.add(value);
        if (prefixSum.isEmpty()) {
            prefixSum.add(0, Long.valueOf(value));
        } else {
            prefixSum.add(prefixSum.get(prefixSum.size() - 1) + value);
        }
    }

    public void remove(int index) {
        arrayList.remove(index);
        prefixSum.remove(index);
        recalculate(index);
    }

    public long getSumArray(int start, int end) {
        if (start < 0 || end >= arrayList.size() || end > start) {
            throw new IndexOutOfBoundsException();
        }
        if (start == 0) {
            return prefixSum.get(end);
        } else {
            return prefixSum.get(end) - prefixSum.get(start - 1);
        }
    }
}
