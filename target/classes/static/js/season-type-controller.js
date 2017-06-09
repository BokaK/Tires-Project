/**
 * Created by user on 03.6.2017.
 */
app.controller('seasonTypeController', SeasonTypeControllerFn);

SeasonTypeControllerFn.$inject = ['seasonTypeService'];

function SeasonTypeControllerFn(seasonTypeService) {
    var vm = this;

    vm.save = save;
    vm.clear = clear;
    vm.edit = edit;
    vm.remove = remove;

    vm.entity = {};
    vm.entities = [];

    loadSeasonTypes();

    function loadSeasonTypes() {
        seasonTypeService.getAll().then(function (data) {
            vm.entities = data;
        });
    }

    function save() {
        var promise = seasonTypeService.save(vm.entity);

        promise.then(successCallback, errorCallback);
        function successCallback(object) {
            console.log(object);
            clear();
            loadSeasonTypes();
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
        seasonTypeService
            .remove(entity)
            .then(function () {
                loadSeasonTypes();
            });
    }

}
