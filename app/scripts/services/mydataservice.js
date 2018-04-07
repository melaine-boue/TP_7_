'use strict';

/**
 * @ngdoc service
 * @name tp7App.myDataService
 * @description
 * # myDataService
 * Service in the tp7App.
 */
angular.module('tp7App')
  .service('myDataService', function ($http) {
    // AngularJS will instantiate a singleton by calling "new" on this function


    this.personnes = [
      {'name':'SARR',
        'prenom':'Seynabou',
        'homes':[{
            'name':'Dakar',
            'heater':[
              'Clim electrique',
              'Clim Solaire'
            ]
          },
          {
            'name':'Rennes',
            'heater':[
              'Chauvage Electrique',
              'Chauvage Solaire'
            ]
          }
        ],
        'electronicDevices':['Ordi de la petite']
      },


    ];






    this.getPersonnes = function(){
      return this.personnes;
    }


    this.getPersonne = function(index){
      return this.personnes[index];
    }


    this.addPersonne =function(personne){

      this.personnes.push(personne);

      //Add personne in database
      var req = {
        method: 'POST',
        url: '192.168.1.14:8080/rest/opower/add',
        headers: {
          'Content-Type': "application/json"
        },
        data: personne
      }

      $http(req).then(function(){
        $location.path('/');
      }, function(){});

    }



    this.chargement = function () {


      $http({
        method: 'GET',
        url: '192.168.1.14:8080/rest/opower/persons'
      }).then(function successCallback(response) {
        this.personnes = response.data
        console.log(response);
      }, function errorCallback(response) {
        console.log(response.data);
      });

    }
  });
