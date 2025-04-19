package me.reyfol.ArtifexCurrencyPlugin.DB;

import java.math.BigDecimal;

public class ArtifexCurrencyModel {

    private String uuid;
    private String currencyName;
    private BigDecimal currencyValue;

    public ArtifexCurrencyModel(String uuid, String currencyName, BigDecimal currencyValue) {
        this.uuid = uuid;
        this.currencyName = currencyName;
        this.currencyValue = currencyValue;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getcurrencyName() {
        return currencyName;
    }

    public void setcurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public BigDecimal getCurrencyValue() {
        return currencyValue;
    }

    public void setCurrencyValue(BigDecimal currencyValue) {
        this.currencyValue = currencyValue;
    }

    @Override
    public String toString() {
        return "Currency [id=" + uuid + ", currencyName=" + currencyName + ", currencyValue=" + currencyValue + "]";
    }
}
