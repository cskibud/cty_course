package advanced_java.unit1;

public class Company {
    private String companyName;
    private String industry;
    // ? what does a variable mean
    private String type;
    private String ceoName;
    private String sellsPaintings;
    private String sellsSketches;
    private String sellsPhotographs;

    public Company() {

    }
    public Company(String companyName, String industry, String type, String ceoName, String sellsPaintings, String sellsSketches, String sellsPhotographs) {
        this.companyName = companyName;
        this.industry = industry;
        this.type = type;
        this.ceoName = ceoName;
        this.sellsPaintings = sellsPaintings;
        this.sellsSketches = sellsSketches;
        this.sellsPhotographs = sellsPhotographs;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getCompanyName() {
        return this.companyName;
    }
    public void setIndustry(String industry) {
        this.industry = industry;
    }
    public String getIndustry() {
        return this.industry;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return this.type;
    }
    public void setCeoName(String ceoName) {
        this.ceoName = ceoName;
    }
    public String getCeoName() {
        return this.ceoName;
    }
    public void setSellsPaintings(String sellsPaintings) {
        this.sellsPaintings = sellsPaintings;
    }
    public String getSellsPaintings() {
        return this.sellsPaintings;
    }
    public void setSellsSketches(String sellsSketches) {
        this.sellsSketches = sellsSketches;
    }
    public String getSellsSketches() {
        return this.sellsSketches;
    }
    public void setSellsPhotographs(String sellsPhotographs) {
        this.sellsPhotographs = sellsPhotographs;
    }
    public String getSellsPhotographs() {
        return this.sellsPhotographs;
    }

    public String toString() {
        String str = "\n" + "Company name: " + companyName + "\n" + "CEO: " + ceoName + "\n" + "Industry: " + industry + "\n" + "Type: " + type + "\n" + "Sells paintings: " + sellsPaintings + "\n" + "Sells sketches: " + sellsSketches + "\n" + "Sells photographs: " + sellsPhotographs;
        return str;
    }
}