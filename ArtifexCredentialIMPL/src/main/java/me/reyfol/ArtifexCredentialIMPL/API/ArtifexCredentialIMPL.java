package me.reyfol.ArtifexCredentialIMPL.API;

import me.reyfol.ArtifexCredentialIMPL.DB.ArtifexCredential;
import me.reyfol.ArtifexCredentialIMPL.DB.ArtifexCredentialDAO;

public class ArtifexCredentialIMPL implements ArtifexCredentialAPI<ArtifexCredential> {
    public ArtifexCredential get(String uuid){
        ArtifexCredentialDAO artifexPlayersDAO = new ArtifexCredentialDAO();
        return artifexPlayersDAO.get(uuid);
    }

    public boolean insert(String uuid, String username, String password){
        ArtifexCredential artifexCredential = new ArtifexCredential(uuid, username, password);

        ArtifexCredentialDAO artifexCredentialDAO = new ArtifexCredentialDAO();
        return artifexCredentialDAO.insert(artifexCredential);
    }

    public String getUuidByUsername(String username){
        ArtifexCredentialDAO artifexPlayersDAO = new ArtifexCredentialDAO();
        return artifexPlayersDAO.getUuidByUsername(username);
    }
}
