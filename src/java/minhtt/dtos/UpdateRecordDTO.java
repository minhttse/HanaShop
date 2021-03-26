/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhtt.dtos;

/**
 *
 * @author minhv
 */
public class UpdateRecordDTO {
    
    private String recordID;
    private String userID;
    private String foodID;
    private String recordDate;
    private boolean status;

    public UpdateRecordDTO(String recordID, String userID, String foodID, String recordDate, boolean status) {
        this.recordID = recordID;
        this.userID = userID;
        this.foodID = foodID;
        this.recordDate = recordDate;
        this.status = status;
    }

    public UpdateRecordDTO() {
    }

    public String getRecordID() {
        return recordID;
    }

    public void setRecordID(String recordID) {
        this.recordID = recordID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
