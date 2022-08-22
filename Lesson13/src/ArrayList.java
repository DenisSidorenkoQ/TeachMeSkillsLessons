public class ArrayList <T>
{
    private Object[] array;
    private int length;

    public ArrayList()
    {
    }

    public ArrayList(int size)
    {
        length = size;
        array = new Object[length];
    }

    public int getLength()
    {
        return length;
    }

    public ArrayList(final T[] array)
    {
        this.array = array;
        this.length = array.length;
    }

    public void addToTheEnd(final T newElement)
    {
        length++;
        Object[] bufferArray = new Object[length];

        if(length > 1)
        {
            System.arraycopy(array, 0, bufferArray, 0, array.length);
        }

        bufferArray[bufferArray.length - 1] = (Object) newElement;
        array = bufferArray;
    }

    public void add(final int position, final T newElement)
    {
        length++;
        Object[] bufferArray = new Object[length];

        System.arraycopy(array, 0, bufferArray, 0, position);
        bufferArray[position] = (Object) newElement;
        System.arraycopy(array, position, bufferArray, position + 1, array.length - position);

        array = bufferArray;
    }

    public void remove(final int position)
    {
        length--;
        Object[] bufferArray = new Object[length];

        System.arraycopy(array, 0, bufferArray, 0, position);
        System.arraycopy(array, position + 1, bufferArray, position, array.length - position - 1);

        array = bufferArray;
    }

    public T get(int index)
    {
        return (T) array[index];
    }

    public boolean check(T element)
    {
        for (int i = 0; i < length; i++)
        {
            if (array[i].equals(element))
            {
                return true;
            }
        }
        return false;
    }

    public void clear()
    {
        length = 0;
        array = new Object[length];
    }

    public String toString()
    {
        String bufferString = "";
        for(int i = 0; i < length; i++)
        {
            bufferString += (String) array[i] + " ";
        }
        return bufferString;
    }
}
