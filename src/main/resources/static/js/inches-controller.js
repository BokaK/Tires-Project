/**
 * Created by user on 09.7.2017.
 */
app.controller('inchesController', InchesControllerFn);

InchesControllerFn.$inject = ['inchesService'];

function InchesControllerFn(inchesService) {
    var vm = this;

    vm.save = save;
    vm.clear = clear;
    vm.edit = edit;
    vm.remove = remove;

    vm.entity = {};
    vm.entities = [];

    loadInches();

    function loadInches() {
        inchesService.getAll().then(function (data) {
            vm.entities = data;
        });
    }

    function save() {
        var promise = inchesService.save(vm.entity);

        promise.then(successCallback, errorCallback);
        function successCallback(object) {
            clear();
            loadInches();
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
        inchesService
            .remove(entity)
            .then(function () {
                loadInches();
            });
    }

}
