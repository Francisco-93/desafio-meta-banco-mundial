package br.com.meta.desafio.worldbank.domain;

import java.io.Serializable;

public class Information implements Serializable{

    private static final long serialVersionUID = 1L;

    private Country country;

    private String countryiso3cod;
    private String date;
    private Double value;

    public Information(Country country, String countryiso3cod, String date, Double value) {
        this.country = country;
        this.countryiso3cod = countryiso3cod;
        this.date = date;
        this.value = value;
    }

    public Information(){
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getCountryiso3cod() {
        return countryiso3cod;
    }

    public void setCountryiso3cod(String countryiso3cod) {
        this.countryiso3cod = countryiso3cod;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Information)) return false;

        Information that = (Information) o;

        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (countryiso3cod != null ? !countryiso3cod.equals(that.countryiso3cod) : that.countryiso3cod != null)
            return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        return value != null ? value.equals(that.value) : that.value == null;
    }

    @Override
    public int hashCode() {
        int result = country != null ? country.hashCode() : 0;
        result = 31 * result + (countryiso3cod != null ? countryiso3cod.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Information{" +
                "country=" + country +
                ", countryiso3cod='" + countryiso3cod + '\'' +
                ", date='" + date + '\'' +
                ", value=" + value +
                '}';
    }
}
