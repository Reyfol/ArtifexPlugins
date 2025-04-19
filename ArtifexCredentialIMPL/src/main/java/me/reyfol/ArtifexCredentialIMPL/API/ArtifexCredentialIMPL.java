package me.reyfol.ArtifexCredentialIMPL.API;

import me.reyfol.ArtifexCredentialIMPL.DB.ArtifexCredential;
import me.reyfol.ArtifexCredentialIMPL.DB.ArtifexCredentialDAO;

public class ArtifexCredentialIMPL implements ArtifexCredentialAPI<ArtifexCredential> {
    public static ArtifexCredentialDAO artifexCredentialDAO = new ArtifexCredentialDAO();

    public ArtifexCredential get(String uuid){
        return artifexCredentialDAO.get(uuid);
    }

    public boolean insert(String uuid, String username, String password){
        ArtifexCredential artifexCredential = new ArtifexCredential(uuid, username, password);
        return artifexCredentialDAO.insert(artifexCredential);
    }

    public String getUuidByUsername(String username){
        return artifexCredentialDAO.getUuidByUsername(username);
    }
}
