package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAYS_LENGTH = 10;

    private K[] keys;
    private V[] values;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keys = (K[]) new Object[ARRAYS_LENGTH];
        values = (V[]) new Object[ARRAYS_LENGTH];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null && key == null) {
                values[i] = value;
                return;
            } else if (keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }

        if (size < ARRAYS_LENGTH) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            throw new IllegalStateException("Storage is full");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null && key == null) {
                return values[i];
            } else if (keys[i] != null && keys[i].equals(key)) {
                return values[i];
            }
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
