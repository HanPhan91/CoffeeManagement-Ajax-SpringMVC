// $(document).ready(function () {
function Drink(drinkId, drinkName, drinkQuantity, price) {
    this.drinkId = drinkId;
    this.drinkName = drinkName;
    this.drinkQuantity = 0;
    this.price = price;
}

for (let i = 0; i < listDrink.length; i++) {
    Drinks.push(new Drink(listDrink[i].id, listDrink[i].drinkName, 0, listDrink[i].price));
}

function handlerButtonAddCart() {
    $("button.addCart").on("click", function () {
        let id = $(this).data("id");
        addtoCart(id);
    });
}

function handlerButtonRemoveCart() {
    $("button.removeCart").on("click", function () {
        let id = $(this).data("id");
        removeCart(id);
    });
}

function handlerInputQuantity(drink) {
    $("#tr_" + drink.drinkId + " td input.quantityDrink").on("change", function () {
        if ($(this).val() < 1) {
            alert("Số lượng phải lớn hơn 0");
            $(this).val(1);
        } else {
            drink.drinkQuantity = parseInt($(this).val());
        }
    });
}

function showDrink() {
    for (let i = 0; i < Drinks.length; i++) {
        let str =
            `<tr id="tr_${Drinks[i].drinkId}">
                    <input value="${Drinks[i].drinkId}" id="idDrinkPre" hidden>
                    <td>${Drinks[i].drinkName}</td>
                    <td class="text-center">
                        <button type="button" class="btn btn-outline-primary addCart"
                                data-id="${Drinks[i].drinkId}">
                            <i class="fa fa-plus-square"></i>
                        </button>
                    </td>
                </tr>`;
        $("#tblDrink tbody").append(str);

    }
    handlerButtonAddCart();
}

function addtoCart(id) {
    let drink = Drinks.find(function (drink, index) {
        return drink.drinkId == id;
    });
    let check = checkCart(drink);
    if (check == true) {
        drink.drinkQuantity = 1;
        Carts.push(drink);
        showCart(drink);
        submitCart();
    }
}

function showCart(drink) {
    let str =
        `<tr id="tr_${drink.drinkId}">
                    <input value="${drink.drinkId}" class="idDrinkOrder" hidden>
                    <td>${drink.drinkName}</td>
                    <td><input value="1" class="w-25 quantityDrink" type="number"></td>
                    <td class="text-center">
                        <button type="button" class="btn btn-outline-primary removeCart"
                                data-id="${drink.drinkId}">
                            <i class="fa fa-minus-square"></i>
                        </button>
                    </td>
                </tr>`;
    $("#tblOrder tbody").append(str);
    handlerButtonRemoveCart();
    handlerInputQuantity(drink);
}

function submitCart() {
    if (Carts.length > 0)
        $(".submit_cart").removeClass("disabled");
    else
        $(".submit_cart").addClass("disabled");
}

function checkCart(drink) {
    for (let i = 0; i < Carts.length; i++) {
        if (Carts[i].drinkId == drink.drinkId) {
            alert("Thức uống này đã được chọn!");
            return false;
        }
    }
    return true;
}

function removeCart(id) {
    if (Carts.length == 1) {
        Carts.pop();
        $("#tblOrder tbody tr").remove();
    }
    for (let i = 0; i < Carts.length; i++) {
        if (Carts[i].drinkId == id) {
            let idDrink = id;
            Carts.splice(i, 1);
            removeDrinkInCart(idDrink);
            break;
        }
    }
    submitCart();
}

function removeDrinkInCart(id) {
    $("#tblOrder tbody #tr_" + id).remove();
}

$("input.search").on('input', function () {
    let value = $(this).val().toLowerCase();
    if (value !== '') {
        $("#tblDrink tbody tr").remove();
        let str;
        for (let i = 0; i < Drinks.length; i++) {
            if (Drinks[i].drinkName.toLowerCase().includes(value)) {
                str =
                    `<tr id="tr_${Drinks[i].drinkId}">
                    <input value="${Drinks[i].drinkId}" id="idDrinkPre" hidden>
                    <td>${Drinks[i].drinkName}</td>
                    <td class="text-center">
                        <button type="button" class="btn btn-outline-primary addCart"
                                data-id="${Drinks[i].drinkId}">
                            <i class="fa fa-plus-square"></i>
                        </button>
                    </td>
                </tr>`;
                $("#tblDrink tbody").append(str);

            }
        }
        handlerButtonAddCart();
    } else {
        $("#tblDrink tbody tr").remove();
        showDrink();
    }
});


// });