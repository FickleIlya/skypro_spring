package com.example.ficklecalculator.ServiceImpls;

import com.example.ficklecalculator.Services.IntegerListInterface;

import java.util.Objects;

public class IntegerList implements IntegerListInterface {

    private final Integer[] list;
    private int size;

    public IntegerList( Integer length ) {
        if (length < 0) {
            throw new IllegalArgumentException("Illegal length: "+ length);
        }
        this.list = new Integer[length];
        this.size = 0;
    }

    @Override
    public Integer add(Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("Item is null");
        }

        if (size == list.length) {
            throw new IllegalStateException("List is full");
        }
        list[size] = item;
        size++;
        return item;

    }

    @Override
    public Integer add(int index, Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("Item is null");
        }

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: "+ index + ", Size " + size);
        }
        if (size == list.length) {
            throw new IllegalStateException("List is full");
        }
        for (int i = size - 1; i >= index; i--) {
            list[i+1] = list[i];
        }
        list[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("Item is null");
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: "+ index + ", Size " + size);
        }
        list[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("Item is null");
        }

        for (int i = 0; i < size; i++) {
            if (item.equals(list[i])) {
                for (int j = i; j < size - 1; j++) {
                    list[j] = list[j+1];
                }
                size--;
                return item;
            }
        }
        return null;
    }

    @Override
    public Integer remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: "+ index + ", Size " + size);
        }
        Integer item = list[index];
        for (int i = index; i < size - 1; i++) {
            list[i] = list[i+1];
        }
        size--;
        return item;
    }

    @Override
    public int indexOf(Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("Item is null");
        }

        for (int i = 0; i < size; i++) {
            if (item.equals(list[i])) {
                return i;
            }
        }
        return -1;

    }

    @Override
    public int lastIndexOf(Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("Item is null");
        }

        for (int i = size - 1; i >= 0; i--) {
            if (item.equals(list[i])) {
                return i;
            }
        }
        return -1;

    }

    @Override
    public Integer get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: "+ index + ", Size " + size);
        }
        return list[index];

    }

    @Override
    public boolean equals(IntegerListInterface otherList) {
        if (otherList == null) {
            throw new IllegalArgumentException("Other list is null");
        }

        if (size != otherList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!list[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            list[i] = null;
        }
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        Integer[] array = new Integer[size];
        System.arraycopy(list, 0, array, 0, size);
        return array;
    }

    public void sortInsertion() {
        for (int i = 1; i < list.length; i++) {
            int temp = list[i];
            int j = i;
            while (j > 0 && list[j - 1] >= temp) {
                list[j] = list[j - 1];
                j--;
            }
            list[j] = temp;
        }
    }

    @Override
    public boolean contains(Integer element) {
        int min = 0;
        int max = list.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (Objects.equals(element, list[mid])) {
                return true;
            }

            if (element < list[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

}
