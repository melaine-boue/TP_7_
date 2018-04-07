'use strict';

/**
 * @ngdoc function
 * @name tp7App.controller:MycvCtrl
 * @description
 * # MycvCtrl
 * Controller of the tp7App
 */
angular.module('tp7App')
  .controller('MycvCtrl', function ($scope) {

    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];



    $scope.ok = function () {
        console.log($scope.viens+"/"+$scope.okV);
    };


    $scope.okF =function(){
      console.log($scope.ggg);

    }
  });
