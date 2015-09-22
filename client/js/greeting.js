var $ = require('jquery');

module.exports = {
    message: "Hello from javascript!",
    sayHi: function () {
        $('#javascript-area').text(this.message);
    }
};