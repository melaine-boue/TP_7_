'use strict';

describe('Controller: MycvCtrl', function () {

  // load the controller's module
  beforeEach(module('tp7App'));

  var MycvCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    MycvCtrl = $controller('MycvCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(MycvCtrl.awesomeThings.length).toBe(3);
  });
});
