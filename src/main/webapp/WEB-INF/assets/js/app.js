var app = angular.module('myApp', []);

// service here
app.service('bookService', function ($http) {
    this.getAll = function () {
        return $http({
            method: 'GET',
            url: 'http://localhost:8080/testGround/getAll'
        });
    }

    this.search = function (key) {
        return $http({
            method: 'GET',
            url: 'http://localhost:8080/testGround/search/' + key
        });
    }

    this.saveBook = function (book) {

    }
});


//controller here
app.controller('myController', function ($http, $scope, bookService) {

    $scope.formData = {};

    //get all books
    $scope.getAll = function () {
        bookService.getAll()
                .then(function (response) {
                    $scope.books = response.data;
                });
    };



    $scope.search = function (key) {
        console.log(key.length);
        if (key.length == 0) {
            this.getAll();
        }
        bookService.search(key)
                .then(function (response) {
                    $scope.books = response.data;
                });
    }


    $scope.selectBook = function (book) {
        $scope.clickedBook = book;
    };

    $scope.updateBook = function () {
        console.log($scope.clickedBook);
        $http.post('http://localhost:8080/testGround/update', $scope.clickedBook)               
        return false;
    }

    $scope.saveBook = function () {
        
        console.log($scope.formData);

        //$scope.books.push($scope.book);
        $http.post('http://localhost:8080/testGround/save', $scope.formData)
                .then(function onSuccess(response) {
                    // Handle success//                  
                    $scope.books.push(response.data);
                })
                .catch(function onError(response) {
                    // Handle error
                    console.log("failed");
                });
        $scope.formData = {};
        return false;
    };

    $scope.deleteBook = function (book) {
        $scope.books.splice($scope.books.indexOf(book), 1);
        $http.delete('http://localhost:8080/testGround/delete/' + this.book.bookId);
        console.log(this.book.bookId);
        return false;
    };

});
