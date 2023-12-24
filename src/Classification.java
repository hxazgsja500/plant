public class Classification {
    private int nodeID;
    private int parentID;
    private String scientificName;
    private String commonName;
    private String province;
    private String city;
    private String county;
    private String growthEnvironment;

    public int getNodeID() {
        return nodeID;
    }

    public void setNodeID(int nodeID) {
        this.nodeID = nodeID;
    }

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getGrowthEnvironment() {
        return growthEnvironment;
    }

    public void setGrowthEnvironment(String growthEnvironment) {
        this.growthEnvironment = growthEnvironment;
    }

    @Override
    public String toString() {
        return "Classification{" +
                "nodeID=" + nodeID +
                ", parentID=" + parentID +
                ", scientificName='" + scientificName + '\'' +
                ", commonName='" + commonName + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", growthEnvironment='" + growthEnvironment + '\'' +
                '}';
    }
}

