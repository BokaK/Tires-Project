/**
 * Created by user on 04.6.2017.
 */
app.controller('vehicleTypeController', VehicleTypeControllerFn);

VehicleTypeControllerFn.$inject = ['vehicleTypeService'];

function VehicleTypeControllerFn(vehicleTypeService) {
    var vm = this;

    vm.save = save;
    vm.clear = clear;
    vm.edit = edit;
    vm.remove = remove;

    vm.entity = {};
    vm.entities = [];

    loadVehicleTypes();

    function loadVehicleTypes() {
        vehicleTypeService.getAll().then(function (data) {
            vm.entities = data;
        });
    }

    function save() {
        var promise = vehicleTypeService.save(vm.entity);

        promise.then(successCallback, errorCallback);
        function successCallback(object) {
            clear();
            loadVehicleTypes();
        }
        function errorCallback(data) {
        }
    }

    function clear() {
        vm.entity = {};
    }

    function edit(entity) {
        vm.entity = {};
        angular.extend(vm.entity, entity);
    }

    function remove(entity) {
        vehicleTypeService
            .remove(entity)
            .then(function () {
                loadVehicleTypes();
            });
    }

}
