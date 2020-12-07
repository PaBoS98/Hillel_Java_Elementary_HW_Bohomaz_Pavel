package com.lesson9;

public class Link<E> {
    public E data;
    public Link<E> next;
    public Link<E> prev;

    public Link(E data, Link<E> next, Link<E> prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public void getLinks() {
        System.out.println(">>> " + data + " <<<");
        System.out.println(">> " + next.data);
        System.out.println("<< " + prev.data);
    }
}
