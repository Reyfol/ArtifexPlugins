package me.reyfol.ArtifexCurrencyPlugin.DB;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ArtifexCurrencyDAO{

    // @Override
    public BigDecimal getCurrencyValue(String uuid, String currencyName) throws SQLException {
        Connection con = DBConnection.getConnection();
        BigDecimal currencyValue = null;

        String sql = "SELECT currency_value FROM currencies WHERE uuid = ? AND currency_name = ?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, uuid);
        ps.setString(2, currencyName);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            currencyValue = rs.getBigDecimal("currency_value");
        }

        DBConnection.closeResultSet(rs);
        DBConnection.closePreparedStatement(ps);
        DBConnection.closeConnection(con);

        return currencyValue;
    }

//


    // @Override
    public boolean insert(ArtifexCurrencyModel currency) throws SQLException {
        Connection con = DBConnection.getConnection();

        String sql = "INSERT INTO currencies (uuid, currency_name, currency_value) "
                + "SELECT ?, ?, ? "
                + "WHERE NOT EXISTS (SELECT 1 FROM currencies WHERE uuid = ? AND currency_name = ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, currency.getUuid());
        ps.setString(2, currency.getcurrencyName());
        ps.setBigDecimal(3, currency.getCurrencyValue());
        ps.setString(4, currency.getUuid());
        ps.setString(5, currency.getcurrencyName());

        int result = ps.executeUpdate();

        DBConnection.closePreparedStatement(ps);
        DBConnection.closeConnection(con);

        return result != 0;
    }

    public boolean update(ArtifexCurrencyModel currency) throws SQLException {
        Connection connection = DBConnection.getConnection();

        String sql = "UPDATE currencies SET currency_value = ? WHERE uuid = ? AND currency_name = ?";

        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setBigDecimal(1, currency.getCurrencyValue());
        ps.setString(2, currency.getUuid());
        ps.setString(3, currency.getcurrencyName());

        int result = ps.executeUpdate();

        DBConnection.closePreparedStatement(ps);
        DBConnection.closeConnection(connection);

        return result != 0;
    }


    public boolean delete(String uuid, String currencyName) throws SQLException {
        Connection connection = DBConnection.getConnection();

        String sql = "DELETE FROM currencies WHERE uuid = ? AND currency_name = ?";

        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, uuid);
        ps.setString(2, currencyName);

        int result = ps.executeUpdate();

        DBConnection.closePreparedStatement(ps);
        DBConnection.closeConnection(connection);

        return result != 0;
    }

    public boolean addValue(String uuid, String currencyName, BigDecimal valueToAdd) throws SQLException{
        BigDecimal currentBalance = getCurrencyValue(uuid, currencyName);
        ArtifexCurrencyModel updatedArtifexCurrencyModel = new ArtifexCurrencyModel(uuid, currencyName, currentBalance.add(valueToAdd));
        update(updatedArtifexCurrencyModel);

        return true;
    }

    public boolean subtractValue(String uuid, String currencyName, BigDecimal valueToSubtract) throws SQLException{
        BigDecimal currentBalance = getCurrencyValue(uuid, currencyName);
        ArtifexCurrencyModel updatedArtifexCurrencyModel = new ArtifexCurrencyModel(uuid, currencyName, currentBalance.subtract(valueToSubtract));
        update(updatedArtifexCurrencyModel);

        return true;
    }

    public boolean transfer(String uuidFrom, String uuidTo, String currencyName, BigDecimal amountToTransfer) throws SQLException {
        BigDecimal balanceFrom = getCurrencyValue(uuidFrom, currencyName);

        if(balanceFrom.compareTo(amountToTransfer) < 0){
            // not enough balance
            return false;
        }

        subtractValue(uuidFrom, currencyName, amountToTransfer);
        addValue(uuidTo, currencyName, amountToTransfer);

        return true;
    }
}