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
        .when('/admin/width',
            {
                templateUrl:'views/width.html',
                controller:'widthController',
                controllerAs:'vm6'
            })
        .when('/admin/height',
            {
                templateUrl:'views/height.html',
                controller:'heightController',
                controllerAs:'vm7'
            })
        .when('/admin/inches',
            {
                templateUrl:'views/inches.html',
                controller:'inchesController',
                controllerAs:'vm8'
            })
        .otherwise({
           redirectTo: '/'
        });
});

