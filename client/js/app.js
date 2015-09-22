var $ = require('jquery');
var greeting = require('./greeting');

$(document).ready(function() {
    greeting.sayHi();
});