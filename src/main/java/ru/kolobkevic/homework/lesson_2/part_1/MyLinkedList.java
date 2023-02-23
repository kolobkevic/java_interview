package ru.kolobkevic.homework.lesson_2.part_1;

import java.util.NoSuchElementException;

public class MyLinkedList<E> {
    private int size = 0;
    private Point<E> first;
    private Point<E> last;

    public MyLinkedList() {
    }

    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    public void addFirst(E e) {
        linkFirst(e);
    }

    public void addLast(E e) {
        linkLast(e);
    }

    public void add(int index, E element) {
        checkIndex(index);

        if (index == size)
            linkLast(element);
        else
            link(element, point(index));
    }

    private void checkIndex (int index){
        if (!isValidIndex(index))
            throw new IndexOutOfBoundsException(index);
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index <= size;
    }

    public E removeFirst(E e) {
        Point<E> f = first;
        if (f == null) {
            throw new NoSuchElementException();
        }
        return unlinkFirst(f);
    }

    public E removeLast(E e) {
        Point<E> l = last;
        if (l == null) {
            throw new NoSuchElementException();
        }
        return unlinkLast(l);
    }

    public boolean remove(Object obj) {
        if (obj == null) {
            for (Point<E> p = first; p != null; p = p.next) {
                if (p.item == null) {
                    unlink(p);
                    return true;
                }
            }
        } else {
            for (Point<E> p = first; p != null; p = p.next) {
                if (obj.equals(p.item)) {
                    unlink(p);
                    return true;
                }
            }
        }
        return false;
    }

    public E remove(int index) {
        checkIndex(index);
        return unlink(point(index));
    }

    private void linkFirst(E e) {
        Point<E> f = first;
        Point<E> newPoint = new Point<>(e, null, f);
        first = newPoint;
        if (f == null) {
            last = newPoint;
        } else {
            f.previous = newPoint;
        }
        size++;
    }

    private void linkLast(E e) {
        Point<E> l = last;
        Point<E> newPoint = new Point<>(e, l, null);
        last = newPoint;
        if (l == null) {
            first = newPoint;
        } else {
            l.next = newPoint;
        }
        size++;
    }

    private void link(E e, Point<E> point) {
        Point<E> prev = point.previous;
        Point<E> newPoint = new Point<>(e, prev, point);
        point.previous = newPoint;
        if (prev == null) {
            first = newPoint;
        } else {
            prev.next = newPoint;
        }
        size++;
    }

    private E unlinkFirst(Point<E> f) {
        Point<E> next = f.next;
        E element = f.item;
        f.next = null;
        f.item = null;
        first = next;
        if (next == null) {
            last = null;
        } else {
            next.previous = null;
        }
        size--;
        return element;
    }

    private E unlinkLast(Point<E> l) {
        Point<E> previous = l.previous;
        E element = l.item;
        l.previous = null;
        l.item = null;
        last = previous;
        if (previous == null) {
            first = null;
        } else {
            previous.next = null;
        }
        size--;
        return element;
    }

    private E unlink(Point<E> p) {
        E element = p.item;
        Point<E> previous = p.previous;
        Point<E> next = p.next;

        if (previous == null) {
            first = next;
        } else {
            previous.next = next;
            p.previous = null;
        }
        if (next == null) {
            last = previous;
        } else {
            next.previous = previous;
            p.next = null;
        }

        p.item = null;
        size--;
        return element;
    }

    Point<E> point(int index) {
        Point<E> p;
        if (index < (size / 2)) {
            p = first;
            for (int i = 0; i < index; i++)
                p = p.next;
        } else {
            p = last;
            for (int i = size - 1; i > index; i--) {
                p = p.previous;
            }
        }
        return p;
    }

    public E get (int index){
        checkIndex(index);
        return point(index).item;
    }

    public E getFirst() {
        Point<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return f.item;
    }

    public E getLast() {
       Point<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return l.item;
    }

    private static class Point<E> {
        E item;
        Point<E> previous;
        Point<E> next;

        public Point(E item, Point<E> previous, Point<E> next) {
            this.item = item;
            this.previous = previous;
            this.next = next;
        }
    }
}
