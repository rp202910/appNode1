package org.example.gymchain.entities;

public class Booking {

    private static int uniqueBookingId = 0;



    private Integer id;
    private Integer customerId;
    private Integer classId;
    private Integer gymId;


    public Booking(Integer customerId, Integer classId, Integer gymId) {
        this.id = ++uniqueBookingId;
        this.customerId = customerId;
        this.classId = classId;
        this.gymId = gymId;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getGymId() {
        return gymId;
    }

    public void setGymId(Integer gymId) {
        this.gymId = gymId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", classId=" + classId +
                ", gymId=" + gymId +
                '}';
    }
}
