/**
 * Created by Simona on 7/15/2017.
 */
app.factory('ordersService', OrdersServiceFn);

OrdersServiceFn.$inject = ['$http', '$q'];

/* @ngInject */
function OrdersServiceFn($http, $q) {

    var URL = '/admin/checkout/';
    var service = {
        save: saveFn,
        update: updateFn,
        getById: getByIdFn,
        getAll: getAllFn,
        remove: removeFn,
        getCartItems: getCartItems
    };
    return service;

    function saveFn(entity) {

    }


    function updateFn(entity) {

    }

    function getByIdFn(entityId) {

    }

    function getAllFn() {
        var deferred = $q.defer();
        $http.get(URL)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

    function removeFn(entity) {
        var deferred = $q.defer();
        $http.delete(URL+entity.id)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

    function getCartItems(cartId) {
        var deferred = $q.defer();
        $http.get('/admin/cartItem/cartId/'+cartId)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }
}