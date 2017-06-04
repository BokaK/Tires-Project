/**
 * Created by user on 03.6.2017.
 */

app.controller('brandController', BrandControllerFn);

BrandControllerFn.$inject = ['brandService'];

function BrandControllerFn(brandService) {
    var vm = this;

    vm.save = save;
    vm.clear = clear;
    vm.edit = edit;
    vm.remove = remove;

    vm.entity = {};
    vm.entities = [];

    loadBrands();

    function loadBrands() {
        brandService.getAll().then(function (data) {
            vm.entities = data;
        });
    }

    function save() {
        var promise = brandService.save(vm.entity);
        promise.then(successCallback, errorCallback);
        function successCallback(data) {
            clear();
            loadBrands();
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
        brandService
            .remove(entity)
            .then(function () {
                loadBrands();
            });
    }

}
