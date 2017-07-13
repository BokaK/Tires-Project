/**
 * Created by user on 08.7.2017.
 */
app.controller('mainController', MainControllerFn);

MainControllerFn.$inject = ['mainService', 'userService'];
function MainControllerFn(mainService, userService) {
    var vm = this;

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
    vm.filterFunction = filterFunction;
    vm.putInCart = putInCart;
    vm.saveUser = saveUser;

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
    function putInCart(entity) {
        mainService.putInCart(entity, 1).then(function (data) {
            getItemsInCart();
        });
    }

    function getItemsInCart() {
        mainService.getCart().then(function (data) {
            vm.cart = data;
            mainService.getItemsInCart(vm.cart.id).then(function (data) {
                vm.cartItems = data;
            });
        });
    }

    function saveUser() {
        var promise = userService.save(vm.user);
        console.log(vm.user);
        promise.then(successCallback, errorCallback);
        function successCallback(object) {
        }
        function errorCallback(data) {
        }
    }


}
