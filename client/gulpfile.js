var gulp = require('gulp');
var concat = require('gulp-concat');
var uglify = require('gulp-uglify');
var imagemin = require('gulp-imagemin');
var sourcemaps = require('gulp-sourcemaps');
var del = require('del');

var paths = {
    external_scripts: [
        'node_modules/jquery/dist/jquery.min.js'
    ],
    application_scripts: ['js/**/*.js'],
    images: 'img/**/*'
};

gulp.task('clean', function() {
    return del(['dist']);
});

gulp.task('scripts', ['clean'], function() {
    return gulp.src(paths.application_scripts)
        .pipe(sourcemaps.init())
        .pipe(uglify())
        .pipe(concat('all.min.js'))
        .pipe(sourcemaps.write())
        .pipe(gulp.dest('dist/js'));
});

gulp.task('vendor-javascript', function() {
    gulp.src(['node_modules/**/*.js'])
        .pipe(sourcemaps.init())
        .pipe(concat('vendor.min.js'))
        .pipe(gulp.dest('dist/js'));
});

gulp.task('images', ['clean'], function() {
    return gulp.src(paths.images)
        .pipe(gulp.dest('dist/img'));
});

gulp.task('browserify-js', [], function () {
    return browserify('dist/js/all.min.js').bundle()
        // vinyl-source-stream makes the bundle compatible with gulp
        .pipe(source('dist/js/all.min.js'))
        .pipe(gulp.dest('dist/js/all.min.js'));
});

gulp.task('default', ['vendor-javascript', 'scripts', 'images']);