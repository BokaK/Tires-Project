/**
 * Created by user on 08.7.2017.
 */
app.controller('mainController', MainControllerFn);

MainControllerFn.$inject = ['mainService'];

function MainControllerFn(mainService) {
    var vm = this;

    vm.entity = {};
    vm.entities = [];
    // vm.possibleBrands=[];
    // vm.seasonTypes=[];
    // vm.vehicleTypes=[];
    // vm.images =[];

    loadTires();
    // loadBrands();
    // loadSeasonTypes();
    // loadVehicleTypes();

    function loadTires() {
        mainService.getAll().then(function (data) {
            vm.entities = data;
        });
    }

    // function loadSeasonTypes() {
    //     seasonTypeService.getAll().then(function (data) {
    //         vm.seasonTypes = data;
    //     });
    // }
    //
    // function loadVehicleTypes() {
    //     vehicleTypeService.getAll().then(function (data) {
    //         vm.vehicleTypes = data;
    //     });
    // }
    //
    // function loadBrands() {
    //     brandService.getAll().then(function (data) {
    //         vm.possibleBrands = data;
    //     });
    // }
    //
    // function  loadImages() {
    //     tireImageService.getAll().then(function (data) {
    //         vm.images = data;
    //     });
    // }




}
