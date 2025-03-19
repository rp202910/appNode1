package org.example.splitwise.entities;

public class Split {
    private static Integer uniqueSplitId = 0;
    private Integer id;
    private Integer payerUserId;

    public Split(Integer payerUserId, Integer payeeUserId, Double amount) {
        this.id = uniqueSplitId++;
        this.payerUserId = payerUserId;
        this.payeeUserId = payeeUserId;
        this.amount = amount;
    }

    private Integer payeeUserId;
    private Double amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPayerUserId() {
        return payerUserId;
    }

    public void setPayerUserId(Integer payerUserId) {
        this.payerUserId = payerUserId;
    }

    public Integer getPayeeUserId() {
        return payeeUserId;
    }

    public void setPayeeUserId(Integer payeeUserId) {
        this.payeeUserId = payeeUserId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
