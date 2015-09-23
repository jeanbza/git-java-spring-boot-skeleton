describe('greeting.js', function () {
    var greeting = require('../js/greeting');
    var $ = require('jquery');

    var html = '<div class="container" id="fixture-html">' +
        '<div id="javascript-area">Waiting for javascript...</div>' +
        '</div>';

    beforeEach(function () {
        $('body').append(html);
    });

    afterEach(function () {
        $('#fixture-html').remove();
    });

    describe('.sayHi', function () {
        it('prints a greeting the the javascript area', function () {
            greeting.sayHi();
            expect($('#javascript-area').text()).toEqual('Hello from javascript!');
        });
    });
});