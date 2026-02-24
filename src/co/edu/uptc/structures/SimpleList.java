package co.edu.uptc.structures;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SimpleList<T> implements List<T> {
    private Node<T> head;

    public SimpleList() {
    	head = null;
    }

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(T e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object o) {
		boolean isFounded = false;
		Node<T> actual = head;
		Node<T> previous = head;
		
		if (head != null && head.getValue().equals(o)){
			head = head.getNext();
		}
		else{
			while (actual != null && !isFounded){
				if (actual.getValue().equals(o)){
					previous.setNext(actual.getNext());
					isFounded = true;
				}else{
					previous = actual;
					actual = actual.getNext();
				}
			}
		}
		return isFounded;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T set(int index, T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, T element) {
		int size = 0;
        Node<T> tail = null;
        Node<T> newNode = new Node<T>(element);
        //excepciones
        Node<T> temp = head;

        while (temp != null) {
            tail = temp;        
            temp = temp.getNext();
            size++;
        }
        //si el indice esta por debajo o por fuera
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        //si se ingresa un  objeto nulo
        if (element == null) {
            throw new NullPointerException();
        }
        //si la lista esta vacia
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } //INSERTAR AL PRINCIPIO
        else if (index == 0) {
            newNode.setNext(head);
            head = newNode;
            //si esta al final
        } else {
            Node<T> currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }

            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
            if (index == size) {
                tail.setNext(newNode);
                tail = newNode;
            }
        }
	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		int index = -1;
		int currentPos = 0;
		Node<T> current = head;
		while (current != null) {
			if (current.getValue() != null && current.getValue().equals(o) ||
					current.getValue() == o) {
				index = currentPos;
			}
			current = current.getNext();
			currentPos++;
		}
		return index;
	}

	@Override
	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
}
