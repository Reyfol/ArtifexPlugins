package me.reyfol.ArtifexCurrencyPlugin.DB;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {

    T get(String uuid) throws SQLException;

    List<T> getAll() throws SQLException;

    boolean insert(T t) throws SQLException;

    boolean update(T t) throws SQLException;

    boolean delete(T t) throws SQLException;

}
