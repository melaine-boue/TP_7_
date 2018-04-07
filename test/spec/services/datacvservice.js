'use strict';

describe('Service: dataCVService', function () {

  // load the service's module
  beforeEach(module('tp7App'));

  // instantiate service
  var dataCVService;
  beforeEach(inject(function (_dataCVService_) {
    dataCVService = _dataCVService_;
  }));

  it('should do something', function () {
    expect(!!dataCVService).toBe(true);
  });

});
