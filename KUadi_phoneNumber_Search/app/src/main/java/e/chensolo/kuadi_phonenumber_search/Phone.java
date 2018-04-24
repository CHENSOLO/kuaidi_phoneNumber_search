package e.chensolo.kuadi_phonenumber_search;

/**
 * Created by Administrator on 2018/4/21.
 */

public class Phone {
    private String province;
    private String catName;
    private String telString;
    private String carrier;

    public Phone(String province, String catName, String telString, String carrier) {
        this.province = province;
        this.catName = catName;
        this.telString = telString;
        this.carrier = carrier;
    }
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getTelString() {
        return telString;
    }

    public void setTelString(String telString) {
        this.telString = telString;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "province='" + province + '\'' +
                ", catName='" + catName + '\'' +
                ", telString='" + telString + '\'' +
                ", carrier='" + carrier + '\'' +
                '}';
    }

}
