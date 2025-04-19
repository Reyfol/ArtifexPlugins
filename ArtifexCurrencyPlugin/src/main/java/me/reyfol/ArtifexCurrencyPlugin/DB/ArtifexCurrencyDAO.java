package me.reyfol.ArtifexCurrencyPlugin.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ArtifexCurrencyDAO implements DAO<ArtifexCurrency> {

    // CRUD - Retrieve
    @Override
    public ArtifexCurrency get(String selectedUuid) throws SQLException {
        Connection con = Database.getConnection();
        ArtifexCurrency currency = null;

        String sql = "SELECT uuid, currency_value, currency_value FROM currencies WHERE uuid = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, selectedUuid);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            String uuid = rs.getString("uuid");
            String currencyName = rs.getString("currency_value");
            int currencyValue = rs.getInt("currency_value");

            currency = new ArtifexCurrency(uuid, currencyName, currencyValue);
        }

        Database.closeResultSet(rs);
        Database.closePreparedStatement(ps);
        Database.closeConnection(con);

        return currency;
    }

    // CRUD - Retrieve All
    @Override
    public List<ArtifexCurrency> getAll() throws SQLException {

        Connection con = Database.getConnection();
        String sql = "SELECT uuid, currency_value, currency_value FROM currencies";

        List<ArtifexCurrency> currencyList = new ArrayList<>();

        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            String uuid = rs.getString("uuid");
            String currencyName = rs.getString("currency_name");
            int currencyValue = rs.getInt("currency_value");

            ArtifexCurrency currency = new ArtifexCurrency(uuid, currencyName, currencyValue);

            currencyList.add(currency);
        }

        return currencyList;
    }

    // CRUD - Create or Update
    @Override
    public int save(ArtifexCurrency currency) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    // CRUD - Create
    @Override
    public int insert(ArtifexCurrency currency) throws SQLException {
        Connection con = Database.getConnection();

        String sql = "INSERT INTO currencies (uuid, currency_value, currency_value) VALUES (?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, currency.getUuid());
        ps.setString(2, currency.getcurrencyName());
        ps.setInt(3, currency.getCurrencyValue());

        int result = ps.executeUpdate();

        Database.closePreparedStatement(ps);
        Database.closeConnection(con);

        return result;
    }

    // CRUD - Update
    @Override
    public int update(ArtifexCurrency currency) throws SQLException {
        Connection connection = Database.getConnection();

        String sql = "UPDATE currencies set currency_type = ?, currency_value = ? where uuid = ?";

        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, currency.getcurrencyName());
        ps.setInt(2, currency.getCurrencyValue());

        int result = ps.executeUpdate();

        Database.closePreparedStatement(ps);
        Database.closeConnection(connection);

        return result;
    }

    // CRUD - Delete
    @Override
    public int delete(ArtifexCurrency currency) throws SQLException {
        Connection connection = Database.getConnection();

        String sql = "DELETE FROM currencies WHERE uuid = ?";

        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, currency.getUuid());

        int result = ps.executeUpdate();

        Database.closePreparedStatement(ps);
        Database.closeConnection(connection);

        return result;
    }

}
