var gulp = require('gulp');
var concat = require('gulp-concat');
var uglify = require('gulp-uglify');
var imagemin = require('gulp-imagemin');
var sourcemaps = require('gulp-sourcemaps');
var sass = require('gulp-sass');
var del = require('del');

var browserify = require('browserify');
var source = require('vinyl-source-stream');
var buffer = require('vinyl-buffer');

var paths = {
    external_scripts: [
        'node_modules/jquery/dist/jquery.min.js'
    ],
    application_scripts: ['js/**/*.js'],
    images: 'img/**/*'
};

gulp.task('clean', function () {
    return del(['dist/**/*', 'dist/*', 'dist']);
});

gulp.task('images', ['clean'], function () {
    return gulp.src(paths.images)
        .pipe(gulp.dest('dist/img'));
});

/* JavaScript */
gulp.task('browserify:js', ['clean'], function () {
    return browserify('js/app.js').bundle()
        .pipe(source('app.min.js'))
        .pipe(buffer())
        .pipe(uglify())
        .pipe(gulp.dest('dist/js'));
});

/* Styles */
+gulp.task('scss', ['clean'], function () {
    gulp.src('scss/**/*.scss')
        .pipe(sass().on('error', function (err) {
            console.error(err);
        }))
        .pipe(concat('app.css'))
        .pipe(gulp.dest('dist/css/'));
});

gulp.task('default', ['clean', 'images', 'browserify:js', 'scss']);