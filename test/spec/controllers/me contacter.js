'use strict';

describe('Controller: MeContacterCtrl', function () {

  // load the controller's module
  beforeEach(module('tp7App'));

  var MeContacterCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    MeContacterCtrl = $controller('MeContacterCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(MeContacterCtrl.awesomeThings.length).toBe(3);
  });
});
