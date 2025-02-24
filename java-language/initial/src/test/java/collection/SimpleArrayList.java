package collection;

public class SimpleArrayList implements SimpleList {
    private String[] values = new String[0];
    private int SIZE = 0;

    @Override
    public boolean add(String value) {
        add(SIZE, value);
        return true;
    }

    @Override
    public void add(int index, String value) {
        if (values.length == SIZE) {
            String[] newValues = new String[SIZE + 1];
            for (int i = 0; i < index; i++) {
                newValues[i] = values[i];
            }
            newValues[index] = value;
            for (int i = index; i < SIZE; i++) {
                newValues[i + 1] = values[i];
            }
            values = newValues;
        }
        SIZE++;
    }

    @Override
    public String set(int index, String value) {
        String previousValue = values[index];
        values[index] = value;
        return previousValue;
    }

    @Override
    public String get(int index) {
        return values[index];
    }

    @Override
    public boolean contains(String value) {
        for (String element : values) {
            return element.equals(value);
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        for (int index = 0; index < SIZE; index++) {
            if (values[index].equals(value)) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return SIZE == 0;
    }

    @Override
    public boolean remove(String value) {
        int index = indexOf(value);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public String remove(int index) {
        String ret = values[index];
        for (int i = index + 1; i < SIZE; i++) {
            values[i - 1] = values[i];
        }
        SIZE--;
        return ret;
    }

    @Override
    public void clear() {
        values = new String[0];
        SIZE = 0;
    }
}
