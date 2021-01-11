import java.util.Date;

public class Customer {
    private String id;
    private String customerType;//乘客类型：成人、儿童、婴儿
    private String name;//乘客姓名
    private String phone;
    private String cardid;
    private Date birthDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }
}
