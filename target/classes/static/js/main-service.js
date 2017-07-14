/**
 * Created by user on 08.7.2017.
 */
app.factory('mainService', MainServiceFn);

MainServiceFn.$inject = ['$http', '$q'];

/* @ngInject */
function MainServiceFn($http, $q) {


    var service = {
        getAllTires: getAllTiresFn,
        getAllSeasonTypes: getAllSeasonTypesFn,
        getAllBrands: getAllBrandsFn,
        getAllWidths: getAllWidthsFn,
        getAllHeights: getAllHeightsFn,
        getAllInches: getAllInchesFn,
        putInCart: putInCartFn,
        getItemsInCart: getItemsInCartFn,
        getCart: getCartFn,
        removeFromCart: removeFromCartFn,
        plusCartItem: plusCartItemFn,
        minusCartItem: minusCartItemFn
    };
    return service;


    function getAllTiresFn() {
        var deferred = $q.defer();
        $http.get('/tires')
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
    function getAllSeasonTypesFn() {
        var deferred = $q.defer();
        $http.get('/seasonTypes')
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
    function getAllBrandsFn() {
        var deferred = $q.defer();
        $http.get('/brands')
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

    function getAllHeightsFn() {
        var deferred = $q.defer();
        $http.get('/heights')
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
    function getAllWidthsFn() {
        var deferred = $q.defer();
        $http.get('/widths')
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
    function getAllInchesFn() {
        var deferred = $q.defer();
        $http.get('/inches')
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

    function putInCartFn(entity,quantity) {
        var deferred = $q.defer();
        $http.post('/cartItem/'+quantity,entity)
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

    function getItemsInCartFn(cartId) {
        var deferred = $q.defer();
        $http.get('/cartItem/'+cartId)
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

    function getCartFn(){
        var deferred = $q.defer();
        $http.get('/cart')
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

    function removeFromCartFn(entity) {
        var deferred = $q.defer();
        $http.delete('/deleteCartItem/'+entity.id)
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

    function plusCartItemFn(entity) {
        var deferred = $q.defer();
        $http.put('/cartItemPlus', entity)
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


    function minusCartItemFn(entity) {
        var deferred = $q.defer();
        $http.put('/cartItemMinus', entity)
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

}