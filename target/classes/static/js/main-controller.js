/**
 * Created by user on 08.7.2017.
 */
app.controller('mainController', MainControllerFn);

MainControllerFn.$inject = ['mainService'];

function MainControllerFn(mainService) {
    var vm = this;

    vm.entity = {};
    vm.entities = [];
    // All kinds of season type
    vm.seasonTypes = [];
    // Selected value from the dropdown list
    vm.selectedSeasonType = {};
    vm.brands = [];
    vm.selectedBrand = {};
    vm.heights = [];
    vm.selectedHeight = {};
    vm.widths = [];
    vm.selectedWidth = {};
    vm.inches = [];
    vm.selectedInch = {};

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




}
