module.exports = function(config) {
    config.set({
        logLevel: config.LOG_WARN,
        reporters: ['spec'],
        singleRun: true,
        autoWatch: false,

        frameworks: [
            'jasmine',
            'browserify'
        ],

        files: [
            '../*.js'
        ],

        exclude: [],

        preprocessors: {
            '../*.js': ['browserify']
        },

        browserify: {
            debug: true
        },

        browsers: ['PhantomJS'],

        port: 9876,
        colors: true
    })
}