'use strict';

describe('Controller: PersonneCtrl', function () {

  // load the controller's module
  beforeEach(module('tp7App'));

  var PersonneCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    PersonneCtrl = $controller('PersonneCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(PersonneCtrl.awesomeThings.length).toBe(3);
  });
});
