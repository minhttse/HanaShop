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
public class FoodErrorDTO {
    private String foodIDError;
    private String foodNameError;
    private String foodPriceError;
    private String quantityError;
    private String descriptionError;
    private String createDateError;
    private String expirationDateError;
    private String linkImgError;
    private String categoryIDError;
    private String statusError;

    public FoodErrorDTO() {
    }

    public FoodErrorDTO(String foodIDError, String foodNameError, String foodPriceError, String quantityError, String descriptionError, String createDateError, String expirationDateError, String linkImgError, String categoryIDError, String statusError) {
        this.foodIDError = foodIDError;
        this.foodNameError = foodNameError;
        this.foodPriceError = foodPriceError;
        this.quantityError = quantityError;
        this.descriptionError = descriptionError;
        this.createDateError = createDateError;
        this.expirationDateError = expirationDateError;
        this.linkImgError = linkImgError;
        this.categoryIDError = categoryIDError;
        this.statusError = statusError;
    }


    public String getFoodIDError() {
        return foodIDError;
    }

    public void setFoodIDError(String foodIDError) {
        this.foodIDError = foodIDError;
    }

    public String getFoodNameError() {
        return foodNameError;
    }

    public void setFoodNameError(String foodNameError) {
        this.foodNameError = foodNameError;
    }

    public String getFoodPriceError() {
        return foodPriceError;
    }

    public void setFoodPriceError(String foodPriceError) {
        this.foodPriceError = foodPriceError;
    }

    public String getQuantityError() {
        return quantityError;
    }

    public void setQuantityError(String quantityError) {
        this.quantityError = quantityError;
    }

    public String getDescriptionError() {
        return descriptionError;
    }

    public void setDescriptionError(String descriptionError) {
        this.descriptionError = descriptionError;
    }

    public String getCreateDateError() {
        return createDateError;
    }

    public void setCreateDateError(String createDateError) {
        this.createDateError = createDateError;
    }

    public String getLinkImgError() {
        return linkImgError;
    }

    public void setLinkImgError(String linkImgError) {
        this.linkImgError = linkImgError;
    }

    public String getCategoryIDError() {
        return categoryIDError;
    }

    public void setCategoryIDError(String categoryIDError) {
        this.categoryIDError = categoryIDError;
    }

    public String getStatusError() {
        return statusError;
    }

    public void setStatusError(String statusError) {
        this.statusError = statusError;
    }

    public String getExpirationDateError() {
        return expirationDateError;
    }

    public void setExpirationDateError(String expirationDateError) {
        this.expirationDateError = expirationDateError;
    }
    
    
}
