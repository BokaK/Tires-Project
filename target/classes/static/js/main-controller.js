/**
 * Created by user on 08.7.2017.
 */
app.controller('mainController', MainControllerFn);


MainControllerFn.$inject = ['mainService', 'userService'];
function MainControllerFn(mainService, userService) {
    var vm = this;

    vm.textNaracka = "Дали сте сигурни дека сакате да ја извршите нарачката?";
    vm.entity = {};
    vm.entities = [];
    vm.user = {};
    // All kinds of season type
    vm.seasonTypes = [];
    // Selected value from the dropdown list
    vm.selectedSeasonType = "";
    vm.brands = [];
    vm.selectedBrand = "";
    vm.heights = [];
    vm.selectedHeight = "";
    vm.widths = [];
    vm.selectedWidth = "";
    vm.inches = [];
    vm.selectedInch = "";
    vm.cartItems = [];
    vm.cart = {};
    vm.quantity = [];
    vm.cartSize=0;
    vm.filterFunction = filterFunction;
    vm.putInCart = putInCart;
    vm.saveUserCheckout = saveUserCheckout;
    vm.plus = plus;
    vm.minus = minus;
    vm.removeFromCart = removeFromCart;
    vm.plusCartItem = plusCartItem;
    vm.minusCartItem = minusCartItem;
    getItemsInCart();
    loadTires();
    loadBrands();
    loadSeasonTypes();
    loadWidths();
    loadHeights();
    loadInches();

    function loadTires() {
        mainService.getAllTires().then(function (data) {
            vm.entities = data;
        });
    }

    function loadSeasonTypes() {
        mainService.getAllSeasonTypes().then(function (data) {
            vm.seasonTypes = data;
        });
    }

    function loadBrands() {
        mainService.getAllBrands().then(function (data) {
            vm.brands = data;
        });
    }

    function loadWidths() {
        mainService.getAllWidths().then(function (data) {
            vm.widths = data;
        });
    }

    function loadHeights() {
        mainService.getAllHeights().then(function (data) {
            vm.heights = data;
        });
    }

    function loadInches() {
        mainService.getAllInches().then(function (data) {
            vm.inches = data;
        });
    }
    function plus(index) {
        var input = $('.quantity').eq(index);
        var currentVal = vm.quantity[index];
        if (currentVal < input.attr('max'))
        {
            currentVal++;
            vm.quantity[index] = currentVal;
            input.val(currentVal).change();
            if (currentVal > input.attr('min'))
            {
                $('.button-minus').eq(index).attr('disabled', false);
            }
        }
        if (parseInt(input.val()) == input.attr('max'))
        {
            $('.button-plus').eq(index).attr('disabled', true);
        }
    }

    function minus(index) {
        var input = $('.quantity').eq(index);
        var currentVal = vm.quantity[index];
        if (currentVal > input.attr('min'))
        {
            currentVal--;
            vm.quantity[index] = currentVal;
            input.val(currentVal).change();
            if (currentVal < input.attr('max'))
            {
                $('.button-plus').eq(index).attr('disabled', false);
            }

        }
        if (parseInt(input.val()) == input.attr('min'))
        {
            $('.button-minus').eq(index).attr('disabled', true);
        }
    }


    function filterFunction(element) {
        if (vm.selectedBrand == "" && vm.selectedSeasonType == "" && vm.selectedInch == "" && vm.selectedHeight == "" && vm.selectedWidth == "") {
            return true;
        }
        else if (vm.selectedBrand != "") {
            if (vm.selectedSeasonType != "") {
                if (vm.selectedInch != "") {
                    if (vm.selectedHeight != "") {
                        if (vm.selectedWidth != "") {
                            if (element.width.width == vm.selectedWidth.width && element.height.height == vm.selectedHeight.height
                                && element.inches.inches == vm.selectedInch.inches && element.brandName.brandName == vm.selectedBrand.brandName && element.seasonType.seasonType == vm.selectedSeasonType.seasonType)
                                return true;
                            else return false;
                        }
                        else {
                            if (element.height.height == vm.selectedHeight.height && element.inches.inches == vm.selectedInch.inches && element.brandName.brandName == vm.selectedBrand.brandName && element.seasonType.seasonType == vm.selectedSeasonType.seasonType)
                                return true;
                            else return false;
                        }
                    }
                    else {
                        if (vm.selectedWidth != "") {
                            if (element.width.width == vm.selectedWidth.width
                                && element.inches.inches == vm.selectedInch.inches && element.brandName.brandName == vm.selectedBrand.brandName && element.seasonType.seasonType == vm.selectedSeasonType.seasonType)
                                return true;
                            else return false;
                        }
                        else {
                            if (element.inches.inches == vm.selectedInch.inches && element.brandName.brandName == vm.selectedBrand.brandName && element.seasonType.seasonType == vm.selectedSeasonType.seasonType)
                                return true;
                            else return false;
                        }
                    }
                }
                else {
                    if (vm.selectedHeight != "") {
                        if (vm.selectedWidth != "") {
                            if (element.width.width == vm.selectedWidth.width && element.height.height == vm.selectedHeight.height
                                && element.brandName.brandName == vm.selectedBrand.brandName && element.seasonType.seasonType == vm.selectedSeasonType.seasonType)
                                return true;
                            else return false;
                        }
                        else {
                            if (element.height.height == vm.selectedHeight.height && element.brandName.brandName == vm.selectedBrand.brandName && element.seasonType.seasonType == vm.selectedSeasonType.seasonType)
                                return true;
                            else return false;
                        }
                    }
                    else {
                        if (vm.selectedWidth != "") {
                            if (element.width.width == vm.selectedWidth.width && element.brandName.brandName == vm.selectedBrand.brandName && element.seasonType.seasonType == vm.selectedSeasonType.seasonType)
                                return true;
                            else return false;
                        }
                        else {
                            if (element.brandName.brandName == vm.selectedBrand.brandName && element.seasonType.seasonType == vm.selectedSeasonType.seasonType)
                                return true;
                            else return false;
                        }
                    }
                }
            }
            else {
                if (vm.selectedInch != "") {
                    if (vm.selectedHeight != "") {
                        if (vm.selectedWidth != "") {
                            if (element.width.width == vm.selectedWidth.width && element.height.height == vm.selectedHeight.height
                                && element.inches.inches == vm.selectedInch.inches && element.brandName.brandName == vm.selectedBrand.brandName)
                                return true;
                            else return false;
                        }
                        else {
                            if (element.height.height == vm.selectedHeight.height && element.inches.inches == vm.selectedInch.inches && element.brandName.brandName == vm.selectedBrand.brandName)
                                return true;
                            else return false;
                        }
                    }
                    else {
                        if (vm.selectedWidth != "") {
                            if (element.width.width == vm.selectedWidth.width
                                && element.inches.inches == vm.selectedInch.inches && element.brandName.brandName == vm.selectedBrand.brandName)
                                return true;
                            else return false;
                        }
                        else {
                            if (element.inches.inches == vm.selectedInch.inches && element.brandName.brandName == vm.selectedBrand.brandName)
                                return true;
                            else return false;
                        }
                    }
                }
                else {
                    if (vm.selectedHeight != "") {
                        if (vm.selectedWidth != "") {
                            if (element.width.width == vm.selectedWidth.width && element.height.height == vm.selectedHeight.height
                                && element.brandName.brandName == vm.selectedBrand.brandName)
                                return true;
                            else return false;
                        }
                        else {
                            if (element.height.height == vm.selectedHeight.height && element.brandName.brandName == vm.selectedBrand.brandName)
                                return true;
                            else return false;
                        }
                    }
                    else {
                        if (vm.selectedWidth != "") {
                            if (element.width.width == vm.selectedWidth.width && element.brandName.brandName == vm.selectedBrand.brandName)
                                return true;
                            else return false;
                        }
                        else {
                            if (element.brandName.brandName == vm.selectedBrand.brandName)
                                return true;
                            else return false;
                        }
                    }
                }
            }
        }
        else {
            if (vm.selectedSeasonType != "") {
                if (vm.selectedInch != "") {
                    if (vm.selectedHeight != "") {
                        if (vm.selectedWidth != "") {
                            if (element.width.width == vm.selectedWidth.width && element.height.height == vm.selectedHeight.height
                                && element.inches.inches == vm.selectedInch.inches && element.seasonType.seasonType == vm.selectedSeasonType.seasonType) {
                                return true;
                            }
                            else return false;
                        }
                        else {
                            if (element.height.height == vm.selectedHeight.height && element.inches.inches == vm.selectedInch.inches && element.seasonType.seasonType == vm.selectedSeasonType.seasonType)
                                return true;
                            else return false;
                        }
                    }
                    else {
                        if (vm.selectedWidth != "") {
                            if (element.width.width == vm.selectedWidth.width
                                && element.inches.inches == vm.selectedInch.inches && element.seasonType.seasonType == vm.selectedSeasonType.seasonType)
                                return true;
                            else return false;
                        }
                        else {
                            if (element.inches.inches == vm.selectedInch.inches && element.seasonType.seasonType == vm.selectedSeasonType.seasonType)
                                return true;
                            else return false;
                        }
                    }
                }
                else {
                    if (vm.selectedHeight != "") {
                        if (vm.selectedWidth != "") {
                            if (element.width.width == vm.selectedWidth.width && element.height.height == vm.selectedHeight.height
                                && element.seasonType.seasonType == vm.selectedSeasonType.seasonType)
                                return true;
                            else return false;
                        }
                        else {
                            if (element.height.height == vm.selectedHeight.height && element.seasonType.seasonType == vm.selectedSeasonType.seasonType)
                                return true;
                            else return false;
                        }
                    }
                    else {
                        if (vm.selectedWidth != "") {
                            if (element.width.width == vm.selectedWidth.width && element.seasonType.seasonType == vm.selectedSeasonType.seasonType)
                                return true;
                            else return false;
                        }
                        else {
                            if (element.seasonType.seasonType == vm.selectedSeasonType.seasonType)
                                return true;
                            else return false;
                        }
                    }
                }
            }
            else {
                if (vm.selectedInch != "") {
                    if (vm.selectedHeight != "") {
                        if (vm.selectedWidth != "") {
                            if (element.width.width == vm.selectedWidth.width && element.height.height == vm.selectedHeight.height
                                && element.inches.inches == vm.selectedInch.inches)
                                return true;
                            else return false;
                        }
                        else {
                            if (element.height.height == vm.selectedHeight.height && element.inches.inches == vm.selectedInch.inches)
                                return true;
                            else return false;
                        }
                    }
                    else {
                        if (vm.selectedWidth != "") {
                            if (element.width.width == vm.selectedWidth.width
                                && element.inches.inches == vm.selectedInch.inches)
                                return true;
                            else return false;
                        }
                        else {
                            if (element.inches.inches == vm.selectedInch.inches)
                                return true;
                            else return false;
                        }
                    }
                }
                else {
                    if (vm.selectedHeight != "") {
                        if (vm.selectedWidth != "") {
                            if (element.width.width == vm.selectedWidth.width && element.height.height == vm.selectedHeight.height)
                                return true;
                            else return false;
                        }
                        else {
                            if (element.height.height == vm.selectedHeight.height)
                                return true;
                            else return false;
                        }
                    }
                    else {
                        if (vm.selectedWidth != "") {
                            if (element.width.width == vm.selectedWidth.width)
                                return true;
                            else return false;
                        }
                        else {
                            return true;
                        }
                    }
                }
            }
        }
    };
    function putInCart(entity,index) {
        mainService.putInCart(entity, vm.quantity[index]).then(function (data) {
            getItemsInCart();
        });
    }

    function getItemsInCart() {
        mainService.getCart().then(function (data) {
            vm.cart = data;
            mainService.getItemsInCart(vm.cart.id).then(function (data) {
                vm.cartItems = data;
                vm.cartSize = vm.cartItems.length;
            });
        });
    }

    function saveUserCheckout() {
        var promise = userService.save(vm.user);
        promise.then(successCallback, errorCallback);
        function successCallback(object) {
            mainService.saveUserCheckout(object.data, vm.cart.id).then(function (data) {
                vm.textNaracka = "Вашата нарачка беше успешна.";
                getItemsInCart();
            });
        }
        function errorCallback(data) {
            vm.textNaracka = "Вашата нарачка не беше успешна. Ве молиме обидете се повторно!";
        }

    }


    function removeFromCart(entity){
        mainService.removeFromCart(entity).then(function (data) {
            getItemsInCart();
        });
    }

    function plusCartItem(entity) {
        mainService.plusCartItem(entity).then(function (data) {
            getItemsInCart();
        });
    }

    function minusCartItem(entity) {
        if(entity.quantity>1){
            mainService.minusCartItem(entity).then(function (data) {
                getItemsInCart();
            });
        }

    }


}
