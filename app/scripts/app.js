'use strict';

/**
 * @ngdoc overview
 * @name tp7App
 * @description
 * # tp7App
 *
 * Main module of the application.
 */
angular
  .module('tp7App', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl',
        controllerAs: 'about'
      })
      .when('/myCV', {
        templateUrl: 'views/mycv.html',
        controller: 'MycvCtrl',
        controllerAs: 'myCV'
      })
      .when('/Me contacter', {
        templateUrl: 'views/me contacter.html',
        controller: 'MeContacterCtrl',
        controllerAs: 'MeContacter'
      })
      .when('/add', {
        templateUrl: 'views/ajouter.html',
        controller: 'AjouterCtrl',
        controllerAs: 'Ajouter'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
