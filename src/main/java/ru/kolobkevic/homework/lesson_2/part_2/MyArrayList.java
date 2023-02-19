package ru.kolobkevic.homework.lesson_2.part_2;

import java.util.Arrays;

public class MyArrayList<E> {
    private Object[] elements;
    private int size = 0;

    public MyArrayList() {
        this.elements = new Object[]{};
    }

    public MyArrayList(int capacity) {
        if (capacity > 0) {
            this.elements = new Object[capacity];
        } else if (capacity == 0) {
            this.elements = new Object[]{};
        } else {
            throw new IllegalArgumentException();
        }
    }

    private Object[] grow() {
        return grow(size + 1);
    }

    private Object[] grow(int capacity) {
        return elements = Arrays.copyOf(elements, newCapacity(capacity));
    }

    private int newCapacity(int capacity) {
        int oldCapacity = elements.length;
        if(oldCapacity == 0){
            return 1;
        }
        return oldCapacity + (capacity / 2);
    }

    private void checkRange(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(index);
    }

    public boolean add(E e) {
        if (size == elements.length) {
            elements = grow();
        }
        elements[size] = e;
        size++;
        return true;
    }

    public void add(int index, E element) {
        checkRange(index);

        int s;
        Object[] elements;

        if ((s = size) == (elements = this.elements).length) {
            elements = grow();
        }
        System.arraycopy(elements, index, elements, index + 1, s - index);
        elements[index] = element;
        size = s + 1;
    }

    public E remove(int index) {
        checkRange(index);

        E oldValue = (E) elements[index];
        removeAt(elements, index);

        return oldValue;
    }

    public boolean remove(Object obj) {
        int size = this.size;

        if (obj == null) {
            for (int i = 0; i < size; i++)
                if (elements[i] == null){
                    removeAt(elements, i);
                    return true;
                }
        } else {
            for (int i = 0; i < size; i++)
                if (obj.equals(elements[i])){
                    removeAt(elements, i);
                    return true;
                }
        }
        return false;
    }

    private void removeAt(Object[] elem, int i) {
        int newSize;
        if ((newSize = size - 1) > i) {
            System.arraycopy(elem, i + 1, elem, i, newSize - i);
        }
        elem[size = newSize] = null;
    }

    public E get(int index) {
        checkRange(index);
        return (E) elements[index];
    }
}
