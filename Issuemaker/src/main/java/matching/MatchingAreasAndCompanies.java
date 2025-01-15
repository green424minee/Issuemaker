package matching;

public class MatchingAreasAndCompanies {
    private String areaName;
    private String comAddress;

    
    public MatchingAreasAndCompanies(String areaName, String comAddress) {
        this.areaName = areaName;
        this.comAddress = comAddress;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getComAddress() {
        return comAddress;
    }

    public void setComAddress(String comAddress) {
        this.comAddress = comAddress;
    }
}
