'use strict';

/**
 * @ngdoc function
 * @name tp7App.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the tp7App
 */
angular.module('tp7App')
  .controller('MainCtrl', function ($scope,myDataService,$location) {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];

    $scope.personnes =  myDataService.getPersonnes();

    $scope.personne = {};

    $scope.afficherDetails = false;




    $scope.getInfo = function(index){
      console.log(myDataService.getPersonne(index));
      $scope.personne = myDataService.getPersonne(index);

      myDataService.chargement();
    }


    $scope.setVisible = function(value){
      $scope.afficherDetails = value;
    }


    $scope.ajouterPersonne = function(){
      $location.path('/add');
    }



  });
