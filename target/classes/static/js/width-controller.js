/**
 * Created by user on 09.7.2017.
 */
app.controller('widthController', WidthControllerFn);

WidthControllerFn.$inject = ['widthService'];

function WidthControllerFn(widthService) {
    var vm = this;

    vm.save = save;
    vm.clear = clear;
    vm.edit = edit;
    vm.remove = remove;

    vm.entity = {};
    vm.entities = [];

    loadWidths();

    function loadWidths() {
        widthService.getAll().then(function (data) {
            vm.entities = data;
        });
    }

    function save() {
        var promise = widthService.save(vm.entity);

        promise.then(successCallback, errorCallback);
        function successCallback(object) {
            clear();
            loadWidths();
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
        widthService
            .remove(entity)
            .then(function () {
                loadWidths();
            });
    }

}
