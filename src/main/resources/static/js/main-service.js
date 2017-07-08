/**
 * Created by user on 08.7.2017.
 */
app.factory('mainService', MainServiceFn);

MainServiceFn.$inject = ['$http', '$q'];

/* @ngInject */
function MainServiceFn($http, $q) {

    var URL = '/tires';

    var service = {
        getAll: getAllFn
    };
    return service;


    function getAllFn() {
        var deferred = $q.defer();
        $http.get(URL)
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