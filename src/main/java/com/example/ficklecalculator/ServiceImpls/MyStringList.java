package com.example.ficklecalculator.ServiceImpls;

import com.example.ficklecalculator.Services.StringList;
import java.util.Arrays;

public class MyStringList implements StringList {

    private final String[] list;
    private int size;

    public MyStringList( Integer length ) {
        if (length < 0) {
            throw new IllegalArgumentException("Illegal length: "+ length);
        }
        this.list = new String[length];
        this.size = 0;
    }


    @Override
    public String add(String item) {
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
    public String add(int index, String item){
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
    public String set(int index, String item) {
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
    public String remove(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Item is null");
        }

        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                for (int j = i; j < size - 1; j++) {
                    list[j] = list[j+1];
                }
            }
        }
        size--;
        return item;
    }

    @Override
    public String remove(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: "+ index + ", Size " + size);
        }
        String item = list[index];
        for (int i = index; i < size - 1; i++) {
            list[i] = list[i+1];
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Item is null");
        }
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Item not found: " + item);
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Item not found: " + item);
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: "+ index + ", Size " + size);
        }
        return list[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return otherList == this;
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
        Arrays.fill(list, null);
        size = 0;
    }

    @Override
    public String[] toArray() {
        String[] array = new String[size];
        System.arraycopy(list, 0, array, 0, size);
        return array;
    }
}
