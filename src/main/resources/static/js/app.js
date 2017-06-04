/**
 * Created by user on 31.5.2017.
 */

var app = angular.module('app', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
        .when('/tires',{
            templateUrl: '/views/home.html',
            controller: 'tireController',
            controllerAs: 'vm'
        })
        .when('/login',{
            templateUrl:'/views/login.html',
            controller:'loginController',
            controllerAs:'vm1'
        })
        .when('/brand',{
            templateUrl:'views/brand.html',
            controller:'brandController',
            controllerAs:'vm2'
        })
        .when('/seasonType',
            {
                templateUrl:'views/season-type.html',
                controller:'seasonTypeController',
                controllerAs:'vm3'
            })
        .when('/vehicleType',
            {
                templateUrl:'views/vehicle-type.html',
                controller:'vehicleTypeController',
                controllerAs:'vm4'
            }
        )
        .otherwise({
           redirectTo: '/'
        });
});

