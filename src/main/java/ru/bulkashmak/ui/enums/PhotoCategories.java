package ru.bulkashmak.ui.enums;


public enum PhotoCategories {
    UPLOAD_FROM_PC("//*[contains(@class, 'modal-out-scroll-body')]" +
            "//*[contains(@class, 'load-photo-button-content')]"),
    PERSONAL_PHOTOS("//*[contains(@class, 'modal-out-scroll-body')]" +
            "//*[text()='Личные фотографии']"),
    OTHER_PHOTOS("//*[contains(@class, 'modal-out-scroll-body')]" +
            "//*[text()='Разное']");

    private final String categoryX;

    PhotoCategories(String categoryX) {
        this.categoryX = categoryX;
    }

    public String getCategoryX() {
        return categoryX;
    }

    @Override
    public String toString() {
        return String.format("categoryX='%s'}", categoryX);
    }
}