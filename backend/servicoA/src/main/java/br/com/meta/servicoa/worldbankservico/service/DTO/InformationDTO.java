package br.com.meta.servicoa.worldbankservico.service.DTO;

import br.com.meta.servicoa.worldbankservico.domain.Information;

import java.io.Serializable;

public class InformationDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String countryName;
    private String date;
    private Double poorPopulation;

    public InformationDTO(String countryName, String date, Double poorPopulation) {
        this.countryName = countryName;
        this.date = date;
        this.poorPopulation = poorPopulation;
    }

    public InformationDTO(Information information){
        this.countryName = information.getCountry().getValue();
        this.date = information.getDate();
        this.poorPopulation = information.getValue();
    }

    public InformationDTO(){
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getPoorPopulation() {
        return poorPopulation;
    }

    public void setPoorPopulation(Double poorPopulation) {
        this.poorPopulation = poorPopulation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InformationDTO)) return false;

        InformationDTO that = (InformationDTO) o;

        if (countryName != null ? !countryName.equals(that.countryName) : that.countryName != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        return poorPopulation != null ? poorPopulation.equals(that.poorPopulation) : that.poorPopulation == null;
    }

    @Override
    public int hashCode() {
        int result = countryName != null ? countryName.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (poorPopulation != null ? poorPopulation.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "InformationDTO{" +
                "countryName='" + countryName + '\'' +
                ", date='" + date + '\'' +
                ", poorPopulation=" + poorPopulation +
                '}';
    }
}
