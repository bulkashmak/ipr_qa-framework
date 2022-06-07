package ru.bulkashmak.ui.enums

enum class PhotoCategories(val categoryX: String) {
    UPLOAD_FROM_PC("//*[contains(@class, 'modal-out-scroll-body')]" +
            "//*[contains(@class, 'load-photo-button-content')]"),
    PERSONAL_PHOTOS("//*[contains(@class, 'modal-out-scroll-body')]" +
            "//*[text()='Личные фотографии']"),
    OTHER_PHOTOS("//*[contains(@class, 'modal-out-scroll-body')]" +
            "//*[text()='Разное']");
}