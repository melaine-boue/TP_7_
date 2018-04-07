'use strict';

describe('Service: myDataService', function () {

  // load the service's module
  beforeEach(module('tp7App'));

  // instantiate service
  var myDataService;
  beforeEach(inject(function (_myDataService_) {
    myDataService = _myDataService_;
  }));

  it('should do something', function () {
    expect(!!myDataService).toBe(true);
  });

});
