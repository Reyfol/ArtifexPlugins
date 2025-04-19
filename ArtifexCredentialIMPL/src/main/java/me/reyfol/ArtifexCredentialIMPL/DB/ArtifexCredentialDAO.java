package me.reyfol.ArtifexCredentialIMPL.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ArtifexCredentialDAO {

    // CRUD - Retrieve
    public ArtifexCredential get(String inputtedUuid){
        try{
            Connection conn = Database.getConnection();
            ArtifexCredential artifexCredential = null;

            String sql = "SELECT uuid, username, password credentials WHERE uuid = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, inputtedUuid);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String uuid = rs.getString("uuid");
                String username = rs.getString("username");
                String password = rs.getString("password");

                artifexCredential = new ArtifexCredential(uuid, username, password);
            }

            Database.closeResultSet(rs);
            Database.closePreparedStatement(ps);
            Database.closeConnection(conn);

            return artifexCredential;
        }
        catch (SQLException e){
            System.out.println(e);
            return null;
        }

    }

    public String getUuidByUsername(String inputtedUsername){
        try{
            Connection conn = Database.getConnection();
            String resultUuid = null;

            String sql = "SELECT uuid credentials WHERE username = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, inputtedUsername);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                resultUuid = rs.getString("uuid");
            }

            Database.closeResultSet(rs);
            Database.closePreparedStatement(ps);
            Database.closeConnection(conn);

            return resultUuid;
        }
        catch (SQLException e){
            System.out.println(e);
            return null;
        }

    }

//    // CRUD - Retrieve All
//    public List<ArtifexPlayers> getAll() throws SQLException {
//
//        Connection conn = Database.getConnection();
//        String sql = "SELECT uuid, currency_value, currency_value FROM currencies";
//
//        List<ArtifexPlayers> currencyList = new ArrayList<>();
//
//        Statement stmt = conn.createStatement();
//
//        ResultSet rs = stmt.executeQuery(sql);
//
//        while (rs.next()) {
//            String uuid = rs.getString("uuid");
//            String currencyType = rs.getString("currency_value");
//            int currencyValue = rs.getInt("currency_value");
//
//            ArtifexCurrency currency = new ArtifexCurrency(uuid, currencyType, currencyValue);
//
//            currencyList.add(currency);
//        }
//
//        return currencyList;
//    }

    // CRUD - Create
    public boolean insert(ArtifexCredential artifexCredential){

        try{
            Connection conn = Database.getConnection();

            int result = -1;

            // Check if UUID already exists
            final String queryCheck = "SELECT * credentials WHERE uuid = ?";
            final PreparedStatement ps_check = conn.prepareStatement(queryCheck);
            ps_check.setString(1, artifexCredential.getUuid());
            final ResultSet resultSet = ps_check.executeQuery();
            if(resultSet.next()) {
                System.out.println("Error: UUID already exist");

                Database.closePreparedStatement(ps_check);
                Database.closeConnection(conn);

                return false; // UUID Already exists
            }

            // Add new player
            String sql = "INSERT INTO artifex_credentials (uuid, username, password) VALUES (?, ?, ?)";

            PreparedStatement ps_insert = conn.prepareStatement(sql);

            ps_insert.setString(1, artifexCredential.getUuid());
            ps_insert.setString(2, artifexCredential.getUsername());
            ps_insert.setString(3, artifexCredential.getPassword());

            ps_insert.executeUpdate();

            // Close All
            Database.closePreparedStatement(ps_check);
            Database.closePreparedStatement(ps_insert);
            Database.closeConnection(conn);

            return true;
        }
        catch (SQLException e){
            System.out.println(e);
            return false;
        }

    }

//    // CRUD - Update
//    @Override
//    public int update(ArtifexPlayers currency) throws SQLException {
//        Connection connection = Database.getConnection();
//
//        String sql = "UPDATE currencies set currency_type = ?, currency_value = ? where uuid = ?";
//
//        PreparedStatement ps = connection.prepareStatement(sql);
//
//        ps.setString(1, currency.getCurrencyType());
//        ps.setInt(2, currency.getCurrencyValue());
//
//        int result = ps.executeUpdate();
//
//        Database.closePreparedStatement(ps);
//        Database.closeConnection(connection);
//
//        return result;
//    }
//
//    // CRUD - Delete
//    @Override
//    public int delete(ArtifexPlayers currency) throws SQLException {
//        Connection connection = Database.getConnection();
//
//        String sql = "DELETE FROM currencies WHERE uuid = ?";
//
//        PreparedStatement ps = connection.prepareStatement(sql);
//
//        ps.setString(1, currency.getUuid());
//
//        int result = ps.executeUpdate();
//
//        Database.closePreparedStatement(ps);
//        Database.closeConnection(connection);
//
//        return result;
//    }

}

