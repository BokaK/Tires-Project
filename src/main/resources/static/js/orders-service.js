/**
 * Created by Simona on 7/15/2017.
 */
app.factory('ordersService', OrdersServiceFn);

OrdersServiceFn.$inject = ['$http', '$q'];

/* @ngInject */
function OrdersServiceFn($http, $q) {

    var URL = '/admin/orders/';
    var service = {
        save: saveFn,
        update: updateFn,
        getById: getByIdFn,
        getAll: getAllFn,
        remove: removeFn
    };
    return service;

    function saveFn(entity) {

    }


    function updateFn(entity) {

    }

    function getByIdFn(entityId) {

    }

    function getAllFn() {

    }

    function removeFn(entity) {

    }
}