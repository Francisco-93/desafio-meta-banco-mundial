package br.com.meta.desafio.worldbank.domain;

import java.io.Serializable;
import java.util.Objects;

public class Country implements Serializable{

    private static final long serialVersionUID = 1L;

    private String id;
    private String value;

    public Country(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public Country(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        Country country = (Country) o;
        return id.equals(country.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Country{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
