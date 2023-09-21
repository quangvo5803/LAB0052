package Model;

public class Country extends EastAsiaCountries implements Comparable<Country> {
    private String countryTerrain;

    public Country(String countryTerrain) {
    }

    public Country(String countryCode, String countryName, double totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    @Override
    public int compareTo(Country t) {
        return this.getCountryName().compareTo(t.getCountryName());
    }

    @Override
    public void display() {
        System.out.printf("%-10s%-25s%-20.1f%-25s\n", this.countryCode,
                this.countryName, this.totalArea, this.countryTerrain);
    }
}
