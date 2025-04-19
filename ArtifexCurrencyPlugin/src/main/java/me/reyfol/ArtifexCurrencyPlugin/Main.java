package me.reyfol.ArtifexCurrencyPlugin;

import me.reyfol.ArtifexCredentialIMPL.API.ArtifexCredentialIMPL;
import me.reyfol.ArtifexCredentialIMPL.DB.ArtifexCredential;
import me.reyfol.ArtifexCurrencyPlugin.DB.ArtifexCurrency;
import me.reyfol.ArtifexCurrencyPlugin.DB.ArtifexCurrencyDAO;

import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.print("Hello and welcome!");

        ArtifexCurrencyDAO artifexCurrencyDAO = new ArtifexCurrencyDAO();
        ArtifexCredentialIMPL artifexCredentialIMPL = new ArtifexCredentialIMPL();
        artifexCredentialIMPL.insert("myzuid", "myusername", "mypass");

        try{
            ArtifexCurrency currency = artifexCurrencyDAO.get("10");
            System.out.println(currency);

            int result = artifexCurrencyDAO.delete(currency);
            System.out.println(result);
        }
        catch(SQLException e){
            System.out.println("FAIL!");
            System.out.println(e);
        }





    }
}