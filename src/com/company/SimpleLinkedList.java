package com.company;

import java.util.Iterator;

public class SimpleLinkedList<T> implements Iterable<T> {

    //класс исключений
    public static class SimpleLinkedListException extends Exception {
        public SimpleLinkedListException(String message) {
            super(message);
        }
    }

    private class SimpleLinkedListNode {
        public T value;
        public SimpleLinkedListNode next; //ссылка на следующий элемент списка

        public SimpleLinkedListNode(T value, SimpleLinkedListNode next) {
            this.value = value;
            this.next = next;
        }

        public SimpleLinkedListNode(T value) {
            this(value, null);
        }
    }

    private SimpleLinkedListNode first; //head
    private SimpleLinkedListNode last; //tail
    private int size = 0;

    //добавить в начало
    public void addFirst(T value) {
        first = new SimpleLinkedListNode(value, first);
        if (size == 0) {
            last = first;
        }
        size++;
    }

    //добавить в конец
    public void addLast(T value) {
        if (size == 0) {
            first = last = new SimpleLinkedListNode(value);
        } else {
            last.next = new SimpleLinkedListNode(value);
            last = last.next;
        }
        size++;
    }

    //получить
    public T getFirst() throws SimpleLinkedListException {
        checkEmptyError();
        return first.value;
    }

    public T getLast() throws SimpleLinkedListException {
        checkEmptyError();
        return last.value;
    }

    //получение по индексу
    public T get(int index) throws SimpleLinkedListException {
        checkEmptyError();
        return getNode(index).value;
    }

    private SimpleLinkedListNode getNode(int index) {
        SimpleLinkedListNode curr = first;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    //проверка на исключения
    private void checkEmptyError() throws SimpleLinkedListException {
        if (size == 0) {
            throw new SimpleLinkedListException("Empty list");
        }
    }

    //удаление с начала
    public void removeFirst() throws SimpleLinkedListException {
        checkEmptyError();
        first = first.next;
        if (size == 1) {
            last = null;
        }
        size--;
    }

    //удаление с конца
    public void removeLast() throws SimpleLinkedListException {
        checkEmptyError();
        if (size == 1) {
            first = last = null;
        } else {
            last = getNode(size - 2);
            last.next = null;
        }
        size--;
    }

    //удаление по индексу
    public void remove(int index) throws SimpleLinkedListException {
        checkEmptyError();
        if (index < 0 || index >= size) {
            throw new SimpleLinkedListException("Incorrect index");
        }
        if (index == 0) {
            removeFirst();
        } else {
            SimpleLinkedListNode prev = getNode(index - 1);
            prev.next = prev.next.next;
            if (prev.next == null) {
                last = prev;
            }
            size--;
        }

    }

    //количество элементов в списке
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        class SimpleLinkedListIterator implements Iterator<T> {
            SimpleLinkedListNode curr = first;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public T next() {
                T value = curr.value;
                curr = curr.next;
                return value;
            }
        }

        return new SimpleLinkedListIterator();
    }


}
