package co.edu.uptc.structures;

import java.lang.reflect.Array;
import java.util.ArrayList;
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
		Node <T> aux= head;
		int counter=0;

		while(aux!=null){
			counter++;
			aux = aux.getNext();
		}

		return counter;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		 Iterator<T> iter = new Iterator<T>() {
            Node<T> aux = head;

            @Override
            public boolean hasNext() {
                return aux != null;
            }

            @Override
            public T next() {
                T value = aux.getValue();
                aux = aux.getNext();
                return value;
            }

        };
        return iter;
	}

	@Override
	public Object[] toArray() {
	    Object[] array = new Object[size()];
	    Node<T> current = head;
	    int index = 0;
	    while (current != null) {
	        array[index++] = current.getValue();
	        current = current.getNext();
	    }
	    return array;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		 Iterator<?> it = c.iterator();
        while (it.hasNext()){
            if(!this.contains(it.next())){
                return false;
            }
        }
        return true;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		boolean modified = false;
        if ( c.isEmpty()) {
            modified = false; 
        }else{ 
                for (T dataCollection : c) {
                add(dataCollection); 
                modified = true;
            }
            }
        return modified; 
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
	    if (c == null) throw new NullPointerException("Collection cannot be null");
	    if (index < 0 || index > size()) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
	    if (c.isEmpty()) return false;

	    for (T element : c) {
	        if (element == null) throw new NullPointerException("Collection cannot contain null elements");
	    }

	    Node<T> prev = null;
	    Node<T> current = head;
	    for (int i = 0; i < index; i++) {
	        prev = current;
	        current = current.getNext();
	    }

	    for (T element : c) {
	        Node<T> newNode = new Node<>(element);
	        newNode.setNext(current);
	        if (prev == null) {
	            head = newNode;
	        } else {
	            prev.setNext(newNode);
	        }
	        prev = newNode;
	    }

	    return true;
	}
	@Override
	public boolean removeAll(Collection<?> c) {
		
		if (c == null) {
			throw new NullPointerException();
		}

		if (head == null) {
			return false;

		} else {
			Node<T> aux = head;
			Node<T> prev = aux;
			boolean delete = false;

			while (aux != null) {

				if (c.contains(aux.getValue())) {
					if (prev == null) {
						head = aux.getNext();
					} else {
						prev.setNext(aux.getNext());
					}
					delete = true;
				} else {
					prev = aux;
				}
				aux = aux.getNext();
			}
			return delete;
		}
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
		// TODO Auto-generated method stub

	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		Node<T> aux = head;
        int i = 0;
        while(aux != null){
            if(aux.getValue().equals(o)){
                return i;
            }
            i++;
            aux = aux.getNext();
        }
        return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		int index = -1;
		int currentPos = 0;
		Node<V> current = head;
		while (current != null) {
			if (current.data != null && current.data.equals(element) ||
					current.data == element) {
				index = currentPos;
			}
			current = current.next;
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
		if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        ArrayList<T> temp = new ArrayList<>();

        Node<T> current = head;
        while (current != null) {
            temp.add(current.getValue());
            current = current.getNext();
        }

        return temp.listIterator(index);
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		if(fromIndex<0 || toIndex>size() || fromIndex>toIndex){
            throw new IndexOutOfBoundsException();
        }
        SimpleList<T> subList = new SimpleList<>();
        Node<T> aux = head;
        int actualIndex=0;
        while(aux!=null && actualIndex<toIndex){
            if(actualIndex>=fromIndex){
                subList.add(aux.getValue());
            }
            aux=aux.getNext();
            actualIndex++;
        }
		return subList;
	}
}
