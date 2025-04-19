package me.reyfol.ArtifexCurrencyPlugin.DB;

public class ArtifexCurrency {

    private String uuid;
    private String currencyName;
    private int currencyValue;

    public ArtifexCurrency(String uuid, String currencyName, int currencyValue) {
        this.uuid = uuid;
        this.currencyName = currencyName;
        this.currencyValue = currencyValue;
    }

    public String getUuid() {
        return uuid;
    }

    public void setId(String uuid) {
        this.uuid = uuid;
    }

    public String getcurrencyName() {
        return currencyName;
    }

    public void setcurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public int getCurrencyValue() {
        return currencyValue;
    }

    public void setCurrencyValue(int currencyValue) {
        this.currencyValue = currencyValue;
    }

    @Override
    public String toString() {
        return "Currency [id=" + uuid + ", currencyName=" + currencyName + ", currencyValue=" + currencyValue + "]";
    }
}
