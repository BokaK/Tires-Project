/**
 * Created by user on 31.5.2017.
 */

var app = angular.module('app', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
        .when('/admin',{
            templateUrl:'/admin.html'
        })
        .when('/admin/tires',{
            templateUrl: '/views/home.html',
            controller: 'tireController',
            controllerAs: 'vm'
        })
        .when('/login',{
            templateUrl:'/views/login.html',
            controller:'loginController',
            controllerAs:'vm1'
        })
        .when('/admin/brand',{
            templateUrl:'views/brand.html',
            controller:'brandController',
            controllerAs:'vm2'
        })
        .when('/admin/seasonType',
            {
                templateUrl:'views/season-type.html',
                controller:'seasonTypeController',
                controllerAs:'vm3'
            })
        .when('/admin/vehicleType',
            {
                templateUrl:'views/vehicle-type.html',
                controller:'vehicleTypeController',
                controllerAs:'vm4'
            }
        )
        .when('/index', {
            templateUrl:'index.html',
            controller:'mainController',
            controllerAs:'vm5'
        })
        .otherwise({
           redirectTo: '/'
        });
});

