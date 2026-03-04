package core.basesyntax;

import core.basesyntax.impl.StorageImpl;

public class Main {
    public static void main(String[] args) {
        Storage<Integer, Box<String>> storage = new StorageImpl<>();

        storage.put(1, new Box<>("Milk"));
        storage.put(2, new Box<>("Apple"));
        storage.put(1, new Box<>("Meat"));

        System.out.println(storage.get(1));
        System.out.println(storage.get(2));
        System.out.println(storage.size());

        Box<String> box = storage.get(1);
        System.out.println(box.get());
        box.set("Doll");
        System.out.println(storage.get(1));
    }
}
