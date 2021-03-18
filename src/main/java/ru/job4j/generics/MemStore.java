package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        if (findById(id) == null) {
            return false;
        } else {
            int index = mem.indexOf(findById(id));
            mem.set(index, model);
            return true;
        }
    }

    @Override
    public boolean delete(String id) {
        if (findById(id) == null) {
            return false;
        } else {
            return mem.remove(findById(id));
        }
    }

    @Override
    public T findById(String id) {
        return mem.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst().orElse(null);
    }
}
