package com.bilgeadam.animal_sims.factory;

import java.util.ArrayList;
import java.util.List;

public abstract class Factory<T> {
    public List<T> generateEntities(int counter) {
        List<T> entities = new ArrayList<>(counter);
        for (int i = 0; i < counter; i++) {
            entities.add(generateEntity());
        }

        return entities;
    }

    protected abstract T generateEntity();
}
