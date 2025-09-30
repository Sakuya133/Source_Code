/**
 * 
 * 
 * @author Ida Bagus Gde Dimas Sutha Maha
 */
public class Dosen {
    private String name;
    private String NIP;

    public Dosen(String name, String NIP) {
        this.name = name;
        this.NIP = NIP;
    }

    public String getName() {
        return name;
    }
    
    public String getNIP() {
        return NIP;
    }
    
    @Override
    public String toString() {
        return this.name + " (NIP: " + this.NIP + ")";
    }
}
