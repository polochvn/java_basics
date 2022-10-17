public class Country {
    private String nameCountry;
    private int populationCountry;
    private double areaCountry;
    private String nameCapital;
    private boolean accessToSea;

    public Country(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public int getPopulationCountry() {
        return populationCountry;
    }

    public void setPopulationCountry(int populationCountry) {
        this.populationCountry = populationCountry;
    }

    public double getAreaCountry() {
        return areaCountry;
    }

    public void setAreaCountry(double areaCountry) {
        this.areaCountry = areaCountry;
    }

    public String getNameCapital() {
        return nameCapital;
    }

    public void setNameCapital(String nameCapital) {
        this.nameCapital = nameCapital;
    }

    public boolean getAccessToSea() {
        return accessToSea;
    }

    public void setAccessToSea(boolean accessToSea) {
        this.accessToSea = accessToSea;
    }
}
