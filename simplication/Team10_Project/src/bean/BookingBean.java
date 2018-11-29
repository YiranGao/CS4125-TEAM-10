package bean;

public class BookingBean {
    
        private int reservationID;
        private int customerID;
        private int RestID; // String restName
        private int TableID;
        private int NoOfGuests;
        private String Date;
        private int AllergyDairy = 0;
        private int AllergyFish = 0;
        private int AllergyGluten = 0;
        private int AllergyPeanuts = 0;
        private int AllergyShellfish = 0;
        private int AllergySoya = 0;
        
        public BookingBean()
        {
        reservationID = 0;
        customerID =0;
        RestID =0; // String restName
        TableID =0;
        NoOfGuests =0;
        Date="";
        AllergyDairy = 0;
        AllergyFish = 0;
        AllergyGluten = 0;
        AllergyPeanuts = 0;
        AllergyShellfish = 0;
        AllergySoya = 0;   
        }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setRestID(int RestID) {
        this.RestID = RestID;
    }

    public void setTableID(int TableID) {
        this.TableID = TableID;
    }

    public void setNoOfGuests(int NoOfGuests) {
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

    public int getReservationID() {
        return reservationID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getRestID() {
        return RestID;
    }

    public int getTableID() {
        return TableID;
    }

    public int getNoOfGuests() {
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
