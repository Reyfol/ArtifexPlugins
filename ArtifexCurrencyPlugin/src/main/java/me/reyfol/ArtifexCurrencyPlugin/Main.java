package me.reyfol.ArtifexCurrencyPlugin;

import me.reyfol.ArtifexCredentialIMPL.API.ArtifexCredentialIMPL;
import me.reyfol.ArtifexCurrencyPlugin.DB.ArtifexCurrencyModel;
import me.reyfol.ArtifexCurrencyPlugin.DB.ArtifexCurrencyDAO;

import java.math.BigDecimal;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.print("Hello and welcome!");

        ArtifexCurrencyDAO artifexCurrencyDAO = new ArtifexCurrencyDAO();
        ArtifexCurrencyModel artifexCurrencyModel1 = new ArtifexCurrencyModel("myuuid", "money", new BigDecimal("12.3"));
        ArtifexCurrencyModel artifexCurrencyModel2 = new ArtifexCurrencyModel("heruuid", "money", new BigDecimal("200"));
        ArtifexCurrencyModel artifexCurrencyModel3 = new ArtifexCurrencyModel("deluuid", "money", new BigDecimal("122"));
        ArtifexCurrencyModel artifexCurrencyModel4 = new ArtifexCurrencyModel("heruuid", "money", new BigDecimal("500"));


        try{
            //artifexCurrencyDAO.insert(artifexCurrencyModel1);
//            artifexCurrencyDAO.insert(artifexCurrencyModel2);
//            artifexCurrencyDAO.insert(artifexCurrencyModel3);
            //rtifexCurrencyDAO.update(artifexCurrencyModel4);
            //artifexCurrencyDAO.delete("myuuid", "money");

            artifexCurrencyDAO.transfer("myuuid", "heruuid", "money", new BigDecimal("5"));
        }
        catch (SQLException e){
            System.out.println("FAIL!");
            System.out.println(e);
        }





    }
}