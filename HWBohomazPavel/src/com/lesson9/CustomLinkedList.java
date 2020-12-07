package com.lesson9;

public class CustomLinkedList<E> implements CustomCollection<E> {

    private int size = 0;

    Link<E> first;
    Link<E> last;

    public CustomLinkedList() {
        this.first = new Link<>(null, first, first);
        this.last = first;
    }

    @Override
    public boolean add(E o) {
        Link<E> newLink = new Link<>(o, first, last);
        last.next = newLink;
        first.prev = newLink;
        last = newLink;
        size++;
        return true;
    }

    @Override
    public boolean add(int index, E o) {
        if (index > size) return false;
        Link current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Link<E> newLink = new Link<>(o, current.next, current);
        current.next.prev = newLink;
        current.next = newLink;
        if (index == size) last = newLink;
        size++;
        return true;
    }

    @Override
    public boolean addAll(E[] array) {
        for (int i = 0; i < array.length; i++) {
            add(array[i]);
        }
        return true;
    }

    @Override
    public boolean addAll(CustomCollection<E> coll) { ;
        CustomLinkedList<?> that = (CustomLinkedList<?>) coll;
        Link<E> current = (Link<E>) that.first.next;
        for (int i = 0; i < coll.size(); i++) {
            add(current.data);
            current = current.next;
        }
        return true;
    }

    @Override
    public boolean delete(int index) {
        if (index >= size) return false;
        Link<E> current = first;
        for (int i = 0; i <= index; i++) {
            current = current.next;
        }

        return delLink(current);
    }

    @Override
    public boolean delete(E o) {
        Link<E> current = first.next;
        for (int i = 0; i < size; i++) {
            if (current.data == o) {
                return delLink(current);
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public E get(int index) {
        Link<E> current = first.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public boolean contains(E o) {
        Link<E> current = first.next;
        E t = current.data;
        for (int i = 0; i < size; i++) {
            if (current.data == o) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean clear() {
        first.next = first;
        first.prev = first;
        last = first;
        size = 0;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean trim() {
        return true;
    }

    @Override
    public boolean compare(CustomCollection<E> coll) {
        if (this == coll) return true;
        if (size != coll.size()) return false;
        CustomLinkedList<?> that = (CustomLinkedList<?>) coll;
        for (int i = 0; i < size; i++) {
            if (!this.get(i).equals(that.get(i))) return false;
        }
        return true;
    }

    @Override
    public E getFirst() {
        return first.next.data;
    }

    @Override
    public E getLast() {
        return last.data;
    }


    @Override
    public String toString() {
        String res = "[";
        Link current = first.next;
        for (int i = 0; i < size; i++) {
            if (i < size - 1) {
                res += current.data + ", ";
            } else res += current.data;
            current = current.next;
        }
        res += "]";
        return res;
    }

    private boolean delLink(Link<E> link) {
        if (link.next == first) last = link.prev;
        link.next.prev = link.prev;
        link.prev.next = link.next;
        link.next = null;
        link.prev = null;
        size--;
        return true;
    }

}
