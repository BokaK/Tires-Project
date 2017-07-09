/**
 * Created by user on 09.7.2017.
 */
app.controller('heightController', HeightControllerFn);

HeightControllerFn.$inject = ['heightService'];

function HeightControllerFn(heightService) {
    var vm = this;

    vm.save = save;
    vm.clear = clear;
    vm.edit = edit;
    vm.remove = remove;

    vm.entity = {};
    vm.entities = [];

    loadHeights();

    function loadHeights() {
        heightService.getAll().then(function (data) {
            vm.entities = data;
        });
    }

    function save() {
        var promise = heightService.save(vm.entity);

        promise.then(successCallback, errorCallback);
        function successCallback(object) {
            clear();
            loadHeights();
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
        heightService
            .remove(entity)
            .then(function () {
                loadHeights();
            });
    }

}
