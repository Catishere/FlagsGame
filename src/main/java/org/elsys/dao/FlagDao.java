package org.elsys.dao;

import org.elsys.entity.Flag;

public interface FlagDao {
    void insert(Flag flag);
    void update(Flag flag);
    void delete(long id);
    Flag findById(long id);
    Flag findByName(String name);
}
