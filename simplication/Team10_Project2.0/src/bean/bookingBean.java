package bean;

public class bookingBean {
    
        private String RestName;
        private String TableID;
        private String NoOfGuests;
        private String Date;
        private int AllergyDairy;
        private int AllergyFish;
        private int AllergyGluten;
        private int AllergyPeanuts;
        private int AllergyShellfish;
        private int AllergySoya;

    public void setRestName(String RestName) {
        this.RestName = RestName;
    }

    public void setTableID(String TableID) {
        this.TableID = TableID;
    }

    public void setNoOfGuests(String NoOfGuests) {
        this.NoOfGuests = NoOfGuests;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public void setAllergyDairy(int AllergyDairy) {
        this.AllergyDairy = AllergyDairy;
    }

    public void setAllergyFish(int AllergyFish) {
        this.AllergyFish = AllergyFish;
    }

    public void setAllergyGluten(int AllergyGluten) {
        this.AllergyGluten = AllergyGluten;
    }

    public void setAllergyPeanuts(int AllergyPeanuts) {
        this.AllergyPeanuts = AllergyPeanuts;
    }

    public void setAllergyShellfish(int AllergyShellfish) {
        this.AllergyShellfish = AllergyShellfish;
    }

    public void setAllergySoya(int AllergySoya) {
        this.AllergySoya = AllergySoya;
    }

    public String getRestName() {
        return RestName;
    }

    public String getTableID() {
        return TableID;
    }

    public String getNoOfGuests() {
        return NoOfGuests;
    }

    public String getDate() {
        return Date;
    }

    public int getAllergyDairy() {
        return AllergyDairy;
    }

    public int getAllergyFish() {
        return AllergyFish;
    }

    public int getAllergyGluten() {
        return AllergyGluten;
    }

    public int getAllergyPeanuts() {
        return AllergyPeanuts;
    }

    public int getAllergyShellfish() {
        return AllergyShellfish;
    }

    public int getAllergySoya() {
        return AllergySoya;
    }
    
}
