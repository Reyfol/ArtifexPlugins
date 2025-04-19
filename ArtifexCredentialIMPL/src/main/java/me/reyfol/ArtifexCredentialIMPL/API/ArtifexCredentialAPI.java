package me.reyfol.ArtifexCredentialIMPL.API;

public interface ArtifexCredentialAPI<T> {
    T get(String uuid);

    boolean insert(String uuid, String username, String password);

    String getUuidByUsername(String username);
}
