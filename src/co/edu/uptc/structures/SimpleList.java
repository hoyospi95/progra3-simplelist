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
		Node<T> temporalNode = head;

    while (temporalNode != null) {
        if (o == null) {
            if (temporalNode.getValue() == null) {
                return true;
            }
        } else {
            if (o.equals(temporalNode.getValue())) {
                return true;
            }
        }
        temporalNode = temporalNode.getNext();
    }

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
	public <E> E[] toArray(E[] a) {
		int size = size();
		if (a.length < size) {
			a = java.util.Arrays.copyOf(a, size);
		}
		Node<T> aux=this.head;
		int count = 0;
		while (aux != null) {
			a[count] = (E) aux.getValue();
			count++;
			aux = aux.getNext();
		}

		if (a.length > size) {
			a[size] = null;
		}
		return a;
	}

	@Override
    public boolean add(T e) {
        Node<T> newNode = new Node<>(e);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        return true;
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
			Node<T> prev = null;
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
		boolean modified = false;
		while (head != null && !c.contains(head.getValue())) {
			head = head.getNext();
			modified = true;
		}
		if (head == null) {
			return modified;
		}
		Node<T> prev = head;
		Node<T> current = head.getNext();
		while (current != null) {
			if (!c.contains(current.getValue())) {
				prev.setNext(current.getNext());
				modified = true;
			} else {
				prev = current;
			}
			current = current.getNext();
		}
		return modified;
	}

	@Override
	public void clear() {
		head=null;
	}

    @Override
    public T get(int index){
        int counter =0;

        if (index>=size() || index<0 ) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> next = head;
            while (counter< index) {
                next = next.getNext();
                counter++;
            }

        return next.getValue();
        
    }

	@Override
    public T set(int index, T element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        T oldValue = current.getValue();
        current.setValue(element);
        return oldValue;
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
            for (int i = 0; i < index; i++) {
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
        if (index < 0 || isEmpty()) {
            return null;
        }
        
        if (index == 0) {
            T data = head.getValue();
            head = head.getNext();
            return data;
        }
        Node<T> current = head;
        int currentPosition = 0;
        
        while (current.getNext() != null && currentPosition < index - 1) {
            current = current.getNext();
            currentPosition++;
        }
        
        if (current.getNext() == null) {
            return null;
        }
        
        T data = current.getNext().getValue();
        
        current.setNext(current.getNext().getNext());
        
        return data;
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
		/* el metodo ListIterator<t> es un metodo que trabaja con nodos next y previous,
		sin embargo la lista simple solo trabaja con nodos next, por lo que no tiene validez implementarlo
		en este caso */
		
		throw new UnsupportedOperationException("ListIterator no es soportado en una lista simplemente enlazada");
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		throw new UnsupportedOperationException("listIterator(int index) no es soportado en lista simplemente enlazada");
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (o instanceof SimpleList) {
            SimpleList<?> that = (SimpleList<?>) o;
            if (this.size() != that.size()) return false;
            for (int i = 0; i < this.size(); i++) {
                T thisElem = this.get(i);
                Object thatElem = that.get(i);
                if (thisElem == null) {
                    if (thatElem != null) return false;
                } else {
                    if (!thisElem.equals(thatElem)) return false;
                }
            }
            return true;
        }
        if (o instanceof List) {
            List<?> thatList = (List<?>) o;
            if (this.size() != thatList.size()) return false;
            for (int i = 0; i < this.size(); i++) {
                T thisElem = this.get(i);
                Object thatElem = thatList.get(i);
                if (thisElem == null) {
                    if (thatElem != null) return false;
                } else {
                    if (!thisElem.equals(thatElem)) return false;
                }
            }
            return true;
        }
        return false;
    }

}
