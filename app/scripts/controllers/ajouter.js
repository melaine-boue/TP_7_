'use strict';

/**
 * @ngdoc function
 * @name tp7App.controller:AjouterCtrl
 * @description
 * # AjouterCtrl
 * Controller of the tp7App
 */
angular.module('tp7App')
  .controller('AjouterCtrl',function ($scope,myDataService) {

    $scope.personnes =[];
    $scope.heaters = [];
    $scope.homes = [];
    $scope.electronicDevices=[];

    $scope.afficherHome = false;
    $scope.afficherElectroDevice = false;
    $scope.header = false;



    $scope.addHeater = function () {
       $scope.heaters.push($scope.nomHeater);
       $scope.nomHeater = '';

     }


     $scope.addHome = function () {

      $scope.homes.push({
          'name':$scope.home_name,
          'heater':$scope.heaters
        });

       $scope.heaters=[];
       $scope.home_name='';

     }


    $scope.addElectronicDevice = function () {

      $scope.electronicDevices.push($scope.nouvelElectronicDevice);

      $scope.nouvelElectronicDevice ='';

    }


    $scope.ajouterPersonne = function () {
       var personne = {
         'name':$scope.name,
         'prenom':$scope.prenom,
         'homes':$scope.homes,
         'electronicDevices':$scope.electronicDevices
       };



      $scope.personnes.push(personne);
      myDataService.addPersonne(personne);

      $scope.homes=[];
      $scope.electronicDevices=[];
      $scope.name='';
      $scope.prenom='';

      console.log($scope.personnes);

    }


    $scope.showHome = function () {
      $scope.afficherHome = ! $scope.afficherHome;
    };

    $scope.showElectroDevice = function () {
      $scope.afficherElectroDevice = ! $scope.afficherElectroDevice;
    };

    $scope.showHeater = function () {
      $scope.afficherHeater = ! $scope.afficherHeater;
    };





  });
