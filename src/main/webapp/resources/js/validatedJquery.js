$(document).ready(function () {
    //validated form Create Drink
    $("#frmCreateDrink").validate({
        rules: {
            drinkNameCreate: {
                required: true,
                minlength: 5,
                maxlength: 50
            },
            priceDrinkCreate: {
                required: true,
            }
        },
        messages: {
            drinkNameCreate: {
                required: "Tên thức uống là bắt buộc",
                minlength: "Tên thức uống phải nằm trong khoảng 5-50 ký tự",
                maxlength: "Tên thức uống phải nằm trong khoảng 5-50 ký tự"
            },
            priceDrinkCreate: {
                required: "Giá thức uống là bắt buộc",
            }
        },
        errorLabelContainer: '#modalCreateDrink .modal-body .modal-alert-danger',
        errorPlacement: function (error, element) {
            error.appendTo("#modalCreateDrink .modal-body .modal-alert-danger");
        },
        showErrors: function (errorMap, errorList) {
            if (this.numberOfInvalids() > 0) {
                $("#modalCreateDrink .modal-body .modal-alert-danger").removeClass("hide").addClass("show");
            } else {
                $("#modalCreateDrink .modal-body .modal-alert-danger").removeClass("show").addClass("hide").empty();
                $("#modalCreateDrink input.error").removeClass("error");
            }
            this.defaultShowErrors();
        },
        submitHandler: function () {
            createDrink();
        }
    });

    //validated form Update Drink
    $("#frmUpdateDrink").validate({
        rules: {
            drinkNameUpdate: {
                required: true,
                minlength: 5,
                maxlength: 50
            },
            priceDrinkUpdate: {}
        },
        messages: {
            drinkNameUpdate: {
                required: "Tên thức uống là bắt buộc",
                minlength: "Tên thức uống phải nằm trong khoảng 5-50 ký tự",
                maxlength: "Tên thức uống phải nằm trong khoảng 5-50 ký tự"
            },
            priceDrinkUpdate: {
                required: "Giá thức uống là bắt buộc",
            }
        },
        errorLabelContainer: '#modalUpdateDrink .modal-body .modal-alert-danger',
        errorPlacement: function (error, element) {
            error.appendTo("#modalUpdateDrink .modal-body .modal-alert-danger");
        },
        showErrors: function (errorMap, errorList) {
            if (this.numberOfInvalids() > 0) {
                $("#modalUpdateDrink .modal-body .modal-alert-danger").removeClass("hide").addClass("show");
            } else {
                $("#modalUpdateDrink .modal-body .modal-alert-danger").removeClass("show").addClass("hide").empty();
                $("#modalUpdateDrink input.error").removeClass("error");
            }
            this.defaultShowErrors();
        },
        submitHandler: function () {
            updateDrink();
        }
    });

    //validated form Restore Drink
    $("#frmRestoreDrink").validate({
        rules: {
            drinkNameUpdate: {
                required: true,
                minlength: 5,
                maxlength: 50
            },
            priceDrinkUpdate: {}
        },
        messages: {
            drinkNameUpdate: {
                required: "Tên thức uống là bắt buộc",
                minlength: "Tên thức uống phải nằm trong khoảng 5-50 ký tự",
                maxlength: "Tên thức uống phải nằm trong khoảng 5-50 ký tự"
            },
            priceDrinkUpdate: {
                required: "Giá thức uống là bắt buộc",
            }
        },
        errorLabelContainer: '#modalRestoreDrink .modal-body .modal-alert-danger',
        errorPlacement: function (error, element) {
            error.appendTo("#modalRestoreDrink .modal-body .modal-alert-danger");
        },
        showErrors: function (errorMap, errorList) {
            if (this.numberOfInvalids() > 0) {
                $("#modalRestoreDrink .modal-body .modal-alert-danger").removeClass("hide").addClass("show");
            } else {
                $("#modalRestoreDrink .modal-body .modal-alert-danger").removeClass("show").addClass("hide").empty();
                $("#modalRestoreDrink input.error").removeClass("error");
            }
            this.defaultShowErrors();
        },
        submitHandler: function () {
            restoreDrink();
        }
    });

    //validated form Create Staff
    $("#frmCreateStaff").validate({
        rules: {
            staffNameCreate: {
                required: true,
                minlength: 5,
                maxlength: 30
            },
            staffPhoneCreate: {
                required: true,
            }
        },
        messages: {
            staffNameCreate: {
                required: "Tên nhân viên là bắt buộc",
                minlength: "Tên nhân viên phải nằm trong khoảng 5-30 ký tự",
                maxlength: "Tên nhân viên phải nằm trong khoảng 5-30 ký tự"
            },
            staffPhoneCreate: {
                required: "Số điện thoại là bắt buộc",
            }
        },
        errorLabelContainer: '#modalCreateStaff .modal-body .modal-alert-danger',
        errorPlacement: function (error, element) {
            error.appendTo("#modalCreateStaff .modal-body .modal-alert-danger");
        },
        showErrors: function (errorMap, errorList) {
            if (this.numberOfInvalids() > 0) {
                $("#modalCreateStaff .modal-body .modal-alert-danger").removeClass("hide").addClass("show");
            } else {
                $("#modalCreateStaff .modal-body .modal-alert-danger").removeClass("show").addClass("hide").empty();
                $("#modalCreateStaff input.error").removeClass("error");
            }
            this.defaultShowErrors();
        },
        submitHandler: function () {
            createStaff();
        }
    });

    //validated form Update Staff
    $("#frmUpdateStaff").validate({
        rules: {
            staffNameUpdate: {
                required: true,
                minlength: 5,
                maxlength: 30
            },
            staffPhoneUpdate: {
                required: true,
            }
        },
        messages: {
            staffNameUpdate: {
                required: "Tên nhân viên là bắt buộc",
                minlength: "Tên nhân viên phải nằm trong khoảng 5-30 ký tự",
                maxlength: "Tên nhân viên phải nằm trong khoảng 5-30 ký tự"
            },
            staffPhoneUpdate: {
                required: "Số điện thoại là bắt buộc",
            }
        },
        errorLabelContainer: '#modalUpdateStaff .modal-body .modal-alert-danger',
        errorPlacement: function (error, element) {
            error.appendTo("#modalUpdateStaff .modal-body .modal-alert-danger");
        },
        showErrors: function (errorMap, errorList) {
            if (this.numberOfInvalids() > 0) {
                $("#modalUpdateStaff .modal-body .modal-alert-danger").removeClass("hide").addClass("show");
            } else {
                $("#modalUpdateStaff .modal-body .modal-alert-danger").removeClass("show").addClass("hide").empty();
                $("#modalUpdateStaff input.error").removeClass("error");
            }
            this.defaultShowErrors();
        },
        submitHandler: function () {
            updateStaff();
        }
    });

    //validated form Create Catalog
    $("#frmCreateCatalog").validate({
        rules: {
            catalogNameCreate: {
                required: true,
                minlength: 3,
                maxlength: 50
            },
        },
        messages: {
            catalogNameCreate: {
                required: "Tên danh mục là bắt buộc",
                minlength: "Tên danh mục phải nằm trong khoảng 3-50 ký tự",
                maxlength: "Tên danh mục phải nằm trong khoảng 3-50 ký tự"
            },
        },
        errorLabelContainer: '#modalCreateCatalog .modal-body .modal-alert-danger',
        errorPlacement: function (error, element) {
            error.appendTo("#modalCreateCatalog .modal-body .modal-alert-danger");
        },
        showErrors: function (errorMap, errorList) {
            if (this.numberOfInvalids() > 0) {
                $("#modalCreateCatalog .modal-body .modal-alert-danger").removeClass("hide").addClass("show");
            } else {
                $("#modalCreateCatalog .modal-body .modal-alert-danger").removeClass("show").addClass("hide").empty();
                $("#modalCreateCatalog input.error").removeClass("error");
            }
            this.defaultShowErrors();
        },
        submitHandler: function () {
            createCatalog();
        }
    });

    //validated form Update Catalog
    $("#frmUpdateCatalog").validate({
        rules: {
            catalogNameUpdate: {
                required: true,
                minlength: 3,
                maxlength: 50
            },
        },
        messages: {
            catalogNameUpdate: {
                required: "Tên danh mục là bắt buộc",
                minlength: "Tên danh mục phải nằm trong khoảng 3-50 ký tự",
                maxlength: "Tên danh mục phải nằm trong khoảng 3-50 ký tự"
            }
        },
        errorLabelContainer: '#modalUpdateCatalog .modal-body .modal-alert-danger',
        errorPlacement: function (error, element) {
            error.appendTo("#modalUpdateCatalog .modal-body .modal-alert-danger");
        },
        showErrors: function (errorMap, errorList) {
            if (this.numberOfInvalids() > 0) {
                $("#modalUpdateCatalog .modal-body .modal-alert-danger").removeClass("hide").addClass("show");
            } else {
                $("#modalUpdateCatalog .modal-body .modal-alert-danger").removeClass("show").addClass("hide").empty();
                $("#modalUpdateCatalog input.error").removeClass("error");
            }
            this.defaultShowErrors();
        },
        submitHandler: function () {
            updateCatalog();
        }
    });

    //validated form Restore Catalog
    $("#frmRestoreCatalog").validate({
        rules: {
            catalogNameRestore: {
                required: true,
                minlength: 3,
                maxlength: 50
            },
        },
        messages: {
            catalogNameRestore: {
                required: "Tên danh mục là bắt buộc",
                minlength: "Tên danh mục phải nằm trong khoảng 3-50 ký tự",
                maxlength: "Tên danh mục phải nằm trong khoảng 3-50 ký tự"
            }
        },
        errorLabelContainer: '#modalRestoreCatalog .modal-body .modal-alert-danger',
        errorPlacement: function (error, element) {
            error.appendTo("#modalRestoreCatalog .modal-body .modal-alert-danger");
        },
        showErrors: function (errorMap, errorList) {
            if (this.numberOfInvalids() > 0) {
                $("#modalRestoreCatalog .modal-body .modal-alert-danger").removeClass("hide").addClass("show");
            } else {
                $("#modalRestoreCatalog .modal-body .modal-alert-danger").removeClass("show").addClass("hide").empty();
                $("#modalRestoreCatalog input.error").removeClass("error");
            }
            this.defaultShowErrors();
        },
        submitHandler: function () {
            restoreCatalog();
        }
    });
})